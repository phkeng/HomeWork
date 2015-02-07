set serveroutput on
declare
  v_output number;
begin
  add_two_numbers(1, 2, v_output);
  dbms_output.put_line(v_output);
exception
  when others then dbms_output.put_line('has exception');
end;