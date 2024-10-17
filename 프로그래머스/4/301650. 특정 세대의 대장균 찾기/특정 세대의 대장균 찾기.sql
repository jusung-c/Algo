-- 3세대의 대장균의 ID를 출력하세요

select childchild.id
from ECOLI_DATA parent
    join ECOLI_DATA child on child.PARENT_ID = parent.ID
    join ECOLI_DATA childchild on child.ID = childchild. PARENT_ID
where parent.PARENT_ID is null;