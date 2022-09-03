select * from user_info;

set autocommit = 0;
begin;
select * from user_info;

insert into user_info(id, username, password) values (null, 'transaction1', 'transaction1');

commit ;

# SET AUTOCOMMIT = 0; 禁止自动提交
SET AUTOCOMMIT = 1;
# 开启自动提交1