-- auto-generated definition
create table user_info
(
    id       int auto_increment
        primary key,
    username varchar(512) null comment '名字',
    password varchar(512) null comment '密码'
);

