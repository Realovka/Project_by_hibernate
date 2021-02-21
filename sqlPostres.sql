create table product (
	id bigserial,
	cold_storage bool,
	dosage_form varchar(30) null,
	recipe bool null,
	package_division bool null,
	belarusian_product bool null,
	name varchar(30) not null
)