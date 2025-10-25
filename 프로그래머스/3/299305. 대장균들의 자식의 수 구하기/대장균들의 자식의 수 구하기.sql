-- 대장균 개체의 ID(ID)와 자식의 수(CHILD_COUNT)를 출력하는 SQL 문을 작성해주세요. 자식이 없다면 자식의 수는 0으로 출력해주세요. 이때 결과는 개체의 ID 에 대해 오름차순 정렬해주세요.
select a.id, count(b.id) as child_count
from ecoli_data a left join ecoli_data b
on a.id = b.parent_id
group by a.id
order by a.id;