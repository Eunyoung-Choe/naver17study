 -- 데이타타입
   -- 문자 : char,varchar
--    숫자 :  tinyint  1 byte
--           smallint  2byte
--           mediumint 3byte
--           int       4byte
--           bigint    8byte
--           float     실수타입 4byte
--           double      "      8byte
--           decimal(m,n) : m자리수,n소숫점자릿수
-- 	날짜 :    date   CCYY-MM-DD  :now() 로 저장한다해도 날짜만 저장된다
--           datetime   CCYY-MM-DD hh:mm:ss : now() 로 저장하면 날짜와 시간이저장된다
--           timestamp     "
--           time          hh:mm:ss
--           year        CCYY 또는 YY

create table person (
	num smallint auto_increment primary key, -- 자동으로 증가하는 고유한 값을 가진 기본 키 (각 행 별로 1씩 증가)
    name varchar(20),
    blood varchar(10) default 'B',
    age smallint,
    today date,
    writeday datetime);
    
-- table 구조 확인
desc person; -- desc = describe
show create table person; -- 디테일한 구조 확인

-- 데이터 추가하기
insert into person (name, age, today, writeday) values ('최은영', 23, now(), now()); -- today는 시간 안 나온다는 경고문 출력 

-- 모든 컬럼명 생략하고 순서대로 넣기 (num은 시퀀스 컬럼이므로 null로 줘도 숫자로 들어간다.)
insert into person values (null, '이재희', 'B', 25, now(), now());
insert into person values (null, '노진구', 'O', 10, now(), now());
insert into person values (null, '장원영', 'A', 22, now(), now());
insert into person values (null, '김태리', 'AB', 33, now(), now());

-- 각종 조회 연습
select num, name, age from person order by age asc; -- asc는 생략 가능
select num, name, age from person order by age desc;
select * from person where age>=20 and age<=30;
select * from person where age between 20 and 30;
select * from person where blood='A' or blood='O' or blood='AB';
select * from person where blood in ('A', 'O', 'AB');
select * from person where name like '장%';
select * from person where name like '%영%'; -- 영을 포함한 경우
select * from person where name like '_진%'; -- 두 번째 글자가 진

-- 그룹 함수: count, avg, sum, max, min
select count(*) from person;
select avg(age) from person; -- 평균 나이
select round(avg(age),0) from person; -- 평균 나이(정수 타입으로)
select max(age) 최고나이, min(age) 최소나이 from person;

-- 혈액형 별 인원 수와 평균 나이를 구해보자.
select blood, count(*) 인원수, round(avg(age),0) 평균나이
from person group by blood order by blood asc;

-- limit 시작위치, 가져올 글의 개수 (페이징: 일부만 가져오기)
select * from person limit 0, 3; -- 첫 글 0번부터 3개만 가져오기
select * from person limit 2, 3; -- 2번 글부터 3개만 가져오기(num3,4,5)

-- where 조건과 limit 사용 시
select * from person where age>=20 limit 1,2;

-- update
update person set blood='O', age=18 where name='노진구';

-- delete
delete from person where name = '김태리';
