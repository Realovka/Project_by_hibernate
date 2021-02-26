create table member_team (
	id bigserial not null,
	first_name varchar(30) not null,
	last_name varchar(30) not null,
	age smallint not null,
	work_chief_years smallint,
	work_assistant_years smallint,
	team_id int8,
	amplua varchar(30),
	weight smallint,
	height smallint,
	position varchar(30) not null
);

create table team (
	id bigserial not null,
	name varchar(30) not null
);

create table team_hockey_player (
	team_id int8,
	hockey_player_id int8
);