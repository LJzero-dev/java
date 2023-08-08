create database mall;
use mall;

-- 관리자 정보 테이블 

create table t_admin_info(
	ai_idx int auto_increment unique,	-- 일련번호
	ai_id varchar(20) primary key,		-- 아이디
	ai_pw varchar(20) not null,			-- 비밀번호
	ai_name varchar(20) not null,		-- 이름
	ai_use char(1) default 'y',			-- 사용여부
	ai_date datetime default now()		-- 등록일
);
insert into t_admin_info (ai_id, ai_pw, ai_name) values ('admin', '1111', '관리자');
select * from t_admin_info;



-- 회원 정보 테이블

create table t_member_info(		
	mi_id varchar(20) primary key,	-- 회원ID
	mi_pw varchar(20) not null,		-- 비밀번호
	mi_name varchar(20) not null,	-- 이름
	mi_gender char(1) not null,		-- 성별
	mi_birth char(10) not null,	 	-- 생년월일
	mi_phone varchar(13) not null,	-- 전화번호
	mi_email varchar(50) not null,	-- 이메일
	mi_isad	char(1)	not null,		-- 광고수신
	mi_point int default 0,			-- 보유포인트
	mi_status char(1) default 'a',	-- 상태
	mi_date	datetime default now(),	-- 가입일
	mi_lastlogin datetime 			-- 최종로그인
);
insert into t_member_info (mi_id, mi_pw, mi_name, mi_gender, mi_birth, mi_phone, mi_email, mi_isad, mi_point) 
values('test1', '1234', '홍길동', '남','1988-05-20', '010-1234-5678', 'hong@test.com', 'y', 1000); 
insert into t_member_info (mi_id, mi_pw, mi_name, mi_gender, mi_birth, mi_phone, mi_email, mi_isad, mi_point) 
values('test2', '1234', '유관순', '여','1989-03-01', '010-3333-1111', 'you@test.com', 'y', 1000); 
insert into t_member_info (mi_id, mi_pw, mi_name, mi_gender, mi_birth, mi_phone, mi_email, mi_isad, mi_point) 
values('test3', '1234', '전우치', '남','1995-12-20', '010-9999-8888', 'jeon@test.com', 'y', 1000); 

select * from t_member_info where mi_id = ? and mi_pw = ?;



-- 회원 주소록 테이블

create table t_member_addr(
	ma_idx int primary key auto_increment,	-- 일련번호
	mi_id varchar(20) not null,				-- 회원 ID
	ma_name	varchar(20)	not null,			-- 주소이름
	ma_rname varchar(20) not null,			-- 수취인 이름
	ma_phone varchar(13) not null,			-- 휴대폰
	ma_zip char(5) not null,				-- 우편번호 
	ma_addr1 varchar(50) not null,			-- 주소 1
	ma_addr2 varchar(50) not null,			-- 주소 2
	ma_basic char(1) default 'y',			-- 기본주소 여부
	ma_date	datetime default now(),			-- 등록일
	constraint fk_mamber_addr_mi_id foreign key (mi_id)
		references t_member_info(mi_id)
);
insert into t_member_addr (mi_id, ma_name, ma_rname, ma_phone, ma_zip, ma_addr1, ma_addr2)
values ('test1', '집주소', '홍길순', '010-1111-3333', '12345', '부산시 연제구 연산동', '987-654');
insert into t_member_addr (mi_id, ma_name, ma_rname, ma_phone, ma_zip, ma_addr1, ma_addr2)
values ('test2', '집주소', '유관순', '010-3333-1111', '12345', '서울시 강남구 삼성동', '123-45');
insert into t_member_addr (mi_id, ma_name, ma_rname, ma_phone, ma_zip, ma_addr1, ma_addr2)
values ('test3', '집주소', '전우치', '010-9999-8888', '32145', '인천시 부평구 부평동', '555-666');

select * from t_member_addr;


-- 회원 포인트 내역 테이블

create table t_member_point(
	mp_idx int auto_increment primary key,	-- 일련번호
	mi_id varchar(20) not null,				-- 회원ID
	mp_su char(1) default 's',				-- 사용/적립
	mp_point int default 0,					-- 포인트
	mp_desc	varchar(20) not null,			-- 사용/적립 내용
	mp_detail varchar(20) default '',		-- 내역상세
	mp_date	datetime default now(),			-- 사용/적립일
	mp_admin int default 0,					-- 관리자 번호
	constraint fk_member_point_mi_id foreign key (mi_id)
		references t_member_info(mi_id)
);
insert into t_member_point (mi_id, mp_point, mp_desc)
values ('test1', 1000, '가입축하금');
insert into t_member_point (mi_id, mp_point, mp_desc)
values ('test2', 1000, '가입축하금');
insert into t_member_point (mi_id, mp_point, mp_desc)
values ('test3', 1000, '가입축하금');

select *from t_member_point;


-- 회원 상태정보 변경 테이블

create table t_member_status(
	ms_idx int auto_increment primary key, 	-- 일련번호
	mi_id varchar(20) not null, 			-- 회원ID
	ms_status char(1) not null,				-- 상태변경값
	ms_reason varchar(200) not null,		-- 사유
	ms_self int default 0,					-- 본인 여부
	ms_date datetime default now(), 		-- 일시
	constraint fk_member_status_mi_id foreign key (mi_id)
		references t_member_info(mi_id)
);



-- 상품 대분류 테이블

create table t_product_ctgr_big (			
	pcb_id char(2) primary key,	 	-- 대분류 코드
	pcb_name varchar(20) not null 	-- 대분류 이름
);
insert into t_product_ctgr_big values('AA', '구두');
insert into t_product_ctgr_big values('BB', '운동화');

select * from t_product_ctgr_big;


-- 상품 소분류 테이블

create table t_product_ctgr_small (			
	pcs_id char(4) primary key,		-- 소분류 코드
	pcb_id char(2) not null,		-- 대분류 코드
	pcs_name varchar(20) not null,	-- 소분류 이름
    constraint fk_product_ctgr_small_pcb_id foreign key (pcb_id)
		references t_product_ctgr_big(pcb_id)
);
insert into t_product_ctgr_small values ('AA01', 'AA', '로퍼');
insert into t_product_ctgr_small values ('AA02', 'AA', '윙팁');
insert into t_product_ctgr_small values ('AA03', 'AA', '더비');
insert into t_product_ctgr_small values ('BB01', 'BB', '러닝화');
insert into t_product_ctgr_small values ('BB02', 'BB', '농구화');
insert into t_product_ctgr_small values ('BB03', 'BB', '스니커즈');
select * from t_product_ctgr_small;





-- 상품 브랜드 테이블

create table t_product_brand (			
	pb_id char(2) primary key,		-- 브랜드 코드
	pb_name varchar(20) not null 	-- 브랜드 이름
);
insert into t_product_brand values ('B1', '랜드로버');
insert into t_product_brand values ('B2', '리갈');
insert into t_product_brand values ('B3', '나이키');
insert into t_product_brand values ('B4', '아디다스');

select * from t_product_brand;



-- 상품 정보 테이블

create table t_product_info (			
	pi_id char(7) primary key,			-- 상품ID
	pcs_id char(4) not null, 			-- 소분류 코드
	pb_id char(2) not null,				-- 브랜드 코드
	pi_name	varchar(50) not null,		-- 상품명
	pi_price int default 0, 			-- 가격
	pi_cost	int	default 0,  			-- 원가
	pi_dc float	default 0, 				-- 할인율
	pi_com varchar(20) not null,		-- 제조사
	pi_img1	varchar(50) not null, 		-- 상품 이미지1
	pi_img2	varchar(50) default '',		-- 상품 이미지2
	pi_img3 varchar(50)	default '',		-- 상품 이미지3
	pi_desc	varchar(50) not null, 		-- 설명 이미지
	pi_special varchar(4) default '',	-- 특별상품 여부
	pi_read int	default 0, 				-- 조회수
	pi_score float default 0, 			-- 평균 평점
	pi_review int default 0,  			-- 리뷰 개수
	pi_sale	int	default 0, 				-- 판매량
	pi_isview char(1) default 'n',		-- 게시여부
	pi_date	datetime default now(),		-- 등록일
	ai_idx int not null,				-- 등록관리자
	pi_last datetime default now(),		-- 최종 수정일
	pi_admin int default 0,				-- 최종 수정자
    constraint fk_product_info_pcs_id foreign key (pcs_id)
		references t_product_ctgr_small(pcs_id),
	 constraint fk_product_info_pb_id foreign key (pb_id)
		references t_product_brand(pb_id),
	constraint fk_product_info_ai_idx foreign key (ai_idx)
		references t_admin_info(ai_idx)
);
insert into t_product_info (pi_id, pcs_id, pb_id, pi_name, pi_price, pi_cost, pi_dc,
pi_com, pi_img1, pi_desc, pi_isview, ai_idx)
values ('AA01101', 'AA01', 'B1', '좋은 로퍼', 150000, 80000, 0, '좋은 회사', 'AA01101_1.jpg',
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


-- 상품 옵션별 재고
create table t_product_stock (			
	ps_idx int primary key auto_increment, 	-- 일련번호
	pi_id char(7) not null,					-- 상품ID
	ps_size	int	unsigned default 0,			-- 재고량
	ps_stock int default 0,					-- 사이즈
	ps_sale int	default 0,					-- 판매량
	ps_isview char(1) default 'n',			-- 게시여부
    constraint fk_product_stock_pi_id foreign key (pi_id)
		references t_product_info(pi_id)
);
insert into t_product_stock (pi_id, ps_size, ps_stock, ps_isview)
values ('AA01101', 250, 100, 'y');
insert into t_product_stock (pi_id, ps_size, ps_stock, ps_isview)
values ('AA01101', 255, 100, 'y');
insert into t_product_stock (pi_id, ps_size, ps_stock, ps_isview)
values ('AA01101', 260, 100, 'y');
insert into t_product_stock (pi_id, ps_size, ps_stock, ps_isview)
values ('AA01101', 265, 100, 'y');
insert into t_product_stock (pi_id, ps_size, ps_stock, ps_isview)
values ('AA01101', 270, 100, 'y');
insert into t_product_stock (pi_id, ps_size, ps_stock, ps_isview)
values ('AA01101', 275, 100, 'y');
insert into t_product_stock (pi_id, ps_size, ps_stock, ps_isview)
values ('AA01101', 280, 100, 'y');

insert into t_product_stock (pi_id, ps_size, ps_stock, ps_isview)
values ('AA01102', 220, 150, 'y');
insert into t_product_stock (pi_id, ps_size, ps_stock, ps_isview)
values ('AA01102', 225, 150, 'y');
insert into t_product_stock (pi_id, ps_size, ps_stock, ps_isview)
values ('AA01102', 230, 150, 'y');
insert into t_product_stock (pi_id, ps_size, ps_stock, ps_isview)
values ('AA01102', 235, 150, 'y');
insert into t_product_stock (pi_id, ps_size, ps_stock, ps_isview)
values ('AA01102', 240, 150, 'y');
insert into t_product_stock (pi_id, ps_size, ps_stock, ps_isview)
values ('AA01102', 245, 150, 'y');
insert into t_product_stock (pi_id, ps_size, ps_stock, ps_isview)
values ('AA01102', 250, 150, 'y');

insert into t_product_stock (pi_id, ps_size, ps_stock, ps_isview)
values ('BB01101', 220, 130, 'y');
insert into t_product_stock (pi_id, ps_size, ps_stock, ps_isview)
values ('BB01101', 230, 140, 'y');
insert into t_product_stock (pi_id, ps_size, ps_stock, ps_isview)
values ('BB01101', 240, 130, 'y');
insert into t_product_stock (pi_id, ps_size, ps_stock, ps_isview)
values ('BB01101', 250, 140, 'y');
insert into t_product_stock (pi_id, ps_size, ps_stock, ps_isview)
values ('BB01101', 260, 150, 'y');
insert into t_product_stock (pi_id, ps_size, ps_stock, ps_isview)
values ('BB01101', 270, 160, 'y');
insert into t_product_stock (pi_id, ps_size, ps_stock, ps_isview)
values ('BB01101', 280, 170, 'y');

select * from t_product_stock;



-- 장바구니 테이블

create table t_order_cart (			
	oc_idx int auto_increment primary key, 	-- 일련번호
	mi_id varchar(20) not null,				-- 회원ID
	pi_id char(7) not null,					-- 상품ID
	ps_idx int not null,					-- 옵션별재고ID
	oc_cnt int default 1,					-- 개수
	oc_date	datetime default now(),			-- 등록일
    constraint fk_order_cart_mi_id foreign key (mi_id)
		references t_member_info(mi_id),
	constraint fk_order_cart_pi_id foreign key (pi_id)
		references t_product_info(pi_id),
	constraint fk_order_cart_ps_idx foreign key (ps_idx)
		references t_product_stock(ps_idx)
);



-- 주문정보 테이블

create table t_order_info (			
	oi_id char(14) primary key,		-- 주문정보
	mi_id varchar(20) not null,		-- 회원ID
	oi_name	varchar(20) not null,	-- 수취인명
	oi_phone varchar(13) not null,	-- 배송지 전화번호
	oi_zip char(5) not null,		-- 배송지 우편번호
	oi_addr1 varchar(50) not null,	-- 배송지 주소1
	oi_addr2 varchar(50) not null,	-- 배송지 주소2
	oi_memo	varchar(50), 			-- 요청사항
	oi_payment char(1) default 'a',	-- 결제수단
	oi_pay int default 0,			-- 결제액
	oi_upoint int default 0,		-- 사용포인트
	oi_spoint int default 0,		-- 적립 포인트
	oi_invoice varchar(50),			-- 송장번호
	oi_status char(1) default 'a',	-- 주문상태
	oi_date datetime default now(),	-- 주문일
    constraint fk_order_info_mi_id foreign key (mi_id)
		references t_member_info (mi_id)
);


-- 주문 상세정보 테이블

create table t_order_detail (			
	oc_idx int auto_increment primary key,	-- 일련번호
	oi_id char(14) not null,				-- 주문번호
	pi_id char(7) not null,					-- 상품ID
	ps_idx int not null,					-- 옵션별재고ID
	od_cnt int default 1,					-- 개수
	od_price int not null,					-- 단가
	od_name varchar(50) not null,			-- 상품명
	od_img varchar(50) not null,			-- 상품이미지
	od_size int	default 0,					-- 옵션명
    constraint fk_order_detail_oi_id foreign key (oi_id)
		references t_order_info(oi_id),
	constraint fk_order_detail_pi_id foreign key (pi_id)
		references t_product_info(pi_id),
	constraint fk_order_detail_ps_idx foreign key (ps_idx)
		references t_product_stock(ps_idx)
);
insert into t_order_info(oi_id, mi_id, oi_name, oi_phone, oi_zip, oi_addr1, oi_addr2, oi_memo, oi_payment, oi_pay, oi_upoint, oi_spoint)
values ('230518AD1001GN', 'test1', '홍길동', '010-1234-5678', '12355', '서울시 서대문구', '33-331', '', 'c', '150000', '1000', 1400);
insert into t_order_detail (oi_id, pi_id, ps_idx, od_cnt, od_price, od_name, od_img, od_size)
values ('230518AD1001GN', 'AA01101', 1, 1, 150000, '좋은 로퍼', 'AA01101_1.jpg', 250);
select *from t_order_info;
select *from t_order_detail;






-- 공지사항 테이블

create table t_notice_list (			
	nl_idx int primary key, 		-- 글번호
	ai_idx int not null,			-- 작성자
	nl_ctgr varchar(10) not null,	-- 분류
	nl_title varchar(100) not null,	-- 제목
	nl_content text not null,		-- 내용
	nl_read	int	default 0,			-- 조회수
	nl_isview char(1) default 'y',	-- 게시여부
	nl_date datetime default now(),	-- 작성일
    constraint fk_notice_list_ai_idx foreign key (ai_idx)
		references t_admin_info (ai_idx)
);



-- Q&A 답변이 하나 테이블

create table t_qna_list (			
	ql_idx int primary key, 			-- 글번호
	mi_id varchar(20) not null,			-- 작성자ID
	ql_ctgr char(1) default 'a',		-- 질문분류
	ql_title varchar(100) not null,		-- 질문제목
	ql_content text	not null,			-- 질문내용
	ql_img1	varchar(50),				-- 이미지1
	ql_img2	varchar(50),				-- 이미지2
	ql_ip varchar(15) not null,			-- 질문자IP
	ql_qdate datetime default now(),	-- 질문일자
	ql_isanswer	char(1) default 'n',	-- 답변여부
	ql_ai_idx int default 0,			-- 답변 관리자
	ql_answer text,						-- 답변 내용
	ql_satis char(1) default 'z',		-- 답변 만족도
	ql_adate datetime,					-- 답변 일자
	ql_isview char(1) default 'y',		-- 게시여부
     constraint fk_t_qna_list_mi_id foreign key (mi_id)
		references t_member_info (mi_id)
);



-- 자유게시판 테이블

create table t_free_list (			
	fl_idx int primary key,			-- 글번호
	fl_ismem char(1) default 'y',	-- 회원여부
	fl_writer varchar(20) not null,	-- 작성자
	fl_pw varchar(20),				-- 비밀번호
	fl_title varchar(100) not null,	-- 제목
	fl_content text	not null,		-- 내용
	fl_reply int default 0,			-- 댓글개수
	fl_read	int	default 0,			-- 조회수
	fl_ip varchar(15) not null,		-- IP주소
	fl_isview char(1) default 'y',	-- 게시여부
	fl_date	datetime default now()	-- 작성일
);

select fl_idx, fl_title, fl_reply, fl_writer, fl_read, if(curdate() = date(fl_date), right(fl_date, 8), mid(fl_date,3,8)) wdate from t_free_list  where fl_isview = 'y'  order by fl_idx desc limit 0, 10;

select * from t_free_list;
insert into t_free_list (fl_idx, fl_writer, fl_title, fl_content, fl_ip) values (1,'test1', '제목1', '내용1', '120.0.0.1');
insert into t_free_list (fl_idx, fl_writer, fl_title, fl_content, fl_ip) values (2,'test1', '제목2', '내용2', '120.0.0.1');
insert into t_free_list (fl_idx, fl_writer, fl_title, fl_content, fl_ip) values (3,'test1', '제목3', '내용3', '120.0.0.1');
insert into t_free_list (fl_idx, fl_writer, fl_title, fl_content, fl_ip) values (4,'test1', '제목4', '내용4', '120.0.0.1');
insert into t_free_list (fl_idx, fl_writer, fl_title, fl_content, fl_ip) values (5,'test1', '제목5', '내용5', '120.0.0.1');
insert into t_free_list (fl_idx, fl_writer, fl_title, fl_content, fl_ip) values (6,'test1', '제목6', '내용6', '120.0.0.1');
insert into t_free_list (fl_idx, fl_writer, fl_title, fl_content, fl_ip) values (7,'test1', '제목7', '내용7', '120.0.0.1');
insert into t_free_list (fl_idx, fl_writer, fl_title, fl_content, fl_ip) values (8,'test1', '제목8', '내용8', '120.0.0.1');
insert into t_free_list (fl_idx, fl_writer, fl_title, fl_content, fl_ip) values (9,'test1', '제목9', '내용9', '120.0.0.1');
insert into t_free_list (fl_idx, fl_writer, fl_title, fl_content, fl_ip) values (10,'test1', '제목10', '내용10', '120.0.0.1');
insert into t_free_list (fl_idx, fl_writer, fl_title, fl_content, fl_ip) values (11,'test1', '제목11', '내용11', '120.0.0.1');
insert into t_free_list (fl_idx, fl_writer, fl_title, fl_content, fl_ip) values (12,'test1', '제목12', '내용12', '120.0.0.1');
insert into t_free_list (fl_idx, fl_writer, fl_title, fl_content, fl_ip) values (13,'test1', '제목13', '내용13', '120.0.0.1');
insert into t_free_list (fl_idx, fl_writer, fl_title, fl_content, fl_ip) values (14,'test1', '제목14', '내용14', '120.0.0.1');
insert into t_free_list (fl_idx, fl_writer, fl_title, fl_content, fl_ip) values (15,'test1', '제목15', '내용15', '120.0.0.1');
insert into t_free_list (fl_idx, fl_writer, fl_title, fl_content, fl_ip) values (16,'test1', '제목16', '내용16', '120.0.0.1');
insert into t_free_list (fl_idx, fl_writer, fl_title, fl_content, fl_ip) values (17,'test1', '제목17', '내용17', '120.0.0.1');
insert into t_free_list (fl_idx, fl_writer, fl_title, fl_content, fl_ip) values (18,'test1', '제목18', '내용18', '120.0.0.1');
insert into t_free_list (fl_idx, fl_writer, fl_title, fl_content, fl_ip) values (19,'test1', '제목19', '내용19', '120.0.0.1');
insert into t_free_list (fl_idx, fl_writer, fl_title, fl_content, fl_ip) values (20,'test1', '제목20', '내용20', '120.0.0.1');
insert into t_free_list (fl_idx, fl_writer, fl_title, fl_content, fl_ip) values (21,'test1', '제목21', '내용21', '120.0.0.1');

-- 자유게시판 댓글 테이블

create table t_free_reply (		
	fr_idx int auto_increment primary key,		-- 댓글번호
	fl_idx int not null, 						-- 게시글번호
	mi_id varchar(20) not null,					-- 회원ID
	fr_content varchar(200) not null,			-- 내용
	fr_good	int	default 0,						-- 좋아요
	fr_bad int default 0,						-- 싫어요
	fr_ip varchar(15) not null, 				-- IP주소
	fr_isview char(1) default 'y',				-- 게시여부
	fr_date	datetime default now(),				-- 작성일
     constraint fk_t_free_reply_fl_idx foreign key (fl_idx)
		references t_free_list (fl_idx),
	constraint fk_t_free_reply_mi_id foreign key (mi_id)
		references t_member_info (mi_id)
);



-- 자유게시판 댓글 좋아요/싫어요	

create table t_free_reply_gnb( 	
	frg_idx	int	auto_increment unique,		-- 일련번호
	mi_id varchar(20) not null,				-- 회원ID
	fr_idx int not null,					-- 댓글번호
	frg_gnb char(1)	default 'g',			-- 좋아요/싫어요
	frg_date datetime default now(),		-- 동록일
    constraint pk_free_reply_gnb primary key (mi_id, fr_idx),
    -- mi_id와 fr_idx 컬럼을 묶어서 PK로 지정
    constraint fk_free_reply_gnb_fr_idx foreign key (fr_idx)
		references t_free_reply (fr_idx),
	constraint fk_free_reply_gnb_mi_id foreign key (mi_id)
		references t_member_info (mi_id)
);

select * from t_free_list where fl_isview = 'y' and fl_idx = 12;
update t_free_list set fl_read = 2147483640 where fl_idx = 12;
-- 구매 후기 테이블

create table t_review_list (			
	rl_idx int unique,				-- 후기번호
	mi_id varchar(20) not null,		-- 회원ID
	oi_id char(14) not null,		-- 주문번호
	pi_id char(7) not null,			-- 상품ID
	ps_idx int not null,			-- 옵션별재고ID
	rl_name	varchar(100) not null,	-- 상품명 & 옵션명
	rl_title varchar(100) not null,	-- 제목
	rl_content text	not null,		-- 내용
	rl_img varchar(50),				-- 이미지
	rl_score float default 0,		-- 평점
	rl_read	int	default 0,			-- 조회수
	rl_good	int	default 0,			-- 좋아요
	rl_ip varchar(15) not null,		-- IP주소
	rl_isview char(1)default 'y',	-- 게시여부
	rl_date	datetime default now(),	-- 작성일
    constraint t_review_list primary key (mi_id, oi_id, pi_id, ps_idx),
    constraint fk_t_review_list_mi_id foreign key (mi_id)
		references t_member_info (mi_id),
	constraint fk_t_review_list_oi_id foreign key (oi_id)
		references t_order_info (oi_id),
	constraint fk_t_review_list_pi_id foreign key (pi_id)
		references t_product_info (pi_id),
	constraint fk_t_review_list_ps_idx foreign key (ps_idx)
		references t_product_stock (ps_idx)
);



-- 구매후기 좋아요 테이블

create table t_review_good (		
	rg_idx int auto_increment unique,	-- 일련번호
	mi_id varchar(20) not null,			-- 회원ID
	rl_idx int not null,				-- 후기번호
	rg_date datetime default now(),		-- 등록일
    constraint t_review_good primary key (mi_id, rl_idx),
    constraint fk_t_review_good_mi_id foreign key (mi_id)
		references t_member_info (mi_id),
	constraint fk_t_review_good_rl_idx foreign key (rl_idx)
		references t_review_list (rl_idx)
);



-- 일정관리 테이블

create table t_schedule_info (			
	si_idx int auto_increment primary key,	-- 일련번호
	mi_id varchar(20) not null,				-- 회원ID
	si_start datetime not null,				-- 일정시작일
	si_end datetime,						-- 일정종료일
	si_content varchar(200) not null,		-- 일정내용
	si_date	datetime default now(),			-- 등록일
    constraint fk_t_schedule_info_mi_id foreign key (mi_id)
		references t_member_info (mi_id)
);




-- 설문조사 테이블

create table t_poll_question (		
	pq_idx int primary key,				-- 일련번호
	pq_start datetime,					-- 설문 시작일
	pq_end datetime,					-- 설문 종료일
	pq_question varchar(200)not null,	-- 질문내용
	pq_status char(1) default 'a',		-- 설문 상태
	pq_date	datetime default now(),		-- 등록일
	ai_idx int not null,				-- 등록 관리자
    constraint fk_t_poll_question_ai_idx foreign key (ai_idx)
		references t_admin_info(ai_idx)
);



-- 설문조사 보기 테이블

create table t_poll_exam (			
	pe_idx int primary key auto_increment,	-- 일련번호
	pq_idx int not null,					-- 질문번호
	pe_seq int default 0,					-- 보기번호및순서
	pe_exam	varchar(100) not null, 			-- 보기내용
	pe_isuse char(1) default 'y',			-- 사용여부
	pe_cnt int default 0,					-- 선택횟수
    constraint fk_t_poll_exam_pq_idx foreign key (pq_idx)
		references t_poll_question(pq_idx)
);



-- 설문조사 결과 테이블

create table t_poll_result (		
	pr_idx int auto_increment unique,	-- 일련번호
	mi_id varchar(20), 					-- 회원ID
	pq_idx int,							-- 질문번호
	pe_idx int not null,				-- 보기번호
	pr_date datetime default now(),		-- 참여일
    constraint pk_t_poll_result primary key (mi_id, pq_idx),
    constraint fk_t_poll_result_mi_id foreign key (mi_id)
		references t_member_info (mi_id),
	constraint fk_t_poll_result_pq_idx foreign key (pq_idx)
		references t_poll_question (pq_idx),
	constraint fk_t_poll_result_pe_idx foreign key (pe_idx)
		references t_poll_exam(pe_idx)
);

CREATE TABLE t_schedule_info (
  si_idx int AUTO_INCREMENT primary key,	-- 일련번호
  mi_id varchar(20) NOT NULL,				-- 회원ID
  si_date CHAR(10) NOT NULL,				-- 일정 일자
  si_time CHAR(5) NOT NULL,					-- 일정 시간
  si_content varchar(200) NOT NULL,			-- 일정 내용
  si_regdate datetime DEFAULT now(),		-- 등록일
  CONSTRAINT fk_schedule_info_mi_id FOREIGN KEY (mi_id) REFERENCES t_member_info (mi_id)
);

