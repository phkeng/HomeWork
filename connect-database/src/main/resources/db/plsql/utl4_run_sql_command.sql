create or replace procedure run_sql(p_sql varchar2) as
begin
    execute immediate p_sql;
end;
