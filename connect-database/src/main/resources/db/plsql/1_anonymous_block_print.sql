set serveroutput on
declare
  v_message varchar2(255) := 'hello pl/sql';
begin
  dbms_output.put_line(v_message);
exception
  when others then dbms_output.put_line('has exception');
end;