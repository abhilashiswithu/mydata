drop table out_patient;

create table out_patient(
	id int AUTO_INCREMENT,
	name varchar(30) NOT NULL, 
	dept varchar(30) DEFAULT 'general medicine', 
	doctor varchar(30), 
	age int,
	dob date,
	registration_time date,
	PRIMARY KEY(id)
);

insert into out_patient(name, dept, doctor, age, dob, registration_time) values ('Shiju', 'GM', 'Renuka', 28, '1984-02-22', '2012-02-23');
