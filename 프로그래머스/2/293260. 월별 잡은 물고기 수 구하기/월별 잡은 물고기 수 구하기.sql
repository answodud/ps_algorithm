-- 월별 잡은 물고기의 수와 월을 출력하는 SQL문을 작성해주세요.

select count(*) as fish_count, month(time) as month
from fish_info
group by month
order by month