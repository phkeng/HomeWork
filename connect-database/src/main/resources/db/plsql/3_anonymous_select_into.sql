set serveroutput on;

declare
    v_employee_id number := 115;
    v_salary number;
begin
    select salary
    into v_salary
    from employees
    where employee_id = v_employee_id;
    
    dbms_output.put_line('salary of employee_id ''' || v_employee_id || ''' = ' || v_salary);
end;