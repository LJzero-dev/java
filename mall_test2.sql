select * from t_member_info where mi_status <> 'c' and mi_id = '' and mi_pw = '';

select 1 from t_member_info where mi_id = '';


insert into t_member_info (mi_id, mi_pw, mi_name, mi_gender, mi_birth, mi_phone, mi_email, mi_isad, mi_point ) values (?, ?, ?, ?, ?, ?, ?, ?, ?);
select * from t_member_addr;

insert into t_member_addr (mi_id, ma_name, ma_rname, ma_phone, ma_zip, ma_addr1, ma_addr2) values (?, ?, ?, ?, ?, ?, ?);

select * from t_member_point;

insert into t_member_point (mi_id, mp_point, mp_desc) values (?, ?, ?);
select * from t_member_info;

select * from t_free_list;
select count(*) from t_free_list where fl_isview = 'y';
select fl_idx, fl_ismem, fl_writer, fl_title, fl_reply, fl_read, fl_ip, 
if(curdate() = date(fl_date), right(fl_date, 8), replace(mid(fl_date, 3, 8),'-', '.')) wdate from t_free_list order by fl_idx desc limit ?, ?;


select * from t_free_list where fl_isview = 'y';

insert into t_free_list (fl_idx, fl_ismem, fl_writer, fl_pw, fl_title, fl_content, fl_ip) values (13, 'n', 'ㅇㅇ1', '1234', '제목 입니다.1', '내용 입니다.1', '127.0.0.1');
insert into t_free_list (fl_idx, fl_ismem, fl_writer, fl_pw, fl_title, fl_content, fl_ip) values (14, 'n', 'ㅇㅇ2', '1234', '제목 입니다.2', '내용 입니다.2', '127.0.0.1');
insert into t_free_list (fl_idx, fl_ismem, fl_writer, fl_pw, fl_title, fl_content, fl_ip) values (15, 'n', 'ㅇㅇ3', '1234', '제목 입니다.3', '내용 입니다.3', '127.0.0.1');
insert into t_free_list (fl_idx, fl_ismem, fl_writer, fl_pw, fl_title, fl_content, fl_ip) values (16, 'n', 'ㅇㅇ4', '1234', '제목 입니다.4', '내용 입니다.4', '127.0.0.1');
insert into t_free_list (fl_idx, fl_ismem, fl_writer, fl_pw, fl_title, fl_content, fl_ip) values (17, 'n', 'ㅇㅇ5', '1234', '제목 입니다.5', '내용 입니다.5', '127.0.0.1');
insert into t_free_list (fl_idx, fl_ismem, fl_writer, fl_pw, fl_title, fl_content, fl_ip) values (18, 'n', 'ㅇㅇ6', '1234', '제목 입니다.6', '내용 입니다.6', '127.0.0.1');
insert into t_free_list (fl_idx, fl_ismem, fl_writer, fl_pw, fl_title, fl_content, fl_ip) values (19, 'n', 'ㅇㅇ7', '1234', '제목 입니다.7', '내용 입니다.7', '127.0.0.1');
insert into t_free_list (fl_idx, fl_ismem, fl_writer, fl_pw, fl_title, fl_content, fl_ip) values (20, 'n', 'ㅇㅇ8', '1234', '제목 입니다.8', '내용 입니다.8', '127.0.0.1');
insert into t_free_list (fl_idx, fl_ismem, fl_writer, fl_pw, fl_title, fl_content, fl_ip) values (21, 'n', 'ㅇㅇ9', '1234', '제목 입니다.9', '내용 입니다.9', '127.0.0.1');
insert into t_free_list (fl_idx, fl_ismem, fl_writer, fl_pw, fl_title, fl_content, fl_ip) values (22, 'n', 'ㅇㅇ10', '1234', '제목 입니다12.', '내용 입니다.10', '127.0.0.1');
insert into t_free_list (fl_idx, fl_ismem, fl_writer, fl_pw, fl_title, fl_content, fl_ip) values (23, 'n', 'ㅇㅇ11', '1234', '제목 입니다13.', '내용 입니다.11', '127.0.0.1');
insert into t_free_list (fl_idx, fl_ismem, fl_writer, fl_pw, fl_title, fl_content, fl_ip) values (24, 'n', 'ㅇㅇ12', '1234', '제목 입니다14.', '내용 입니다.12', '127.0.0.1');
insert into t_free_list (fl_idx, fl_ismem, fl_writer, fl_pw, fl_title, fl_content, fl_ip) values (25, 'n', 'ㅇㅇ13', '1234', '제목 입니다15.', '내용 입니다.13', '127.0.0.1');
insert into t_free_list (fl_idx, fl_ismem, fl_writer, fl_pw, fl_title, fl_content, fl_ip) values (26, 'n', 'ㅇㅇ14', '1234', '제목 입니다16.', '내용 입니다.14', '127.0.0.1');
insert into t_free_list (fl_idx, fl_ismem, fl_writer, fl_pw, fl_title, fl_content, fl_ip) values (27, 'n', 'ㅇㅇ15', '1234', '제목 입니다17.', '내용 입니다.15', '127.0.0.1');
insert into t_free_list (fl_idx, fl_ismem, fl_writer, fl_pw, fl_title, fl_content, fl_ip) values (28, 'n', 'ㅇㅇ16', '1234', '제목 입니다18.', '내용 입니다.16', '127.0.0.1');
insert into t_free_list (fl_idx, fl_ismem, fl_writer, fl_pw, fl_title, fl_content, fl_ip) values (29, 'n', 'ㅇㅇ17', '1234', '제목 입니다19.', '내용 입니다.17', '127.0.0.1');
insert into t_free_list (fl_idx, fl_ismem, fl_writer, fl_pw, fl_title, fl_content, fl_ip) values (30, 'n', 'ㅇㅇ18', '1234', '제목 입니다20.', '내용 입니다.18', '127.0.0.1');
insert into t_free_list (fl_idx, fl_ismem, fl_writer, fl_pw, fl_title, fl_content, fl_ip) values (31, 'n', 'ㅇㅇ19', '1234', '제목 입니다21.', '내용 입니다.19', '127.0.0.1');
insert into t_free_list (fl_idx, fl_ismem, fl_writer, fl_pw, fl_title, fl_content, fl_ip) values (?, ?, ?, ?, ?, ?, ?);

select * from t_free_list;

select max(fl_idx) + 1 from t_free_list;

update t_free_list set fl_read = fl_read + 1 where fl_idx = ?;

select * from t_free_list where fl_idx = 1;

use mall;
select * from t_free_list;


-- 회원용
select * from t_free_list where fl_isview = 'y' and fl_idx = ? and fl_writer = '';

-- 비회원용
select * from t_free_list where fl_isview = 'y' and fl_idx = ? and fl_pw = '';

select * from t_free_list;
update t_free_list set fl_reply = fl_reply + 1 where fl_idx = ;
select * from t_free_reply;

insert into t_free_reply (fl_idx, mi_id, fr_content, fr_ip) values (?, '', '', '');


select * from t_free_reply where fl_idx = 53;

select * from t_free_list;
select * from t_free_reply;
update t_free_list set fl_reply = fl_reply - 1 where fl_idx = 3;

select * from t_free_reply;



select frg_gnb from t_free_reply_gnb where fr_idx = 1 and mi_id = '';

insert into t_free_reply_gnb (mi_id, fr_idx, frg_gnb, frg_date) values ('', ?, '', '');

select * from t_free_list;
update t_free_list set fl_reply = fl_reply - 1 where fl_idx = (select fl_idx from t_free_reply where fr_idx =45);

select * from t_product_info;

select * from t_product_ctgr_big;

select * from t_product_info where pcs_id like 'AA%';
select * from t_product_info where left(pcs_id, 2) = 'BB';

select a.pi_id, a.pi_name, a.pi_img1, a.pi_price, a.pi_dc, a.pi_special, a.pi_review, a.pi_sale, a.pi_score, sum(b.ps_stock) stock
from t_product_info a, t_product_stock b
where a.pi_id = b.pi_id and a.pi_isview = 'y'
group by a.pi_id, a.pi_name, a.pi_img1, a.pi_price, a.pi_dc, a.pi_special, a.pi_review, a.pi_sale, a.pi_score;



select count(*) from t_product_info a where a.pi_isview = 'y';

select * from t_product_ctgr_small where pcb_id = 'AA';

select * from t_product_brand order by pb_name asc;

select * from t_product_brand order by pb_name;
select a.pi_id, a.pi_name, a.pi_img1, a.pi_price, a.pi_dc, a.pi_special, a.pi_review, a.pi_sale, a.pi_score, sum(b.ps_stock) stock  from t_product_info a, t_product_stock b  where a.pi_id = b.pi_id and a.pi_isview = 'y'  and a.pi_name like '%aa%'  and (a.pb_id = 'B3' )  and a.pi_price >= 30 and a.pi_price <= 77 group by a.pi_id  order by  a.pi_date desc  limit 0, 12;

select a.pi_id, a.pi_name, a.pi_img1, a.pi_price, a.pi_dc, a.pi_special, a.pi_review, a.pi_sale, a.pi_score, sum(b.ps_stock) stock  
from t_product_info a, t_product_stock b  
where a.pi_id = b.pi_id and a.pi_isview = 'y'  and a.pi_name like '%aa%'  and (a.pb_id = 'B3'  or a.pb_id = 'B2'  or a.pb_id = 'B4' )  and a.pi_price >= 30 and a.pi_price <= 77 
group by a.pi_id  
order by  a.pi_date desc  limit 0, 12;



select a.pi_id, a.pi_name, a.pi_img1, a.pi_price, a.pi_dc, a.pi_special, a.pi_review, a.pi_sale, a.pi_score, sum(b.ps_stock) stock  
from t_product_info a, t_product_stock b  
where a.pi_id = b.pi_id and a.pi_isview = 'y'  and a.pi_name like '%aa%'  and (a.pb_id = 'B3'  or a.pb_id = 'B2'  or a.pb_id = 'B4' )  and a.pi_price >= 30 and a.pi_price <= 77 
group by a.pi_id  
order by  a.pi_date desc  limit 0, 12;

select * from t_product_info;
update t_product_info set pi_img1 = 'AA01101_1.png' where pi_id = 'AA01101';
update t_product_info set pi_img1 = 'AA01102_1.png' where pi_id = 'AA01102';
update t_product_info set pi_img1 = 'AA01103_1.png' where pi_id = 'AA01103';
update t_product_info set pi_img1 = 'AA02101_1.png' where pi_id = 'AA02101';
update t_product_info set pi_img2 = 'AA02101_2.png' where pi_id = 'AA02101';
update t_product_info set pi_img1 = 'BB01103_1.png' where pi_id = 'BB01101';

select * from t_product_info;
insert into t_product_info () values ();

insert into t_product_info (pi_id, pcs_id, pb_id, pi_name, pi_price, pi_cost, pi_dc,
pi_com, pi_img1, pi_desc, pi_isview, ai_idx)
values ('AA01109', 'AA01', 'B1', '좋은 로퍼3', 150000, 80000, 0, '좋은 회사', 'AA01101_1.png',
'AA01101_d.jpg', 'y', 1);
insert into t_product_info (pi_id, pcs_id, pb_id, pi_name, pi_price, pi_cost, pi_dc,
pi_com, pi_img1, pi_desc, pi_isview, ai_idx)
values ('AA01102', 'AA01', 'B2', '좋은 윙팁', 180000, 90000, 0.1, '좋은 회사', 'AA01102_1.jpg',
'AA01102_d.jpg', 'y', 1);
insert into t_product_info (pi_id, pcs_id, pb_id, pi_name, pi_price, pi_cost, pi_dc,
pi_com, pi_img1, pi_desc, pi_isview, ai_idx)
values ('BB01101', 'BB01', 'B3', '뛰는 러닝화', 130000, 70000, 0, '좋은 회사2', 'BB01101_1.jpg',
'BB01101_d.jpg', 'y', 1);
select * from t_product_info;

select * from t_product_stock;
insert into t_product_stock (pi_id, ps_size, ps_stock, ps_isview) values ('AA011', 250, 100, 'y');

update t_product_info set pi_read = piread + 1 where pi_id = '';

select a.*, b.pcb_name, c.pcs_name, d.pb_name from t_product_info a, t_product_ctgr_big b, t_product_ctgr_small c, t_product_brand d where a.pcs_id = c.pcs_id and b.pcb_id = c.pcb_id and a.pb_id = d.pb_id and a.pi_isview = 'y' and a.pi_id = 'AA01101';
select ps_idx, ps_size, ps_stock from t_product_stock where ps_isview = 'y' and pi_id = 'AA01101';

select * from t_order_info;

select * from t_order_cart order by oc_idx desc;

update t_product_info set pi_img1 = 'AA01102_1.png', pi_img2 = 'AA01103_1.png', pi_img3 = 'AA02101_1.png' where pi_id = 'AA01102';
select * from t_product_stock where pi_id = 'AA01102' and ps_idx = 9;
update t_product_stock set ps_stock = -3 where pi_id = 'AA01102' and ps_idx = 9;

insert into t_order_cart (mi_id, pi_id, ps_idx, oc_cnt) values ('test1','','',3);


update t_order_cart set oc_cnt = oc_cnt + ? where mi_id = '' and pi_id = '' and ps_idx = ?;

select * from t_order_cart;

select a.oc_cnt, b.pi_name, b.pi_img1, b.pi_price, b.pi_id 
from t_order_cart a, t_product_info b 
where a.pi_id = b.pi_id and a.mi_id = 'test1';


select b.ps_size, b.ps_stock, sum(a.oc_cnt)
from t_order_cart a left join t_product_stock b on a.pi_id = b.pi_id
where a.mi_id = 'test1' and ps_isview = 'y' and a.pi_id = 'AA01102'
group by b.ps_size, b.ps_stock;

select * from t_order_cart;
select * from t_product_stock;

select a.*, b.pi_img1, if(b.pi_dc > 0, round((1 - b.pi_dc) * b.pi_price) ,b.pi_dc) price from t_order_cart a, t_product_info b where a.pi_id = b.pi_id and b.pi_isview = 'y' and a.mi_id = 'test1' order by a.pi_id, a.ps_idx;

select a.*,b.pi_name, b.pi_img1, if(b.pi_dc > 0, round((1 - b.pi_dc) * b.pi_price) ,b.pi_dc) price from t_order_cart a, t_product_info b where a.pi_id = b.pi_id and b.pi_isview = 'y' and a.mi_id = 'test1' order by a.pi_id, a.ps_idx;

select * from t_product_info;

select * from t_order_cart where mi_id='test1';
update t_order_cart set ps_idx = 23, oc_cnt = oc_cnt + 1 where oc_idx = 44;
delete from t_order_cart where ps_idx = 10;


delete from t_order_cart where ps_idx = 22;
-- delete from t_order_cart
select oc_idx, oc_cnt from t_order_cart where mi_id = 'test1' and ps_idx = 12;
select * from t_order_cart where mi_id = 'test1' and ps_idx = 1;
select oc_cnt, oc_idx from t_order_cart;
select * from t_order_cart;

update t_order_cart set ps_idx = ?, oc_cnt = ? where mi_id = '' and oc_idx = ?;
update t_order_cart set ps_idx = ? where mi_id = '' and oc_idx = ?;

select * from t_product_stock;
select * from t_product_info;


 update t_order_cart set ps_idx = 11 where mi_id = 'test1' and oc_idx = 34;

update t_order_cart set oc_cnt = 0 where mi_id = 'test1' and oc_idx = 34;
update t_order_cart set ps_idx = 11 where mi_id = 'test1' and oc_idx = 34;

-- 바로 구매 시 결제 폼 쿼리
select a.pi_id, a.pi_name, a.pi_img1, b.ps_size, if(a.pi_dc > 0, round((1 - a.pi_dc) * a.pi_price), a.pi_price) price, ? cnt
from t_product_info a, t_product_stock b
where a.pi_id = b.pi_id and a.pi_isview = 'y' and b.ps_isview = 'y' and a.pi_id = '' and b.ps_idx = ? and b.ps_stock > ?;

-- 장바구니 구매 시 결제 폼 쿼리
select a.pi_id, a.pi_name, a.pi_img1, b.ps_size, c.oc_cnt, if(a.pi_dc > 0, round((1 - a.pi_dc) * a.pi_price), a.pi_price) price, c.oc_cnt cnt
from t_product_info a, t_product_stock b, t_order_cart c
where a.pi_id = b.pi_id and a.pi_isview = 'y' and b.ps_isview = 'y' 
and b.ps_idx = c.ps_idx and (c.oc_idx = ? or ... or c.oc_idx = ? )
order by a.pi_id, c.ps_idx;

select * from t_member_addr where mi_id = 'test1' order by ma_basic desc;


select a.pi_id, a.pi_name, a.pi_img1, b.ps_size, if(a.pi_dc > 0, round((1 - a.pi_dc) * a.pi_price), a.pi_price) price,  c.oc_cnt cnt, c.oc_idx  
from t_product_info a, t_product_stock b , t_order_cart c  
where a.pi_id = b.pi_id and a.pi_isview = 'y' and b.ps_isview = 'y'  and a.pi_id = c.pi_id and b.ps_idx = c.ps_idx and c.mi_id = 'test1' and (c.oc_idx = 44) 
order by a.pi_id, c.ps_idx;



