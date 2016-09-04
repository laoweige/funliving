CREATE TABLE Schedule (
    id INT NOT NULL auto_increment,
    apartmentId INT,
    roomId INT,
    userId INT NOT NULL,
    name VARCHAR(50) NOT NULL,
    mobile VARCHAR(20) NOT NULL,
    email VARCHAR(100),
    status INT,
    startTime Date,
    endTime Date,
    createTime Date,
    PRIMARY KEY(id)
);


CREATE TABLE Apply (
    id INT NOT NULL auto_increment,
    userId INT NOT NULL,
    createId INT NOT NULL,
    name VARCHAR(50) NOT NULL,
    gender INT,
    birthday Date,
    mobile VARCHAR(20) NOT NULL,
    email VARCHAR(100),
    status INT,

    university VARCHAR(200),
    major VARCHAR(100),
    enterDate Date,

    creditName VARCHAR(50),
    creditCard VARCHAR(50),
    creditSecurity VARCHAR(20),
    startDate Date,
    expireDate  Date,

    assureName VARCHAR(20),
    assureGender int,
    assureRelation VARCHAR(20),
    assureBirthday  Date,
    assureMobile VARCHAR(20),
    assureAddress VARCHAR(20),
    createTime Date,
    PRIMARY KEY(id)
);
