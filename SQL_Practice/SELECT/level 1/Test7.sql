-- @Kwanghyeon
-- Category : SELECT
-- �׽�Ʈ�� : ���� n�� ���ڵ�
-- �ڵ带 �Է��ϼ���
SELECT NAME
FROM ANIMAL_INS
WHERE DATETIME = (SELECT MIN(DATETIME)
FROM ANIMAL_INS)
;