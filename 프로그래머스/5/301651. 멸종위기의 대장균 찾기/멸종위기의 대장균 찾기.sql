-- 코드를 작성해주세요
with recursive cte as (

    select id, parent_id, 1 as gen
    from ecoli_data
    where parent_id is null
    
    union all
    
    select a.id, a.parent_id, cte.gen + 1
    from ecoli_data a join cte
    where cte.id = a.parent_id
)

select count(*) as count, c.gen as generation
from cte c left outer join ecoli_data e
on c.id = e.parent_id
where e.id is null
group by c.gen;
