insert into apartment(name,rank,images,address,supplier,postcode,rent,currency,city,
coordinate,nation,description,createTime,lastTime) values(
'Chapter Spitalfields 1',10,
'https://static.student-cdn.com/media/cache/property_preview_desktop/mstr/country/united-kingdom/city/london/property/nido-west-hampstead/image-o6i642.jpeg',
'9 Frying Pan Alley, Spitalfields街区, 伦敦, E1 7HS',
'UNITE STUDENTS','90001',211,1,1,'1.3034,123.24',1,'描述1','2016-8-3','2016-8-3');

insert into apartment(name,rank,images,address,supplier,postcode,rent,currency,city,
coordinate,nation,description,createTime,lastTime) values(
'Chapter Spitalfields 2',7,
'https://static.student-cdn.com/media/cache/property_preview_desktop/mstr/country/united-kingdom/city/london/property/scape-shoreditch/image-o9kfop.jpeg',
'9 Frying Pan Alley, Spitalfields街区, 伦敦, E1 7HS',
'UNITE STUDENTS','90002',136,1,1,'1.3134,123.24',1,'描述2','2016-8-4','2016-8-4');

insert into apartment(name,rank,images,address,supplier,postcode,rent,currency,city,
coordinate,nation,description,createTime,lastTime) values(
'Chapter Spitalfields 3',9,
'https://static.student-cdn.com/media/cache/property_preview_desktop/mstr/country/united-kingdom/city/london/property/prince-consort-village/image-o850uc.jpeg',
'9 Frying Pan Alley, Spitalfields街区, 伦敦, E1 7HS',
'UNITE STUDENTS','90002',366,1,1,'1.3234,123.24',1,'描述2','2016-8-4','2016-8-4');

insert into apartment(name,rank,images,address,supplier,postcode,rent,currency,city,
coordinate,nation,description,createTime,lastTime) values(
'Chapter Spitalfields 4',8,
'https://static.student-cdn.com/media/cache/property_preview_desktop/mstr/country/united-kingdom/city/london/property/urbanest-hoxton/image-o83nza.jpeg',
'9 Frying Pan Alley, Spitalfields街区, 伦敦, E1 7HS',
'UNITE STUDENTS','90002',118,1,1,'1.3334,123.24',1,'描述2','2016-8-4','2016-8-4');

insert into apartment(name,rank,images,address,supplier,postcode,rent,currency,city,
coordinate,nation,description,createTime,lastTime) values(
'Chapter Spitalfields 5',7,'pic','9 Frying Pan Alley, Spitalfields街区, 伦敦, E1 7HS',
'UNITE STUDENTS','90002',289,1,1,'1.3434,123.24',1,'描述2','2016-8-4','2016-8-4');

insert into apartment(name,rank,images,address,supplier,postcode,rent,currency,city,
coordinate,nation,description,createTime,lastTime) values(
'Chapter Spitalfields 6',7,'pic','9 Frying Pan Alley',
'UNITE STUDENTS','90002',300,1,2,'1.3434,123.24',1,'描述2','2016-8-4','2016-8-4');

insert into apartment(name,rank,images,address,supplier,postcode,rent,currency,city,
coordinate,nation,description,createTime,lastTime) values(
'Chapter Spitalfields 7',8,'pic','9 Frying Pan Alley',
'UNITE STUDENTS','90002',300,1,3,'1.3434,123.24',1,'描述2','2016-8-4','2016-8-4');

insert into ApartmentRoom(apartmentId,rent,imprest,status,name,type,toilet,kitchen,acreage1,acreage2,createTime,bed)
values(1,222,100,1,'Premium Range 1 One Bedroom Flat',1,1,1,'20','30','2016-8-4',1);

insert into apartmentFacility(apartmentId,facility) values(1,1);
insert into apartmentFacility(apartmentId,facility) values(1,2);
insert into apartmentFacility(apartmentId,facility) values(1,3);
insert into apartmentFacility(apartmentId,facility) values(1,4);
insert into apartmentFacility(apartmentId,facility) values(1,5);
insert into apartmentFacility(apartmentId,facility) values(1,6);
insert into apartmentFacility(apartmentId,facility) values(1,7);
insert into apartmentFacility(apartmentId,facility) values(1,8);

insert into apartmentFacility(apartmentId,facility) values(2,3);
insert into apartmentFacility(apartmentId,facility) values(2,5);
insert into apartmentFacility(apartmentId,facility) values(2,7);
insert into apartmentFacility(apartmentId,facility) values(2,9);

