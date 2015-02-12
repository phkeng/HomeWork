-- 1. normal for loop ----------------------------------------------------------
set serveroutput on;
begin
  
  for numb in 1..5 loop
    dbms_output.put_line(numb);
  end loop;

end;

-- 2. --------------------------------------------------------------------------
set serveroutput on;
begin
  
  for rec in (
      select *
      from employees
  ) loop
    dbms_output.put_line('employee_id = ' || rec.employee_id);
    dbms_output.put_line('first_name = ' || rec.first_name);
    dbms_output.put_line('last_name = ' || rec.last_name);
    dbms_output.put_line('email = ' || rec.email);
    dbms_output.put_line('');
  end loop;

end;