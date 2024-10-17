-- 가장 큰 물고기 10마리의 ID와 길이를 출력
select id, length
from FISH_INFO
order by length desc, id
limit 10;