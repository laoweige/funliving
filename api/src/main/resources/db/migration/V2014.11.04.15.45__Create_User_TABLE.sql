CREATE TABLE Users (
    id INT NOT NULL auto_increment,
    name VARCHAR(50) NOT NULL,
    password VARCHAR(50),
    email VARCHAR(50),
    mobile VARCHAR(50) NOT NULL,
    integral INT NOT NULL,
    status INT NOT NULL,
    createTime DATETIME,
    loginTime DATETIME,
    PRIMARY KEY(id)
);

INSERT INTO Users (name,password,email,mobile,status,integral,createTime,loginTime)
VALUES('weizhigang','123456','laoweige@163.com','13910178445',0,0,'2014-10-4','2014-10-4');
INSERT INTO Users (name,password,email,mobile,status,integral,createTime,loginTime)
VALUES('guoxuewen','123456','gexuewen@163.com','13910171111',0,20,'2014-10-4','2014-10-4');