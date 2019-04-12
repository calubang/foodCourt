ALTER TABLE fook_user
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

ALTER TABLE fook_manager
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

ALTER TABLE fook_job
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

ALTER TABLE fook_food
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

ALTER TABLE fook_category
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

ALTER TABLE fook_payment
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

ALTER TABLE fook_payment_detail
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_fook_user;

DROP INDEX PK_fook_manager;

DROP INDEX PK_fook_job;

DROP INDEX food;

DROP INDEX categories;

DROP INDEX PK_fook_payment;

DROP INDEX PK_fook_payment_detail;

/* fook_user */
DROP TABLE fook_user 
	CASCADE CONSTRAINTS;

/* fook_manager */
DROP TABLE fook_manager 
	CASCADE CONSTRAINTS;

/* fook_job */
DROP TABLE fook_job 
	CASCADE CONSTRAINTS;

/* fook_food */
DROP TABLE fook_food 
	CASCADE CONSTRAINTS;

/* fook_category */
DROP TABLE fook_category 
	CASCADE CONSTRAINTS;

/* fook_payment */
DROP TABLE fook_payment 
	CASCADE CONSTRAINTS;

/* fook_payment_detail */
DROP TABLE fook_payment_detail 
	CASCADE CONSTRAINTS;

/* fook_user */
CREATE TABLE fook_user (
	user_id VARCHAR2(32) NOT NULL, /* 유저ID */
	password VARCHAR2(32), /* 비밀번호 */
	name VARCHAR2(32), /* 이름 */
	phone_first VARCHAR2(3), /* 핸드폰번호1 */
	phone_middle VARCHAR2(4), /* 핸드폰번호2 */
	phone_last VARCHAR2(4), /* 핸드폰번호3 */
	user_point NUMBER, /* 사용가능포인트 */
	password_quiz VARCHAR2(80), /* 비밀번호퀴즈 */
	password_answer VARCHAR2(80), /* 비밀번호답변 */
	join_date DATE, /* 가입일 */
	secession_date DATE, /* 탈퇴일 */
	enable VARCHAR2(1) /* 활성화여부 */
);

COMMENT ON TABLE fook_user IS 'fook_user';

COMMENT ON COLUMN fook_user.user_id IS '유저ID';

COMMENT ON COLUMN fook_user.password IS '비밀번호';

COMMENT ON COLUMN fook_user.name IS '이름';

COMMENT ON COLUMN fook_user.phone_first IS '핸드폰번호1';

COMMENT ON COLUMN fook_user.phone_middle IS '핸드폰번호2';

COMMENT ON COLUMN fook_user.phone_last IS '핸드폰번호3';

COMMENT ON COLUMN fook_user.user_point IS '사용가능포인트';

COMMENT ON COLUMN fook_user.password_quiz IS '비밀번호퀴즈';

COMMENT ON COLUMN fook_user.password_answer IS '비밀번호답변';

COMMENT ON COLUMN fook_user.join_date IS '가입일';

COMMENT ON COLUMN fook_user.secession_date IS '탈퇴일';

COMMENT ON COLUMN fook_user.enable IS '활성화여부';

CREATE UNIQUE INDEX PK_fook_user
	ON fook_user (
		user_id ASC
	);

ALTER TABLE fook_user
	ADD
		CONSTRAINT PK_fook_user
		PRIMARY KEY (
			user_id
		);

/* fook_manager */
CREATE TABLE fook_manager (
	manager_id VARCHAR2(32) NOT NULL, /* 관리자ID */
	name VARCHAR2(32), /* 이름 */
	password VARCHAR2(32), /* 비밀번호 */
	phone_first VARCHAR2(3), /* 핸드폰번호1 */
	phone_middle VARCHAR2(4), /* 핸드폰번호2 */
	phone_last VARCHAR2(4), /* 핸드폰번호3 */
	job_id VARCHAR2(32), /* 직업코드 */
	hire_date DATE, /* 입사일 */
	address_zip VARCHAR2(6), /* 우편번호 */
	address VARCHAR2(160), /* 주소 */
	email VARCHAR2(32), /* 이메일 */
	email_domain VARCHAR2(32) /* 이메일_도메인 */
);

COMMENT ON TABLE fook_manager IS 'fook_manager';

COMMENT ON COLUMN fook_manager.manager_id IS '관리자ID';

COMMENT ON COLUMN fook_manager.name IS '이름';

COMMENT ON COLUMN fook_manager.password IS '비밀번호';

COMMENT ON COLUMN fook_manager.phone_first IS '핸드폰번호1';

COMMENT ON COLUMN fook_manager.phone_middle IS '핸드폰번호2';

COMMENT ON COLUMN fook_manager.phone_last IS '핸드폰번호3';

COMMENT ON COLUMN fook_manager.job_id IS '직업코드';

COMMENT ON COLUMN fook_manager.hire_date IS '입사일';

COMMENT ON COLUMN fook_manager.address_zip IS '우편번호';

COMMENT ON COLUMN fook_manager.address IS '주소';

COMMENT ON COLUMN fook_manager.email IS '이메일';

COMMENT ON COLUMN fook_manager.email_domain IS '이메일_도메인';

CREATE UNIQUE INDEX PK_fook_manager
	ON fook_manager (
		manager_id ASC
	);

ALTER TABLE fook_manager
	ADD
		CONSTRAINT PK_fook_manager
		PRIMARY KEY (
			manager_id
		);

/* fook_job */
CREATE TABLE fook_job (
	job_id VARCHAR2(32) NOT NULL, /* 직급ID */
	job_name VARCHAR2(64), /* 직급 */
	grade_level VARCHAR2(1) /* 보안등급 */
);

COMMENT ON TABLE fook_job IS 'fook_job';

COMMENT ON COLUMN fook_job.job_id IS '직급ID';

COMMENT ON COLUMN fook_job.job_name IS '직급';

COMMENT ON COLUMN fook_job.grade_level IS '보안등급';

CREATE UNIQUE INDEX PK_fook_job
	ON fook_job (
		job_id ASC
	);

ALTER TABLE fook_job
	ADD
		CONSTRAINT PK_fook_job
		PRIMARY KEY (
			job_id
		);

/* fook_food */
CREATE TABLE fook_food (
	food_id VARCHAR2(64) NOT NULL, /* 음식ID */
	food_name VARCHAR2(64), /* 음식이름 */
	category_id NUMBER(2) NOT NULL, /* 카테고리ID */
	price NUMBER(6), /* 가격 */
	food_point NUMBER(6), /* 포인트 */
	food_description VARCHAR2(1024), /* 설명 */
	image_address VARCHAR2(128), /* 이미지주소 */
	manager_id VARCHAR2(32), /* 관리자ID */
	create_date DATE DEFAULT sysdate, /* 생성일 */
	food_enable VARCHAR2(1) /* 활성화여부 */
);

COMMENT ON TABLE fook_food IS 'fook_food';

COMMENT ON COLUMN fook_food.food_id IS 'food_id는 카테고리아이디 + 푸드네임 + 생성날짜 조합
ex) 1_bibimbap_190101';

COMMENT ON COLUMN fook_food.food_name IS '음식이름';

COMMENT ON COLUMN fook_food.category_id IS '1 : korean, 2 : Chinese, ...';

COMMENT ON COLUMN fook_food.price IS '가격';

COMMENT ON COLUMN fook_food.food_point IS '포인트';

COMMENT ON COLUMN fook_food.food_description IS '설명';

COMMENT ON COLUMN fook_food.image_address IS '이미지주소';

COMMENT ON COLUMN fook_food.manager_id IS '관리자ID';

COMMENT ON COLUMN fook_food.create_date IS '생성일';

COMMENT ON COLUMN fook_food.food_enable IS '활성화여부';

CREATE UNIQUE INDEX food
	ON fook_food (
		food_id ASC
	);

ALTER TABLE fook_food
	ADD
		CONSTRAINT food
		PRIMARY KEY (
			food_id
		);

/* fook_category */
CREATE TABLE fook_category (
	category_id NUMBER(2) NOT NULL, /* 카테고리ID */
	category_name VARCHAR2(64) /* 카테고리_이름 */
);

COMMENT ON TABLE fook_category IS 'fook_category';

COMMENT ON COLUMN fook_category.category_id IS '카테고리ID';

COMMENT ON COLUMN fook_category.category_name IS 'korean, chinese';

CREATE UNIQUE INDEX categories
	ON fook_category (
		category_id ASC
	);

ALTER TABLE fook_category
	ADD
		CONSTRAINT categories
		PRIMARY KEY (
			category_id
		);

/* fook_payment */
CREATE TABLE fook_payment (
	payment_id VARCHAR2(32) NOT NULL, /* 결제ID */
	user_id VARCHAR2(32) NOT NULL, /* 유저ID */
	payment_date DATE DEFAULT sysdate, /* 결제일 */
	request_number NUMBER(4), /* 요청번호 */
	total_price NUMBER, /* 총가격 */
	save_point NUMBER DEFAULT 0, /* 총획득포인트 */
	cash NUMBER DEFAULT 0, /* 현금금액 */
	card NUMBER DEFAULT 0, /* 카드금액 */
	used_point NUMBER DEFAULT 0, /* 결제시사용포인트 */
	payment_state VARCHAR2(1) /* 결제상태 */
);

COMMENT ON TABLE fook_payment IS 'fook_payment';

COMMENT ON COLUMN fook_payment.payment_id IS '날짜 + 시퀀스(4자리)
ex) 1904010001';

COMMENT ON COLUMN fook_payment.user_id IS '유저ID';

COMMENT ON COLUMN fook_payment.payment_date IS '결제일';

COMMENT ON COLUMN fook_payment.request_number IS '요청번호';

COMMENT ON COLUMN fook_payment.total_price IS '총가격';

COMMENT ON COLUMN fook_payment.save_point IS '총획득포인트';

COMMENT ON COLUMN fook_payment.cash IS '현금금액';

COMMENT ON COLUMN fook_payment.card IS '카드금액';

COMMENT ON COLUMN fook_payment.used_point IS '결제시사용포인트';

COMMENT ON COLUMN fook_payment.payment_state IS '환불(1)
결제완료(0)';

CREATE UNIQUE INDEX PK_fook_payment
	ON fook_payment (
		payment_id ASC
	);

ALTER TABLE fook_payment
	ADD
		CONSTRAINT PK_fook_payment
		PRIMARY KEY (
			payment_id
		);

/* fook_payment_detail */
CREATE TABLE fook_payment_detail (
	payment_id VARCHAR2(32) NOT NULL, /* 결제_ID */
	food_id VARCHAR2(64) NOT NULL, /* 음식ID */
	food_name VARCHAR2(64), /* 음식이름 */
	price NUMBER, /* 가격 */
	count NUMBER, /* 수량 */
	point NUMBER DEFAULT 0 /* 획득포인트 */
);

COMMENT ON TABLE fook_payment_detail IS 'fook_payment_detail';

COMMENT ON COLUMN fook_payment_detail.payment_id IS '결제_ID';

COMMENT ON COLUMN fook_payment_detail.food_id IS '음식ID';

COMMENT ON COLUMN fook_payment_detail.food_name IS '음식이름';

COMMENT ON COLUMN fook_payment_detail.price IS '가격';

COMMENT ON COLUMN fook_payment_detail.count IS '수량';

COMMENT ON COLUMN fook_payment_detail.point IS '획득포인트';

CREATE UNIQUE INDEX PK_fook_payment_detail
	ON fook_payment_detail (
		payment_id ASC,
		food_id ASC
	);

ALTER TABLE fook_payment_detail
	ADD
		CONSTRAINT PK_fook_payment_detail
		PRIMARY KEY (
			payment_id,
			food_id
		);
-- 시퀀스 삭제 및 생석
DROP SEQUENCE food_fid_seq;
DROP SEQUENCE payment_pid_seq;

CREATE SEQUENCE food_fid_seq
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 99999
    MINVALUE 1
    NOCYCLE;

CREATE SEQUENCE payment_pid_seq 
    START WITH 1
    INCREMENT BY 1 
    MAXVALUE 999999 
    MINVALUE 0
    NOCYCLE;

-- JOB
insert into fook_job(job_id, job_name, grade_level) values ('Admin', '관리자', 'H');
insert into fook_job(job_id, job_name, grade_level) values ('Clerk', '점원', 'M');
insert into fook_job(job_id, job_name, grade_level) values ('Newbie', '신입', 'L');

-- MANAGER
insert into fook_manager(manager_id, name, password, phone_first, phone_middle, phone_last, job_id, hire_date, address_zip, address, email, email_domain)
values ('Admin123', '홍길동', '123qwe', '010', '1234', '5678', 'Admin', sysdate, '34343', 'Seoul yeouido', 'kitri', 'naver.com');
insert into fook_manager(manager_id, name, password, phone_first, phone_middle, phone_last, job_id, hire_date, address_zip, address, email, email_domain)
values ('Clerk123', '서생원', '1a2s3d4f', '010', '2345', '6789', 'Clerk', sysdate, '43438', 'Seoul yeongdeungpogu', 'c234', 'hanmail.net');
insert into fook_manager(manager_id, name, password, phone_first, phone_middle, phone_last, job_id, hire_date, address_zip, address, email, email_domain)
values ('Newbie123', '김두한', 'skujhf723', '010', '3456', '7890', 'Newbie', sysdate, '29843', 'Seoul jonglogu', '2396sdf', 'google.com');

-- CATEGORY
insert into fook_category(category_id, category_name) values (1, '한식');
insert into fook_category(category_id, category_name) values (2, '중식');
insert into fook_category(category_id, category_name) values (3, '일식');
insert into fook_category(category_id, category_name) values (4, '양식');

-- FOOD
insert into fook_food(food_id, food_name, category_id, price, food_point, food_description, image_address, manager_id, create_date, food_enable)
values (food_fid_seq.nextval, '볶음밥', 1, 6000, 60, '신선한 야채를 사용.', '/kitri/foodCourt/management/menu/image/bokeumbap.jpg', 'Clerk123', sysdate, 'y');
insert into fook_food(food_id, food_name, category_id, price, food_point, food_description, image_address, manager_id, create_date, food_enable)
values (food_fid_seq.nextval, '자장면', 2, 5000, 50, '직접 수타로 만듦.', '/kitri/foodCourt/management/menu/image/jajangmyeon.jpg', 'Clerk123', sysdate, 'y');
insert into fook_food(food_id, food_name, category_id, price, food_point, food_description, image_address, manager_id, create_date, food_enable)
values (food_fid_seq.nextval, '소바', 3, 7000, 70, '메밀이 들어감.', '/kitri/foodCourt/management/menu/image/soba.jpg', 'Clerk123', sysdate, 'y');
insert into fook_food(food_id, food_name, category_id, price, food_point, food_description, image_address, manager_id, create_date, food_enable)
values (food_fid_seq.nextval, '스테이크', 4, 9500, 95, '뉴질랜드산 소고기를 사용.', '/kitri/foodCourt/management/menu/image/steak.jpg', 'Admin123', sysdate, 'y');
INSERT INTO "FOOK"."FOOK_FOOD" (FOOD_ID, FOOD_NAME, CATEGORY_ID, PRICE, FOOD_POINT, FOOD_DESCRIPTION, IMAGE_ADDRESS, MANAGER_ID, CREATE_DATE, FOOD_ENABLE) VALUES ('6', '테스트1', '1', '6000', '60', '국내산 콩 사용1', '/img/food/ilsic.jpg', 'Admin123', TO_DATE('2019-04-12 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'y');
INSERT INTO "FOOK"."FOOK_FOOD" (FOOD_ID, FOOD_NAME, CATEGORY_ID, PRICE, FOOD_POINT, FOOD_DESCRIPTION, IMAGE_ADDRESS, MANAGER_ID, CREATE_DATE, FOOD_ENABLE) VALUES ('7', '테스트2', '2', '6000', '60', '국내산 콩 사용2', '/img/food/jajangmyeon.jpg', 'Admin123', TO_DATE('2019-04-12 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'y');
INSERT INTO "FOOK"."FOOK_FOOD" (FOOD_ID, FOOD_NAME, CATEGORY_ID, PRICE, FOOD_POINT, FOOD_DESCRIPTION, IMAGE_ADDRESS, MANAGER_ID, CREATE_DATE, FOOD_ENABLE) VALUES ('8', '테스트3', '3', '6000', '60', '국내산 콩 사용3', '/img/food/joongsic.jpg', 'Admin123', TO_DATE('2019-04-12 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'y');
INSERT INTO "FOOK"."FOOK_FOOD" (FOOD_ID, FOOD_NAME, CATEGORY_ID, PRICE, FOOD_POINT, FOOD_DESCRIPTION, IMAGE_ADDRESS, MANAGER_ID, CREATE_DATE, FOOD_ENABLE) VALUES ('9', '테스트4', '4', '6000', '60', '국내산 콩 사용4', '/img/food/junjoobibimbab.jpg', 'Admin123', TO_DATE('2019-04-12 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'y');
INSERT INTO "FOOK"."FOOK_FOOD" (FOOD_ID, FOOD_NAME, CATEGORY_ID, PRICE, FOOD_POINT, FOOD_DESCRIPTION, IMAGE_ADDRESS, MANAGER_ID, CREATE_DATE, FOOD_ENABLE) VALUES ('10', '테스트5', '1', '6000', '60', '국내산 콩 사용5', '/img/food/soba.jpg', 'Admin123', TO_DATE('2019-04-12 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'y');
INSERT INTO "FOOK"."FOOK_FOOD" (FOOD_ID, FOOD_NAME, CATEGORY_ID, PRICE, FOOD_POINT, FOOD_DESCRIPTION, IMAGE_ADDRESS, MANAGER_ID, CREATE_DATE, FOOD_ENABLE) VALUES ('11', '테스트6', '2', '6000', '60', '국내산 콩 사용6', '/img/food/steak.jpg', 'Admin123', TO_DATE('2019-04-12 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'y');
INSERT INTO "FOOK"."FOOK_FOOD" (FOOD_ID, FOOD_NAME, CATEGORY_ID, PRICE, FOOD_POINT, FOOD_DESCRIPTION, IMAGE_ADDRESS, MANAGER_ID, CREATE_DATE, FOOD_ENABLE) VALUES ('12', '테스트7', '3', '6000', '60', '국내산 콩 사용7', '/img/food/yangsic.jpeg', 'Admin123', TO_DATE('2019-04-12 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'y');


-- USER
insert into fook_user(user_id, password, name, phone_first, phone_middle, phone_last, user_point, password_quiz, password_answer, join_date, secession_date, enable)
values ('a1s2d3', '1q2w3e', '이수만', '010', '1234', '5678', 0, 'Country?', 'South Korea', sysdate, NULL, 'y');
insert into fook_user(user_id, password, name, phone_first, phone_middle, phone_last, user_point, password_quiz, password_answer, join_date, secession_date, enable)
values ('dfkjhg987', 'dfjhjh2', '박진영', '010', '3456', '7890', 10000, 'City?', 'Seoul', sysdate, NULL, 'y');
insert into fook_user(user_id, password, name, phone_first, phone_middle, phone_last, user_point, password_quiz, password_answer, join_date, secession_date, enable)
values ('dxcvowej34', '2309fjsdjfh', '양현석', '010', '7948', '2948', 300, 'Nation?', 'East Asia', sysdate, sysdate, 'n');

-- PAYMENT
insert into fook_payment(payment_id, user_id, payment_date, request_number, total_price, save_point, used_point, card, cash, payment_state)
values (payment_pid_seq.nextval, 'a1s2d3', sysdate, '0001', 50000, 500, 0, 25000, 25000, '0');
insert into fook_payment(payment_id, user_id, payment_date, request_number, total_price, save_point, used_point, card, cash, payment_state)
values (payment_pid_seq.nextval, 'dfkjhg987', sysdate, '0002', 150000, 1500, 0, 125000, 25000, '0');
insert into fook_payment(payment_id, user_id, payment_date, request_number, total_price, save_point, used_point, card, cash, payment_state)
values (payment_pid_seq.nextval, 'dxcvowej34', sysdate, '0003', 80000, 800, 0, 25000, 55000, '0');

-- PAYMENT_DETAIL
insert into fook_payment_detail(payment_id, food_id, food_name, price, count, point)
values ('1', '72', '볶음밥', 6000, 3, 60);
insert into fook_payment_detail(payment_id, food_id, food_name, price, count, point)
values ('1', '73', '자장면', 5000, 2, 50);
insert into fook_payment_detail(payment_id, food_id, food_name, price, count, point)
values ('1', '74', '소바', 7000, 1, 70);
insert into fook_payment_detail(payment_id, food_id, food_name, price, count, point)
values ('1', '75', '스테이크', 9500, 4, 95);

insert into fook_payment_detail(payment_id, food_id, food_name, price, count, point)
values ('0', '73', '자장면', 5000, 3, 50);
insert into fook_payment_detail(payment_id, food_id, food_name, price, count, point)
values ('0', '74', '소바', 7000, 2, 70);

insert into fook_payment_detail(payment_id, food_id, food_name, price, count, point)
values ('2', '72', '볶음밥', 6000, 5, 60);
insert into fook_payment_detail(payment_id, food_id, food_name, price, count, point)
values ('2', '74', '소바', 7000, 3, 70);
insert into fook_payment_detail(payment_id, food_id, food_name, price, count, point)
values ('2', '75', '스테이크', 9500, 1, 95);

COMMIT;
