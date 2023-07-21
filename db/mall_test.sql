-- 함수, 트리거, 뷰, 커서 등의테스트용 파일
use mall;


-- 두 개의 정수를 받아 더한 후 결과값을 리턴하는 함수 fn_add()

set global log_bin_trust_function_creators = 1;
drop function if exists fn_add;
delimiter $$
create function fn_add(n1 int, n2 int) returns int
begin
    return n1 + n2;
end $$
delimiter ;

select fn_add(10,20);

-- 회원 아이디 현시점 포인트 현시점 포인트 + 100
set global log_bin_trust_function_creators = 1;
drop function if exists fn_mi_point_add_100;
delimiter $$
create function fn_mi_point_add_100(n1 int) returns int
begin
    return n1 + 100;
end $$
delimiter ;
select mi_id, mi_point, fn_mi_point_add_100(mi_point)  from t_member_info;



-- 회원 ID를 받아 해당 회원의 나이를 계산하여 리턴하는 함수 fn_age()
set global log_bin_trust_function_creators = 1;
drop function if exists fn_age;
delimiter $$
create function fn_age(miid varchar(20)) returns varchar(20)
begin
	declare age int;	-- 나이를 저장할 변수
    declare cYear int;	-- 현재 연도를 저장할 변수
    declare bYear int;	-- 태어난 연도를 저장할 변수
    
    set cYear = year(now());	-- 오늘(now()) 날짜에서 연도부분만 추출하여 저장
    select left(mi_birth, 4) into bYear from t_member_info where mi_id = miid;	-- 받아온 회원ID에 해당하는 생일에서 태어난 연도부분을 잘라 bYear에 저장
    set age = cYear - bYear;  
    
    return age;
end $$
delimiter ;

-- 모든 회원들의 정보 출력(아이디, 나이-??살, 상태-정상,휴면,탈퇴)
select mi_id, fn_age(mi_id), if(mi_status = 'a', '정상', if(mi_status = 'b', '휴면', '탈퇴')) from t_member_info;


-- 상품ID를 받아 해당 상품이 할인율이 있으면 할인가를 없으면 정상가를 리턴 fn_price()

set global log_bin_trust_function_creators = 1;
drop function if exists fn_price;
delimiter $$
create function fn_price(piid char(7)) returns int
begin
	declare price int;	-- 가격을 저장할 변수
    declare dc float;	-- 할인율을 저장할 변수
    
    select pi_price into price from t_product_info where pi_id = piid;
    select pi_dc into dc from t_product_info where pi_id = piid;
    
    return ceil(price * (1-dc));
end $$
delimiter ;
select pi_price '판매가', pi_dc '할인률', fn_price(pi_id) '실판매가' from t_product_info;

-- 트리거 사용 예제
create table test_tr (
	tt_c1 int auto_increment primary key,
    tt_c2 varchar(10) not null,
    tt_c3 varchar(10) default '',
    tt_c4 datetime default now()
);
insert into test_tr(tt_c2, tt_c3) values ('a', 'b');

create table test_tr2 (
	tt2_c1 int auto_increment primary key,
    tt2_c2 varchar(10) not null,
    tt2_c3 varchar(10) default '',
    tt2_c4 datetime default now()
);

-- test_tr 테이블에 update가 일어나면 test_tr2 테이블에 
-- tt2_c2 컬럼의 값이 'aaa'인 레코드를 삽입 하는 트리거 tr_test

 drop trigger if exists tr_test;
delimiter $$
create trigger tr_test after update on test_tr for each row
 begin
	insert into test_tr2 (tt2_c2) values ('aaa');
end $$
delimiter ;
select * from test_tr;
update test_tr set tt_c2 = 'a', tt_c3 = 'z' where tt_c1 = 1;
select * from test_tr2;

-- test_tr 테이블에 update가 일어나면 tt_c2와 tt_c3의 값들을 
-- test_tr2 테이블의 tt2_c2, tt2_c3 컬럼에 저장하는 트리거 tr_test2 생성


 drop trigger if exists tr_test2;
delimiter $$
create trigger tr_test2 after update on test_tr for each row
 begin
	declare c2 varchar(10);
	declare c3 varchar(10);
    set c2 = old.tt_c2;
    set c3 = old.tt_c3;
	insert into test_tr2 (tt2_c2, tt2_c3) values (c2, c3);
end $$
delimiter ;
select * from test_tr;
update test_tr set tt_c2 = 'w', tt_c3 = 'n' where tt_c1 = 1;
select * from test_tr2;

-- 상품 가격 변동 히스토리 트리거 예제
-- 상품 테이블
create table test_pdt (
	tp_id char(6) primary key,
    tp_name varchar(20) not null,
    tp_price int default 0
);
insert into test_pdt values ('aa0101', '좋은 상품', 150000);
insert into test_pdt values ('aa0102', '나쁜 상품', 180000);
insert into test_pdt values ('aa0103', '보통 상품', 120000);
select * from test_pdt;

create table test_history (
	th_idx int auto_increment primary key,
    tp_id char(6),
    th_old int default 0,
    th_new int default 0,
    th_date datetime default now(),
    constraint fk_test_history_tp_id foreign key (tp_id) references test_pdt(tp_id)
);

-- 상품테이블에서 가격 변동 시 변경전 가격과 변경후 가격을 history테이블에 저장 tr_price
 drop trigger if exists tr_price;
delimiter $$
create trigger tr_price after update on test_pdt for each row
 begin
	declare old_price, new_price int;
    declare tpid char(6);
    set old_price = old.tp_price;
    set new_price = new.tp_price;
    set tpid = old.tp_id;
    if old_price <> new_price then	-- update로 가격이 변동될 경우
		insert into test_history (tp_id, th_old, th_new) values (tpid, old_price, new_price);
    end if;
end $$
delimiter ;
select * from test_pdt;
update test_pdt set tp_price = 10000 where tp_id = 'aa0101';
update test_pdt set tp_price = 10000 where tp_id = 'aa0101';
select * from test_history;


-- 뷰 View
-- 구매목록 뷰 생성(회원ID, 주문번호, 주문일자, 상품ID, 상품명, 개수, 옵션)
select * from t_member_info;
create view v_order_list as
	select a.mi_id, a.oi_id, a.oi_date, b.pi_id, b.od_name, b.od_cnt, b.od_size from t_order_info a, t_order_detail b where a.oi_id = b.oi_id;
select * from v_order_list;

-- 구매목록2 뷰 생성
-- 회원ID, 회원명, 주문번호, 주문일자, 상품ID, 소분류명, 상품명, 개수, 옵션
create view v_order_list2 as
	select b.mi_id, a.mi_name, b.oi_id, b.oi_date, d.pi_id, e.pcs_name, c.od_name, c.od_size
    from t_member_info a, t_order_info b, t_order_detail c, t_product_info d, t_product_ctgr_small e
    where a.mi_id = b.mi_id and b.oi_id = c.oi_id and c.pi_id = d.pi_id and d.pcs_id = e.pcs_id;
select * from v_order_list2;

use mall;
-- 회원별 구매액 목록 (id, 이름, 총 구매액, 주문횟수) : v_member_order_total
create view v_order_total as
	select a.mi_id, a.mi_name, sum(b.oi_pay) total, count(b.oi_id) cnt from t_member_info a, t_order_info b where a.mi_id = b.mi_id group by a.mi_id, a.mi_name;
select * from v_order_total;

-- 위 쿼리를 참조하여 구매를 하지 않은 회원들도 보여주는 목록 : v_member_order_tota2
create view v_order_total2 as select a.mi_id, a.mi_name, count(b.oi_id) cnt, ifnull(sum(b.oi_pay), 0) total from t_member_info a left join t_order_info b on a.mi_id = b.mi_id group by a.mi_id, a.mi_name;
select * from v_order_total2 where cnt > 0;

drop view v_member_monthly;
-- 월별 및 월별 회원 가입자 수 목록(월, 가입자 수) : v_member_monthly
create view v_member_monthly as select year(mi_date), month(mi_date), count(mi_date) from t_member_info group by year(mi_date), month(mi_date);
create view v_member_monthly2 as select left(mi_date, 7), count(mi_date) from t_member_info group by left(mi_date, 7);
select * from v_member_monthly;
select * from v_member_monthly2;


-- 커서 관련 예제
create table test_cursor (
	c1 int auto_increment primary key,
    c2 int default 0,
    c3 varchar(20)
);
insert into test_cursor (c2, c3) values (11, 'test1');
insert into test_cursor (c2, c3) values (22, 'test2');
insert into test_cursor (c2, c3) values (33, 'test3');
select * from test_cursor;

-- test_cursor 테이블의 c2컬럼의 값을 c1과 더한 값으로 변경하는 프로시저 제작
-- 커서를 이용하여 작업 : sp_cursor_test


drop procedure if exists sp_cursor_test;
delimiter $$
create procedure sp_cursor_test()
begin
	declare is_end boolean default false;
    declare cid int default 0;	-- 커서에 들어있는 c1컬럼의 값을 저장할 변수    
    declare cs cursor for select c1 from test_cursor;	-- test_cursor테이블의 c1컬럼을 모두 추출하여 cs라는 커서 생성
    declare continue handler for not found set is_end = true;
    open cs;
    cursorLoop:while true do
		fetch cs into cid;
        if is_end then
			leave cursorLoop;
		end if;
        update test_cursor set c2 = c2 + cid where c1 = cid;
	end while;    
    close cs;
end $$
delimiter ;
call sp_cursor_test();
select * from test_cursor;
select * from test_tr;


-- 트랜잭션 예제
drop procedure if exists sp_trandaction;
delimiter $$
create procedure sp_trandaction(kind char(1), vc2 int, vc3 varchar(20), tc2 varchar(10), tc3 varchar(10))
begin
	declare err int default 0;	-- 오류 여부를 저장할 변수
    declare continue handler for sqlexception set err = 1;	-- 쿼리 작업 시 오류가 발생하면 err변수의 값에 1을 저장
    
    start transaction;	-- 트랜잭션 시작
    
    if kind = 'e' then	-- 롤백 테스트용 쿼리 작업
    begin
		insert into test_cursor (c2, c3) values (vc2, vc3);
		insert into test_tr (tt_c1, tt_c2, tt_c3) values (v3, tc2, tc3);
	end;
    else 				-- 커밋 테스트용 쿼리 작업
    begin
		insert into test_cursor (c2, c3) values (vc2, vc3);
		insert into test_tr (tt_c2, tt_c3) values (tc2, tc3);
	end;
    end if;
    
    if err = 0 then	-- 트랜잭션내의 쿼리 실행시 오류가 발생하지 않았으면
		commit;		-- 쿼리의 실행 결과들을 해당 테이블들에 적용
    else			-- 트랜잭션내의 쿼리 실행시 오류가 발생했으면
		rollback;	-- 모든 쿼리의 실행 결과를 실행 전으로 되돌림
    end if;
end $$
delimiter ;
call sp_trandaction('e', 12, 'abcd', 'efg', 'hij');
call sp_trandaction('i', 12, 'abcd', 'efg', 'hij');
select * from test_cursor;
select * from test_tr;

-- 상품별 판매량 및 판매액 목롱 : v_product_sale_list
-- 상품ID, 상품명, 판매량, 판매액, 주문횟수
drop view v_product_sale_list;
create view v_product_sale_list as select a.pi_id, a.pi_name, sum(b.od_cnt) salecnt, sum(b.od_cnt * b.od_price) total, count(b.od_cnt) ordercnt from t_product_info a, t_order_detail b where a.pi_id = b.pi_id group by a.pi_id, a.pi_name;
select * from v_product_sale_list;


-- 연도, 월별, 성별 회원 가입수 : v_member_gender
-- 연도, 월, 성별, 회원수
drop view v_member_gender;
create view v_member_gender as select year(mi_date) joinyear, month(mi_date) joinmonth, mi_gender, count(mi_id) from t_member_info where mi_status = 'a' group by joinyear, joinmonth, mi_gender;
select * from v_member_gender;
select * from t_admin_info;
insert into t_admin_info (ai_id, ai_pw, ai_name) values ('admin2', '1111', '관리자2');
use mall;


select * from t_member_info;

insert into t_member_info values (?, ?, ?, ?, ?, ?, ?, ?, 1000, 'a', now(), null);











select count(*) from t_member_info where mi_id = '';

update t_member_info set mi_phone = '', mi_email = '', mi_isad = '' where mi_id = '';



















