CREATE TABLE Nation (
    id INT NOT NULL auto_increment,
    name VARCHAR(200) NOT NULL,
    PRIMARY KEY(id)
);
insert into Nation(name) values('英国');

CREATE TABLE City (
    id INT NOT NULL auto_increment,
    name VARCHAR(500) NOT NULL,
    nationId INT NOT NULL,
    PRIMARY KEY(id)
);
insert into City(name,nationId) values('伦敦',1);
insert into City(name,nationId) values('曼彻斯特',1);
insert into City(name,nationId) values('格拉斯哥',1);
insert into City(name,nationId) values('伯明翰',1);
insert into City(name,nationId) values('谢菲尔德',1);
insert into City(name,nationId) values('利物浦',1);

CREATE TABLE College (
    id INT NOT NULL auto_increment,
    name VARCHAR(500) NOT NULL,
    cityId INT NOT NULL,
    nationId INT NOT NULL,
    coordinate VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
);
insert into City(name,nationId,cityId,coordinate) values('BPP大学Croydon校区',1,1,'1.637,18.33');
insert into City(name,nationId,cityId,coordinate) values('BPP大学商学院Kings Cross校区',1,1,'1.637,18.33');
insert into City(name,nationId,cityId,coordinate) values('东伦敦大学',1,1,'1.637,18.33');
insert into City(name,nationId,cityId,coordinate) values('伦敦国王学院St Thomas&#039;校区',1,1,'1.637,18.33');
insert into City(name,nationId,cityId,coordinate) values('伦敦密德萨斯大学',1,1,'1.637,18.33');

CREATE TABLE ApartmentCollege(
    id INT NOT NULL auto_increment,
    apartmentId INT NOT NULL,
    collegeId INT,
    walk INT,
    metro INT,
    drive INT,
    distance INT,
    PRIMARY KEY(id)
)
