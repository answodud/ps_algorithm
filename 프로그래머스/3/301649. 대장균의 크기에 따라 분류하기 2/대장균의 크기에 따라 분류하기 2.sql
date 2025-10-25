-- 코드를 작성해주세요
select id, 
case ntile(4) over(order by size_of_colony) 
when 4 then "CRITICAL"
when 3 then "HIGH"
when 2 then "MEDIUM"
else "LOW"
end as COLONY_NAME
from ECOLI_DATA
order by id;