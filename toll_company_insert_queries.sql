insert into card (cardid)
values (101),
(102),
(103),
(104),
(105),
(106),
(107),
(108),
(109);

insert into retail_clients (retailafm, firstname, lastname, phone, email)
values (0000111123, 'Dimitris', 'Kokoras', 6991234321, 'koko@gmail.gr'),
(1234111124, 'Vasilis', 'Iakovopoulos', 6988966987, 'iako@gmail.gr'),
(4321432112, 'Sotiris', 'Kalampokakis', 6976976977, 'kala@email.gr');


insert into pro_clients (proafm, companyname, phone, address, email)
values (1111222233, 'Coscote', 6999999986, 'Kolokotroni 27', 'email@coscote.gr'),
(1111222233, 'Xaplopoulos', 6988877766, 'Ath. DIakou 02', 'email@xaplo.gr'),
(3335557779, 'Byte', 6945678923, 'Kavalas 18', 'email@byte.gr');


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

insert into employee (firstname, lastname, phone, email)
values ('Nick', 'Nickolson', 6996996999, 'nickolson@atc.gr'),
('Jack', 'Jackson', 6936549871, 'jackson@atc.gr'),
('Andy', 'Andyson', 6924567892, 'andyson@atc.gr'),
('George', 'Georgeson', 6906901111, 'georgeson@atc.gr'),
('Mike', 'Mikeson', 6986986972, 'mikeson@atc.gr'),
('Chris', 'Christopherson', 6998976452, 'christopherson@atc.gr'),
('Alan' , 'White', 6971234568, 'white@atc.gr'),
('Owen', 'Black', 6971234569, 'black@atc.gr'),
('Margie', 'Green', 6922356471, 'green@atc.gr'),
('Sophia', 'Brown', 6957894562, 'brown@atc.gr'),
('Anna', 'Red', 6941237985, 'red@atc.gr'),
('Helen', 'Yellow', 6916879438, 'yellow@atc.gr'),
('Susan', 'Grey', 6966969987,'grey@atc.gr'),
('Barbara', 'Blue', 6963963876,'blue@atc.gr'),
('Deborah', 'Debman', 6937599513, 'debman@atc.gr'),
('Valeria', 'Valman', 6911236547, 'valman@atc.gr'),
('Peter', 'Peterson', 6928527419, 'peterson@atc.gr'),
('Pablo', 'Pablovsky', 6939638574, 'pablovsky@atc.gr'),
('Hector', 'Hectorson', 6993335557, 'hectorson@atc.gr'),
('Martina', 'Martinovsky', 6988887777, 'martinovsky,gr'),
('Alexy', 'Volodnikov', 6955578944, 'volodnikov@atc.gr'),
('David', 'Hayter', 6932378789, 'hayter@atc.gr'),
('Vanesa', 'Friednman', 6987898651, 'friedman@atc.gr'),
('Angie', 'Papadopoulou', 69564732945, 'papadopoulou@.gr'),
('Miranda', 'Spilioti', 6977225596, 'spilioti@atc.gr'),
('Eutihia', 'Lukou', 6932299555, 'lukou@atc.gr'),
('Konstantinos', 'Rodopoulos', 69444220661, 'rodopoulos@atc.gr'),
('Dimitris', 'Arkoudas', 6964679183, 'arkoudas@atc.gr'),
('Manolis', 'Alepoudakis', 6978964915, 'alepoudakis@atc.gr');

insert into gate  (gateNo, stationid, employeeid)
values (001, 1, 1),
(002, 1, 2),
(003, 1, 3),
(001, 2, 4),
(002, 2, 5),
(001, 3, 6),
(002, 3, 7),
(003, 3, 8),
(001, 4, 9),
(002, 4, 10),
(001, 5, 11),
(002, 5, 12),
(003, 5, 13),
(004, 5, 14),
(001, 6, 15),
(002, 6, 16),
(003, 6, 17),
(004, 7, 18),
(001, 8, 19),
(002, 9, 20),
(001, 10, 21),
(002, 10, 22),
(001, 11, 23),
(002, 12, 24),
(001, 13, 25),
(002, 13, 26),
(003, 13, 27),
(001, 14, 28),
(002, 14, 29);

-- insert into ongoing_logs (cardid, entrygateid, entrytime)
-- values (101, 1, "2020-01-01 00:30:31");

