create or replace function multiply_two_numbers(p_numb1 number, p_numb2 number) return number as

begin
   return p_numb1 * p_numb2;
end;