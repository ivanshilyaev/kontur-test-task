select feed_time, volunteer_id
from cat_volunteer
where cat_id = ?;

select count()
from cat_volunteer
where volunteer_id = 1 and feed_time > (now() - cast ('1 week' as interval))
group by cat_id;
