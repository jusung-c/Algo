
-- 분화된 연도(YEAR), 분화된 연도별 대장균 크기의 편차(YEAR_DEV), 대장균 개체의 ID(ID) 를 출력
-- 분화된 연도별 대장균 크기의 편차 = 분화된 연도별 가장 큰 대장균의 크기 - 각 대장균의 크기
-- 결과는 연도에 대해 오름차순으로 정렬, 대장균 크기의 편차에 대해 오름차순으로 정렬

select a.year YEAR, (b.b_max - a.SIZE_OF_COLONY) as YEAR_DEV, id ID
from (select id, SIZE_OF_COLONY, year(DIFFERENTIATION_DATE) year
     from ECOLI_DATA) as a
join (select year(DIFFERENTIATION_DATE) year, max(SIZE_OF_COLONY) b_max
        from ECOLI_DATA
        group by year) as b
    on a.year = b.year
order by a.year, YEAR_DEV