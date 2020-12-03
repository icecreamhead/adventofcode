create table input
(
    puzzle    int  not null,
    input_num int  not null,
    input     text not null,
    constraint pk_input primary key (puzzle, input_num)
);

create view q2_vals AS
select unnest(string_to_array(input, chr(10))) val
from input
where puzzle = 2
  and input_num = 2;


select count(*)
from (
         select regexp_matches(val, '^([0-9]+)-([0-9]+) ([a-z]): ([a-z]+)$') tokens
         from q2_vals
     ) t
--part1
--where length(regexp_replace(tokens[4], '[^' || tokens[3] || ']', '', 'g')) between tokens[1] :: int and tokens[2] :: int;
--part2
where (substring(tokens[4], tokens[1] :: int, 1) = tokens[3] or
       substring(tokens[4], tokens[2] :: int, 1) = tokens[3])
  and not (substring(tokens[4], tokens[1] :: int, 1) = substring(tokens[4], tokens[2] :: int, 1));