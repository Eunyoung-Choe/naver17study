-- [ 12월 30일 오라클 문제 ]
-- 1. 어떤 종류의 직업이 있는지 job을 한 번씩만 출력하기(오름차순으로)
    select distinct job from emp order by job;

-- 2. ename에 대소문자 상관없이 's'를 포함하고 있는 데이터 출력
--    (컬럼: ename, job, sal)
    select ename, job, sal from emp where lower(ename) like '%s%'; --모든 문자를 lower/upper로 만들고 찾는 방식!

-- 3. ename의 3번째 글자가 L인 사람을 조회하기 (ename, sal, comm)
    select ename from emp where ename like '__L%';

-- 4. comm이 null이 아닌 사람 중에 sal이 1500 이상인 사람 출력
--    (컬럼: ename, sal, comm)
    select ename, sal, comm from emp where comm is not null AND sal>=1500;
    

-- 5. hiredate 입사일이 5월인 사람은 모두 출력 (ename, hiredate, sal)
    SELECT ENAME, to_char(hiredate, 'yyyy-mm-dd') 입사일, SAL FROM EMP WHERE to_char(hiredate, 'mm') = '05'; --어렵
    --참고로 오라클은 숫자5로 써도 비교가 가능하다.


-- 6. hiredate 입사일이 1985-01-01 이후에 입사한사람 출력(컬럼 : ename, hiredate, sal)
    select ename, to_char(hiredate, 'yyyy-mm-dd'), sal from emp where hiredate > TO_DATE('1985-01-01', 'yyyy-mm-dd'); --to_date 기억
    select ename, hiredate, sal from emp where hiredate >= '1985-01-01'; --쌤 답안 

-- 7. sal이 1500~3000 사이인 사람을 출력하는데 관계연산자와 and를 이용해서 출력
    select ename, sal from emp where sal>1500 and sal<=3000;

-- 8. 7번의 결과를 between을 이용해서 출력(컬럼 : ename, sal, mgr)
    select ename, sal, mgr from emp where sal between 1500 and 3000;

-- 9. in을 이용해서 job이 clerk, president, manager인 사람의 전체 컬럼을 모두 출력
    select * from emp where job in ('CLERK', 'PRESIDENT', 'MANAGER'); --컬럼명 대문자인 점 주의 

-- 10. ename, sal, comm, sal*comm을 출력하는데 comm이 null인 경우 1로 변경해서 출력하고 계산하기
    select ename, sal, NVL(comm,1), sal*NVL(comm,1) from emp; --NVL=Null Value Logic : NULl값 대체를 위한 기능 

-- 11. ename이 ADAMS인 사람의 SAL보다 더 많이 받는 사람 출력(컬럼명 : ENAME, JOB, SAL)
    select ename, job, sal from emp where sal > (select sal from emp where ename='ADAMS'); --자꾸 ==으로 쓰게 된다;

-- 12. 평균 SAL 보다 작은 사람의 전체 컬럼 출력
    select * from emp where sal < (SELECT AVG(sal) FROM emp); --AVG()함수가 단일 값을 반환해서 행 단위로 비교하는 where절에 직접적으로 쓸 수 없다고 한다.
 
-- 13. ENAME이 A나 S나 M으로 시작하는 모든 사람 출력(컬럼 : ENAME, JOB, SAL)
    select ename from emp where ename like 'A%' or ename like 'S%' or ename like 'M%';

-- 14. MGR을 GROUP로 인원수와 평균 SAL을 구하시오(평균 SAL은 무조건 올림으로)
    select count(*) 인원수, round(avg(sal), -1) 평균급여, mgr from emp where mgr is not null group by mgr; --평균 소수점 쓰려면 round()로.
    -- 1원 단위는 반올림
    
-- 15. SCOTT의 SAL과 같은 SAL을 받는사람을 조회하시오(컬럼 : ENAME, SAL)
    select ename, sal from emp where sal = (select sal from emp where ename='SCOTT');

-- 16. ENAME의 글자 길이가 4글자인 사람만 조회(컬럼 : ENAME, JOB)
    select ename 이름, job 직업 from emp where length(ename)=4;

-- 17. ENAME의 3번째 글자가 R이거나 A인사람 조회(컬럼 : ENAME, JOB)
    select ename 이름, job 직업 from emp where ename like '__R%' OR ename like '__A%';
    
-- 18. JOB 직업별로 인원수와 최고 연봉을 출력하는데 직업의 오름차순으로 출력
    select job 직업, count(*), max(sal) from emp group by job order by 1;

-- 19. || 연산자를 이용하여 다음과 같이 하나의 컬럼으로 출력하시오
----      (예) SCOTT의 직업은 CLERK이며 입사년도는 1989년 05월입니다.
    select ename||'의 직업은 '||job||'이며 입사년도는 '||to_char(hiredate, 'yyyy')||'년 '||to_char(hiredate, 'mm')||'월 '||to_char(hiredate, 'dd')||'일입니다.' 자기소개 from emp;