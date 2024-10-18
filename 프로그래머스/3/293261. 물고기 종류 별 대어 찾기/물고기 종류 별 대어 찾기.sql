
-- 물고기 종류 별로 가장 큰 물고기의 ID, 물고기 이름, 길이를 출력하는 SQL 문을 작성해주세요.
-- 물고기의 ID 컬럼명은 ID, 이름 컬럼명은 FISH_NAME, 길이 컬럼명은 LENGTH로 해주세요.
-- ID에 대해 오름차순
-- 물고기 종류별 가장 큰 물고기는 1마리만 있으며 10cm 이하의 물고기가 가장 큰 경우는 없습니다.

# select *
# from FISH_NAME_INFO

SELECT f.ID, fn.FISH_NAME, f.LENGTH
FROM FISH_INFO f
JOIN FISH_NAME_INFO fn ON f.FISH_TYPE = fn.FISH_TYPE
WHERE (f.FISH_TYPE, f.LENGTH) IN (
    SELECT FISH_TYPE, MAX(LENGTH)
    FROM FISH_INFO
    GROUP BY FISH_TYPE
)
ORDER BY f.ID;

