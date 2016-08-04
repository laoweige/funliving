insert into apartment(name,images,address,serialNumber,rent,currency,city,
coordinate,nation,description,createTime,lastTime) values(
'Chapter Spitalfields','pic','9 Frying Pan Alley, Spitalfields街区, 伦敦, E1 7HS',
'xx885',136.2,1,1,'1.3434,123.24',1,'描述1','2016-8-3','2016-8-3');

insert into apartment(name,images,address,serialNumber,rent,currency,city,
coordinate,nation,description,createTime,lastTime) values(
'Chapter Spitalfields2','pic','9 Frying Pan Alley, Spitalfields街区, 伦敦, E1 7HS',
'xx885',136.2,1,1,'1.3434,123.24',1,'描述2','2016-8-4','2016-8-4');

insert into ApartmentRoom(apartmentId,images,rent,imprest,total,used,
name,type,toilet,description,createTime,lastTime)
values(1,'pic',222.12,100.2,10,2,'fangjian01',1,1,'desc','2016-8-4','2016-8-4');

insert into ApartmentRoom(apartmentId,images,rent,imprest,total,used,
name,type,toilet,description,createTime,lastTime)
values(1,'pic',1222.12,100.2,10,2,'fangjian02',1,1,'desc','2016-8-4','2016-8-4');

insert into ApartmentRoom(apartmentId,images,rent,imprest,total,used,
name,type,toilet,description,createTime,lastTime)
values(2,'pic',222.12,100.2,10,2,'fangjian03',1,1,'desc','2016-8-4','2016-8-4');

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

