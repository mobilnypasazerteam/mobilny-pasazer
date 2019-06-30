create table if not exists passengers
(
	id bigint not null
		constraint passengers_pkey
			primary key,
	first_name varchar(255),
	last_name varchar(255),
	password_hash varchar(255),
	phone varchar(255),
	sex integer,
	username varchar(255)
)
;

alter table passengers owner to yjtcnehnbqfhdo
;

create table if not exists roles
(
	id bigint not null
		constraint roles_pkey
			primary key,
	role_name varchar(255)
)
;

alter table roles owner to yjtcnehnbqfhdo
;

create table if not exists passengers_roles
(
	passenger_id bigint not null
		constraint fkhdmv4pii2m3ren7qgqybs9ewp
			references passengers,
	roles_id bigint not null
		constraint fkityx8xponphlp4vsqo91xdf1n
			references roles,
	constraint passengers_roles_pkey
		primary key (passenger_id, roles_id)
)
;

alter table passengers_roles owner to yjtcnehnbqfhdo
;

create sequence hibernate_sequence
;

alter sequence hibernate_sequence owner to yjtcnehnbqfhdo
;
