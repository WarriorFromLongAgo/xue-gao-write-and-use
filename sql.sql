-- auto-generated definition
create table user_info
(
    id       int auto_increment
        primary key,
    username varchar(512) null comment '名字',
    password varchar(512) null comment '密码'
);

-- auto-generated definition
create table mybatis_type_handler
(
    id     int auto_increment
        primary key,
    src    varchar(512) null comment '原文',
    target varchar(512) null comment '密文'
);

-- auto-generated definition
create table mybatis_result
(
    id          int auto_increment
        primary key,
    result_type varchar(512) null comment '字段有下划线，映射'
);