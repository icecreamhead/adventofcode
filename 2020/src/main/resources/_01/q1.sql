create table input
(
    puzzle    int  not null,
    input_num int  not null,
    input     text not null,
    constraint pk_input primary key (puzzle, input_num)
);

insert into input
values (1, 1,
        '1721
        979
        366
        299
        675
        1456');

create view q1_vals AS
select unnest(string_to_array(input, chr(10))) :: int val
from input
where puzzle = 1
  and input_num = 1;

select a.val a, b.val b, c.val c, (a.val * b.val * c.val) answer
from q1_vals a
         cross join q1_vals b
         cross join q1_vals c
where a.val < b.val
  and b.val < c.val
  and a.val + b.val + c.val = 2020;
