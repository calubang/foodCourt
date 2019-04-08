DROP TABLE manager;
DROP TABLE job;
DROP TABLE food;
DROP TABLE category;

CREATE TABLE job (
	job_id VARCHAR2(32) NOT NULL, /* 직급ID */
	job_name VARCHAR2(64), /* 직급 */
	grade_level VARCHAR2(1), /* 보안등급 */
    CONSTRAINT job_job_id_pk PRIMARY KEY (job_id)
);

-- 예제 값
insert into job(job_id, job_name, grade_level) values ('Admin', '관리자', 'H');
insert into job(job_id, job_name, grade_level) values ('Clerk', '점원', 'M');
insert into job(job_id, job_name, grade_level) values ('Newbie', '신입', 'L');

-- 확인
SELECT * FROM job;


CREATE TABLE manager (
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
    CONSTRAINT manager_job_id_fk foreign key(job_id) references job(job_id)
);

-- 예제 값
insert into manager(manager_id, name, password, phone_first, phone_middle, phone_last, job_id, hire_date, address_zip, address, email, email_domain)
values ('Admin123', '홍길동', '123qwe', '010', '1234', '5678', 'Admin', sysdate, '34343', 'Seoul yeouido', 'kitri', 'naver.com');
insert into manager(manager_id, name, password, phone_first, phone_middle, phone_last, job_id, hire_date, address_zip, address, email, email_domain)
values ('Clerk123', '서생원', '1a2s3d4f', '010', '2345', '6789', 'Clerk', sysdate, '43438', 'Seoul yeongdeungpogu', 'c234', 'hanmail.net');
insert into manager(manager_id, name, password, phone_first, phone_middle, phone_last, job_id, hire_date, address_zip, address, email, email_domain)
values ('Newbie123', '김두한', 'skujhf723', '010', '3456', '7890', 'Newbie', sysdate, '29843', 'Seoul jonglogu', '2396sdf', 'google.com');

-- 확인
SELECT * FROM manager;


CREATE TABLE category (
	category_id NUMBER(2) NOT NULL, /* 카테고리ID */
	category_name VARCHAR2(64) NOT NULL, /* 카테고리_이름 */
    CONSTRAINT category_category_id_pk PRIMARY KEY (category_id)
);

-- 예제 값
insert into category(category_id, category_name) values (1, '한식');
insert into category(category_id, category_name) values (2, '중식');
insert into category(category_id, category_name) values (3, '일식');
insert into category(category_id, category_name) values (4, '양식');

-- 확인
SELECT * FROM category;


CREATE TABLE food (
	food_id VARCHAR2(64) NOT NULL, /* 음식ID */
	food_name VARCHAR2(64) NOT NULL, /* 음식이름 */
	category_id NUMBER(2) NOT NULL, /* 카테고리ID */
	price NUMBER(6) NOT NULL, /* 가격 */
	point NUMBER(6), /* 포인트 (가격 /100) - Default 설정이 안돼서 default 값 없음 */
	description VARCHAR2(1024), /* 설명 */
	image_address VARCHAR2(128) NOT NULL, /* 이미지주소 */
	manager_id VARCHAR2(32), /* 관리자ID */
	create_date DATE DEFAULT sysdate, /* 생성일 */
	enable VARCHAR2(1) DEFAULT 'y', /* 활성화여부 */
    CONSTRAINT food_food_id_pk PRIMARY KEY (food_id),
    CONSTRAINT food_category_id_fk foreign key(category_id) references category(category_id),
    CONSTRAINT food_manager_id_fk foreign key(manager_id) references manager(manager_id)
);

-- Sequence
CREATE SEQUENCE food_fid_seq START WITH 0 INCREMENT BY 1 MAXVALUE 999999 MINVALUE 0;

DROP SEQUENCE food_fid_seq;

-- 예제 값
insert into food(food_id, food_name, category_id, price, point, description, image_address, manager_id, create_date, enable)
values (to_char(food_fid_seq.nextval, '999999'), '볶음밥', 1, 6000, 60, '신선한 야채를 사용.', '/kitri/foodCourt/management/menu/image/bokeumbap.jpg', 'Clerk123', sysdate, 'y');
insert into food(food_id, food_name, category_id, price, point, description, image_address, manager_id, create_date, enable)
values (to_char(food_fid_seq.nextval, '999999'), '자장면', 2, 5000, 50, '직접 수타로 만듦.', '/kitri/foodCourt/management/menu/image/jajangmyeon.jpg', 'Clerk123', sysdate, 'y');
insert into food(food_id, food_name, category_id, price, point, description, image_address, manager_id, create_date, enable)
values (to_char(food_fid_seq.nextval, '999999'), '소바', 3, 7000, 70, '메밀이 들어감.', '/kitri/foodCourt/management/menu/image/soba.jpg', 'Clerk123', sysdate, 'y');
insert into food(food_id, food_name, category_id, price, point, description, image_address, manager_id, create_date, enable)
values (to_char(food_fid_seq.nextval, '999999'), '스테이크', 4, 9500, 95, '뉴질랜드산 소고기를 사용.', '/kitri/foodCourt/management/menu/image/steak.jpg', 'Admin123', sysdate, 'y');

-- 확인
SELECT * FROM food;

commit;