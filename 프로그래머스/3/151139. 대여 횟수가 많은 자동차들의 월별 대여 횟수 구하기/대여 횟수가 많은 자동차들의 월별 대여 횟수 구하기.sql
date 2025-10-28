-- 코드를 입력하세요

with rec as (
    select car_id, count(history_id) as records
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
where start_date between '2022-08-01' and '2022-10-31'
group by car_id
having records >= 5
order by car_id desc
)

select month(h.start_date) as month, r.car_id, count(h.history_id) as records
FROM rec r join CAR_RENTAL_COMPANY_RENTAL_HISTORY h
on r.car_id = h.car_id
where h.start_date between '2022-08-01' and '2022-10-31'
group by month, r.car_id
order by month, r.car_id desc