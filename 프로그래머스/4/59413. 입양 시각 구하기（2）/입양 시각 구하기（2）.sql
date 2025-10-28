-- 보호소에서는 몇 시에 입양이 가장 활발하게 일어나는지 알아보려 합니다. 0시부터 23시까지, 각 시간대별로 입양이 몇 건이나 발생했는지 조회하는 SQL문을 작성해주세요. 이때 결과는 시간대 순으로 정렬해야 합니다.
# select hour(datetime) as hour, count(*) as count
# from animal_outs
# group by hour
# order by hour;

with recursive cte as (
    select 0 as hour
    
    union all
    
    select cte.hour + 1
    from cte
    where cte.hour < 23
)

select c.hour, case
when a.animal_id is null then 0
when a.animal_id is not null then count(*)
end as count
from cte c left outer join animal_outs a
on c.hour = hour(a.datetime)
group by c.hour
order by c.hour;
