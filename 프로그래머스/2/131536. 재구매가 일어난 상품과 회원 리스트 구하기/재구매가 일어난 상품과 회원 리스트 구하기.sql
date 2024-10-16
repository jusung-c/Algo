-- 회원 ID, 상품 ID 출력
-- 동일한 회원이 동일한 상품을 재구매한 데이터
-- 회원 ID asc, 상품 ID desc

select USER_ID, PRODUCT_ID
from ONLINE_SALE
group by USER_ID, PRODUCT_ID
having count(*) >= 2
order by 1, 2 desc;