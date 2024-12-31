-- EQUI JOIN 또는 INNER JOIN : 두 테이블 결합

-- 방법1 : 컬럼명 앞에 테이블명이나 테이블 별칭을 붙인다.
SELECT
    E.ENAME, E.JOB, E.SAL, D.DNAME, D.LOC --누가 갖고 있는지에 따라 E, D지정
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO;

-- 방법2 : JOIN할 테이블에 컬럼명이 겹치지 않는 경우 테이블명이나 별칭을 붙이지 않아도 됨.
-- DECODE 함수 : 다중 IF문같은 함수
SELECT
    E.DEPTNO, ENAME, JOB, SAL, DNAME, LOC 
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO;

SELECT ENAME, DEPTNO, DECODE(DEPTNO, 10, '홍보부', 20, '교육부', 30, '인사부') 부서명 FROM EMP;
