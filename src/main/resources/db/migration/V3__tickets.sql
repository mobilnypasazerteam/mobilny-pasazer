create table if not exists tickets
(
	id bigserial not null
		constraint tickets_pkey
			primary key,
	additional_info varchar(50),
	email varchar(255),
	end_point varchar(255),
	end_time varchar(255),
	intermediate_point varchar(255),
	passenger_no integer,
	phone varchar(255),
	reduced_mobility_type varchar(255),
	start_point varchar(255),
	start_time varchar(255),
	travel_date varchar(255)
)
;

