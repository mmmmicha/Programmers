-- @Kwanghyeon
-- Category : SUM,MAX,MIN
-- �׽�Ʈ�� : �ߺ� �����ϱ�
-- �ڵ带 �Է��ϼ���
SELECT COUNT(A.NAME)
FROM
(
SELECT NAME
FROM ANIMAL_INS
WHERE NAME IS NOT NULL
GROUP BY NAME
) A;