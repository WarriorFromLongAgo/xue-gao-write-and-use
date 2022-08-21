create database IF NOT EXISTS minimybatis;
use minimybatis;
drop table if exists users;

create table users
(
    uid  int,
    name varchar(20)
);

insert into users (uid, name)
values (1, 'User1');
insert into users (uid, name)
values (2, 'User2');


create table author
(
    id       int,
    username varchar(20),
    password varchar(20),
    bio      varchar(20),
    email    varchar(20)
);

insert into author (id, username, password, bio, email)
values (1, 'author1', 'password1', 'bio1', 'email1');
insert into author (id, username, password, bio, email)
values (2, 'author2', 'password2', 'bio2', 'email2');