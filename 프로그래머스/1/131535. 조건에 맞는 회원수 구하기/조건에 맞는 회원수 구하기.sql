-- 조건에 맞는 회원 수 출력
-- 2021년에 가입한 회원 중 나이가 20세 이상 29세 이하인 회원

select count(USER_ID)
from USER_INFO
where age between 20 and 29
and year(joined) = 2021;