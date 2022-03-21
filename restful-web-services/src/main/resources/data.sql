DROP TABLE IF EXISTS USERSLIST;
CREATE TABLE USERSLIST (
  username			VARCHAR(250) 		PRIMARY KEY,
  usernameid 		INT   				DEFAULT NULL,
  password			VARCHAR(250) 		DEFAULT NULL
);

INSERT INTO USERSLIST (usernameid,username,password) VALUES
  (10002,'dawid','haslo'),
  (10003,'dawid2','haslo'),
  (10004,'admin','admin')
  ;
  
DROP TABLE IF EXISTS CATEGORY;
CREATE TABLE CATEGORY (
  categoryname 		VARCHAR(250) 		PRIMARY KEY,
  categoryid 		INT   				DEFAULT NULL,
  username 			VARCHAR(250) 		DEFAULT NULL, foreign key (username) references USERSLIST(username),
  comment 			VARCHAR(250) 		DEFAULT NULL,
  hexcolor 			VARCHAR(250) 		DEFAULT NULL
);

INSERT INTO CATEGORY (categoryid, username, categoryname,comment,hexcolor) VALUES
  (10001,'dawid','Kredyty, raty, podatki','','#490009'),
  (10002,'dawid','Spozywcze','','#0033FF'),
  (10003,'dawid','Dom','Oplaty zwiazane z mieszkaniem, telefon','#27BEBE'),
  (10004,'dawid','Edukacja i odziez','','#8B572A'),
  (10005,'dawid','Hobby','Sprzet sportowy, silownia itp.','#417505'),
  (10007,'dawid','Podroze','','#4A90E2'),
  (10008,'dawid','Transport','Komunikacja miejska, paliwo itp.','#8ADD1D'),
  (10009,'dawid','Rozrywka','Kino, Mecze, Restauracja, Netflix itp.','#0B440B'),
  (10010,'dawid','Meblowy','','#5A3511'),
  (10011,'dawid','Naprawy/Lekarz','Naprawy samochodu, apteka, wizyta u lekarza, dentysty itp.','#1B531B')
  ;

DROP TABLE IF EXISTS BUDGET;
CREATE TABLE BUDGET (
  budgetid 			INT AUTO_INCREMENT  PRIMARY KEY,
  username 			VARCHAR(250) 		DEFAULT NULL, foreign key (username) references USERSLIST(username),
  target_month 		DATE 				DEFAULT NULL,
  amount 			DOUBLE				DEFAULT NULL,
  comment    		VARCHAR(250) 		DEFAULT NULL
);

INSERT INTO BUDGET (budgetid, username, target_month, amount, comment) VALUES
  (10004,'dawid','2021-11-22',3100,''),
  (10005,'dawid','2021-12-22',3200,''),
  (10006,'dawid','2022-01-22',5000,''),
  (10007,'dawid2','2022-01-22',5010,''),
  (10008,'dawid2','2022-02-22',5110,'')
  ;
  
DROP TABLE IF EXISTS INCOME;
CREATE TABLE INCOME (
  incomeid 		INT AUTO_INCREMENT  PRIMARY KEY,
  username 		VARCHAR(250) 		DEFAULT NULL, foreign key (username) references USERSLIST(username),
  description 	VARCHAR(250) 		DEFAULT NULL,
  target_date 	DATE 				DEFAULT NULL,
  finish_date 	DATE 				DEFAULT NULL,
  amount 		DOUBLE				DEFAULT NULL,
  comment 		VARCHAR(250) 		DEFAULT NULL,
  cycle			VARCHAR(250)		DEFAULT NULL
);

INSERT INTO INCOME (incomeid, username, description, target_date,finish_date,amount, comment,cycle) VALUES
(10001,'dawid','Pensja','2021-11-01','2021-12-31',3200,'','Co miesiac'),
(10002,'dawid','Sprzedaz ubran','2021-11-22','2021-11-22',372,'','Nie'),
(10003,'dawid2','Pensja Dawid','2021-01-01','2023-12-31',6300,'','Co miesiac'),
(10004,'dawid','Bonus kwartalny','2021-12-22','2021-12-22',511,'','Nie'),
(10005,'dawid','Pensja','2022-01-01','2022-01-31',5800,'','Co miesiac'),
(10006,'dawid','Bonus kwartalny','2022-04-22','2022-04-22',1122,'','Nie'),
(10007,'dawid2','Sprzedaz ubran','2022-02-22','2022-02-22',372,'','Nie')
;  

DROP TABLE IF EXISTS EXPENSE;
CREATE TABLE EXPENSE (
  expenseid 		INT AUTO_INCREMENT  PRIMARY KEY,
  username 			VARCHAR(250)  		DEFAULT NULL,  foreign key (username) references USERSLIST(username),
  description 		VARCHAR(250) 		DEFAULT NULL,
  target_date 		DATE 				DEFAULT NULL,
  finish_date 		DATE 				DEFAULT NULL,
  price 			DOUBLE				DEFAULT NULL,
  categoryname 		VARCHAR(250) 		DEFAULT NULL,  foreign key (categoryname) references CATEGORY(categoryname),
  comment 			VARCHAR(250) 		DEFAULT NULL,
  cycle				VARCHAR(250)		DEFAULT NULL
);
    
INSERT INTO EXPENSE (expenseid, username, description, target_date,finish_date,price, categoryname,comment,cycle) VALUES
(10001,'dawid','Gitara','2022-05-31','2022-05-31',780,'Hobby','','Nie'),
(10002,'dawid','Czynsz','2021-11-01','2021-12-31',500,'Dom','','Co miesiac'),
(10003,'dawid','Telefon','2021-11-01','2021-12-31',20,'Dom','','Co miesiac'),
(10004,'dawid','Netflix','2021-11-01','2021-12-31',18,'Rozrywka','','Co miesiac'),
(10005,'dawid','Ubezpieczenie','2021-11-01','2021-12-31',108.75,'Kredyty, raty, podatki','','Co miesiac'),
(10006,'dawid','Kredyt telefon','2021-11-01','2021-12-31',48.95,'Kredyty, raty, podatki','','Co miesiac'),
(10007,'dawid','Media','2021-11-01','2022-12-31',480,'Dom','Gaz','Co rok'),
(10008,'dawid','Media','2021-11-01','2022-12-31',490,'Dom','Prad','Co pol roku'),
(10009,'dawid','Czynsz','2022-01-01','2022-01-31',510,'Dom','','Co miesiac'),
(10010,'dawid','Telefon','2022-01-01','2022-01-31',30,'Dom','','Co miesiac'),
(10011,'dawid','Netflix','2022-01-01','2022-01-31',18,'Dom','','Co miesiac'),
(10012,'dawid','Ubezpieczenie','2022-01-01','2022-01-31',110,'Dom','','Co miesiac'),
(10013,'dawid','Kredyt','2022-01-01','2022-01-31',25,'Kredyty, raty, podatki','','Co miesiac'),
(10014,'dawid','netflix','2022-01-01','2022-01-31',15,'Dom','','Co miesiac'),
(10017,'dawid','Kredyt hipoteczny','2022-01-01','2022-12-01',1300,'Kredyty, raty, podatki','','Co miesiac'),

(10018,'dawid','Wyjazd','2021-11-30','2021-11-30',28,'Podroze','','Nie'),
(10019,'dawid','Stacja benzynowa','2021-11-11','2021-11-11',112.58,'Transport','','Nie'),
(10020,'dawid','Kawa','2021-11-24','2021-11-24',7.99,'Rozrywka','','Nie'),
(10021,'dawid','Sklep','2021-11-12','2021-11-12',80.18,'Spozywcze','','Nie'),
(10022,'dawid','Sklep','2021-11-05','2021-11-05',59.61,'Spozywcze','','Nie'),
(10023,'dawid','Stacja benzynowa','2021-11-26','2021-11-26',61.99,'Transport','','Nie'),
(10024,'dawid','Sklep','2021-11-27','2021-11-27',4.5,'Spozywcze','','Nie'),
(10025,'dawid','Sklep','2021-11-12','2021-11-12',5.5,'Spozywcze','','Nie'),
(10026,'dawid','Sklep','2021-11-24','2021-11-24',2.8,'Spozywcze','','Nie'),
(10027,'dawid','Sklep','2021-11-26','2021-11-26',9.89,'Spozywcze','','Nie'),
(10028,'dawid','Sklep','2021-11-07','2021-11-07',1,'Spozywcze','','Nie'),
(10029,'dawid','Buty','2021-11-03','2021-11-03',149.9,'Edukacja i odziez','','Nie'),
(10030,'dawid','Sklep','2021-11-06','2021-11-06',9.47,'Spozywcze','','Nie'),
(10031,'dawid','Restauracja','2021-11-22','2021-11-22',30,'Rozrywka','','Nie'),
(10032,'dawid','Sklep','2021-11-04','2021-11-04',15.25,'Spozywcze','','Nie'),
(10033,'dawid','Sklep','2021-11-26','2021-11-26',122.58,'Spozywcze','','Nie'),
(10034,'dawid','Restauracja','2021-11-30','2021-11-30',45.9,'Rozrywka','','Nie'),
(10035,'dawid','Restauracja','2021-11-19','2021-11-19',13.5,'Rozrywka','','Nie'),
(10036,'dawid','Sklep','2021-11-24','2021-11-24',8.2,'Spozywcze','','Nie'),
(10037,'dawid','Restauracja','2021-11-23','2021-11-23',100,'Rozrywka','','Nie'),
(10038,'dawid','Sklep','2021-11-20','2021-11-20',17.32,'Spozywcze','','Nie'),
(10039,'dawid','Sklep','2021-11-12','2021-11-12',15,'Spozywcze','','Nie'),
(10040,'dawid','Kebab','2021-11-18','2021-11-18',21,'Spozywcze','','Nie'),
(10041,'dawid','Stacja benzynowa','2021-11-21','2021-11-21',100.36,'Transport','','Nie'),
(10042,'dawid','Sklep','2021-11-28','2021-11-28',124.66,'Spozywcze','','Nie'),
(10043,'dawid','Sklep','2021-11-02','2021-11-02',63.97,'Spozywcze','','Nie'),
(10044,'dawid','Sklep','2021-11-27','2021-11-27',89.96,'Spozywcze','','Nie'),
(10045,'dawid','Sklep','2021-11-04','2021-11-04',48.75,'Spozywcze','','Nie'),
(10046,'dawid','Sklep','2021-11-23','2021-11-23',10.58,'Spozywcze','','Nie'),
(10047,'dawid','Ikea','2021-11-08','2021-11-08',137.92,'Meblowy','','Nie'),
(10048,'dawid','Stacja benzynowa','2021-11-20','2021-11-20',99.99,'Transport','','Nie'),
(10049,'dawid','Sklep','2021-11-30','2021-11-30',48.8,'Spozywcze','','Nie'),
(10050,'dawid','Wycieczka','2021-11-08','2021-11-08',254,'Podroze','','Nie'),
(10051,'dawid','Restauracja','2021-11-02','2021-11-02',140,'Rozrywka','','Nie'),
(10052,'dawid','Ikea','2021-11-01','2021-11-01',199.46,'Meblowy','','Nie'),
(10053,'dawid','Vinted','2021-11-15','2021-11-15',136.8,'Edukacja i odziez','','Nie'),
(10054,'dawid','Sklep','2021-11-12','2021-11-12',116.75,'Spozywcze','','Nie'),

(10055,'dawid','Sklep','2021-12-29','2021-12-29',22.85,'Spozywcze','','Nie'),
(10056,'dawid','Restauracja','2021-12-29','2021-12-29',23,'Rozrywka','','Nie'),
(10057,'dawid','Sklep','2021-12-03','2021-12-03',39,'Spozywcze','','Nie'),
(10058,'dawid','Sklep','2021-12-02','2021-12-02',3.9,'Spozywcze','','Nie'),
(10059,'dawid','Sklep','2021-12-06','2021-12-06',20.36,'Spozywcze','','Nie'),
(10060,'dawid','Sklep','2021-12-16','2021-12-16',39,'Spozywcze','','Nie'),
(10061,'dawid','Sklep','2021-12-27','2021-12-27',3.9,'Spozywcze','','Nie'),
(10062,'dawid','Kurtka','2021-12-30','2021-12-30',410,'Edukacja i odziez','','Nie'),
(10063,'dawid','Sklep','2021-12-17','2021-12-17',155.56,'Spozywcze','','Nie'),
(10064,'dawid','Sklep','2021-12-09','2021-12-09',4.8,'Spozywcze','','Nie'),
(10065,'dawid','Sklep','2021-12-07','2021-12-07',106.89,'Spozywcze','','Nie'),
(10066,'dawid','Sklep','2021-12-24','2021-12-24',61.79,'Spozywcze','','Nie'),
(10067,'dawid','Sklep','2021-12-05','2021-12-05',13.37,'Spozywcze','','Nie'),
(10068,'dawid','Stacja benzynowa','2021-12-23','2021-12-23',84.95,'Transport','','Nie'),
(10069,'dawid','Stacja benzynowa','2021-12-23','2021-12-23',100.27,'Transport','','Nie'),
(10070,'dawid','Sklep','2021-12-29','2021-12-29',83.42,'Spozywcze','','Nie'),
(10071,'dawid','Sklep','2021-12-19','2021-12-19',16.99,'Spozywcze','','Nie'),
(10072,'dawid','Klub','2021-12-31','2021-12-31',34,'Rozrywka','','Nie'),
(10073,'dawid','Klub','2021-12-01','2021-12-01',13,'Rozrywka','','Nie'),
(10074,'dawid','Klub','2021-12-28','2021-12-28',63,'Rozrywka','','Nie'),
(10075,'dawid','Klub','2021-12-09','2021-12-09',30,'Rozrywka','','Nie'),
(10076,'dawid','Stacja benzynowa','2021-12-21','2021-12-21',42,'Transport','','Nie'),
(10077,'dawid','Sklep','2021-12-11','2021-12-11',17.39,'Spozywcze','','Nie'),
(10078,'dawid','Stacja benzynowa','2021-12-28','2021-12-28',99.99,'Transport','','Nie'),
(10079,'dawid','Sklep','2021-12-17','2021-12-17',67.92,'Spozywcze','','Nie'),
(10080,'dawid','Pepco','2021-12-28','2021-12-28',90,'Meblowy','','Nie'),
(10081,'dawid','Restauracja','2021-12-10','2021-12-10',15,'Rozrywka','','Nie'),
(10082,'dawid','Ikea','2021-12-20','2021-12-20',55.98,'Meblowy','','Nie'),
(10083,'dawid','Sklep','2021-12-04','2021-12-04',86.04,'Spozywcze','','Nie'),
(10084,'dawid','Stacja benzynowa','2021-12-20','2021-12-20',5.98,'Transport','','Nie'),
(10085,'dawid','Sklep','2021-12-17','2021-12-17',67.5,'Spozywcze','','Nie'),
(10086,'dawid','Decathlon','2021-12-22','2021-12-22',81.97,'Edukacja i odziez','','Nie'),
(10087,'dawid','Plecak','2021-12-18','2021-12-18',145.9,'Edukacja i odziez','','Nie'),
(10088,'dawid','Korki','2021-12-26','2021-12-26',100,'Hobby','','Nie'),
(10089,'dawid','Sklep','2021-12-08','2021-12-08',14.94,'Spozywcze','','Nie'),
(10090,'dawid','Sklep','2021-12-10','2021-12-10',20,'Spozywcze','','Nie'),
(10091,'dawid','Restauracja','2021-12-06','2021-12-06',89,'Rozrywka','','Nie'),
(10092,'dawid','Sklep','2021-12-07','2021-12-07',14.99,'Spozywcze','','Nie'),
(10093,'dawid','Spodnie','2021-12-18','2021-12-18',139,'Edukacja i odziez','','Nie'),
(10094,'dawid','MPK','2021-12-27','2021-12-27',41.48,'Transport','','Nie'),
(10095,'dawid','Klub','2021-12-04','2021-12-04',8,'Rozrywka','','Nie'),
(10096,'dawid','Klub','2021-12-07','2021-12-07',33,'Rozrywka','','Nie'),
(10097,'dawid','Klub','2021-12-26','2021-12-26',60,'Rozrywka','','Nie'),
(10098,'dawid','Sklep','2021-12-27','2021-12-27',39,'Spozywcze','','Nie'),
(10099,'dawid','Sklep','2021-12-25','2021-12-25',3.5,'Spozywcze','','Nie'),

(10100,'dawid','Rekawice','2022-01-12','2022-01-12',259,'Hobby','','Nie'),
(10101,'dawid','Sklep','2022-01-31','2022-01-31',90,'Spozywcze','','Nie'),
(10102,'dawid','Restauracja','2022-01-23','2022-01-23',20,'Rozrywka','','Nie'),
(10103,'dawid','Sklep','2022-01-03','2022-01-03',50.3,'Spozywcze','','Nie'),
(10104,'dawid','Sylwester','2022-01-27','2022-01-27',349,'Rozrywka','','Nie'),
(10105,'dawid','Sklep','2022-01-08','2022-01-08',30.45,'Spozywcze','','Nie'),
(10106,'dawid','Sklep','2022-01-03','2022-01-03',27,'Spozywcze','','Nie'),
(10107,'dawid','Sklep','2022-01-29','2022-01-29',90.28,'Spozywcze','','Nie'),
(10108,'dawid','MPK','2022-01-08','2022-01-08',20,'Transport','','Nie'),
(10109,'dawid','Sklep','2022-01-01','2022-01-01',7.79,'Spozywcze','','Nie'),
(10110,'dawid','Apteka','2022-01-26','2022-01-26',16.88,'Naprawy/Lekarz','','Nie'),
(10111,'dawid','Stacja benzynowa','2022-01-14','2022-01-14',100.02,'Transport','','Nie'),
(10112,'dawid','Sklep','2022-01-21','2022-01-21',51.14,'Spozywcze','','Nie'),
(10113,'dawid','Leroy Merlin','2022-01-04','2022-01-04',25.49,'Meblowy','','Nie'),
(10114,'dawid','Leroy Merlin','2022-01-13','2022-01-13',49.99,'Meblowy','','Nie'),
(10115,'dawid','Sklep','2022-01-13','2022-01-13',48.8,'Spozywcze','','Nie'),
(10116,'dawid','Sklep','2022-01-15','2022-01-15',131.51,'Spozywcze','','Nie'),
(10117,'dawid','Sklep','2022-01-09','2022-01-09',44.83,'Spozywcze','','Nie'),
(10118,'dawid','Stacja benzynowa','2022-01-03','2022-01-03',99.85,'Transport','','Nie'),
(10119,'dawid','Apteka','2022-01-27','2022-01-27',24.95,'Naprawy/Lekarz','','Nie'),
(10120,'dawid','Sklep','2022-01-20','2022-01-20',21.92,'Spozywcze','','Nie'),
(10121,'dawid','Stacja benzynowa','2022-01-28','2022-01-28',90.22,'Transport','','Nie'),
(10122,'dawid','Bus','2022-01-25','2022-01-25',30,'Podroze','','Nie'),
(10123,'dawid','Sklep','2022-01-09','2022-01-09',15.33,'Spozywcze','','Nie'),
(10124,'dawid','Bus','2022-01-06','2022-01-06',52.89,'Podroze','','Nie'),
(10125,'dawid','Sklep','2022-01-23','2022-01-23',109.11,'Spozywcze','','Nie'),
(10126,'dawid','Stacja benzynowa','2022-01-17','2022-01-17',199.58,'Transport','','Nie'),
(10127,'dawid','Mechanik','2022-01-16','2022-01-16',265,'Naprawy/Lekarz','','Nie'),
(10128,'dawid','Sklep','2022-01-28','2022-01-28',43.48,'Spozywcze','','Nie'),
(10129,'dawid','Sklep','2022-01-16','2022-01-16',32.99,'Spozywcze','','Nie'),
(10130,'dawid','Stacja benzynowa','2022-01-23','2022-01-23',143.52,'Transport','','Nie'),
(10131,'dawid','Kawa','2022-01-12','2022-01-12',8.99,'Rozrywka','','Nie'),
(10132,'dawid','Sklep','2022-01-31','2022-01-31',3.58,'Spozywcze','','Nie'),
(10133,'dawid','Sklep','2022-01-10','2022-01-10',5.59,'Spozywcze','','Nie'),
(10134,'dawid','Sklep','2022-01-14','2022-01-14',28.11,'Spozywcze','','Nie')
;