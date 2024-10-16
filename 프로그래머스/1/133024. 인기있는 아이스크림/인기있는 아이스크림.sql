-- 아이스크림 맛 조회
-- TOTAL_ORDER DESC, SHIPMENT_ID ASC

select flavor
from first_half
order by TOTAL_ORDER DESC, SHIPMENT_ID ASC