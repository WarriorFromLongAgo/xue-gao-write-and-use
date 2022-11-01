create database if not exists xue_gao_write_and_use;
use xue_gao_write_and_use;

create table user_info
(
    id       int auto_increment,
    username varchar(20) not null,
    password varchar(20) not null,

    primary key (id)
) engine = InnoDB;

create table mybatis_result
(
    id         int auto_increment,
    resultType varchar(20) not null,

    primary key (id)
) engine = InnoDB;


