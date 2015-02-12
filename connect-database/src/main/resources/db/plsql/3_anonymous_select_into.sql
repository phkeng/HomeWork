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



---
set serveroutput on;

declare
    v_employee_id number := 115;
    v_salary number;
    v_phone_number varchar2(100);
begin
    select salary, phone_number
    into v_salary, v_phone_number
    
    from employees
    where employee_id = v_employee_id;
    
    dbms_output.put_line('salary of employee_id ''' || v_employee_id || ''' = ' || v_salary);
    dbms_output.put_line('phone number of employee_id ''' || v_employee_id || ''' = ' || v_phone_number);
end;