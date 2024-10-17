-- 온/오프라인 판매 데이터의 SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT 출력
-- SALES_DATE 2022년 3월
-- SALES_DATE ASC
-- PRODUCT_ID asc, USER_ID asc

select date_format(SALES_DATE, '%Y-%m-%d') as date, PRODUCT_ID, USER_ID, SALES_AMOUNT
from ONLINE_SALE
where year(SALES_DATE) = 2022 and month(SALES_DATE) = 3
UNION ALL
select date_format(SALES_DATE, '%Y-%m-%d') as date, PRODUCT_ID, null as USER_ID, SALES_AMOUNT
from OFFLINE_SALE
where year(SALES_DATE) = 2022 and month(SALES_DATE) = 3
order by date, PRODUCT_ID, USER_ID;

