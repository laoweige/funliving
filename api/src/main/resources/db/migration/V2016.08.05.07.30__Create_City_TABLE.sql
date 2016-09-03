CREATE TABLE Nation (
    id INT NOT NULL auto_increment,
    name VARCHAR(200) NOT NULL,
    PRIMARY KEY(id)
);

insert into Nation(name) values('英国');

CREATE TABLE City (
    id INT NOT NULL auto_increment,
    name VARCHAR(100) NOT NULL,
    english  VARCHAR(100) NOT NULL,
    letter VARCHAR(100) NOT NULL,
    nationId INT NOT NULL,
    PRIMARY KEY(id)
);
insert into City(name,english,letter,nationId) values('伦敦','london','lundun',1);
insert into City(name,english,letter,nationId) values('曼彻斯特','manchester','manqiesite',1);
insert into City(name,english,letter,nationId) values('利物浦','liverpool','liwupu',1);

CREATE TABLE College (
    id INT NOT NULL auto_increment,
    name VARCHAR(500) NOT NULL,
    english  VARCHAR(100) NOT NULL,
    letter VARCHAR(100) NOT NULL,
    cityId INT NOT NULL,
    nationId INT NOT NULL,
    coordinate VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
);
insert into College(name,english,letter,nationId,cityId,coordinate)
values('BPP大学Croydon校区','BPP','BPP',1,1,'1.537,18.33');
insert into College(name,english,letter,nationId,cityId,coordinate)
values('BPP大学商学院Kings Cross校区','BPP','BPP',1,1,'1.3134,123.24');
insert into College(name,english,letter,nationId,cityId,coordinate)
values('东伦敦大学','east london','donglundun',1,1,'1.3334,123.24');

CREATE TABLE ApartmentCollege(
    id INT NOT NULL auto_increment,
    apartmentId INT NOT NULL,
    collegeId INT,
    walk INT,
    metro INT,
    drive INT,
    PRIMARY KEY(id)
);
insert into ApartmentCollege(apartmentId,collegeId,walk,metro,drive) values(1,1,30,10,6);
insert into ApartmentCollege(apartmentId,collegeId,walk,metro,drive) values(1,2,32,12,6);
insert into ApartmentCollege(apartmentId,collegeId,walk,metro,drive) values(1,3,15,3,3);