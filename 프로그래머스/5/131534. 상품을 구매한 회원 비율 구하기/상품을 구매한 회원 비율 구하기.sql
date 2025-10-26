-- 코드를 입력하세요

with allPeople as (
    select count(*) as allCnt
    from user_info u
    where year(u.joined) = 2021
)

select year(o.sales_date) as YEAR, month(o.sales_date) as MONTH, count(distinct o.user_id) as PURCHASED_USERS, round((count(distinct o.user_id) / (a.allCnt * 1.0)), 1) as PUCHASED_RATIO
from user_info u, online_sale o, allPeople a
where u.user_id = o.user_id and year(u.joined) = 2021
group by year(o.sales_date), month(o.sales_date)
order by YEAR, MONTH;