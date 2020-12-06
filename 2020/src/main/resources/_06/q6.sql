insert into input
values (6, 1, 'abc

a
b
c

ab
ac

a
a
a
a

b');

create or replace view q6_vals AS
select replace(unnest(string_to_array(input, E'\n\n')), E'\n', '') val
from input
where puzzle = 6
  and input_num = 1;

select regexp_split_to_table(val, '')
from q6_vals;

-- NOPE, FAILURE