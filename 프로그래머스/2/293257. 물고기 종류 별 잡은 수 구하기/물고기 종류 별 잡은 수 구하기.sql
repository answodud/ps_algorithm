-- FISH_NAME_INFO에서 물고기의 종류 별 물고기의 이름과 잡은 수를 출력하는 SQL문을 작성해주세요.

-- 물고기의 이름 컬럼명은 FISH_NAME, 잡은 수 컬럼명은 FISH_COUNT로 해주세요.
-- 결과는 잡은 수 기준으로 내림차순 정렬해주세요.

with r as (
select fish_type, count(*) as fish_count
from fish_info
group by fish_type
)

select r.fish_count, n.fish_name
from r left join fish_name_info n
on r.fish_type = n.fish_type
order by r.fish_count desc