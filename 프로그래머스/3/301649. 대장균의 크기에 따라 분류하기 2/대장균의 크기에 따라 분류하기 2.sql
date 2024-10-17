-- 대장균 개체의 ID(ID) 와 분류된 이름(COLONY_NAME)을 출력
-- 대장균 개체의 크기를 내름차순으로 정렬
-- 상위 0% ~ 25% 를 'CRITICAL', 26% ~ 50% 를 'HIGH', 51% ~ 75% 를 'MEDIUM', 76% ~ 100% 를 'LOW' 라고 분류
-- 개체의 ID 에 대해 오름차순 정렬
-- 단, 총 데이터의 수는 4의 배수이며 같은 사이즈의 대장균 개체가 서로 다른 이름으로 분류되는 경우는 없습니다.

select ID, 
    (case when e.r * 100 / total_cnt <= 25 then 'CRITICAL'
          when e.r * 100 / total_cnt <= 50 then 'HIGH'
          when e.r * 100 / total_cnt <= 75 then 'MEDIUM'
          else 'LOW' 
          end) as COLONY_NAME
from (select *, rank() over(order by SIZE_OF_COLONY desc) r, count(*) over() total_cnt
      from ECOLI_DATA) e
order by ID;