set serveroutput on
declare
  v_output number;
begin
  v_output := multiply_two_numbers(3, 2);
  dbms_output.put_line(v_output);
exception
  when others then dbms_output.put_line('has exception');
end;