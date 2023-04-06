

create table test
(
    id         int auto_increment,
    user_code  varchar(255),
    open_time  varchar(255),
    close_time varchar(255),
    show_flag  varchar(255),
    show_info  varchar(255),
    primary key (id)
);

insert into test(id, user_code, open_time, close_time, show_flag, show_info)
VALUES (1, 'A', '2019-01-01', '2019-12-31', 'NO', ''),
       (2, 'B', '2019-02-01', '', 'YES', '2行与201行时间存在重叠应该查出来'),
       (3, 'C', '2019-02-03', '2019-12-31', 'YES', '3行与101行的存在重叠应该被查出来'),
       (100, 'A', '2020-01-01', '', 'YES', '100行与200行user_code重复，且open_time与close_time存在重叠'),
       (101, 'C', '2018-01-01', '2020-12-31', 'YES', '3行与101行的存在重叠应该被查出来'),
       (200, 'A', '2020-06-01', '', 'YES', '100行与200行user_code重复，且open_time与close_time存在重叠'),
       (201, 'B', '2019-06-01', '2020-12-31', 'YES', '2行与201行时间存在重叠应该查出来');

select a.id,
       a.user_code,
       a.show_flag,
       a.show_info,
       if(ifnull(a.open_time, '2099-12-31'), a.open_time, '2099-12-31')   as open_time,
       if(ifnull(a.close_time, '2099-12-31'), a.close_time, '2099-12-31') as close_time
from test.test as a
         inner join test.test as b
                    on a.user_code = b.user_code
where a.id != b.id
  and (
#       b 在 a 左边
        (a.open_time > b.open_time and b.close_time < a.close_time and a.close_time != '' and b.close_time != '')
#       b 包含 a
        or (a.open_time > b.open_time and a.close_time < b.close_time and a.close_time != '' and b.close_time != '')
#       b 在 a 右边
        or (a.open_time < b.open_time and a.close_time < b.close_time and a.close_time != '' and b.close_time != '')
#       a 包含 b
        or (a.open_time < b.open_time and a.close_time > b.close_time and a.close_time != '' and b.close_time != '')
#         为了解决 close_time 为空的情况
        or (a.open_time < b.open_time and a.close_time = '')
        or (b.open_time < a.open_time and b.close_time = '')
    )
order by a.user_code;


