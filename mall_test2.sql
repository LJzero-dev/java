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