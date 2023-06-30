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









