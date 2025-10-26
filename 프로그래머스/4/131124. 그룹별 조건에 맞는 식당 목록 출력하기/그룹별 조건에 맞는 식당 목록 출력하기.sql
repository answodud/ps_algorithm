-- 코드를 입력하세요
with cnt as (
    select m.member_id, count(*) as review_cnt
    from MEMBER_PROFILE m join REST_REVIEW r
    on m.member_id = r.member_id
    group by m.member_id
    order by review_cnt desc
)

select m.member_name, r.review_text, date_format(r.review_date, '%Y-%m-%d') as REVIEW_DATE
from MEMBER_PROFILE m join REST_REVIEW r
on m.member_id = r.member_id
join cnt c on c.member_id = m.member_id
where c.review_cnt = (select review_cnt from cnt limit 1)
order by r.review_date, r.review_text;