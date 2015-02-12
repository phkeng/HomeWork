select replace(regexp_substr(job_id, '.*\_'), '_', '') front
from jobs