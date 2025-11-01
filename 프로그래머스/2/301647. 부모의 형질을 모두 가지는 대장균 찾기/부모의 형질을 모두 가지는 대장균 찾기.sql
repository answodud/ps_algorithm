-- 부모의 형질을 모두 보유한 대장균의 ID(ID), 대장균의 형질(GENOTYPE), 부모 대장균의 형질(PARENT_GENOTYPE)을 출력하는 SQL 문을 작성해주세요. 이때 결과는 ID에 대해 오름차순 정렬해주세요.
select a.id, a.genotype, b.genotype as parent_genotype
from ecoli_data a join ecoli_data b
on a.parent_id = b.id
where (a.genotype & b.genotype) = b.genotype
order by a.id;