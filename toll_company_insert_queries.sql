

INSERT INTO role VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_EMPLOYEE'),
(3, 'ROLE_CLIENT'),
(4, 'ROLE_TERMINAL');

# PASSWORD FOR ALL USERS IS 1234
INSERT INTO user(username, password, rid) VALUES
('admin1', '$2y$12$IsEt/FjyQw3f9JSQZueodOFlbhviHMh9rIgbCycLXe3.5NUbcyf8W', 1),
('admin2', '$2y$12$IsEt/FjyQw3f9JSQZueodOFlbhviHMh9rIgbCycLXe3.5NUbcyf8W', 1),
('admin3', '$2y$12$IsEt/FjyQw3f9JSQZueodOFlbhviHMh9rIgbCycLXe3.5NUbcyf8W', 1),
('emp1', '$2y$12$IsEt/FjyQw3f9JSQZueodOFlbhviHMh9rIgbCycLXe3.5NUbcyf8W', 2),
('emp2', '$2y$12$IsEt/FjyQw3f9JSQZueodOFlbhviHMh9rIgbCycLXe3.5NUbcyf8W', 2),
('emp3', '$2y$12$IsEt/FjyQw3f9JSQZueodOFlbhviHMh9rIgbCycLXe3.5NUbcyf8W', 2),
('emp4', '$2y$12$IsEt/FjyQw3f9JSQZueodOFlbhviHMh9rIgbCycLXe3.5NUbcyf8W', 2),
('emp5', '$2y$12$IsEt/FjyQw3f9JSQZueodOFlbhviHMh9rIgbCycLXe3.5NUbcyf8W', 2),
('emp6', '$2y$12$IsEt/FjyQw3f9JSQZueodOFlbhviHMh9rIgbCycLXe3.5NUbcyf8W', 2),
('pro1', '$2y$12$IsEt/FjyQw3f9JSQZueodOFlbhviHMh9rIgbCycLXe3.5NUbcyf8W', 3),
('pro2', '$2y$12$IsEt/FjyQw3f9JSQZueodOFlbhviHMh9rIgbCycLXe3.5NUbcyf8W', 3),
('pro3', '$2y$12$IsEt/FjyQw3f9JSQZueodOFlbhviHMh9rIgbCycLXe3.5NUbcyf8W', 3),
('ret1', '$2y$12$IsEt/FjyQw3f9JSQZueodOFlbhviHMh9rIgbCycLXe3.5NUbcyf8W', 3),
('ret2', '$2y$12$IsEt/FjyQw3f9JSQZueodOFlbhviHMh9rIgbCycLXe3.5NUbcyf8W', 3),
('ret3', '$2y$12$IsEt/FjyQw3f9JSQZueodOFlbhviHMh9rIgbCycLXe3.5NUbcyf8W', 3);

INSERT INTO client VALUES
(10, 0, 'color', '$2y$12$kAVt/I9nZcWIC7..AzO4d.RxAQb1DYpJeap2dA/wwzToeAgC79MQC'),
(11, 0, 'color', '$2y$12$kAVt/I9nZcWIC7..AzO4d.RxAQb1DYpJeap2dA/wwzToeAgC79MQC'),
(12, 0, 'color', '$2y$12$kAVt/I9nZcWIC7..AzO4d.RxAQb1DYpJeap2dA/wwzToeAgC79MQC'),
(13, 1, 'color', '$2y$12$kAVt/I9nZcWIC7..AzO4d.RxAQb1DYpJeap2dA/wwzToeAgC79MQC'),
(14, 1, 'color', '$2y$12$kAVt/I9nZcWIC7..AzO4d.RxAQb1DYpJeap2dA/wwzToeAgC79MQC'),
(15, 1, 'color', '$2y$12$kAVt/I9nZcWIC7..AzO4d.RxAQb1DYpJeap2dA/wwzToeAgC79MQC');

insert into card
values (101, 10),
(102, 11),
(103, 12),
(104, 13),
(105, 14),
(106, 15);

insert into pro_clients (id, proafm, companyname, phone, address, email)
values (10, 1111222233, 'Coscote', 6999999986, 'Kolokotroni 27', 'email@coscote.gr'),
(11, 1111222233, 'Xaplopoulos', 6988877766, 'Ath. DIakou 02', 'email@xaplo.gr'),
(12, 3335557779, 'Byte', 6945678923, 'Kavalas 18', 'email@byte.gr');

insert into retail_clients (id, retailafm, firstname, lastname, phone, email)
values (13, 0000111123, 'Dimitris', 'Kokoras', 6991234321, 'koko@gmail.gr'),
(14, 1234111124, 'Vasilis', 'Iakovopoulos', 6988966987, 'iako@gmail.gr'),
(15, 4321432112, 'Sotiris', 'Kalampokakis', 6976976977, 'kala@email.gr');

insert into road (name) values ('Egnatia'),
('P.A.TH.E.'),
('Ionia');

insert into station (stationname, distance, roadid)
values 
('Turias', 0, 1),
('Pamvotidas', 30.5, 1),
('Malakasiou', 87.9, 1),
('Polimulou', 182, 1),
('Malgaron', 276, 1),
('Afidnon', 0, 2),
('Malakasas', 21.9, 2),
('Inofita', 41.3, 2),
('Thivas', 70.3, 2),
('Traganas', 113, 2),
('Klokovas', 0, 3),
('Aggelokastrou', 46.1, 3),
('Menidiou', 101, 3),
('Terovou', 164, 3);
SELECT * FROM station;

UPDATE station SET
stationname = 'Agios Stefanos',
latitude = 38.138963,
longitude = 23.843020
WHERE stationid = 6;

UPDATE station SET
stationname = 'Malakasa',
latitude = 38.2355644,
longitude = 23.7871869
WHERE stationid = 7;

UPDATE station SET
stationname = 'Katerini',
latitude = 40.2532067,
longitude = 22.5386118,
distance = 409
WHERE stationid = 8;

UPDATE station SET
stationname = 'Larisa',
latitude = 39.579468, 
longitude = 22.482579,
distance = 322
WHERE stationid = 9;

INSERT INTO vehicle VALUES
('Motorcycle', 0.04),
('Passenger car', 0.06),
('Bus', 0.16),
('Truck', 0.23);

UPDATE station SET
stationname = 'Delta',
latitude = 40.605956,
longitude = 22.723859,
distance = 458
WHERE stationid = 10;

insert into employee
values (1, 'Nick', 'Nickolson', 6996996999, 'nickolson@atc.gr'),
(2, 'Jack', 'Jackson', 6936549871, 'jackson@atc.gr'),
(3, 'Andy', 'Andyson', 6924567892, 'andyson@atc.gr'),
(4, 'George', 'Georgeson', 6906901111, 'georgeson@atc.gr'),
(5, 'Mike', 'Mikeson', 6986986972, 'mikeson@atc.gr'),
(6, 'Chris', 'Christopherson', 6998976452, 'christopherson@atc.gr'),
(7, 'Alan' , 'White', 6971234568, 'white@atc.gr'),
(8, 'Owen', 'Black', 6971234569, 'black@atc.gr'),
(9, 'Margie', 'Green', 6922356471, 'green@atc.gr');
-- ('Sophia', 'Brown', 6957894562, 'brown@atc.gr'),
-- ('Anna', 'Red', 6941237985, 'red@atc.gr'),
-- ('Helen', 'Yellow', 6916879438, 'yellow@atc.gr'),
-- ('Susan', 'Grey', 6966969987,'grey@atc.gr'),
-- ('Barbara', 'Blue', 6963963876,'blue@atc.gr'),
-- ('Deborah', 'Debman', 6937599513, 'debman@atc.gr'),
-- ('Valeria', 'Valman', 6911236547, 'valman@atc.gr'),
-- ('Peter', 'Peterson', 6928527419, 'peterson@atc.gr'),
-- ('Pablo', 'Pablovsky', 6939638574, 'pablovsky@atc.gr'),
-- ('Hector', 'Hectorson', 6993335557, 'hectorson@atc.gr'),
-- ('Martina', 'Martinovsky', 6988887777, 'martinovsky,gr'),
-- ('Alexy', 'Volodnikov', 6955578944, 'volodnikov@atc.gr'),
-- ('David', 'Hayter', 6932378789, 'hayter@atc.gr'),
-- ('Vanesa', 'Friednman', 6987898651, 'friedman@atc.gr'),
-- ('Angie', 'Papadopoulou', 69564732945, 'papadopoulou@.gr'),
-- ('Miranda', 'Spilioti', 6977225596, 'spilioti@atc.gr'),
-- ('Eutihia', 'Lukou', 6932299555, 'lukou@atc.gr'),
-- ('Konstantinos', 'Rodopoulos', 69444220661, 'rodopoulos@atc.gr'),
-- ('Dimitris', 'Arkoudas', 6964679183, 'arkoudas@atc.gr'),
-- ('Manolis', 'Alepoudakis', 6978964915, 'alepoudakis@atc.gr');

insert into gate (gateNo, stationid, isentry) values
(1001, 1, 0),
(1002, 1, 1), #ENTRY
(1003, 1, 0),
(1004, 1, 1),
(2001, 2, 0),
(2002, 2, 0),
(2003, 2, 0), #EXIT
(2004, 2, 1),
(2005, 2, 1),
(2006, 2, 1),
(3001, 3, 0),
(3002, 3, 1),
(4001, 4, 0),
(4002, 4, 1),
(5001, 5, 0),
(5002, 5, 1),
(6001, 6, 0),
(6002, 6, 1),
(7001, 7, 0),
(7002, 7, 1), #ENTRY
(8001, 8, 0),
(8002, 8, 1),
(9001, 9, 0),
(9002, 9, 1),
(10001, 10, 0),
(10002, 10, 1);


-- insert into ongoing_logs (cardid, entrygateid, entrytime)
-- values (101, 1, "2020-01-01 00:30:31");


INSERT INTO user(username, password, rid) VALUES
('terminal2', '$2y$12$IsEt/FjyQw3f9JSQZueodOFlbhviHMh9rIgbCycLXe3.5NUbcyf8W', 4),
('terminal7', '$2y$12$IsEt/FjyQw3f9JSQZueodOFlbhviHMh9rIgbCycLXe3.5NUbcyf8W', 4);
INSERT INTO user(username, password, rid) VALUES
('terminal17', '$2y$12$IsEt/FjyQw3f9JSQZueodOFlbhviHMh9rIgbCycLXe3.5NUbcyf8W', 4),
('terminal18', '$2y$12$IsEt/FjyQw3f9JSQZueodOFlbhviHMh9rIgbCycLXe3.5NUbcyf8W', 4),
('terminal19', '$2y$12$IsEt/FjyQw3f9JSQZueodOFlbhviHMh9rIgbCycLXe3.5NUbcyf8W', 4),
('terminal20', '$2y$12$IsEt/FjyQw3f9JSQZueodOFlbhviHMh9rIgbCycLXe3.5NUbcyf8W', 4),
('terminal21', '$2y$12$IsEt/FjyQw3f9JSQZueodOFlbhviHMh9rIgbCycLXe3.5NUbcyf8W', 4),
('terminal22', '$2y$12$IsEt/FjyQw3f9JSQZueodOFlbhviHMh9rIgbCycLXe3.5NUbcyf8W', 4),
('terminal23', '$2y$12$IsEt/FjyQw3f9JSQZueodOFlbhviHMh9rIgbCycLXe3.5NUbcyf8W', 4),
('terminal24', '$2y$12$IsEt/FjyQw3f9JSQZueodOFlbhviHMh9rIgbCycLXe3.5NUbcyf8W', 4),
('terminal25', '$2y$12$IsEt/FjyQw3f9JSQZueodOFlbhviHMh9rIgbCycLXe3.5NUbcyf8W', 4),
('terminal26', '$2y$12$IsEt/FjyQw3f9JSQZueodOFlbhviHMh9rIgbCycLXe3.5NUbcyf8W', 4);

INSERT INTO terminal VALUES (16,2),(17,7);

INSERT INTO terminal VALUES 
(18,17),
(19,18),
(20,19),
(21,20),
(22,21),
(23,22),
(24,23),
(25,24),
(26,25),
(27,26);

INSERT INTO ongoing_logs VALUES
(26,	101,	18,	'2020-01-18 18:50:48'),
(27,	102,	18,	'2020-01-18 18:50:52'),
(28,	103,	20,	'2020-01-18 18:51:32'),
(29,	104,	20,	'2020-01-18 18:51:42'),
(30,	105,	24,	'2020-01-18 18:53:46'),
(31,	106,	24,	'2020-01-18 18:53:50');

INSERT INTO ongoing_logs VALUES
(36,	101,	22,	'2020-01-18 18:50:48');
-- (27,	101,	18,	'2020-01-18 18:50:52');
-- (28,	101,	22,	'2020-01-18 18:51:32');
-- (29,	101,	20,	'2020-01-18 18:51:42');
-- (30,	101,	24,	'2020-01-18 18:53:46');
-- (31,	101,	24,	'2020-01-18 18:53:50');




SELECT * FROM history_logs;
SELECT * FROM ongoing_logs;
SELECT * FROM terminal;
select * from gate;
SET SQL_SAFE_UPDATES = 1;
UPDATE gate SET employeeid = null;
DELETE FROM ongoing_logs;
DELETE FROM history_logs;
DELETE FROM terminal;

DELETE FROM history_logs WHERE historyid = 35;

SELECT * FROM role;
SELECT * FROM user;
SELECT * FROM client;
SELECT * FROM pro_clients;
SELECT * FROM retail_clients;
SELECT * FROM employee;
desc pro_clients;
SELECT * FROM terminal;

SELECT * FROM user;
SELECT * FROM station;
SELECT * FROM road;

SELECT * FROM vehicle;
SELECT * FROM retail_clients;
SELECT * FROM card;
desc retail_clients;

-- ALTER TABLE history_logs
-- ADD geometry VARCHAR(500);

-- ALTER TABLE history_logs
-- ADD cost DECIMAL(5,2);

-- ALTER TABLE history_logs
-- ADD vehicle INT UNSIGNED;

-- ALTER TABLE station
-- ADD longitude DECIMAL(12,9);

-- ALTER TABLE history_logs
-- ADD CONSTRAINT gateFK3 FOREIGN KEY (vehicle) REFERENCES vehicle(id);