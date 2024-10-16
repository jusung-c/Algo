-- TOTAL_ORDER가 3000 초과이면서 INGREDIENT_TYPE이 fruit_based인 아이스크림의 FLAVOR 조회
-- TOTAL_ORDER DESC 정렬

SELECT F.FLAVOR
FROM FIRST_HALF F
JOIN ICECREAM_INFO I ON F.FLAVOR = I.FLAVOR
WHERE F.TOTAL_ORDER > 3000 AND I.INGREDIENT_TYPE = 'fruit_based'
ORDER BY F.TOTAL_ORDER DESC;