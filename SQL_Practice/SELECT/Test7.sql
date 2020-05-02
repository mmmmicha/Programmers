-- @Kwanghyeon
-- Category : SELECT
-- 테스트명 : 상위 n개 레코드
-- 코드를 입력하세요
SELECT NAME
FROM ANIMAL_INS
WHERE DATETIME = (SELECT MIN(DATETIME)
FROM ANIMAL_INS)
;