-- 시퀀스를 생성해보자.
CREATE SEQUENCE SEQ1; -- 1부터 1씩 자동 증가하는 시퀀스 객체 생성
CREATE SEQUENCE SEQ2 START WITH 1 INCREMENT BY 1; -- 위에서 생략된 부분. 완전히 똑같은 문장임.
-- CACHE : 시퀀스 값 N개를 미리 메모리에 할당함. 
CREATE SEQUENCE SEQ3 START WITH 1 INCREMENT BY 1 NOCACHE; -- 위와 같으니 CACHE 사이즈를 20에서 0으로 변경
CREATE SEQUENCE SEQ4 START WITH 1 INCREMENT BY 1 MAXVALUE 100 NOCACHE; -- MAX값을 100까지만
CREATE SEQUENCE SEQ5 START WITH 5 INCREMENT BY 5 NOCACHE;


-- 시퀀스 전체 정보 출력
SELECT * FROM SEQ;

-- 시퀀스 값을 발생시켜보자. (한 번 발생한 값들은 두 번 다시 안 나옴)
SELECT SEQ1.NEXTVAL, SEQ2.NEXTVAL, SEQ3.NEXTVAL, SEQ4.NEXTVAL, SEQ5.NEXTVAL FROM DUAL;

-- 시퀀스 제거
DROP SEQUENCE SEQ1;
DROP SEQUENCE SEQ2;
DROP SEQUENCE SEQ3;
DROP SEQUENCE SEQ4;
DROP SEQUENCE SEQ5;

-- TABLE 생성
CREATE TABLE TEST1 (
    -- PRIMARY KEY는 가능한 주는 게 좋음. (유일성 및 중복X 보장) 
    NUM NUMBER(3) PRIMARY KEY, --같은 숫자 올 수 없음, (3)은 정수 길이(최대 3자리 숫자 저장 가능)
    NAME VARCHAR2(20) NOT NULL,
    TODAY DATE);
    
-- 구조 확인
DESC TEST1;

-- 데이터 추가
INSERT INTO TEST1 VALUES (1, 'EMILY', SYSDATE); --컬럼명 생략 시 모든 컬럼을 순서대로 값을 넣음.
INSERT INTO TEST1 VALUES (1, 'MIRA', SYSDATE); -- PRIMARY KEY에 같은 값을 넣었을 경우 : 무결성 제약 조건(ANGEL.SYS_C008318) 오류

-- 이번에는 이름을 빼고 넣은 후 오류 확인
INSERT INTO TEST1 (NUM, TODAY) VALUES (2, SYSDATE); --ORA-01400: NULL을 ("ANGEL"."TEST1"."NAME") 안에 삽입할 수 없습니다 

-- 이번엔 전체 데이터를 넣는데 순서를 바꿔 넣어보자.
INSERT INTO TEST1 (NUM, TODAY, NAME) VALUES (2, '2024-11-20', 'MYA');

-- INSERT를 2개 추가한 상태에서 ROLLBACK을 해보자.
ROLLBACK; -- 커밋 안 한 상태였어서 데이터 안 보임.
--
COMMIT; --COMMIT한 후에는 ROLLBACK 해도 취소 안 됨.
--
ROLLBACK;

-- 데이터 확인
SELECT * FROM TEST1;


-- TEST2는 TEST1과 같은데 제약 조건 이름을 추가해서 생성해보자.
CREATE TABLE TEST2(
    NUM NUMBER(3) CONSTRAINT PK_TEST2_NUM PRIMARY KEY,
    NAME VARCHAR2(20) CONSTRAINT NN_TEST2_NAME NOT NULL,
    TODAY DATE);
    
-- 오류를 발생시켜보자.
INSERT INTO TEST2 VALUES (1, '최은영', SYSDATE); --정상 추가
INSERT INTO TEST2 VALUES (1, '쵠녕', SYSDATE); --오류 발생 ORA-00001: 무결성 제약 조건(ANGEL.PK_TEST2_NUM)에 위배 

SELECT * FROM TEST2; 

-- 테이블의 구조 변경 : ALTER TABLE
-- 컬럼 추가 : ADD / 컬럼 삭제 : DROP COLUMN / 컬럼 수정 : MODIFY / 컬럼명 변경 : RENAME COLUMN

-- TEST1에 AGE NUMBER(3) 컬럼 추가하기, 일단 값은 NULL로 들어감.
ALTER TABLE TEST1 ADD AGE NUMBER(3);

-- TEST1에 ADDR VARCHAR2(30) 추가하는데 기본값을 SEOUL로 주고 싶다.
ALTER TABLE TEST1 ADD ADDR VARCHAR2(30) DEFAULT 'SEOUL';

-- TEST1에 GAIPDAY DATE으로 추가하는데 기본값을 현재 날짜로
ALTER TABLE TEST1 ADD GAIPDAY DATE DEFAULT SYSDATE;

-- TEST1의 TODAY 컬럼 삭제하기
ALTER TABLE TEST1 DROP COLUMN TODAY;

-- TEST1의 NAME 길이를 20에서 30으로 수정해보자.
ALTER TABLE TEST1 MODIFY NAME VARCHAR2(30);

-- TEST1의 ADDR을 ADDRESS로 컬럼명을 변경해보자.
ALTER TABLE TEST1 RENAME COLUMN ADDR TO ADDRESS;

-- TEST1의 GAIPDAY를 WRITEDAY로 이름 변경
ALTER TABLE TEST1 RENAME COLUMN GAIPDAY TO WRITEDAY;

-- TEST1의 제약 조건 중 SYS_C008317(임시 이름)을 제거해보자.
ALTER TABLE TEST1 DROP CONSTRAINT SYS_C008317;

-- TEST1에 제약 조건 추가 : AGE의 나이 범위가 10~30으로, 제약 조건명 : CK_TEST1_AGE (보통 이런 형태로 줌)
ALTER TABLE TEST1 ADD CONSTRAINT CK_TEST1_AGE CHECK(AGE>=10 AND AGE<=30);

-- AGE에 범위를 벗어나게 추가해서 오류 확인하기
INSERT INTO TEST1 (NUM, NAME, AGE) VALUES (3, 'ME', 22);

-- 5분 문제
-- 1. TEST2에 BLOOD VARCHAR2(10) 초기값은 A로 추가하기
    ALTER TABLE TEST2 ADD BLOOD VARCHAR2(10) DEFAULT 'A';

-- 2. TEST2에서 TODAY 컬럼 제거하기
    ALTER TABLE TEST2 DROP COLUMN TODAY;

-- 3. TEST2의 NAME을 SAWON_NAME으로 컬럼 이름 변경하기
    ALTER TABLE TEST2 RENAME COLUMN NAME TO SAWON_NAME;
    
-- 4. BLOOD에 제약 조건 추가 (A, B, O ,AB만 가능하도록 CHECK) CK_TEST2_BLOOD
    ALTER TABLE TEST2 ADD CONSTRAINT CK_TEST2_BLOOD CHECK(BLOOD IN ('A', 'B', 'O', 'AB'));
    
-- 5. NN_TEST2_NAME이라는 제약 조건 제거하기
    ALTER TABLE TEST2 DROP CONSTRAINT NN_TEST2_NAME;
    
-- 연습용 테이블 제거하기
DROP TABLE TEST1;
DROP TABLE TEST2;


--------------------------------------------------------------------------------
-- 시퀀스 생성
CREATE SEQUENCE SEQ1 NOCACHE; -- 1부터 1씩 증가하는 CACHE가 없는 시퀀스 생성

-- 테이블 생성
CREATE TABLE SAWON (
    NUM NUMBER(3) CONSTRAINT PK_SAWON_NUM PRIMARY KEY,
    NAME VARCHAR2(20),
    BUSEO VARCHAR2(20),
    GENDER VARCHAR2(10) DEFAULT '남자',
    AGE NUMBER(3),
    HEIGHT NUMBER(5,1),
    WRITEDAY DATE);
    
-- 제약 조건 추가 : 부서명은 '홍보부', '교육부', '관리부'만 가능하다 CK_SAWON_BUSEO
ALTER TABLE SAWON ADD CONSTRAINT CK_SAWON_BUSEO CHECK(BUSEO IN ('홍보부', '교육부', '관리부'));

-- 제약 조건 추가 : 성별은 '남자', '여자'만 가능하다 CK_SAWON_GENDER
ALTER TABLE SAWON ADD CONSTRAINT CK_SAWON_GENDER CHECK(GENDER IN ('남자', '여자'));

-- 데이터 추가
INSERT INTO SAWON VALUES (SEQ1.NEXTVAL, '이진', '홍보부', '여자', 22, 163, SYSDATE);
INSERT INTO SAWON (NUM, NAME, BUSEO, AGE) VALUES (SEQ1.NEXTVAL, '서지수', '관리부', 23);
INSERT INTO SAWON VALUES (SEQ1.NEXTVAL, '황미애', '홍보부', '여자', 23, 155.5, SYSDATE);
INSERT INTO SAWON (NUM, NAME, GENDER, AGE) VALUES (SEQ1.NEXTVAL, '최은영', '여자', 22);
COMMIT;


-- 수정 UPDATE
UPDATE SAWON SET HEIGHT=186.5; -- 만약 WHERE 조건을 안 쓰면 전체 데이터가 수정됨!
ROLLBACK; -- 다시 취소

-- NUM=3인 경우만 수정
UPDATE SAWON SET HEIGHT=186.5 WHERE NUM=3;

-- 여러 컬럼을 수정하는 경우
UPDATE SAWON SET BUSEO='홍보부', AGE=39, HEIGHT=162.1 WHERE NAME='황미애';

-- WRITEDAY가 NULL인 경우 '2024-12-12'로 변경을 해보자.
UPDATE SAWON SET WRITEDAY='2024-12-12' WHERE WRITEDAY IS NULL;

COMMIT;

-- 삭제 DELETE
DELETE FROM SAWON; -- WHERE 조건을 안 쓴 경우 전체 데이터가 삭제됨.
ROLLBACK;

-- AGE가 NULL인 데이터는 모두 삭제
DELETE FROM SAWON WHERE AGE IS NULL;

-- GROUP BY 연습
-- 부서별 인원 수와 평균 나이를 구하시오.
    SELECT BUSEO 부서, COUNT(*) 인원수, AVG(AGE) 평균나이 FROM SAWON GROUP BY BUSEO;

-- 성별 인원 수와 평균 나이를 구하시오.
    SELECT GENDER 성별, COUNT(*) 인원수,  ROUND(AVG(AGE), 0) 평균나이 FROM SAWON GROUP BY GENDER;
    

    
--------------------------------------------------------------------------------

-- JOIN 연습용 테이블 생성하기
CREATE TABLE FOOD (
    FOODNUM NUMBER(3) PRIMARY KEY,
    FOODNAME VARCHAR2(20),
    FOODPRICE NUMBER(7),
    FOODSIZE VARCHAR2(20));

CREATE TABLE BOOKING (
    BNUM NUMBER(3) CONSTRAINT PK_BOOKING_BNUM PRIMARY KEY,
    BNAME VARCHAR2(20) CONSTRAINT NN_BOOKING_BNAME NOT NULL,
    BHP VARCHAR2(20) CONSTRAINT UQ_BOOKING_BHP UNIQUE,
    FOODNUM NUMBER(3),
    BOOKING DATE,
    CONSTRAINT FK_FOODNUM FOREIGN KEY(FOODNUM) REFERENCES FOOD(FOODNUM));
    
-- 메뉴를 등록해보자.
INSERT INTO FOOD VALUES (100, '짜장면', 9000, '보통');
INSERT INTO FOOD VALUES (101, '짜장면', 11000, '곱빼기');
INSERT INTO FOOD VALUES (200, '탕수육', 15000, '보통');
INSERT INTO FOOD VALUES (201, '탕수육', 20000, '곱빼기');
INSERT INTO FOOD VALUES (300, '칠리새우', 15000, '소');
INSERT INTO FOOD VALUES (301, '칠리새우', 30000, '대');
INSERT INTO FOOD VALUES (400, '해물짬뽕', 11000, '보통');

COMMIT;
SELECT * FROM FOOD;

-- 시퀀스 생성
CREATE SEQUENCE SEQ_FOOD START WITH 10 INCREMENT BY 10 NOCACHE;

-- 예약
INSERT INTO BOOKING VALUES (SEQ_FOOD.NEXTVAL, '이재희', '010-1234-5678', 200, '2024-12-31');
INSERT INTO BOOKING VALUES (SEQ_FOOD.NEXTVAL, '이효리', '010-1111-2222', 400, '2024-12-31');
INSERT INTO BOOKING VALUES (SEQ_FOOD.NEXTVAL, '최은영', '010-9999-9999', 301, '2024-12-31');


-- 오류 발생시켜보기 (ORA-02291: 무결성 제약조건(ANGEL.FK_FOODNUM)이 위배되었습니다- 부모 키가 없습니다)
INSERT INTO BOOKING VALUES (SEQ_FOOD.NEXTVAL, '김에러', '010-0000-0000', 401, '2024-12-31'); --401은 메뉴에 없음.

COMMIT;

-- INNER JOIN으로 예약 손님의 주문 정보 확인하기
SELECT
    BNAME, BHP, FOODNAME, FOODPRICE, FOODSIZE, TO_CHAR(BOOKING, 'YYYY-MM-DD') BOOKINGDAY
FROM FOOD F, BOOKING B
WHERE F.FOODNUM=B.FOODNUM;

-- OUTER JOIN을 이용해서 한 번도 주문하지 않은 메뉴들을 알아보자.
SELECT
    F.FOODNUM, BNAME, FOODNAME, FOODPRICE, FOODSIZE
FROM FOOD F, BOOKING B
WHERE F.FOODNUM=B.FOODNUM(+); --(+): 주문 안 한 것도 같이 출력됨. 다만 주문자가 NULL로 나옴.

--위의 SQL문을 이용해서 주문자 이름을 빼고 NULL인 경우만 출력하면 아무도 주문하지 않은 메뉴만 골라낼 수 있다.
SELECT
    F.FOODNUM, FOODNAME, FOODPRICE, FOODSIZE
FROM FOOD F, BOOKING B
WHERE F.FOODNUM=B.FOODNUM(+) AND BNAME IS NULL; --주문자가 NULL인 걸 이용해서 주문 안 들어온 메뉴만 골라내기.


-- BOOKING(자식테이블)에 추가된 메뉴를 FOOD(부모테이블)에서 삭제할 수 있을까? 
---> 자식 테이블 생성 시 ON DELETE CASCADE 설정을 안 했으면 못 지운다!
DELETE FROM FOOD WHERE FOODNUM = 200; --200번 메뉴는 이재희가 예약 주문했어서 삭제 못 함. (ORA-02292: 무결성 제약조건(ANGEL.FK_FOODNUM)이 위배되었습니다- 자식 레코드가 발견되었습니다)
DELETE FROM FOOD WHERE FOODNUM = 300; --이건 아무도 주문 안 했으므로 삭제 가능

-- 부모 테이블 삭제 될까?
DROP TABLE FOOD; --> 이 또한 안 됨. 자식 먼저 삭제해야 부모테이블 삭제 가능! (ORA-02449: 외래 키에 의해 참조되는 고유/기본 키가 테이블에 있습니다)
COMMIT;

-- booking을 먼저 제거 후 food 제거하기 (외부키로 서로 연결되어 있으므로)
drop table booking;
drop table food;

-- sawon 테이블도 일단 삭제
drop table sawon;

-- 시퀀스도 일단 모두 삭제
drop sequence seq_food;
drop sequence seq1;









----아래는 스터디 팀원끼리 풀어본 문제
-- Q. 판매량 많은 순서대로 출력하되 주문 없는(null)은 0으로 뜨도록. 

SELECT 
    F.FOODNAME 음식명,
    F.FOODSIZE 음식크기,
    F.FOODPRICE 가격,
    COUNT(B.FOODNUM) 판매량
FROM 
    FOOD F
LEFT JOIN 
    BOOKING B
ON 
    F.FOODNUM = B.FOODNUM
GROUP BY 
    F.FOODNAME, F.FOODSIZE, F.FOODPRICE
ORDER BY 
    판매량 DESC;



SELECT
    f.foodnum, f.foodname, NVL(count(b.foodnum), 0) 판매량    
FROM food f, booking b
WHERE f.foodnum = b.foodnum(+)
group by f.foodnum, f.foodname --묶어야 하는 요소가 f.foodnum과 f.foodname으로 2개가 한 세트라서 요소 하나만 쓰면 오류남.
order by 판매량 desc;

