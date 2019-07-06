create table if not exists elevatortickets
(
	id bigserial not null
		constraint elevatortickets_pkey
			primary key,
	action_taken varchar(20),
	malfunction_date varchar(255),
	malfunction_end varchar(255),
	planned_malfunction_end varchar(255),
	platform varchar(255),
	station varchar(255)
)
;

