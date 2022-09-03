# v1 
如果在两个session中，session2的提交数据，session1必须提交事务，再查询才可以查询到
否则session1因为是先开启的，所以session2的数据
```
session1                    session2
开启事务                     
                            开启事务  
查询一次-没有数据             
                            查询一次没有数据
                            新增一条数据
查询一次-没有数据             
                            提交
查询一次-没有数据
提交

```

```sql
# session1
set autocommit = 0;
begin;
select * from user_info;

select * from user_info;

select * from user_info;
commit ;
```
```sql
# session2
set autocommit = 0;
begin;
select * from user_info;

insert into user_info(id, username, password) values (null, 'transaction1', 'transaction1');

commit ;
```

# v1.1
如果在一个事务里面是可以读取到的
```sql
# session1
set autocommit = 0;
begin;
select * from user_info;
insert into user_info(id, username, password) values (null, 'transaction1', 'transaction1');
select * from user_info;
commit ;
```








