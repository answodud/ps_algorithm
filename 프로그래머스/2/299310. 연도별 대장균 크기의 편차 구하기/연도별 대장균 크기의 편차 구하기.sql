-- 분화된 연도(YEAR), 분화된 연도별 대장균 크기의 편차(YEAR_DEV), 대장균 개체의 ID(ID) 를 출력하는 SQL 문을 작성해주세요.
-- 분화된 연도별 대장균 크기의 편차는 분화된 연도별 가장 큰 대장균의 크기 - 각 대장균의 크기로 구하며
-- 결과는 연도에 대해 오름차순으로 정렬하고 같은 연도에 대해서는 대장균 크기의 편차에 대해 오름차순으로 정렬해주세요.
with yearD as (
    select year(DIFFERENTIATION_DATE) as YEAR, max(size_of_colony) as SIZE
    from ecoli_data
    group by YEAR
)

select a.YEAR, a.SIZE - b.size_of_colony as YEAR_DEV, b.id
from ecoli_data b, yearD a
where a.YEAR = year(b.DIFFERENTIATION_DATE)
order by a.YEAR, YEAR_DEV;