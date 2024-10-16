-- 식당 ID, 식당 이름, 음식 종류, 즐겨찾기수, 주소, 리뷰 평균 점수(소수점 세 번째 자리에서 반올림)를 조회
-- 위치는 서울
-- 평균점수 DESC, FAVORITES DESC


select i.rest_id, i.rest_name, i.food_type, i.favorites, 
    i.address, round(avg(r.review_score), 2)
from rest_info i
join rest_review r on i.rest_id = r.rest_id
where i.address like '서울%'
group by r.rest_id
order by avg(r.review_score) desc, i.favorites desc;