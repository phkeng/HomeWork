select *
from(
    select employee_id,
           first_name || ' ' || last_name as name,
           email,
           job_id,
           row_number() over (partition by job_id order by dbms_random.value) sequence
           
    from employees
    order by job_id
)

where sequence <= 3