create table product (
	id bigserial,
	name varchar (35),
	cold_storage bool,
	dosage_form varchar(30) null,
	recipe bool null,
	package_division bool null,
	belarusian_product bool null,
	type varchar(30) not null
)