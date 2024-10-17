
-- 잡은 BASS와 SNAPPER의 수의 합을 출력
select count(id) as FISH_COUNT
from FISH_INFO f
    join FISH_NAME_INFO fn on f.FISH_TYPE = fn.FISH_TYPE
where fn.FISH_NAME in ('BASS', 'SNAPPER');
