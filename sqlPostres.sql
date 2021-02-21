create table product_join (
	id bigserial,
	name varchar(30) not null,
	cold_storage bool,
	type varchar(30) not null
);

create table medicine_join (
	id int8 not null,
	dosage_form varchar(30) null,
	recipe bool null
);

create table dietary_supplement_join (
	id int8 not null,
	package_division bool null,
	belarusian_product bool null
)