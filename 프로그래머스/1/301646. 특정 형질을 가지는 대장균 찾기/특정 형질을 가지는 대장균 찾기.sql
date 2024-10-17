-- 대장균 개체의 수
-- GENOTYPE != 2 and GENOTYPE in (1, 3)

select count(*) COUNT
from ECOLI_DATA
where (GENOTYPE & 2) != 2 
    and (GENOTYPE & 5)

