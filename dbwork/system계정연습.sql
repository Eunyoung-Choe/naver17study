-- system에 등록된 table들 확인하기
-- 커서가 있는 곳의 sql문 실행 단축키 : Ctrl+Enter

select * from tab;

--등록된 user(계정)들 확인
select username from dba_users; -- dba_users 테이블에서 username이라는 컬럼만 확인하기 

--dba_users라는 테이블에는 어떤 컬럼이 있을까 
desc dba_users; -- 기본 구조만 확인 (데이터는 확인 안 됨)
select username, account_status from dba_users; -- 계정과 lock 상태 알아보기


-- scott 계정 생성 (비번 : tiger)
create user scott IDENTIFIED by tiger; -- identified by= 비밀번호 설정

-- 12버전부터는 user명에 공통문자열 c##이 들어가야 한다.
-- 일단 c##scott, 비번 tiger로 만들어보자.
create user c##scott IDENTIFIED by tiger; 

-- c##scott 계정 삭제 후 공통문자열을 안 넣고도 생성하는 방법으로 다시 생성해보자.
drop user c##scott;

alter session set "_ORACLE_SCRIPT"=true; -- SESSION 변경

-- c## 뺀 채로 scott 계정 다시 생성해보자.
create user scott IDENTIFIED by tiger;


-- angel/a1234로 만들어보자.
create user angel IDENTIFIED by a1234;
select username, account_status from dba_users; -- angel, scott 추가된 걸 볼 수 있음.

-- angel 계정에 lock 설정
alter user angel account lock;

-- lock 해제
alter user angel account unlock;

-- scott과 angel 계정에 기본 권한을 주자.
grant connect, RESOURCE to angel;
grant connect, RESOURCE to scott;

-- 생성된 계정에서 테이블을 생성하고 데이터를 추가하려고 하면 table space에 대한 오류가 발생함.
-- table space를 unlimit로 설정 (system 계정에서만 가능)
alter user angel default TABLESPACE users quota UNLIMITED on users;
alter user scott default TABLESPACE users quota UNLIMITED on users;

-- angel의 비번을 a1234에서 pw1234로 변경해보자.
alter user angel IDENTIFIED by pw1234;


