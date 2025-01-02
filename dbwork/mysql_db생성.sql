-- cmd 창에서 접속 시 
-- mysql -u root -p 엔터 누른 후 비번 입력 후 엔터로 접속 
show databases; -- database 전체 종류

-- 연습용 database study502 생성하기
create database study502;
-- cmd 창에서 접속한 경우 use database명으로 이동한다.

-- database 제거
-- 연습용 생성 후 제거해보자.
create database test; -- 생성
show databases; -- 확인
drop database test; -- 제거
