CREATE TABLE user
(
	id BIGINT(20) NOT NULL COMMENT '主键ID',
	name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
	age INT(11) NULL DEFAULT NULL COMMENT '年龄',
	email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
	PRIMARY KEY (id)
);

INSERT INTO user (id, name, age, email)
VALUES (1, 'Jone', 18, 'test1@baomidou.com'),
       (2, 'Jack', 20, 'test2@baomidou.com'),
       (3, 'Jack', 20, 'test2@baomidou.com'),
       (4, 'Jack', 20, 'test2@baomidou.com'),
       (5, 'Jack', 20, 'test2@baomidou.com'),
       (6, 'Jack', 20, 'test2@baomidou.com'),
       (7, 'Jack', 20, 'test2@baomidou.com'),
       (8, 'Jack', 20, 'test2@baomidou.com'),
       (9, 'Jack', 20, 'test2@baomidou.com'),
       (10, 'Jack', 20, 'test2@baomidou.com'),
       (11, 'Jack', 20, 'test2@baomidou.com'),
       (12, 'Jack', 20, 'test2@baomidou.com'),
       (13, 'Jack', 20, 'test2@baomidou.com'),
       (14, 'Jack', 20, 'test2@baomidou.com'),
       (15, 'Tom', 28, 'test3@baomidou.com'),
       (16, 'Sandy', 21, 'test4@baomidou.com'),
       (17, 'Billie', 24, 'test5@baomidou.com');