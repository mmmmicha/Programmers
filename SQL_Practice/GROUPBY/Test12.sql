-- @Kwanghyeon
-- Category : GROUP BY
-- �׽�Ʈ�� : ����̿� ���� ��� ������
-- �ڵ带 �Է��ϼ���
SELECT ANIMAL_TYPE, COUNT(ANIMAL_TYPE)
FROM ANIMAL_INS
WHERE ANIMAL_TYPE IN ('DOG', 'CAT')
GROUP BY ANIMAL_TYPE;