create database if not exists awesome_toll_company
default character set utf8mb4;

DROP SCHEMA awesome_toll_company;

use awesome_toll_company;

create table card (
cardid int unsigned primary key auto_increment
);

CREATE TABLE client (
	id INT UNSIGNED PRIMARY KEY,
    clientid INT UNSIGNED NOT NULL
);

create table retail_clients (
id INT UNSIGNED NOT NULL  primary key ,
retailafm bigint unsigned,
firstname varchar(100),
lastname varchar(100),
phone VARCHAR(15),
address varchar(100),
email varchar(50)
);

create table pro_clients (
id INT UNSIGNED NOT NULL primary key,
proafm bigint unsigned ,
companyname varchar(100),
phone VARCHAR(15),
address varchar(100),
email varchar(50)
);

create table road (
roadid int unsigned auto_increment primary key,
name varchar(70)
);

create table station (
stationid int unsigned auto_increment primary key,
stationname varchar(70),
distance decimal(8,3),
roadid int unsigned,
constraint roadFK foreign key (roadid) references road (roadid)
);

create table employee (
id int unsigned primary key,
firstname varchar (50),
lastname varchar (50),
phone VARCHAR(15),
email varchar (50)
);

create table gate (
gateid int unsigned auto_increment primary key,
gateNo int unsigned,
stationid int unsigned,
employeeid int unsigned,
isentry TINYINT(1) DEFAULT 0,
constraint gate_stationFK foreign key (stationid) references station (stationid),
constraint gate_employeeFK foreign key (employeeid) references employee (id)
);

CREATE TABLE terminal (
	id INT UNSIGNED PRIMARY KEY,
    gateid INT UNSIGNED,
    UNIQUE(gateid),
    CONSTRAINT terminal_gateidFK
    FOREIGN KEY (gateid)
    REFEReNCES gate(gateid)
);

create table ongoing_logs (
ongoingid int unsigned auto_increment primary key,
cardid int unsigned,
gateid int unsigned,
entrytime timestamp not null,
constraint ol_cardFK1 foreign key (cardid) references card (cardid),
constraint ol_gateFK foreign key (gateid) references gate (gateid)
);

create table history_logs (
historyid int unsigned primary key,
cardid int unsigned,
entrytime timestamp not null,
exittime timestamp,
entrygateid int unsigned,
exitgateid int unsigned,
constraint gateFK1 foreign key (entrygateid) references gate (gateid),
constraint gateFK2 foreign key (exitgateid) references gate (gateid)
);

CREATE TABLE role(
    rid INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    rname VARCHAR(30),
    UNIQUE(rname)
);

CREATE TABLE user (
	id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
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