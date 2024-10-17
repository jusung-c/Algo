-- 모든 다음 업그레이드 아이템의 ITEM_ID, ITEM_NAME, RARITY
-- RARITY가 'RARE'인 아이템
-- ITEM_ID 기준 내림차순

select ITEM_ID, ITEM_NAME, RARITY
from ITEM_INFO
where ITEM_ID in (select t.ITEM_ID
                  from ITEM_INFO i
                    join ITEM_TREE t on i.ITEM_ID = t.PARENT_ITEM_ID
                  where RARITY = 'RARE')
order by ITEM_ID desc;
