with joinT as (
    select h.history_id, c.car_id, c.car_type, c.daily_fee, h.start_date, h.end_date, p.duration_type, p.discount_rate
    from CAR_RENTAL_COMPANY_CAR c join CAR_RENTAL_COMPANY_RENTAL_HISTORY h
    on c.car_id = h.car_id
    join CAR_RENTAL_COMPANY_DISCOUNT_PLAN p
    on c.car_type = p.car_type
)

select distinct j.car_id, j.car_type, round(((j.daily_fee * 30) * (100-j.discount_rate) / 100), 0) as FEE
from joinT j
where j.car_id NOT IN (
      SELECT h.car_id
      FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY h
      WHERE NOT (h.end_date < '2022-11-01' OR h.start_date > '2022-11-30')
  )
and j.duration_type like '%30일%'
and ((j.daily_fee * 30) * (100-j.discount_rate) / 100) >= 500000 and ((j.daily_fee * 30) * (100-j.discount_rate) / 100) < 2000000
order by FEE desc, j.car_type asc, j.car_id desc;