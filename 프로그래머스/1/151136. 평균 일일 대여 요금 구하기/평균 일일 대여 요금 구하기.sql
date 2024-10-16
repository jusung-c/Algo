-- 자동차 종류가 'SUV'인 자동차들의 평균 일일 대여 요금
-- 평균 일일 대여 요금은 소수 첫 번째 자리에서 반올림
-- 컬럼명은 AVERAGE_FEE

SELECT ROUND(AVG(C.DAILY_FEE)) AS AVERAGE_FEE
FROM CAR_RENTAL_COMPANY_CAR C
WHERE CAR_TYPE = 'SUV';