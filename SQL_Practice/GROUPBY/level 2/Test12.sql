-- @Kwanghyeon
-- Category : GROUP BY
-- 테스트명 : 고양이와 개는 몇마리 있을까
-- 코드를 입력하세요
SELECT ANIMAL_TYPE, COUNT(ANIMAL_TYPE)
FROM ANIMAL_INS
WHERE ANIMAL_TYPE IN ('DOG', 'CAT')
GROUP BY ANIMAL_TYPE;