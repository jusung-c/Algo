-- 생일이 3월인 여성 회원의 ID, 이름, 성별, 생년월일 조회
-- 전화번호가 NULL인 경우 제외
-- 회원 ID를 기준으로 오름차순 정렬


select member_id, member_name, gender, 
    date_format(date_of_birth, '%Y-%m-%d')
from member_profile
where date_format(date_of_birth, '%m') = '03' 
    and tlno is not null 
    and gender = 'W'
order by member_id;
