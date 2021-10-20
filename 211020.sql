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