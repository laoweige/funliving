CREATE TABLE Users (
    id INT NOT NULL auto_increment,
    name VARCHAR(50),
    password VARCHAR(50),
    email VARCHAR(100),
    mobile VARCHAR(50),
    status INT,
    createTime DATETIME,
    loginTime DATETIME,
    PRIMARY KEY(id)
);

CREATE TABLE ThirdParty (
    id INT NOT NULL auto_increment,
    externalId VARCHAR(200) NOT NULL,
    token VARCHAR(200) NOT NULL,
    userId  INT,
    status INT NOT NULL,
    openId INT NOT NULL,
    createTime DATETIME,
    loginTime DATETIME,
    PRIMARY KEY(id)
);

CREATE TABLE AuthCode (
    id INT NOT NULL auto_increment,
    mobile VARCHAR(20) NOT NULL,
    code INT NOT NULL,
    total INT NOT NULL,
    createTime DATETIME,
    sendTime DATETIME,
    PRIMARY KEY(id)
);


INSERT INTO Users (name,password,email,mobile,status,createTime,loginTime)
VALUES('老魏','123456','laoweige@163.com','13910178888',0,'2016-10-4','2016-10-4');
INSERT INTO Users (name,password,email,mobile,status,createTime,loginTime)
VALUES('小树','123456','laoweige@163.com','13910178445',9,'2016-10-4','2016-10-4');
