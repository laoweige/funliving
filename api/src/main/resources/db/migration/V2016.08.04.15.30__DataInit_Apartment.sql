insert into apartment(name,rank,images,address,serialNumber,rent,currency,city,
coordinate,nation,description,createTime,lastTime) values(
'Chapter Spitalfields',10,'pic','9 Frying Pan Alley, Spitalfields街区, 伦敦, E1 7HS',
'xx885',136,1,1,'1.3434,123.24',1,'描述1','2016-8-3','2016-8-3');

insert into apartment(name,rank,images,address,serialNumber,rent,currency,city,
coordinate,nation,description,createTime,lastTime) values(
'Chapter Spitalfields2',9,'pic','9 Frying Pan Alley, Spitalfields街区, 伦敦, E1 7HS',
'xx885',136,1,1,'1.3434,123.24',1,'描述2','2016-8-4','2016-8-4');

insert into ApartmentRoom(apartmentId,images,rent,imprest,total,used,
name,type,toilet,description,createTime,lastTime)
values(1,'pic',222,100,10,2,'Premium Range 1 One Bedroom Flat',1,1,'desc','2016-8-4','2016-8-4');

insert into ApartmentRoom(apartmentId,images,rent,imprest,total,used,
name,type,toilet,description,createTime,lastTime)
values(1,'pic',316,100,10,2,'Premium Range 1 One Bedroom Flat',2,0,'desc','2016-8-4','2016-8-4');

insert into ApartmentRoom(apartmentId,images,rent,imprest,total,used,
name,type,toilet,description,createTime,lastTime)
values(1,'pic',1222,100,10,2,'Premium Range 1 One Bedroom Flat',3,1,'desc','2016-8-4','2016-8-4');

insert into ApartmentRoom(apartmentId,images,rent,imprest,total,used,
name,type,toilet,description,createTime,lastTime)
values(1,'pic',222,100,10,2,'Premium Range 1 One Bedroom Flat',1,1,'desc','2016-8-4','2016-8-4');

insert into ApartmentRoom(apartmentId,images,rent,imprest,total,used,
name,type,toilet,description,createTime,lastTime)
values(1,'pic',222,100,10,2,'Premium Range 1 One Bedroom Flat',1,1,'desc','2016-8-4','2016-8-4');

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

