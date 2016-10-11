--mysql -u root -p
--pass
--use TESTDB

DROP DATABASE TESTDB;

CREATE DATABASE TESTDB;

CREATE TABLE test
(
	id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	created_by VARCHAR(30), 
	created_date TIMESTAMP,
	description VARCHAR(80) NOT NULL
);

INSERT INTO test (id, created_by, created_date, description)
VALUES (1, 'Kishoj', NOW(), 'Description for test');

CREATE TABLE test 
(
	id big_serial PRIMARY KEY,
	created_by text, 
	created_date TIMESTAMP,
	description text not null
);