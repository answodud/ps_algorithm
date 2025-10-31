-- 코드를 작성해주세요
with recursive cte as (
    select id, 1 as gen
    from ecoli_data
    where parent_id is null
    
    union all
    
    select e.id, c.gen + 1 as gen
    from ecoli_data e, cte c
    where e.parent_id = c.id
)

select count(c.id) as count, c.gen as generation
from cte c left outer join ecoli_data e
on c.id = e.parent_id
where e.id is null
group by generation;