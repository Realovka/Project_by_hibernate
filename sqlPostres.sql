create table medicine_per_class (
	id int8 not null,
	name varchar(30) not null,
	cold_storage bool,
	dosage_form varchar(30) null,
	recipe bool null
);

create table dietary_supplement_per_class (
	id int8 not null,
	name varchar(30) not null,
	cold_storage bool,
	package_division bool null,
	belarusian_product bool null
)