--------------------------------------------------------------------------------
create or replace package employees_pack as

    function find_email_by_employee_id(p_employee_id number) return varchar2;
  
end employees_pack;

-- body ------------------------------------------------------------------------
create or replace package body employees_pack as

    function find_email_by_employee_id(p_employee_id number) return varchar2 as
        p_email varchar2(50);
    begin
        select email
        into p_email
        from EMPLOYEES
        where employee_id = p_employee_id;
        
        return p_email;
    end find_email_by_employee_id;
  
end employees_pack;
