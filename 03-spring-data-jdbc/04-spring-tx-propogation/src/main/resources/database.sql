create database if not exists prepagateDb;

create user 'pUser'@'localhost' identified by 'pPass';
grant all privileges on prepagateDb.* to 'pUser'@'localhost';
flush privileges;

use prepagateDb;

create table category_tbl(
	id int primary key auto_increment,
	name varchar(45) not null
);

create table product_tbl(
	id int primary key auto_increment,
	name varchar(45) not null,
	cat_id int,
	foreign key(cat_id) references category_tbl(id)
);