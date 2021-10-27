/*
Schema
외부 ,개념, 애부
외부 : 모든 데이터는 Table 형태로 되어있다
*/
CREATE DATABASE naraDB;

USE naraDB;
show tables;
DESC tbl_buyer;

INSERT INTO tbl_buyer(userid, name)
VALUES('B001','홍길동');
INSERT INTO tbl_buyer(userid, name)
VALUES('B002','성춘향');

SELECT * FROM tbl_buyer;

-- UPDATE를 실행할 때는 반드시 변경하고자 하는 데이터의 PK를 확인하고 PK를 조건절(WHERE)에 지정하여 실행을 한다
UPDATE tbl_buyer SET tel='010-111-1111'
WHERE userid = 'B001';

-- DELETE를 실행할 때도 반드시 삭제하고자 하는 데이터의 PK를 확인하고 조건절에 PK를 설정하여 삭제를 실행한다 (데이터 무결성 보장 위한 조건)
DELETE FROM tbl_buyer
WHERE userid = 'B002';

-- 보안사고 : 권한이 없는 사용자가 침투하여 사고를 내는 것
-- 무결성 파괴 : 권한이 있는 사용자가 잘못하여 DB에 문제를 일으키는 것
--             방지를 위하여 역할을 적절하게 부여하는 것이 좋다
--             또한 PK 관리, FK 관리를 잘해야 한다




DESC hibernate_sequence;

SELECT * FROM tbl_buyer;

-- 고객별로 몇번씩 거래했냐?
SELECT userid, COUNT(userid) FROM tbl_sales
GROUP BY userid;

-- 고객별로 얼만큼씩 구입을 했나?
SELECT userid, SUM(userid) FROM tbl_sales
GROUP BY userid;

-- 상품별로 몇번씩 판매되었나
SELECT pname, count(pname) FROM tbl_sales
GROUP BY pname
ORDER BY count(pname) DESC;
-- 상품별로 많이 판매된 것부터 순서대로

-- 상품별로 총 몇개씩 판매가 되었나
SELECT pname, sum(qty) FROM tbl_sales
GROUP BY pname;

-- 상품별로 총 판매금액이 얼마냐
SELECT pname, sum(total) FROM tbl_sales
GROUP BY pname;

-- 고객별로 어떤 상품을 몇회 구입했나
SELECT userid, pname, COUNT(*) FROM tbl_sales
GROUP BY userid, pame
ORDER BY userid, pname;

-- 어떤 고객이 어떤 상품을 몇개씩 구매했나
-- 많이 구매한 순으로 보여라
SELECT userid, pname, COUNT(*) FROM tbl_sales
GROUP BY userid, pname
ORDER BY userid, SUM(QTY) DESC;

SELECT userid, pname, SUM(total) FROM tbl_sales
GROUP BY userid, pname
ORDER BY userid, SUM(total) DESC;

SELECT S.userid, B.name, pname, SUM(total)
FROM tbl_sales S
LEFT JOIN tbl_buyer B
	ON S.userid = B.userid
GROUP BY S.userid, B.name, pname
ORDER BY S.userid, SUM(total) DESC;


SELECT * FROM tbl_book;
SELECT * FROM tbl_readbook;