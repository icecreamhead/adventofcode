insert into input
values (4, 2, 'xxx');



-- byr (Birth Year) - four digits; at least 1920 and at most 2002.
-- iyr (Issue Year) - four digits; at least 2010 and at most 2020.
-- eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
-- hgt (Height) - a number followed by either cm or in:
-- If cm, the number must be at least 150 and at most 193.
-- If in, the number must be at least 59 and at most 76.
-- hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
-- ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
-- pid (Passport ID) - a nine-digit number, including leading zeroes.
-- cid (Country ID) - ignored, missing or not.

create or replace view q4_vals AS
select replace(unnest(string_to_array(input, E'\n\n')), E'\n', ' ') val
from input
where puzzle = 4
  and input_num = 2;

select count(*)
from (
         select array_to_string(regexp_match(val, 'byr:(\d{4})'), '')::int     byr,
                array_to_string(regexp_match(val, 'iyr:(\d{4})'), '')::int     iyr,
                array_to_string(regexp_match(val, 'eyr:(\d{4})'), '')::int     eyr,
                array_to_string(regexp_match(val, 'hgt:(\d{2,3})(cm|in)'), '') hgt,
                array_to_string(regexp_match(val, 'hcl:(#[0-9a-f]{6})'), '')   hcl,
                array_to_string(regexp_match(val, 'ecl:([a-z]{3})'), '')       ecl,
                array_to_string(regexp_match(val, 'pid:(\d{9,})'), '')         pid
         from q4_vals
     ) passports
-- where length(hcl) = 1
where byr between 1920 and 2002
  and iyr between 2010 and 2020
  and eyr between 2020 and 2030
  and ((right(hgt, 2) = 'cm' and substr(hgt, 0, length(hgt) - 1)::int between 150 and 193)
    or (right(hgt, 2) = 'in' and substr(hgt, 0, length(hgt) - 1)::int between 59 and 76))
  and hcl is not null
  and ecl in ('amb', 'blu', 'brn', 'gry', 'grn', 'hzl', 'oth')
  and length(pid) = 9