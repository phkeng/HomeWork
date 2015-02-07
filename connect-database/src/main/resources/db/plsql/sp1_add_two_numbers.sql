create or replace procedure add_two_numbers(p_numb1 number, p_numb2 number, p_result out number) as

begin
   p_result := p_numb1 + p_numb2;
end;