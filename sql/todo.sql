create table todo(
	uid integer auto_increment primary key,
	title varchar(250),
	content varchar(1000),
	repeat tinyint not null,
	std_day date not null,
	variable_std_day date not null,
	insert_timestamp timestamp not null default CURRENT_TIMESTAMP,
	modified_timestamp timestamp not null default CURRENT_TIMESTAMP
);

create table user(
	uid integer auto_increment primary key,
	mail varchar(100) unique key not null,
	password varchar(256) not null,
	join_day date not null default CURRENT_TIMESTAMP,
	withdraw_day date,
	status enum('L','R','D') not null default 'L'
);