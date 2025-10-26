-- 7월 아이스크림 총 주문량과 상반기의 아이스크림 총 주문량을 더한 값이 큰 순서대로 상위 3개의 맛을 조회하는 SQL 문을 작성해주세요.


select a.flavor
from first_half a join july b
on a.flavor = b.flavor
group by a.flavor
order by a.total_order + sum(b.total_order) desc
limit 3;