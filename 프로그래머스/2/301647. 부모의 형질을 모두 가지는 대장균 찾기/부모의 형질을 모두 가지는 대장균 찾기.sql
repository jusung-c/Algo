
-- 데이터: 대장균의 ID, 대장균의 형질(GENOTYPE), 부모 대장균의 형질(PARENT_GENOTYPE)
-- 조건: 부모의 형질을 모두 보유한 대장균
-- 정렬: ID asc

select child.ID, child.GENOTYPE, parent.GENOTYPE PARENT_GENOTYPE
from ECOLI_DATA child
    join ECOLI_DATA parent on child.PARENT_ID = parent.ID
where (child.GENOTYPE & parent.GENOTYPE) = parent.GENOTYPE
order by child.ID asc;