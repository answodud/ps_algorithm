-- 대장균 개체의 크기가 100 이하라면 'LOW', 100 초과 1000 이하라면 'MEDIUM', 1000 초과라면 'HIGH' 라고 분류합니다. 대장균 개체의 ID(ID) 와 분류(SIZE)를 출력하는 SQL 문을 작성해주세요.이때 결과는 개체의 ID 에 대해 오름차순 정렬해주세요.
select id, case
            when size_of_colony < 100 then "LOW"
            when size_of_colony > 100 and size_of_colony <= 1000 then "MEDIUM"
            when size_of_colony > 1000 then "HIGH"
            end as SIZE
from ecoli_data
order by id;