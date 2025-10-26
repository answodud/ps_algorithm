-- FOOD_PRODUCT와 FOOD_ORDER 테이블에서 생산일자가 2022년 5월인 식품들의 식품 ID, 식품 이름, 총매출을 조회하는 SQL문을 작성해주세요. 이때 결과는 총매출을 기준으로 내림차순 정렬해주시고 총매출이 같다면 식품 ID를 기준으로 오름차순 정렬해주세요.

select p.product_id, p.product_name, sum(o.amount) * p.price as TOTAL_SALES
from food_product p join food_order o
on p.product_id = o.product_id
where year(PRODUCE_DATE) = 2022 and month(PRODUCE_DATE) = 5
group by p.product_id
order by TOTAL_SALES desc, p.product_id;