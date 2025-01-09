-- emp 테이블로 연습
-- job 컬럼의 데이터 중 중복되는 데이터는 한 번만 출력해보자.
select distinct job from emp; -- distinct 안 붙이면 개수대로 다 나옴.
select DISTINCT job, ename from emp; -- 다른 컬럼하고 같이 쓸 경우 적용이 안 되거나 오류 발생

select * from emp; -- 전체 컬럼 데이터 조회
select ename, job from emp; --일부 컬럼만 조회
select ename, job from emp order by ename; -- ename의 오름차순 조회(asc인 경우는 생략)
select ename, job from emp order by ename desc; -- ename의 내림차순 조회(desc인 경우는 생략 안 됨)

-- job의 오름차순, 같은 job일 경우 ename의 내림차순 조회
select job, ename from emp order by job, ename desc;
-- job의 오름차순, 같은 job일 경우 ename도 오름차순 조회
select job, ename from emp order by job, ename;
-- 순서를 정할 때 컬럼명 대신 컬럼 번호로 해도 된다. (첫 번째 컬럼은 0 아니고 1)
select job, ename from emp order by 1, 2; -- job=1, ename=2

select * from emp order by 6; -- by sal;과 같음.

-- empno의 오름차순 조회 
select ename, sal, comm, job, empno from emp order by 5;

--ename의 내림차순
select ename, sal, comm, job, empno from emp order by ename desc;

-- where 조건문
select ename, job, sal, comm from emp where sal>=1500;
select ename, job, sal, comm from emp where ename='allen'; -- 데이터는 대소문자 정확히 써야 함.
select ename, job, sal, comm from emp where ename='ALLEN';


-- ENAME이 A로 시작하는 데이터 조회
select ename, job, sal, comm from emp where ename LIKE 'A%'; -- A로 시작하는 모든 데이터
-- ENAME에 A가 포함되는 데이터 조회
select ename, job, sal, comm from emp where ename LIKE '%A%'; -- A가 포함된 모든 데이터
-- ENAME에 A로 시작하거나 S로 시작하는 데이터 조회
select ename, job, sal, comm from emp where ename LIKE 'A%' OR ename LIKE 'S%'; --OR 뒤에도 컬럼명 다 써줘야 함.
-- ENAME에 A와 S를 모두 포함하는 데이터만 출력
select ename, job, sal, comm from emp where ename LIKE '%A%' AND ename LIKE '%S%';

-- ENAME의 두 번째 글자가 A인 사람만 조회
select ename, job, sal, comm from emp where ename LIKE '_A%' order by SAL; -- 언더바 하나 있으면 그 자리엔 반드시 무슨 글자라도 있어야 함.
-- ENAME의 두 번째 글자가 이거나 세 번째가 A인 사람만 조회
select ename, job, sal, comm from emp where ename LIKE '_A%' OR ename LIKE '__A%';
-- ENAME이 N이나 K로 끝나는 사람만 조회
select ename, job, sal, comm from emp where ename LIKE '%N' OR ename LIKE '%K';

-- JOB이 ANALYST이면서 SAL이 1500인 사람 조회
select ename, job, sal, comm from emp where JOB='ANALYST' AND SAL>=1500;

-- SAL 1200~2000 사이 값 조회
select ename, job, sal, comm from emp where SAL>1200 AND SAL<=2000; -- 방법1
select ename, job, sal, comm from emp where SAL BETWEEN 1200 AND 2000; -- 방법2

-- JOB이 MANAGER, SALESMAN, ANALYST 이 3가지 직업의 사람 조회하기
select ename, job, sal, comm from emp where JOB='MANAGER' OR JOB='SALESMAN' OR JOB='ANALYST'; --방법1
select ename, job, sal, comm from emp where JOB IN ('MANAGER', 'SALESMAN', 'ANALYST'); -- 방법2 

-- EMPNO가 7654, 7788, 7844, 7902인 사람만 조회
select EMPNO, ename, job, sal, comm from emp where EMPNO IN (7654, 7788, 7844, 7902);

-- COMM이 NULL인 데이터 조회
select ename, job, sal, comm from emp where COMM IS NULL;
-- NULL이 아닌 경우 데이터만 조회
select ename, job, sal, comm from emp where COMM IS NOT NULL;
-- comm이 null일 경우 sal+comm도 sal+comm도 null

-- MGR이 NULL이 아닌 경우만 조회
select * from emp where mgr is not null;

-- comm이 null인 경우는 0으로 출력 (MGR은 null인 경우 100으로)
select ename,job,sal, NVL(mgr, 100), NVL(comm,0) from emp;

select sal, comm, sal+comm from emp; -- 결과가 어떻게 되는지?
-- 위의 경우 sal+comm에서 comm이 null이면 0으로 계산
select sal, comm, sal+NVL(comm, 0) from emp;


-- 컬럼 제목에 별칭 주기 (alias는 큰 따옴표)
select ename as "사원명", sal as "월급여" from emp; --생략없이 alias 지정
select ename "사원명", sal "월급여" from emp; --as 생략
select ename 사원명, sal 월급여 from emp; --alias에 띄어쓰기 없는 경우 ""도 생략 가능

--총 레코드 개수 (=데이터 개수)
select count(*) from emp; --이 경우는 컬럼명이 count(*)
select count(*) count from emp; --이 경우는 컬럼명이 count
select count(*) 총개수 from emp; --이 경우는 컬럼명이 총개수 

-- NVL(): null값 대체 함수
select sal, comm, sal+NVL(comm, 0) sum from emp; -- sal+NVL(comm, 0)열의 컬럼명은 sum으로 변경
select sal 월급여, comm 커미션, sal+NVL(comm, 0) 총금액 from emp; --컬럼명을 한글로

--문자열을 컬럼에 추가 시 || 연산자 사용 
select '내 이름은 '||ename||'입니다' 자기소개 from emp;
select '내 이름은 '||job||'이고 내 월 급여는 '||sal||'입니다' 자기소개 from emp;

-- sal이 1500~2000 사이가 아닌 경우만 조회
select * from emp where sal not between 1500 and 2000;

--not in을 사용하여 job이 salesman, clerk가 아닌 경우만 조회
select * from emp where job not in ('salesman', 'clerk');

-- GROUP 함수 (COUNT, SUM, AVG, MAX, MIN)
select count(*) from emp; --전체 데이터 수
select sum(sal) from emp; --sal의 총 합계
select avg(sal) from emp; --sal의 평균 but 소수점 이하가 너무 많이 나옴.
select round(avg(sal),2) from emp; --sal의 평균을 구하는데 소수점 이하 두 자리로 구함.
select max(sal) from emp; --최고 급여액수
select min(sal) from emp; --최소 급여액수


-- 평균 급여보다 sal이 더 높은 사람을 조회하시오. (서브 쿼리)
select * from emp where sal>(select avg(sal) from emp); 

-- scott의 직업과 같은 직업을 가진 사람을 조회하시오. (==이 아니고 =이었음)
select ename from emp where job = (select job from emp where ename='SCOTT'); 

-- scott의 mgr과 같은 mgr을 가진 사람
select * from emp where mgr = (select mgr from emp where ename='SCOTT');

-- GROUP BY
SELECT JOB FROM EMP GROUP BY JOB; --JOB이 그룹별로 나열
-- JOB의 GROUP 별 인원수를 구해보자.
SELECT JOB, COUNT(*) FROM EMP GROUP BY JOB; --*이 인원 수

-- 제목에 별칭 부여
SELECT JOB 직업, COUNT(*) 인원수 FROM EMP GROUP BY JOB;

-- JOB의 GROUP 별 인원 수를 구해보자. (인원이 3명 이상인 경우에만)
select job 직업, count(*) 인원수 from emp group by job having count(JOB)>=3;
-- 위를 인원순으로 출력
select job 직업, count(*) 인원수 from emp group by job having count(JOB)>=3 order by 인원수; --방법1
select job 직업, count(*) 인원수 from emp group by job having count(JOB)>=3 order by 2; --방법2
--

-- 직업 별 인원 수, 최저연봉, 최고연봉, 평균연봉 (소수점 이하 없이) 구하기.
select job 직업, count(*) 인원수, min(sal) 최저연봉, max(sal) 최고연봉, round(avg(sal),0) 평균연봉 from emp group by job order by 직업; 

-- 48페이지 숫자 함수 (절댓값 출력)
select abs(-5), abs(-5) from dual;

--ROUND:반올림, CEIL:무조건 올림, FLOOR:무조건 내림
select round(3.6,0), ceil(3.6), floor(3.6) from dual; --4 4 3
select round(3.4,0), ceil(3.4), floor(3.4) from dual; --4 4 3
select round(328947, -2) from dual; --328900
select round(328947, -2) from dual; --328500

select round(avg(sal), 0), ceil(avg(sal)), floor(avg(sal)) from emp;

--POWER(M, N) : M의 N승값을 구함 / MOD(M, N) : M을 N으로 나눈 나머지
select power(3,3), mod(10, 3) from dual; --27


-- 문자함수 CONCAT, LOWER(소문자 전환), UPPER(대문자), INITCAP(첫 글자만 대문자)
select ename, concat(ename, '님'), lower(ename), upper(ename), initcap(ename) from emp;

select LPAD(sal, 10, '*') from emp; --총 10자리에 남는 부분을 *로 채움 (왼쪽에서부터)
select RPAD(sal, 10, '*') from emp; --총 10자리에 남는 부분을 *로 채움 (오른쪽에서부터)

select substr('HAPPY DAY', 7, 3) from dual; --7번째 글자부터 3글자 추출
select substr('HAPPY DAY', -6, 3) from dual; --뒤에서부터 3글자 5번째 글자 찾기

-- EMP 테이블의 ENAME에서 왼쪽의 3글자 추출 후 총 7자리 중 우측 빈공간은 *으로 채워서 출력
select rpad(substr(ename, 1, 3), 7, '*'), sal from emp;

-- length 길이 구하기
select ename 이름, length(ename) 문자길이 from emp;

-- REPLACE (HAPPY를 GOOD으로 변경 
select replace('HAPPY
DAY', 'HAPPY', 'GOOD') FROM DUAL;

-- TRIM : 앞뒤 공백제거
select '*'||'Choi Eun Young' from dual;
select '*'||trim('Eun Young')||'*' from dual; --앞두 공백 제거

--일단 현재 날짜 나타내는 sysdate
select sysdate from dual; --현재 날짜
select sysdate+1 from dual; --내일 날짜 
select sysdate+7 from dual; --오늘로부터 7일 뒤 날짜

-- to_cahr 함수로 원하는 날짜 모양으로 출력하좌.
select to_char(sysdate, 'yyyy-mm-dd') from dual; --2024-12-30
-- mm:월 / mi:분 / hh:12시간 표시 / AM 또는 PM:오전 오후 표시
select to_char(sysdate, 'yyyy-mm-dd am hh24:mi') from dual; --2024-12-30 오후 04:41

select to_char(sysdate, 'month') from dual; --12월 (지역마다 결과가 다르게 나오므로 잘 사용X)

-- 현재 년도 네 자리만 추출
select to_char(sysdate, 'yyyy') from dual;

-- 현재 월 추출
select to_char(sysdate, 'mm') from dual;
select to_char(to_date('2024-5-10'), 'mm') from dual; --05

-- emp의 hiredate는 날짜 타입이다.
select to_char(hiredate, 'rrrr-mm-dd') 입사일 from emp;

