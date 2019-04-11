DROP TABLE fook_manager;
DROP TABLE fook_job;
DROP TABLE fook_food;
DROP TABLE fook_category;
DROP TABLE fook_user;
DROP TABLE fook_payment;

CREATE TABLE fook_job (
	job_id VARCHAR2(32) NOT NULL, /* 직급ID */
	job_name VARCHAR2(64), /* 직급 */
	grade_level VARCHAR2(1), /* 보안등급 */
    CONSTRAINT job_job_id_pk PRIMARY KEY (job_id)
);

-- 예제 값
insert into fook_job(job_id, job_name, grade_level) values ('Admin', '관리자', 'H');
insert into fook_job(job_id, job_name, grade_level) values ('Clerk', '점원', 'M');
insert into fook_job(job_id, job_name, grade_level) values ('Newbie', '신입', 'L');

-- 확인
SELECT * FROM fook_job;


CREATE TABLE fook_manager (
	manager_id VARCHAR2(32) NOT NULL, /* 관리자ID */
	name VARCHAR2(32) NOT NULL, /* 이름 */
	password VARCHAR2(32) NOT NULL, /* 비밀번호 */
	phone_first VARCHAR2(3) NOT NULL, /* 핸드폰번호1 */
	phone_middle VARCHAR2(4) NOT NULL, /* 핸드폰번호2 */
	phone_last VARCHAR2(4) NOT NULL, /* 핸드폰번호3 */
	job_id VARCHAR2(32), /* 직업코드 */
	hire_date DATE DEFAULT sysdate, /* 입사일 */
	address_zip VARCHAR2(6), /* 우편번호 */
	address VARCHAR2(160), /* 주소 */
	email VARCHAR2(32), /* 이메일 */
	email_domain VARCHAR2(32), /* 이메일_도메인 */
    CONSTRAINT manager_manager_id_pk PRIMARY KEY (manager_id),
    CONSTRAINT manager_job_id_fk foreign key(job_id) references fook_job(job_id)
);

-- 예제 값
insert into fook_manager(manager_id, name, password, phone_first, phone_middle, phone_last, job_id, hire_date, address_zip, address, email, email_domain)
values ('Admin123', '홍길동', '123qwe', '010', '1234', '5678', 'Admin', sysdate, '34343', 'Seoul yeouido', 'kitri', 'naver.com');
insert into fook_manager(manager_id, name, password, phone_first, phone_middle, phone_last, job_id, hire_date, address_zip, address, email, email_domain)
values ('Clerk123', '서생원', '1a2s3d4f', '010', '2345', '6789', 'Clerk', sysdate, '43438', 'Seoul yeongdeungpogu', 'c234', 'hanmail.net');
insert into fook_manager(manager_id, name, password, phone_first, phone_middle, phone_last, job_id, hire_date, address_zip, address, email, email_domain)
values ('Newbie123', '김두한', 'skujhf723', '010', '3456', '7890', 'Newbie', sysdate, '29843', 'Seoul jonglogu', '2396sdf', 'google.com');

-- 확인
SELECT * FROM fook_manager;


CREATE TABLE fook_category (
	category_id NUMBER(2) NOT NULL, /* 카테고리ID */
	category_name VARCHAR2(64) NOT NULL, /* 카테고리_이름 */
    CONSTRAINT category_category_id_pk PRIMARY KEY (category_id)
);

-- 예제 값
insert into fook_category(category_id, category_name) values (1, '한식');
insert into fook_category(category_id, category_name) values (2, '중식');
insert into fook_category(category_id, category_name) values (3, '일식');
insert into fook_category(category_id, category_name) values (4, '양식');

-- 확인
SELECT * FROM fook_category;


CREATE TABLE fook_food (
	food_id VARCHAR2(64) NOT NULL, /* 음식ID */
	food_name VARCHAR2(64) NOT NULL, /* 음식이름 */
	category_id NUMBER(2) NOT NULL, /* 카테고리ID */
	price NUMBER(6) NOT NULL, /* 가격 */
	food_point NUMBER(6), /* 포인트 (가격 /100) - Default 설정이 안돼서 default 값 없음 */
	food_description VARCHAR2(1024), /* 설명 */
	image_address VARCHAR2(128) NOT NULL, /* 이미지주소 */
	manager_id VARCHAR2(32), /* 관리자ID */
	create_date DATE DEFAULT sysdate, /* 생성일 */
	food_enable VARCHAR2(1) DEFAULT 'y', /* 활성화여부 */
    CONSTRAINT food_food_id_pk PRIMARY KEY (food_id),
    CONSTRAINT food_category_id_fk foreign key(category_id) references fook_category(category_id),
    CONSTRAINT food_manager_id_fk foreign key(manager_id) references fook_manager(manager_id)
);

-- Sequence
CREATE SEQUENCE food_fid_seq START WITH 0 INCREMENT BY 1 MAXVALUE 999999 MINVALUE 0;

DROP SEQUENCE food_fid_seq;

-- 예제 값
insert into fook_food(food_id, food_name, category_id, price, food_point, food_description, image_address, manager_id, create_date, food_enable)
values (food_fid_seq.nextval, '볶음밥', 1, 6000, 60, '신선한 야채를 사용.', '/kitri/foodCourt/management/menu/image/bokeumbap.jpg', 'Clerk123', sysdate, 'y');
insert into fook_food(food_id, food_name, category_id, price, food_point, food_description, image_address, manager_id, create_date, food_enable)
values (food_fid_seq.nextval, '자장면', 2, 5000, 50, '직접 수타로 만듦.', '/kitri/foodCourt/management/menu/image/jajangmyeon.jpg', 'Clerk123', sysdate, 'y');
insert into fook_food(food_id, food_name, category_id, price, food_point, food_description, image_address, manager_id, create_date, food_enable)
values (food_fid_seq.nextval, '소바', 3, 7000, 70, '메밀이 들어감.', '/kitri/foodCourt/management/menu/image/soba.jpg', 'Clerk123', sysdate, 'y');
insert into fook_food(food_id, food_name, category_id, price, food_point, food_description, image_address, manager_id, create_date, food_enable)
values (food_fid_seq.nextval, '스테이크', 4, 9500, 95, '뉴질랜드산 소고기를 사용.', '/kitri/foodCourt/management/menu/image/steak.jpg', 'Admin123', sysdate, 'y');

-- 확인
SELECT * FROM fook_food;

commit;


CREATE TABLE fook_user (
	user_id VARCHAR2(32) NOT NULL, /* 유저ID */
	password VARCHAR2(32) NOT NULL, /* 비밀번호 */
	name VARCHAR2(32) NOT NULL, /* 이름 */
	phone_first VARCHAR2(3), /* 핸드폰번호1 */
	phone_middle VARCHAR2(4), /* 핸드폰번호2 */
	phone_last VARCHAR2(4), /* 핸드폰번호3 */
	user_point NUMBER DEFAULT 0, /* 사용가능포인트 */
	password_quiz VARCHAR2(80), /* 비밀번호퀴즈 */
	password_answer VARCHAR2(80), /* 비밀번호답변 */
	join_date DATE DEFAULT sysdate, /* 가입일 */
	secession_date DATE, /* 탈퇴일 */
	enable VARCHAR2(1) DEFAULT 'y' /* 활성화여부 */
);

-- 예제 값
insert into fook_user(user_id, password, name, phone_first, phone_middle, phone_last, user_point, password_quiz, password_answer, join_date, secession_date, enable)
values ('a1s2d3', '1q2w3e', '이수만', '010', '1234', '5678', 0, 'Country?', 'South Korea', sysdate, NULL, 'y');
insert into fook_user(user_id, password, name, phone_first, phone_middle, phone_last, user_point, password_quiz, password_answer, join_date, secession_date, enable)
values ('dfkjhg987', 'dfjhjh2', '박진영', '010', '3456', '7890', 10000, 'City?', 'Seoul', sysdate, NULL, 'y');
insert into fook_user(user_id, password, name, phone_first, phone_middle, phone_last, user_point, password_quiz, password_answer, join_date, secession_date, enable)
values ('dxcvowej34', '2309fjsdjfh', '양현석', '010', '7948', '2948', 300, 'Nation?', 'East Asia', sysdate, sysdate, 'n');

-- 확인
SELECT * FROM fook_user;


CREATE TABLE fook_payment (
	payment_id VARCHAR2(32) NOT NULL, /* 결제ID */
	user_id VARCHAR2(32) NOT NULL, /* 유저ID */
	payment_date DATE DEFAULT sysdate, /* 결제일 */
	request_number VARCHAR2(4), /* 요청번호 */
	total_price NUMBER, /* 총가격 */
	save_point NUMBER DEFAULT 0, /* 총획득포인트 */
	used_point NUMBER DEFAULT 0, /* 결제시사용포인트 */
	card NUMBER DEFAULT 0, /* 카드금액 */
	cash NUMBER DEFAULT 0, /* 현금금액 */
	payment_state VARCHAR2(1) /* 결제상태 */
);


-- Sequence
CREATE SEQUENCE payment_pid_seq START WITH 0 INCREMENT BY 1 MAXVALUE 999999 MINVALUE 0;

DROP SEQUENCE payment_pid_seq;

-- 예제 값
insert into fook_payment(payment_id, user_id, payment_date, request_number, total_price, save_point, used_point, card, cash, payment_state)
values (payment_pid_seq.nextval, 'a1s2d3', sysdate, '0001', 50000, 500, 0, 25000, 25000, '0');
insert into fook_payment(payment_id, user_id, payment_date, request_number, total_price, save_point, used_point, card, cash, payment_state)
values (payment_pid_seq.nextval, 'dfkjhg987', sysdate, '0002', 150000, 1500, 0, 125000, 25000, '0');
insert into fook_payment(payment_id, user_id, payment_date, request_number, total_price, save_point, used_point, card, cash, payment_state)
values (payment_pid_seq.nextval, 'dxcvowej34', sysdate, '0003', 80000, 800, 0, 25000, 55000, '0');

-- 확인
SELECT * FROM fook_payment;