-- BOOK_ID, PUBLISHED_DATE 출력
-- 2021년에 출판된 '인문' 카테고리 도서 리스트 

select BOOK_ID, date_format(PUBLISHED_DATE, '%Y-%m-%d')
from BOOK
where year(PUBLISHED_DATE) = 2021 and CATEGORY = '인문';