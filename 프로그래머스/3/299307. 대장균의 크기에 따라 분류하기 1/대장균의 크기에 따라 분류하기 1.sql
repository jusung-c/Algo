
-- SIZE_OF_COLONY <= 100 'LOW'
-- 100 < SIZE_OF_COLONY <= 1000 'MEDIUM'
-- SIZE_OF_COLONY > 1000 'HIGH'

select id, 
    (case when SIZE_OF_COLONY <= 100 then 'LOW'
          when 100 < SIZE_OF_COLONY and SIZE_OF_COLONY <= 1000 then 'MEDIUM'
          when SIZE_OF_COLONY > 1000 then 'HIGH'
     end) as SIZE
from ECOLI_DATA
