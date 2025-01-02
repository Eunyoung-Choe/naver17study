-- join table 연습 - on delete cascade로 자식 테이블 생성

-- 부모 테이블인 shop을 만들어보자 (상품을 등록하는 테이블)
create table shop(
    sangcode varchar2(10) constraint pk_shop_sangcode PRIMARY key,
    sangname varchar2(30),
    sangprice number(7));
    
-- shop 상품코드를 참조해서 cart에 담을 수 있도록 테이블 생성
-- 상품을 지우면 cart의 데이터도 자동으로 지워지도록 on delete cascade를 설정해서 생성하자.
create table cart (
    cartnum number(3) constraint pk_cart_cartnum PRIMARY key,
    sangcode varchar2(10),
    cntnum number(3) DEFAULT 1,
    cartday DATE,
    CONSTRAINT fk_cart_sangcode foreign key(sangcode) REFERENCES shop(sangcode)
    on delete cascade);
    
-- cart에 들어갈 시퀀스 생성
create SEQUENCE seqcart nocache;

-- 상품 등록을 하자.
insert into shop values ('A100', '체크셔츠', 23000);
insert into shop values ('A200', '청바지', 33000);
insert into shop values ('A300', '블레이저', 45000);
insert into shop values ('A400', '슬랙스', 37000);
insert into shop values ('A500', '체크목도리', 13000);
insert into shop values ('A600', '양털조끼', 25000);
insert into shop values ('A700', '무스탕', 52000);
insert into shop values ('A800', '코트', 99000);
insert into shop values ('A900', '무지셔츠', 15000);

-- cart에 원하는 상품을 담아보자.
insert into cart (cartnum, sangcode, cartday) values (seqcart.nextval, 'A500', sysdate); --얘는 cntnum을 default값으로 쓰려고 안 씀.
insert into cart (cartnum, sangcode, cartday) values (seqcart.nextval, 'A700', sysdate); 
insert into cart (cartnum, sangcode, cntnum, cartday) values (seqcart.nextval, 'A800', 3, sysdate); 
insert into cart (cartnum, sangcode, cntnum, cartday) values (seqcart.nextval, 'A100', 2, sysdate); 
insert into cart (cartnum, sangcode, cntnum, cartday) values (seqcart.nextval, 'A500', 1, sysdate); 
insert into cart (cartnum, sangcode, cntnum, cartday) values (seqcart.nextval, 'A400', 2, sysdate); 
commit;
select * from cart;

-- join sql문을 이용해 다음 순서로 출력해보시오.
-- cartnum, sangcode, sangname, sangprice, cntnum, cartday(yyyy-mm-dd HH:mi 이렇게 나오게)
select 
    c.cartnum, s.sangcode, s.sangname, s.sangprice, c.cntnum,
    to_char(cartday, 'yyyy-mm-dd hh24:mi') cartday
from cart c, shop s 
where s.sangcode = c.sangcode; --c.sangcode를 s.sangcode에 넣겠다는 게 아니라 그냥 같다의 =임. 

-- outer join을 이용해서 아무도 카트에 담지 않은 상품을 알아보자.
select 
    c.cartnum, s.sangcode, s.sangname, s.sangprice, c.cntnum,
    to_char(cartday, 'yyyy-mm-dd hh24:mi') cartday
from cart c, shop s 
where s.sangcode = c.sangcode(+) and cartnum is null;


-- on delete cascade로 생성한 경우 카트에 담긴 데이터도 부모 테이블인 shop에서 삭제가 가능하다.
-- 이때, 상품 삭제 시 카트에 담긴 상품은 자동으로 삭제된다.

-- shop에서 A500을 제거해보자. (카트에 2개 담겨있는 상태)
delete from shop where sangcode = 'A500';

-- 다시 join으로 cart 확인하기
select 
    c.cartnum, s.sangcode, s.sangname, s.sangprice, c.cntnum,
    to_char(cartday, 'yyyy-mm-dd hh24:mi') cartday
from cart c, shop s 
where s.sangcode = c.sangcode;


