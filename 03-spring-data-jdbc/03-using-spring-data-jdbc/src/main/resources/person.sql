SET FOREIGN_KEY_CHECKS = 0;

drop table if exists person_tbl;
drop table if exists address_tbl;

create table address_tbl(
	id INT primary key auto_increment,
	state varchar(45),
    township varchar(45),
    address varchar(45)
);

create table person_tbl(
	id int primary key auto_increment,
	name varchar(45) not null,
	age int ,
	address_id int,
	days varchar(45) not null,
	foreign key(address_id) references address_tbl(id)
);
SET FOREIGN_KEY_CHECKS = 1;
