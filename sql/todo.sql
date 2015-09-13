create table todo(
	uid integer auto_increment primary key,
	title varchar(250),
	content varchar(1000),
	repeat_type varchar(50) not null,
	std_day date not null,
	variable_std_day date not null,
	insert_timestamp timestamp not null default CURRENT_TIMESTAMP,
	modified_timestamp timestamp not null default CURRENT_TIMESTAMP on update current_timestamp
);

create table todo_user(
	uid integer auto_increment primary key,
	mail varchar(100) unique key not null,
	password varchar(256) not null,
	join_day datetime default CURRENT_TIMESTAMP,
	withdraw_day datetime,
	status enum('L','R','D') not null default 'L'
);

create table todo_mapper(
	uid integer auto_increment primary key,
	mail varchar(100) not null,
	todo_id integer not null,
	constraint foreign key (mail) references todo_user (mail) on delete cascade on update cascade,
	constraint foreign key (todo_id) references todo (uid) on delete cascade on update cascade
);