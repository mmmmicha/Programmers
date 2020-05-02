-- @Kwanghyeon
-- Category : SUM,MAX,MIN
-- 테스트명 : 중복 제거하기
-- 코드를 입력하세요
SELECT COUNT(A.NAME)
FROM
(
SELECT NAME
FROM ANIMAL_INS
WHERE NAME IS NOT NULL
GROUP BY NAME
) A;