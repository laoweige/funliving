CREATE TABLE Apartment (
    id INT NOT NULL auto_increment,
    name VARCHAR(50) NOT NULL,
    images  VARCHAR(2000),
    address VARCHAR(1000),
    serialNumber VARCHAR(20),
    rent FLOAT,
    currency int,
    city int NOT NULL,
    coordinate VARCHAR(50) NOT NULL,
    nation int NOT NULL,
    description VARCHAR(4000),
    createTime DATETIME,
    lastTime DATETIME,
    PRIMARY KEY(id)
);

CREATE TABLE ApartmentRoom (
    id INT NOT NULL auto_increment,
    apartmentId INT NOT NULL,
    images  VARCHAR(2000),
    rent FLOAT ,
    imprest FLOAT ,
    count int,
    used int,
    name VARCHAR(50) NOT NULL,
    type int,
    toilet int,
    description VARCHAR(2000),
    createTime DATETIME,
    lastTime DATETIME,
    PRIMARY KEY(id)
);

CREATE TABLE ApartmentFacility (
    id INT NOT NULL auto_increment,
    apartmentId INT NOT NULL,
    facility int,
    PRIMARY KEY(id)
);

CREATE TABLE ApartmentDistance(
    id INT NOT NULL auto_increment,
    apartmentId INT NOT NULL,
    schoolId int,
    walk int,
    metro int,
    drive int,
    PRIMARY KEY(id)
)