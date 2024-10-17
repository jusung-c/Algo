
-- 대장균 개체의 ID, CHILD_COUNT 출력
-- 자식이 없다면 자식의 수는 0으로 출력
-- 개체의 ID asc

# select e1.id, count(e2.parent_id) CHILD_COUNT
# from ECOLI_DATA e1
#     left join ECOLI_DATA e2 on e1.id = e2.PARENT_ID
# group by e1.ID
# order by e1.ID


select e1.id, count(e2.parent_id) CHILD_COUNT
from ECOLI_DATA e1
    left join ECOLI_DATA e2 on e1.id = e2.PARENT_ID
group by e1.id
order by e1.id


