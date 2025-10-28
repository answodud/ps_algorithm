/* DEVELOPERS 테이블에서 GRADE별 개발자의 정보를 조회하려 합니다. GRADE는 다음과 같이 정해집니다.

A : Front End 스킬과 Python 스킬을 함께 가지고 있는 개발자
B : C# 스킬을 가진 개발자
C : 그 외의 Front End 개발자
GRADE가 존재하는 개발자의 GRADE, ID, EMAIL을 조회하는 SQL 문을 작성해 주세요.

결과는 GRADE와 ID를 기준으로 오름차순 정렬해 주세요.
*/

with func as (
    select d.id, d.first_name, d.last_name, d.email, s.name, s.category, s.code
    from developers d, skillcodes s
    where s.code & d.skill_code >= 1
)

# select * from func;

select case
when (sum(category = 'Front End') > 0 and sum(name = 'Python') > 0) then 'A'
else (case when (sum(name = 'C#') > 0) then 'B'
else (case when sum(category = 'Front End') > 0 then 'C' end)
end) end as grade, id, email
from func
group by id, email
having grade is not null
order by grade, id;

# select 'A' as grade, f.id, f.email
# from func f
# where f.category = 'Front End' and f.id in (select id from func where name = 'Python')

# union

# select 'B' as grade, id, email
# from func
# where id in (select id from func where name = 'C#')

# union

# select 'C' as grade, id, email
# from func
# where f.category = 'Front End'
