create database if not exists Awesome_Toll_Company
default character set utf8;

use Awesome_Toll_Company;

create table card (
cardid int unsigned primary key auto_increment
);

create table retail_clients (
retailafm int unsigned primary key,
firstname varchar(40),
lastname varchar(40),
phone int unsigned,
email varchar(50)
);

create table pro_clients (
proafm int unsigned primary key,
companyname varchar(100),
phone int unsigned,
address varchar(100),
email varchar(50)
);

create table all_clients (
clientid int unsigned primary key auto_increment,
cardid int unsigned,
retailafm int unsigned,
proafm int unsigned,
constraint cardFK foreign key (cardid) references card (cardid),
constraint retailFK foreign key (retailafm) references retail_clients (retailafm),
constraint profFK foreign key (proafm) references pro_clients (proafm)
);

create table road (
roadid int unsigned auto_increment primary key,
name varchar(70)
);

create table station (
stationid int unsigned auto_increment primary key,
stationname varchar(70),
distance decimal(8,3) unsigned,
roadid int unsigned,
constraint roadFK foreign key (roadid) references road (roadid)
);

create table gate (
gateid int unsigned auto_increment primary key,
gateNo int unsigned,
stationid int unsigned,
employeeid int unsigned,
constraint stationFK foreign key (stationid) references station (stationid)
);

create table ongoing_logs (
ongoingid int unsigned auto_increment primary key,
cardid int unsigned,
entrygateid int unsigned,
entrytime timestamp not null,
constraint cardFK1 foreign key (cardid) references card (cardid),
constraint gateFK foreign key (entrygateid) references gate (gateid)
);

create table history_logs (
historyid int unsigned auto_increment primary key,
cardid int unsigned,
entrytime timestamp not null,
exittime timestamp not null,
entrygateid int unsigned,
exitgateid int unsigned,
constraint gateFK1 foreign key (entrygateid) references gate (gateid),
constraint gateFK2 foreign key (exitgateid) references gate (gateid)
);

create trigger copy_history
after insert 
on ongoing_logs
for each row
insert into history_logs
set
cardid = o.cardid,
entrytime = o.entrytme,
entrygateid = o.entrygateid;

