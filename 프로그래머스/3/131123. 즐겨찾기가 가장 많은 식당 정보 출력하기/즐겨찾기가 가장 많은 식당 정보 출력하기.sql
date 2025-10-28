with fav as (
    select food_type, rest_id, rest_name, favorites, dense_rank() over(partition by food_type order by favorites desc) as fav_order
    from rest_info
)

select food_type, rest_id, rest_name, favorites
from fav
where fav_order = 1
group by food_type
order by food_type desc;