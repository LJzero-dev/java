use mall;

-- 회원 관련 프로시저들

-- 회원 주소록 테이블에 새로운 주소를 추가하는 프로시저 sp_member_addr_insert()
drop procedure if exists sp_member_addr_insert;
delimiter $$
create procedure sp_member_addr_insert(	
	miid varchar(20), maname varchar(20), marname varchar(20), maphone varchar(13), mazip char(5), maaddr1 varchar(50), maaddr2 varchar(50), mabasic char(1))
begin
	if mabasic = 'y' then	-- 추가하려는 주소를 기본주소로 설정하려면 기존의 기본주소를 일반주소로 변경해야 함
		update t_member_addr set ma_basic = 'n'
        where ma_basic = 'y' and mi_id = miid;
	end if;
    
	insert into t_member_addr(mi_id, ma_name, ma_rname, ma_phone, ma_zip, ma_addr1, ma_addr2, ma_basic) 
    values (miid, maname, marname, maphone, mazip, maaddr1, maaddr2, mabasic);
end $$
delimiter ;

call sp_member_addr_insert('test1', '회사', '홍길동', '010-1234-5678', '12344', '서울시 관악구', '22-331', 'n');
call sp_member_addr_insert('test1', '회사2', '홍길동', '010-1234-5678', '12355', '서울시 서대문구', '22-331', 'y');
select * from t_member_addr;


drop procedure if exists sp_member_point_insert;
delimiter $$
create procedure sp_member_point_insert(miid varchar(20), mpsu char(1), mppoint int, mpdesc varchar(20), mpdetail varchar(20))
begin
	declare pnt int default mppoint;
    if mpsu = 'u' then			-- 포인트 적립이 아닌 사용일 경우 
		set pnt = mppoint * -1;	-- 포인트 사용이므로 pnt의 값을 음수로 변경
    end if;
    
	insert into t_member_point (mi_id, mp_su, mp_point, mp_desc, mp_detail) values (miid, mpsu, pnt, mpdesc, mpdetail);
    
    select sum(mp_point) into pnt from t_member_point where mi_id = miid;		-- 현재 회원이 보유하고 있는 포인트를 다시 계산하여 pnt 변수에 저장
    update t_member_info set mi_point = pnt where mi_id = miid;					-- 포인트 사용(또는 적립)시 새롭게 보유 포인트를 계산하여 회원 테이블에 저장
    
    -- update t_member_info set mi_point = mi_point + pnt where mi_id = miid; 	-- 오동작이 있을 경우 계속해서 잘못된 포인트를 보유할 위험이 있는 쿼리
end $$
delimiter ;
call sp_member_point_insert('test1', 'u', 1000,'상품구매', '230518AD1001GN');
call sp_member_point_insert('test1', 's', 1400,'상품구매', '230518AD1001GN');
select * from t_member_point;
select * from t_member_info;


-- 회원 가입 프로시저 sp_member_info_insert()
-- 가입 시 가입축하금 지급과 기본주소 등록도 같이 처리해야 함
drop procedure if exists sp_member_info_insert;
delimiter $$
create procedure sp_member_info_insert(miid varchar(20),mipw varchar(20), miname varchar(20),migender char(1), mibirth char(10),
miphone varchar(13), miemail varchar(50), miisad char(1),maname varchar(20), mazip char(5),
maaddr1 varchar(50), maaddr2 varchar(50), mp_point int, mpdesc varchar(20))
begin
	-- 회원 정보 테이블에 insert 
    insert into t_member_info (mi_id, mi_pw, mi_name, mi_gender, mi_birth, mi_phone, mi_email, mi_isad) values (miid, mipw, miname, migender, mibirth, miphone, miemail, miisad);
    
	-- 회원 주소록 테이블에 insert 
    call sp_member_addr_insert(miid, maname, miname, miphone, mazip, maaddr1, maaddr2, 'y');
    
	-- 회원 포인트 테이블에 insert 
    call sp_member_point_insert(miid, 's', mppoint, mpdesc, '');
end $$
delimiter ;
call sp_member_info_insert('test4', '1234', '임꺽정', '여', '2002-09-09',
'010-9999-2222', 'lim@naver.com', 'y', '집', '98765', '강원도 강릉시', '22-555', 1000, '가입축하금');
select * from t_member_info;
select * from t_member_addr;
select * from t_member_point;


-- 상품 관련 프로시저들

-- 상품 정보 관리(등록, 수정), 프로시저 sp_product_info_mange();
-- 등록(i), 정보 수정(u)
drop procedure if exists sp_product_info_mange;
delimiter $$
create procedure sp_product_info_mange(kind char(1), piid char(7), pcsid char(4), pbid char(2), piname varchar(50),
piprice int, picost int, pidc float, picom varchar(20), piimg1 varchar(50),
piimg2 varchar(50), piimg3 varchar(50), pidesc varchar(50), pispecial varchar(4), piisview char(1), aiidx int)
begin
	declare num char(3);
	declare id char(7);
	if kind = 'i' then		-- 상품 등록일 경우
        select right(max(pi_id), 3) into num from t_product_info where pcs_id = pcsid;	-- 새로 등록할 상품의 아이디 생성
        if num is null then
			set id = concat(pcsid, '101');
		else
			set id = concat(pcsid, num + 1);
        end if;
		insert into t_product_info (pi_id, pcs_id, pb_id, pi_name, pi_price, pi_cost, pi_dc, pi_com, pi_img1, pi_img2, pi_img3, pi_desc, pi_special, pi_isview, ai_idx)
        values (id, pcsid, pbid, piname, piprice, picost, pidc, picom, piimg1, piimg2, piimg3, pidesc, pispecial, piisview, aiidx);
        
    elseif kind = 'u' then	-- 상품 변경일 경우
		update t_product_info set 
		pb_id = pbid, pi_name = piname, pi_price = piprice,	pi_cost = picost, pi_dc = pidc, pi_com = picom,	pi_img1 = piimg1, pi_img2 = piimg2, pi_img3 = piimg3,
		pi_desc = pidesc, pi_special = pispecial, pi_isview = piisview,	pi_last = now(), pi_admin = aiidx	where pi_id = piid;
    end if;
end $$
delimiter ;


call sp_product_info_mange('i', null, 'AA01', 'B2', '쓸만한 신발', 180000, 120000, 0, '쓸만한 회사', 'test.jpg', '', '', 'test_d.jpg', '', 'y', 1);
call sp_product_info_mange('i', null, 'AA02', 'B1', '쓸만한 신발2', 170000, 110000, 0, '쓸만한 회사', 'test2.jpg', '', '', 'test2_d.jpg', '', 'y', 1);
call sp_product_info_mange('u', 'AA01103', 'AA01', 'B2', '쓸만한 신발', 180000, 120000, 0.2, '쓸만한 회사', 'AA01103.jpg', '', '', 'AA01103_d.jpg', '', 'y', 1);
select * from t_product_info;

-- 상품 옵션별 재고 관리(등록, 변경) sp_product_stock_manage;

drop procedure if exists sp_product_stock_manage;
delimiter $$
create procedure sp_product_stock_manage(kind char(1), psidx int, piid char(7), pssize int, psstock int, pssale int, psisview char(1))
begin
	if kind = 'i' then		-- 옵션별 재고 등록 시
		insert into t_product_stock (pi_id, ps_size, ps_stock, ps_sale, ps_isview) values (piid, pssize, psstock, pssale, psisview);
    else					-- 옵션별 재고 변경 시 
		update t_product_stock set ps_size = pssize, ps_stock = psstock, ps_sale = pssale, ps_isview = psisview where ps_idx = psidx;
    end if;
end $$
delimiter ;
call sp_product_stock_manage('i', 0, 'AA01103', 240, 100, 0, 'y');
call sp_product_stock_manage('i', 0, 'AA01103', 250, 100, 0, 'y');
call sp_product_stock_manage('i', 0, 'AA01103', 260, 100, 0, 'y');

call sp_product_stock_manage('i', 0, 'AA02101', 240, 100, 0, 'y');
call sp_product_stock_manage('i', 0, 'AA02101', 250, 100, 0, 'y');
call sp_product_stock_manage('i', 0, 'AA02101', 260, 100, 0, 'y');
select * from t_product_stock;


-- QnA 관리(질문등록, 질문수정, 질문삭제, 답변등록, 답변평가) 프로시저 sp_qna_manage()
drop procedure if exists sp_qna_manage;
delimiter $$
create procedure sp_qna_manage(kind char(1), qlidx int, miid varchar(20), qlctgr char(1), qltitle varchar(100), qlcontent text, qlimg1 varchar(50),
qlimg2 varchar(50), qlip varchar(15), qlisanswer char(1), qlai_idx int, qlanswer text, qlsatis char(1), qladate datetime, qlisview char(1))
begin
	if kind = 'i' then		-- 질문등록일 경우
		insert into t_qna_list (ql_idx, mi_id, ql_ctgr, ql_title, ql_content, ql_img1, ql_img2, ql_ip) values (qlidx, miid, qlctgr, qltitle, qlcontent, qlimg1, qlimg2, qlip); 
    elseif kind = 'u' then	-- 질문수정일 경우(답변이 달리기 전)
		update t_qna_list set ql_ctgr = qlctgr, ql_title = qltitle, ql_content = qlcontent, ql_img1 = qlimg1, ql_img2 = qlimg2 where ql_idx = qlidx and mi_id = miid;
    elseif kind = 'd' then	-- 질문삭제일 경우(답변이 달리기 전)
		update t_qna_list set ql_isvied = 'n' where ql_idx = qlidx and mi_id = miid;
    elseif kind = 'a' then	-- 답변등록일 경우
		update t_qna_list set ql_isanswer = qlisanswer, ql_ai_idx = qlai_idx, ql_answer = qlanswer, ql_satis = qlsatis, ql_adate = now() where ql_idx = qlidx;
    elseif kind = 's' then	-- 답변평가일 경우
		update t_qna_list set ql_satis = qlsatis where ql_idx = qlidx and mi_id = miid;
    end if;
end $$
delimiter ;

call sp_qna_manage('i', 1, 'test1', 'a', '질문입니다.', '내용입니다.', null, null, '127.0.0.1', 'n', 0, null, null, null, null);
call sp_qna_manage('u', 1, 'test1', 'b', '질문입니다2.', '내용입니다2.', null, null, '127.0.0.1', 'n', 0, null, null, null, null);
select * from t_qna_list;

-- 자유게시판 관리(등록, 수정-회원, 비회원, 삭제-회원, 비회원) 프로시저 sp_free_manage()
drop procedure if exists sp_free_manage;
delimiter $$
create procedure sp_free_manage(kind char(1), flidx int, flismem char(1), flwriter varchar(20), flpw varchar(20), fltitle varchar(100), flcontent text, flip varchar(15), flisview char(1))
begin
	if kind = 'i' then		-- 게시글 등록일 경우
		insert into t_free_list (fl_idx, fl_ismem, fl_writer, fl_pw, fl_title, fl_content, fl_ip) values (flidx, flismem, flwriter, flpw, fltitle, flcontent, flip);
    elseif kind = 'u' and flismem = 'y' then	-- 회원글 수정이면
		update t_free_list set fl_title = fltitle, fl_content = flcontent where fl_idx = flidx and fl_writer = flwriter;
    elseif kind = 'u' and flismem = 'n' then	-- 비회원글 수정이면
		update t_free_list set fl_title = fltitle, fl_content = flcontent  where fl_idx = flidx  and fl_pw = flpw;
    elseif kind = 'd' and flismem = 'y' then	-- 회원글 삭제이면
		update t_free_list set fl_isview = 'n' where fl_idx = flidx and fl_writer = flwriter;
    elseif kind = 'd' and flismem = 'n' then	-- 비회원글 삭제이면
		update t_free_list set fl_isview = 'n' where fl_idx = flidx and fl_pw = flpw;
    end if;
end $$
delimiter ;
call sp_free_manage('i', 1, 'y', 'test1', null, '첫번째 글', '내용', '127.0.0.1', null);
call sp_free_manage('i', 2, 'n', 'ㅇㅇ', 1234, '두번째 글', '내용2', '127.0.0.1', null);
call sp_free_manage('u', 1, 'y', 'test1', null, '첫번째 글2', '내용22', '127.0.0.1', null);
call sp_free_manage('u', 2, 'n', null, '1234', '두번째 글2', '내용222', '127.0.0.1', null);
select * from t_free_list;

-- 자유게시판 댓글 관리(등록, 삭제) 프로시저 sp_free_reply_manage()
drop procedure if exists sp_free_reply_manage;
delimiter $$
create procedure sp_free_reply_manage(kind char(1), fridx int, flidx int, miid varchar(20), frcontent varchar(200), frip varchar(15), frisview char(1))
begin
	if kind = 'i' then	-- 댓글 등록일 경우
		insert into t_free_reply (fl_idx, mi_id, fr_content, fr_ip) values (flidx, miid, frcontent, frip);
        
        update t_free_list set fl_reply = flreply + 1 where fl_idx = flidx;					-- 원본 게시글의 댓글 개수를 1 증가시키는 쿼리
    elseif kind = 'd' then
		update t_free_reply set fr_isview = 'n' where fr_idx = fridx and mi_id = miid;
        
        update t_free_list set fl_reply = flreply - 1 where fl_idx = flidx and mi_reply > 0;	-- 원본 게시글의 댓글 개수를 1 감소시키는 쿼리(음수가 되지 않도록 조건 추가)
    end if;
end $$
delimiter ;
call sp_free_reply_manage('i', 1, 1, 'ㅇㅇ', '댓글', '127.0.0.1', null);
select * from t_free_list;









-- 게시판 관련 프로시저들

-- 공지사항 관리(입력, 수정, 삭제) 프로시저 sp_notice_manage()
drop procedure if exists sp_notice_manage;
delimiter $$
create procedure sp_notice_manage(kind char(1), nlidx int, aiidx int, nlctgr varchar(10), nltitle varchar(100), nlcontent text, nlisview char(1))
begin
	declare witch char(1) default kind;
	
    if kind = 'i' then		-- 공지사항 등록이면
		insert into t_notice_list (nl_idx, ai_idx, nl_ctgr, nl_title, nl_content, nl_isview) values (nlidx, aiidx, nlctgr, nltitle, nlcontent, nlisview);
    elseif kind = 'u' then	-- 공지사항 수정이면
		update t_notice_list set nl_ctgr = nlctgr, nl_title = nltitle, nl_content = nlcontent, nl_isview = nlisview where nl_idx = nlidx;
    else 					-- 공지사항 삭제이면
		delete from t_notice_list where nl_idx = nlidx;
    end if;
end $$
delimiter ;

call sp_notice_manage('i', 1, 1, '공지', '첫번째 공지글', '내용', 'y');
call sp_notice_manage('u', 1, 1, '공지', '첫번째 이벤트', '이벤트 내용', 'y');
call sp_notice_manage('', 1, 0, '', '', '', '');
select * from t_notice_list;
















