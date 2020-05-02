-- @Kwanghyeon
-- Category : IS NULL
-- 테스트명 : NULL 처리하기
-- 코드를 입력하세요
SELECT ANIMAL_TYPE, IFNULL(NAME, 'No name'), SEX_UPON_INTAKE
FROM ANIMAL_INS;