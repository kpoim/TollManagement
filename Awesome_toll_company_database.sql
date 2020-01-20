CREATE DATABASE IF NOT EXISTS awesome_toll_company
default character set utf8mb4;

-- DROP SCHEMA awesome_toll_company; 

USE awesome_toll_company;

CREATE TABLE card (
cardid INT UNSIGNED PRIMARY KEY AUTO_INCREMENT
);

CREATE TABLE client (
	id INT UNSIGNED PRIMARY KEY,
    clientid INT UNSIGNED NOT NULL
);

CREATE TABLE retail_clients (
id INT UNSIGNED NOT NULL PRIMARY KEY ,
retailafm BIGINT UNSIGNED,
firstname VARCHAR(100),
lastname VARCHAR(100),
phone VARCHAR(15),
address VARCHAR(100),
email VARCHAR(50)
);

CREATE TABLE pro_clients (
id INT UNSIGNED NOT NULL PRIMARY KEY,
proafm BIGINT UNSIGNED ,
companyname varchar(100),
phone VARCHAR(15),
address VARCHAR(100),
email VARCHAR(50)
);

CREATE TABLE road (
roadid INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
NAME VARCHAR(70)
);

create table station (
stationid INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
stationname VARCHAR(70),
distance DECIMAL(8,3),
roadid INT UNSIGNED,
latitude DECIMAL(12,9),  
longitude DECIMAL(12,9),
CONSTRAINT roadFK FOREIGN KEY (roadid) REFERENCES road (roadid)
);

create table employee (
id INT UNSIGNED PRIMARY KEY,
firstname VARCHAR (50),
lastname VARCHAR (50),
phone VARCHAR(15),
email VARCHAR (50)
);

create table gate (
gateid INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
gateNo INT UNSIGNED,
stationid INT UNSIGNED,
employeeid INT UNSIGNED,
isentry TINYINT(1) DEFAULT 0,
CONSTRAINT gate_stationFK FOREIGN KEY (stationid) REFERENCES station (stationid),
CONSTRAINT gate_employeeFK FOREIGN KEY (employeeid) REFERENCES employee (id)
);

CREATE TABLE terminal (
	id INT UNSIGNED PRIMARY KEY,
    gateid INT UNSIGNED,
    UNIQUE(gateid),
    CONSTRAINT terminal_gateidFK
    FOREIGN KEY (gateid)
    REFERENCES gate(gateid)
);

create table ongoing_logs (
ongoingid INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
cardid INT UNSIGNED,
gateid INT UNSIGNED,
entrytime TIMESTAMP NOT NULL,
CONSTRAINT ol_cardFK1 FOREIGN KEY (cardid) REFERENCES card (cardid),
CONSTRAINT ol_gateFK FOREIGN KEY (gateid) REFERENCES gate (gateid)
);

CREATE TABLE vehicle(
	-- id INT UNSIGNED AUTO_INCREMENT ,
    name VARCHAR(20) PRIMARY KEY,
    #ppkm = price per km
    ppkm DECIMAL(5,4)
);

create table history_logs (
historyid INT UNSIGNED PRIMARY KEY,
cardid INT UNSIGNED,
entrytime TIMESTAMP NOT NULL,
exittime TIMESTAMP,
entrygateid INT UNSIGNED,
exitgateid INT UNSIGNED,
geometry VARCHAR(500),
cost DECIMAL(5,2),
vehicle VARCHAR(20),
CONSTRAINT gateFK1 FOREIGN KEY (entrygateid) REFERENCES gate (gateid),
CONSTRAINT gateFK2 FOREIGN KEY (exitgateid) REFERENCES gate (gateid),
CONSTRAINT gateFK3 FOREIGN KEY (vehicle) REFERENCES vehicle(name)
);

CREATE TABLE role(
    rid INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    rname VARCHAR(30),
    UNIQUE(rname)
);

CREATE TABLE user (
	id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE,
    password VARCHAR(68),
    rid INT UNSIGNED,
    CONSTRAINT roleFK FOREIGN KEY (rid) REFERENCES role(rid)
);

-- DELIMITER $
-- create trigger copy_history
-- before insert 
-- on ongoing_logs
-- for each row
-- BEGIN
-- 	insert into history_logs 
--     set
--     historyid = new.ongoingid,
--     cardid = new.cardid,
--     entrytime = new.entrytime,
--     entrygateid = new.entrygateid;
-- END;
-- $
-- DELIMITER ;


select * from client;
select * from retail_clients;