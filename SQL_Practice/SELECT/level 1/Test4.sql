-- @Kwanghyeon
-- Category : SELECT
-- �׽�Ʈ�� : � ���� ã��
-- �ڵ带 �Է��ϼ���
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION NOT IN ('AGED')
ORDER BY ANIMAL_ID;