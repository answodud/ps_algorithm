-- FISH_INFO 테이블에서 잡은 BASS와 SNAPPER의 수를 출력하는 SQL 문을 작성해주세요.
-- 컬럼명은 'FISH_COUNT`로 해주세요.
select count(*) as FISH_COUNT
from fish_info
where fish_type in (select fish_type from fish_name_info where fish_name = "BASS" or fish_name = "SNAPPER");