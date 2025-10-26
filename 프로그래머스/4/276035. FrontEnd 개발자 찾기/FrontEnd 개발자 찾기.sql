-- 코드를 작성해주세요
select distinct d.id, d.email, d.first_name, d.last_name
from developers d, skillcodes s
where (d.skill_code & s.code) = s.code and s.category = 'Front End'
order by d.id;