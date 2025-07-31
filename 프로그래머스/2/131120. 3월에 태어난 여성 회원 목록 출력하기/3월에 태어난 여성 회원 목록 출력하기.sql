SELECT MEMBER_ID, MEMBER_NAME, GENDER, date_format(DATE_OF_BIRTH, "%Y-%m-%d") as DATE_OF_BIRTH
from member_profile
WHERE gender = 'W'
and month(DATE_OF_BIRTH) = 3
and tlno is not null
order by member_id