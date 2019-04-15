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
values ('Administrator', '홍길동', '123q#we', '010', '1234', '9876', 'Admin', sysdate, '34343', '서울특별시 여의도동 영등포구 국회대로 17길', 'honggildong', 'naver.com');
insert into fook_manager(manager_id, name, password, phone_first, phone_middle, phone_last, job_id, hire_date, address_zip, address, email, email_domain)
values ('Clerk1', '서생원', 'eidud928', '010', '2345', '8765', 'Clerk', sysdate, '43378', '경기도 시흥시 정왕동 254번지', 'seosaengwon', 'hanmail.net');
insert into fook_manager(manager_id, name, password, phone_first, phone_middle, phone_last, job_id, hire_date, address_zip, address, email, email_domain)
values ('Clerk2', '이방헌', 'cjkjd46!2', '010', '3456', '7654', 'Clerk', sysdate, '67890', '강원도 삼척시 도계읍 점리', 'leebangheon', 'naver.com');
insert into fook_manager(manager_id, name, password, phone_first, phone_middle, phone_last, job_id, hire_date, address_zip, address, email, email_domain)
values ('Clerk3', '정도전', 'djsd984u24s', '010', '4567', '6543', 'Clerk', sysdate, '25727', '충청북도 청주시 상당구 내덕동 173-6', 'jeongdojeon', 'google.com');
insert into fook_manager(manager_id, name, password, phone_first, phone_middle, phone_last, job_id, hire_date, address_zip, address, email, email_domain)
values ('Clerk4', '김구', 'kkjfg%$sk', '010', '5678', '5432', 'Clerk', sysdate, '92783', '전라남도 순천군 동초면 금치리', 'kimku', 'hanmail.net');
insert into fook_manager(manager_id, name, password, phone_first, phone_middle, phone_last, job_id, hire_date, address_zip, address, email, email_domain)
values ('Clerk5', '박상면', 'sdjsjf98248', '010', '6789', '4321', 'Clerk', sysdate, '23985', '제주도 서귀포시 성산읍 서성일로 433', 'parksangmyeon', 'google.com');
insert into fook_manager(manager_id, name, password, phone_first, phone_middle, phone_last, job_id, hire_date, address_zip, address, email, email_domain)
values ('Newbie1', '이순재', 'zgzg761', '010', '7890', '3210', 'Newbie', sysdate, '86748', '대전광역시 유성구 가정로 218', 'leesoonjae', 'google.com');
insert into fook_manager(manager_id, name, password, phone_first, phone_middle, phone_last, job_id, hire_date, address_zip, address, email, email_domain)
values ('Newbie2', '신구', 'sfju394f89', '010', '8901', '2109', 'Newbie', sysdate, '64921', '대구광역시 동구 동부로 459', 'shinku', 'naver.com');
insert into fook_manager(manager_id, name, password, phone_first, phone_middle, phone_last, job_id, hire_date, address_zip, address, email, email_domain)
values ('Newbie3', '김두한', 'kudfg908dws', '010', '9012', '1098', 'Newbie', sysdate, '10198', '울산광역시 북구 효문동 587-1', 'kimduhan', 'google.com');


-- CATEGORY
insert into fook_category(category_id, category_name) values (1, '한식');
insert into fook_category(category_id, category_name) values (2, '중식');
insert into fook_category(category_id, category_name) values (3, '일식');
insert into fook_category(category_id, category_name) values (4, '양식');

-- FOOD
insert into fook_food(food_id, food_name, category_id, price, food_point, food_description, image_address, manager_id, create_date, food_enable)
values (food_fid_seq.nextval, '볶음밥', 1, 7000, 70, '신선한 야채를 사용.', 'bokeumbap.jpg', 'Newbie1', sysdate, 'y');
insert into fook_food(food_id, food_name, category_id, price, food_point, food_description, image_address, manager_id, create_date, food_enable)
values (food_fid_seq.nextval, '안동국시', 1, 7500, 75, '안종 지역에서 유래한 국수.', 'andongkuksi.jpg', 'Newbie2', sysdate, 'y');
insert into fook_food(food_id, food_name, category_id, price, food_point, food_description, image_address, manager_id, create_date, food_enable)
values (food_fid_seq.nextval, '바지락칼국수', 1, 7000, 70, '바지락이 들어가 개운함.', 'bajirakcalkuksu.jpg', 'Newbie3', sysdate, 'y');
insert into fook_food(food_id, food_name, category_id, price, food_point, food_description, image_address, manager_id, create_date, food_enable)
values (food_fid_seq.nextval, '뚝배기불고기', 1, 7900, 79, '기사식당의 인기 메뉴.', 'ddookbaegibulgogi.jpg', 'Clerk1', sysdate, 'y');
insert into fook_food(food_id, food_name, category_id, price, food_point, food_description, image_address, manager_id, create_date, food_enable)
values (food_fid_seq.nextval, '돌솥비빔밥', 1, 7500, 75, '다먹을 떄까지 온기가 유지됨.', 'dolsotbibimbap.jpg', 'Clerk2', sysdate, 'y');
insert into fook_food(food_id, food_name, category_id, price, food_point, food_description, image_address, manager_id, create_date, food_enable)
values (food_fid_seq.nextval, '갈비탕', 1, 9000, 90, '국내산 1등급 한우를 사용.', 'galbitang.jpg', 'Administrator', sysdate, 'y');
insert into fook_food(food_id, food_name, category_id, price, food_point, food_description, image_address, manager_id, create_date, food_enable)
values (food_fid_seq.nextval, '자장면', 2, 5000, 50, '직접 수타로 만듦.', 'jajangmyeon.jpg', 'Clerk4', sysdate, 'y');
insert into fook_food(food_id, food_name, category_id, price, food_point, food_description, image_address, manager_id, create_date, food_enable)
values (food_fid_seq.nextval, '마파두부', 2, 7000, 70, '중국식 두부 요리.', 'mapatofu.jpg', 'Clerk3', sysdate, 'y');
insert into fook_food(food_id, food_name, category_id, price, food_point, food_description, image_address, manager_id, create_date, food_enable)
values (food_fid_seq.nextval, '잡채밥', 2, 8000, 80, '짭잘한 잡채 요리.', 'japchaebap.jpg', 'Clerk5', sysdate, 'y');
insert into fook_food(food_id, food_name, category_id, price, food_point, food_description, image_address, manager_id, create_date, food_enable)
values (food_fid_seq.nextval, '찹쌀탕수육', 2, 13000, 130, '찹쌀로 만들어 식감이 쫄깃함.', 'chapssaltangsuyook.jpg', 'Clerk5', sysdate, 'y');
insert into fook_food(food_id, food_name, category_id, price, food_point, food_description, image_address, manager_id, create_date, food_enable)
values (food_fid_seq.nextval, '짬뽕', 2, 8000, 80, '칼칼한 국물이 일품임.', 'jjambbong.jpg', 'Clerk2', sysdate, 'y');
insert into fook_food(food_id, food_name, category_id, price, food_point, food_description, image_address, manager_id, create_date, food_enable)
values (food_fid_seq.nextval, '소바', 3, 7000, 70, '메밀이 들어감.', 'soba.jpg', 'Clerk1', sysdate, 'y');
insert into fook_food(food_id, food_name, category_id, price, food_point, food_description, image_address, manager_id, create_date, food_enable)
values (food_fid_seq.nextval, '알밥', 3, 8000, 80, '입안에서 톡톡 터지는 식감이 일품임.', 'albap.jpg', 'Clerk1', sysdate, 'y');
insert into fook_food(food_id, food_name, category_id, price, food_point, food_description, image_address, manager_id, create_date, food_enable)
values (food_fid_seq.nextval, '돈까스', 3, 8500, 85, '국내산 돈육을 사용함.', 'donkats.jpg', 'Clerk3', sysdate, 'y');
insert into fook_food(food_id, food_name, category_id, price, food_point, food_description, image_address, manager_id, create_date, food_enable)
values (food_fid_seq.nextval, '가쓰오우동', 3, 5000, 50, '정통 일본식 우동.', 'gasoudong.jpg', 'Clerk4', sysdate, 'y');
insert into fook_food(food_id, food_name, category_id, price, food_point, food_description, image_address, manager_id, create_date, food_enable)
values (food_fid_seq.nextval, '참치회덮밥', 3, 18000, 180, '참치 100% 사용.', 'chamchihoideopbap.jpg', 'Newbie2', sysdate, 'y');
insert into fook_food(food_id, food_name, category_id, price, food_point, food_description, image_address, manager_id, create_date, food_enable)
values (food_fid_seq.nextval, '스테이크', 4, 9500, 95, '뉴질랜드산 소고기를 사용.', 'steak.jpg', 'Administrator', sysdate, 'y');
insert into fook_food(food_id, food_name, category_id, price, food_point, food_description, image_address, manager_id, create_date, food_enable)
values (food_fid_seq.nextval, '토마토김치스파게티', 4, 8500, 85, '토마토와 김치의 만남.', 'tomatokimchispaghetti.jpg', 'Clerk2', sysdate, 'y');
insert into fook_food(food_id, food_name, category_id, price, food_point, food_description, image_address, manager_id, create_date, food_enable)
values (food_fid_seq.nextval, '클럽샌드위치', 4, 9000, 90, '한끼 식사로 적당함.', 'clubsandwitch.jpg', 'Newbie1', sysdate, 'y');
insert into fook_food(food_id, food_name, category_id, price, food_point, food_description, image_address, manager_id, create_date, food_enable)
values (food_fid_seq.nextval, '자이언트피자', 4, 14000, 140, '3~4인이 먹기에 적당한 피자.', 'giantpizza.jpg', 'Administrator', sysdate, 'y');
INSERT INTO "FOOK"."FOOK_FOOD" (FOOD_ID, FOOD_NAME, CATEGORY_ID, PRICE, FOOD_POINT, FOOD_DESCRIPTION, IMAGE_ADDRESS, MANAGER_ID, CREATE_DATE, FOOD_ENABLE) VALUES ('6', '테스트1', '1', '6000', '60', '국내산 콩 사용1', 'ilsic.jpg', 'Admin123', TO_DATE('2019-04-12 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'y');
INSERT INTO "FOOK"."FOOK_FOOD" (FOOD_ID, FOOD_NAME, CATEGORY_ID, PRICE, FOOD_POINT, FOOD_DESCRIPTION, IMAGE_ADDRESS, MANAGER_ID, CREATE_DATE, FOOD_ENABLE) VALUES ('7', '테스트2', '2', '6000', '60', '국내산 콩 사용2', 'jajangmyeon.jpg', 'Admin123', TO_DATE('2019-04-12 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'y');
INSERT INTO "FOOK"."FOOK_FOOD" (FOOD_ID, FOOD_NAME, CATEGORY_ID, PRICE, FOOD_POINT, FOOD_DESCRIPTION, IMAGE_ADDRESS, MANAGER_ID, CREATE_DATE, FOOD_ENABLE) VALUES ('8', '테스트3', '3', '6000', '60', '국내산 콩 사용3', 'joongsic.jpg', 'Admin123', TO_DATE('2019-04-12 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'y');
INSERT INTO "FOOK"."FOOK_FOOD" (FOOD_ID, FOOD_NAME, CATEGORY_ID, PRICE, FOOD_POINT, FOOD_DESCRIPTION, IMAGE_ADDRESS, MANAGER_ID, CREATE_DATE, FOOD_ENABLE) VALUES ('9', '테스트4', '4', '6000', '60', '국내산 콩 사용4', 'junjoobibimbab.jpg', 'Admin123', TO_DATE('2019-04-12 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'y');
INSERT INTO "FOOK"."FOOK_FOOD" (FOOD_ID, FOOD_NAME, CATEGORY_ID, PRICE, FOOD_POINT, FOOD_DESCRIPTION, IMAGE_ADDRESS, MANAGER_ID, CREATE_DATE, FOOD_ENABLE) VALUES ('10', '테스트5', '1', '6000', '60', '국내산 콩 사용5', 'soba.jpg', 'Admin123', TO_DATE('2019-04-12 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'y');
INSERT INTO "FOOK"."FOOK_FOOD" (FOOD_ID, FOOD_NAME, CATEGORY_ID, PRICE, FOOD_POINT, FOOD_DESCRIPTION, IMAGE_ADDRESS, MANAGER_ID, CREATE_DATE, FOOD_ENABLE) VALUES ('11', '테스트6', '2', '6000', '60', '국내산 콩 사용6', 'steak.jpg', 'Admin123', TO_DATE('2019-04-12 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'y');
INSERT INTO "FOOK"."FOOK_FOOD" (FOOD_ID, FOOD_NAME, CATEGORY_ID, PRICE, FOOD_POINT, FOOD_DESCRIPTION, IMAGE_ADDRESS, MANAGER_ID, CREATE_DATE, FOOD_ENABLE) VALUES ('12', '테스트7', '3', '6000', '60', '국내산 콩 사용7', 'yangsic.jpeg', 'Admin123', TO_DATE('2019-04-12 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'y');


-- USER
insert into fook_user(user_id, password, name, phone_first, phone_middle, phone_last, user_point, password_quiz, password_answer, join_date, secession_date, enable)
values ('a1s2d3', '1q2w3e', '이수만', '010', '1234', '5678', 0, 'Country?', 'South Korea', sysdate, NULL, 'y');
insert into fook_user(user_id, password, name, phone_first, phone_middle, phone_last, user_point, password_quiz, password_answer, join_date, secession_date, enable)
values ('dfkjhg987', 'dfjhjh2', '박진영', '010', '3456', '7890', 10000, 'City?', 'Seoul', sysdate, NULL, 'y');
insert into fook_user(user_id, password, name, phone_first, phone_middle, phone_last, user_point, password_quiz, password_answer, join_date, secession_date, enable)
values ('dxcvowej34', '2309fjsdjfh', '양현석', '010', '7948', '2948', 300, 'Nation?', 'East Asia', sysdate, sysdate, 'n');
insert into fook_user(user_id, password, name, phone_first, phone_middle, phone_last, user_point, password_quiz, password_answer, join_date, secession_date, enable)
values ('jb287dhcb', 'drtlse@#', '서장훈', '010', '3489', '5666', 3000, 'First Number?', '010', sysdate, sysdate, 'n');
insert into fook_user(user_id, password, name, phone_first, phone_middle, phone_last, user_point, password_quiz, password_answer, join_date, secession_date, enable)
values ('sosuf7548', 'dj34897', '우지원', '010', '2907', '8956', 8000, 'Second Number?', '2907', sysdate, NULL, 'y');
insert into fook_user(user_id, password, name, phone_first, phone_middle, phone_last, user_point, password_quiz, password_answer, join_date, secession_date, enable)
values ('dh48dh', 'cjcjsd@#$', '단테존슨', '010', '7455', '2348', 1500, 'Last NUmber?', '2348', sysdate, NULL, 'y');
insert into fook_user(user_id, password, name, phone_first, phone_middle, phone_last, user_point, password_quiz, password_answer, join_date, secession_date, enable)
values ('sdfg9s82', 'sjsddgsd87d', '라건아', '010', '7356', '9034', 4200, 'Job?', 'Basketball player', sysdate, NULL, 'y');
insert into fook_user(user_id, password, name, phone_first, phone_middle, phone_last, user_point, password_quiz, password_answer, join_date, secession_date, enable)
values ('xx8z72', 'bbkg9048', '허재', '010', '0389', '2361', 9300, 'How many children?', '2 childs', sysdate, NULL, 'y');
insert into fook_user(user_id, password, name, phone_first, phone_middle, phone_last, user_point, password_quiz, password_answer, join_date, secession_date, enable)
values ('calubang', '123456', '안병욱', '010', '8927', '6383', 5000, 'Nation?', 'East Asia', sysdate, sysdate, 'y');

-- PAYMENT
insert into fook_payment(payment_id, user_id, payment_date, request_number, total_price, save_point, used_point, card, cash, payment_state)
values (payment_pid_seq.nextval, 'a1s2d3', sysdate, '0001', 50000, 500, 0, 25000, 25000, '0');
insert into fook_payment(payment_id, user_id, payment_date, request_number, total_price, save_point, used_point, card, cash, payment_state)
values (payment_pid_seq.nextval, 'dfkjhg987', sysdate, '0002', 150000, 1500, 0, 125000, 25000, '0');
insert into fook_payment(payment_id, user_id, payment_date, request_number, total_price, save_point, used_point, card, cash, payment_state)
values (payment_pid_seq.nextval, 'dxcvowej34', sysdate, '0003', 80000, 800, 0, 25000, 55000, '0');
insert into fook_payment(payment_id, user_id, payment_date, request_number, total_price, save_point, used_point, card, cash, payment_state)
values (payment_pid_seq.nextval, 'jb287dhcb', sysdate, '0004', 70000, 700, 5000, 10000, 55000, '0');
insert into fook_payment(payment_id, user_id, payment_date, request_number, total_price, save_point, used_point, card, cash, payment_state)
values (payment_pid_seq.nextval, 'sosuf7548', sysdate, '0005', 105000, 1050, 10000, 85000, 10000, '0');
insert into fook_payment(payment_id, user_id, payment_date, request_number, total_price, save_point, used_point, card, cash, payment_state)
values (payment_pid_seq.nextval, 'dh48dh', sysdate, '0006', 10000, 100, 0, 10000, 0, '0');
insert into fook_payment(payment_id, user_id, payment_date, request_number, total_price, save_point, used_point, card, cash, payment_state)
values (payment_pid_seq.nextval, 'sdfg9s82', sysdate, '0007', 66500, 665, 1000, 60000, 5000, '0');
insert into fook_payment(payment_id, user_id, payment_date, request_number, total_price, save_point, used_point, card, cash, payment_state)
values (payment_pid_seq.nextval, 'xx8z72', sysdate, '0008', 78000, 780, 8000, 15000, 55000, '0');

-- PAYMENT_DETAIL
insert into fook_payment_detail(payment_id, food_id, food_name, price, count, point)
values ('0', '7', '자장면', 5000, 3, 50);
insert into fook_payment_detail(payment_id, food_id, food_name, price, count, point)
values ('0', '12', '소바', 7000, 2, 70);

insert into fook_payment_detail(payment_id, food_id, food_name, price, count, point)
values ('1', '1', '볶음밥', 6000, 3, 60);
insert into fook_payment_detail(payment_id, food_id, food_name, price, count, point)
values ('1', '7', '자장면', 5000, 2, 50);
insert into fook_payment_detail(payment_id, food_id, food_name, price, count, point)
values ('1', '12', '소바', 7000, 1, 70);
insert into fook_payment_detail(payment_id, food_id, food_name, price, count, point)
values ('1', '17', '스테이크', 9500, 4, 95);

insert into fook_payment_detail(payment_id, food_id, food_name, price, count, point)
values ('2', '1', '볶음밥', 6000, 5, 60);
insert into fook_payment_detail(payment_id, food_id, food_name, price, count, point)
values ('2', '12', '소바', 7000, 3, 70);
insert into fook_payment_detail(payment_id, food_id, food_name, price, count, point)
values ('2', '17', '스테이크', 9500, 1, 95);

insert into fook_payment_detail(payment_id, food_id, food_name, price, count, point)
values ('3', '2', '안동국시', 7500, 3, 75);
insert into fook_payment_detail(payment_id, food_id, food_name, price, count, point)
values ('3', '19', '클럽샌드위치', 9000, 2, 90);
insert into fook_payment_detail(payment_id, food_id, food_name, price, count, point)
values ('3', '11', '짬뽕', 8000, 1, 80);
insert into fook_payment_detail(payment_id, food_id, food_name, price, count, point)
values ('3', '8', '마파두부', 7000, 2, 70);
insert into fook_payment_detail(payment_id, food_id, food_name, price, count, point)
values ('3', '5', '돌솥비빔밥', 7500, 4, 75);
insert into fook_payment_detail(payment_id, food_id, food_name, price, count, point)
values ('3', '10', '찹쌀탕수육', 13000, 1, 130);

insert into fook_payment_detail(payment_id, food_id, food_name, price, count, point)
values ('4', '16', '참치회덮밥', 18000, 1, 180);

insert into fook_payment_detail(payment_id, food_id, food_name, price, count, point)
values ('5', '16', '토마토김치스파게티', 8500, 1, 85);
insert into fook_payment_detail(payment_id, food_id, food_name, price, count, point)
values ('5', '9', '잡채밥', 8000, 3, 80);
insert into fook_payment_detail(payment_id, food_id, food_name, price, count, point)
values ('5', '5', '돌솥비빔밥', 7500, 2, 75);
insert into fook_payment_detail(payment_id, food_id, food_name, price, count, point)
values ('5', '4', '뚝배기불고기', 7900, 1, 79);

insert into fook_payment_detail(payment_id, food_id, food_name, price, count, point)
values ('6', '14', '돈까스', 8500, 3, 85);
insert into fook_payment_detail(payment_id, food_id, food_name, price, count, point)
values ('6', '15', '가쓰오우동', 5000, 4, 50);

insert into fook_payment_detail(payment_id, food_id, food_name, price, count, point)
values ('7', '11', '짬뽕', 8000, 3, 80);
insert into fook_payment_detail(payment_id, food_id, food_name, price, count, point)
values ('7', '13', '알밥', 8000, 1, 80);

insert into fook_payment_detail(payment_id, food_id, food_name, price, count, point)
values ('8', '3', '바지락칼국수', 7000, 8, 70);


COMMIT;
