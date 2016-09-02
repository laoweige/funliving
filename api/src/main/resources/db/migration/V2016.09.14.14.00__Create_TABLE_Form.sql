CREATE TABLE Schedule (
    id INT NOT NULL auto_increment,
    userId INT NOT NULL,
    name VARCHAR(50) NOT NULL,
    mobile VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL,
    status INT,
    startTime Date,
    endTime Date,
    createTime Date,
    PRIMARY KEY(id)
);


