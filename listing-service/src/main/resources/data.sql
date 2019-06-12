INSERT INTO listing_types(name,local_name) values ('land','Land');
insert into listing_types(name, local_name) values ('building','Building');
insert into listing_subtypes(name,main_type,local_name) values ('cultivated_land',1,'Cultivated Land');
insert into availabilities(name,main_type,local_name) values ('immediate',1,'Immediate Sale');
insert into price_rates(name,main_type,local_name) values ('per_perch',1,'Per Perch');
