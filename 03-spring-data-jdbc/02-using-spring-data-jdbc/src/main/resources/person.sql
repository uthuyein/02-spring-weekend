
create table if not exists person_tbl(
	id int primary key auto_increment,
	name varchar(45) not null,
	age int ,
	days varchar(45) not null
);

truncate table person_tbl;