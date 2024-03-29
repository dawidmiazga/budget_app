--DROP TABLE IF EXISTS CYCLES;
--CREATE TABLE USERSLIST (
--  cyclename			VARCHAR(250) 		DEFAULT NULL,
--  cycleid 			INT   				PRIMARY KEY,
--  frequency			INT 				DEFAULT NULL
--);
--
--INSERT INTO CYCLES (cycleid,cyclename, frequency) VALUES
--  (10002,'Co miesiac',1),
--  (10003,'Co pol roku',6),
--  (10004,'Co rok',12)
--  ;

DROP TABLE IF EXISTS USERSLIST;
CREATE TABLE USERSLIST (
  username			VARCHAR(250) 		DEFAULT NULL,
  usernameid 		INT   				PRIMARY KEY,
  password			VARCHAR(250) 		DEFAULT NULL,
  useremail			VARCHAR(250) 		DEFAULT NULL
);

INSERT INTO USERSLIST (usernameid,username,password,useremail) VALUES
  (10002,'dawid','haslo','dawid.miazga.90@gmail.com'),
  (10003,'dawid2','haslo','dawid.miazga.90@gmail.com'),
  (10004,'admin','admin','dawid.miazga.90@gmail.com')
  ;
  
DROP TABLE IF EXISTS CATEGORY;
CREATE TABLE CATEGORY (
  categoryname 		VARCHAR(250) 		DEFAULT NULL,
  categoryid 		INT   				PRIMARY KEY,
  usernameid 		INT 				DEFAULT NULL, foreign key (usernameid) references USERSLIST(usernameid),
  comment 			VARCHAR(250) 		DEFAULT NULL,
  hexcolor 			VARCHAR(250) 		DEFAULT NULL
);

INSERT INTO CATEGORY (categoryid, usernameid, categoryname,comment,hexcolor) VALUES
  (10001,10002,'Kredyty, raty, podatki','','#490009'),
  (10002,10002,'Spozywcze','','#0033FF'),
  (10003,10002,'Dom','Oplaty zwiazane z mieszkaniem, telefon','#27BEBE'),
  (10004,10002,'Edukacja i odziez','','#8B572A'),
  (10005,10002,'Hobby','Sprzet sportowy, silownia itp.','#417505'),
  (10007,10002,'Podroze','','#4A90E2'),
  (10008,10002,'Transport','Komunikacja miejska, paliwo itp.','#8ADD1D'),
  (10009,10002,'Rozrywka','Kino, Mecze, Restauracja, Netflix itp.','#0B440B'),
  (10010,10002,'Meblowy','','#5A3511'),
  (10011,10002,'Naprawy/Lekarz','Naprawy samochodu, apteka, wizyta u lekarza, dentysty itp.','#1B531B')
  ;

DROP TABLE IF EXISTS BUDGET;
CREATE TABLE BUDGET (
  budgetid 			INT AUTO_INCREMENT  PRIMARY KEY,
  usernameid 		INT					DEFAULT NULL, foreign key (usernameid) references USERSLIST(usernameid),
  target_month 		DATE 				DEFAULT NULL,
  amount 			DOUBLE				DEFAULT NULL,
  comment    		VARCHAR(250) 		DEFAULT NULL
);

INSERT INTO BUDGET (budgetid, usernameid, target_month, amount, comment) VALUES
  (10004,'10002','2021-11-22',3100,''),
  (10005,'10002','2021-12-22',3200,''),
  (10006,'10002','2022-01-22',5000,''),
  (10007,'10003','2022-01-22',5010,''),
  (10008,'10003','2022-02-22',5110,'')
  ; 
  
DROP TABLE IF EXISTS INCOME;
CREATE TABLE INCOME (
  incomeid 		INT AUTO_INCREMENT  PRIMARY KEY,
  usernameid 	INT 				DEFAULT NULL, foreign key (usernameid) references USERSLIST(usernameid),
  description 	VARCHAR(250) 		DEFAULT NULL,
  target_date 	DATE 				DEFAULT NULL,
  finish_date 	DATE 				DEFAULT NULL,
  amount 		DOUBLE				DEFAULT NULL,
  comment 		VARCHAR(250) 		DEFAULT NULL,
  cycle			VARCHAR(250)		DEFAULT NULL
);

INSERT INTO INCOME (incomeid, usernameid, description, target_date,finish_date,amount, comment,cycle) VALUES
(10001,10002,'Pensja','2021-11-01','2021-12-31',3200,'','Co miesiac'),
(10002,10002,'Sprzedaz ubran','2021-11-22','2021-11-22',372,'','Nie'),
(10003,10003,'Pensja Dawid','2021-01-01','2023-12-31',6300,'','Co miesiac'),
(10004,10002,'Bonus kwartalny','2021-12-22','2021-12-22',511,'','Nie'),
(10005,10002,'Pensja','2022-01-01','2022-01-31',5800,'','Co miesiac'),
(10006,10002,'Bonus kwartalny','2022-04-22','2022-04-22',1122,'','Nie'),
(10007,10003,'Sprzedaz ubran','2022-02-22','2022-02-22',372,'','Nie')
;  

DROP TABLE IF EXISTS EXPENSE;
CREATE TABLE EXPENSE (
  expenseid 		INT AUTO_INCREMENT  PRIMARY KEY,
  usernameid 		INT					DEFAULT NULL,  foreign key (usernameid) references USERSLIST(usernameid),
  description 		VARCHAR(250) 		DEFAULT NULL,
  target_date 		DATE 				DEFAULT NULL,
  finish_date 		DATE 				DEFAULT NULL,
  price 			DOUBLE				DEFAULT NULL,
  categoryid 		INT 				DEFAULT NULL, foreign key (categoryid) references CATEGORY(categoryid),
  comment 			VARCHAR(250) 		DEFAULT NULL,
  cycle				VARCHAR(250)		DEFAULT NULL
); 
    
INSERT INTO EXPENSE (expenseid, usernameid, description, target_date,finish_date,price, categoryid,comment,cycle) VALUES
(10001,10002,'Gitara','2022-01-31','2022-05-31',780,10005,'','Nie'),
(10002,10002,'Czynsz','2021-11-01','2021-12-31',500,10003,'','Co miesiac'),
(10003,10002,'Telefon','2021-11-01','2021-12-31',20,10003,'','Co miesiac'),
(10004,10002,'Netflix','2021-11-01','2021-12-31',18,10009,'','Co miesiac'),
(10005,10002,'Ubezpieczenie','2021-11-01','2021-12-31',108.75,10001,'','Co miesiac'),
(10006,10002,'Kredyt telefon','2021-11-01','2021-12-31',48.95,10001,'','Co miesiac'),
(10007,10002,'Media','2021-11-01','2022-12-31',480,10003,'Gaz','Co rok'),
(10008,10002,'Media','2021-11-01','2022-12-31',490,10003,'Prad','Co pol roku'),
(10009,10002,'Czynsz','2022-01-01','2022-01-31',510,10003,'','Co miesiac'),
(10010,10002,'Telefon','2022-01-01','2022-01-31',30,10003,'','Co miesiac'),
(10011,10002,'Netflix','2022-01-01','2022-01-31',18,10003,'','Co miesiac'),
(10012,10002,'Ubezpieczenie','2022-01-01','2022-01-31',110,10003,'','Co miesiac'),
(10013,10002,'Kredyt','2022-01-01','2022-01-31',25,10001,'','Co miesiac'),
(10014,10002,'netflix','2022-01-01','2022-01-31',15,10003,'','Co miesiac'),
(10017,10002,'Kredyt hipoteczny','2022-01-01','2022-01-01',1300,10001,'','Co miesiac'),
(10018,10002,'Wyjazd','2021-11-30','2021-11-30',28,10007,'','Nie'),
(10019,10002,'Stacja benzynowa','2021-11-11','2021-11-11',112.58,10008,'','Nie'),
(10020,10002,'Kawa','2021-11-24','2021-11-24',7.99,10009,'','Nie'),
(10021,10002,'Sklep','2021-11-12','2021-11-12',80.18,10002,'','Nie'),
(10022,10002,'Sklep','2021-11-05','2021-11-05',59.61,10002,'','Nie'),
(10023,10002,'Stacja benzynowa','2021-11-26','2021-11-26',61.99,10008,'','Nie'),
(10024,10002,'Sklep','2021-11-27','2021-11-27',4.5,10002,'','Nie'),
(10025,10002,'Sklep','2021-11-12','2021-11-12',5.5,10002,'','Nie'),
(10026,10002,'Sklep','2021-11-24','2021-11-24',2.8,10002,'','Nie'),
(10027,10002,'Sklep','2021-11-26','2021-11-26',9.89,10002,'','Nie'),
(10028,10002,'Sklep','2021-11-07','2021-11-07',1,10002,'','Nie'),
(10029,10002,'Buty','2021-11-03','2021-11-03',149.9,10004,'','Nie'),
(10030,10002,'Sklep','2021-11-06','2021-11-06',9.47,10002,'','Nie'),
(10031,10002,'Restauracja','2021-11-22','2021-11-22',30,10009,'','Nie'),
(10032,10002,'Sklep','2021-11-04','2021-11-04',15.25,10002,'','Nie'),
(10033,10002,'Sklep','2021-11-26','2021-11-26',122.58,10002,'','Nie'),
(10034,10002,'Restauracja','2021-11-30','2021-11-30',45.9,10009,'','Nie'),
(10035,10002,'Restauracja','2021-11-19','2021-11-19',13.5,10009,'','Nie'),
(10036,10002,'Sklep','2021-11-24','2021-11-24',8.2,10002,'','Nie'),
(10037,10002,'Restauracja','2021-11-23','2021-11-23',100,10009,'','Nie'),
(10038,10002,'Sklep','2021-11-20','2021-11-20',17.32,10002,'','Nie'),
(10039,10002,'Sklep','2021-11-12','2021-11-12',15,10002,'','Nie'),
(10040,10002,'Kebab','2021-11-18','2021-11-18',21,10002,'','Nie'),
(10041,10002,'Stacja benzynowa','2021-11-21','2021-11-21',100.36,10008,'','Nie'),
(10042,10002,'Sklep','2021-11-28','2021-11-28',124.66,10002,'','Nie'),
(10043,10002,'Sklep','2021-11-02','2021-11-02',63.97,10002,'','Nie'),
(10044,10002,'Sklep','2021-11-27','2021-11-27',89.96,10002,'','Nie'),
(10045,10002,'Sklep','2021-11-04','2021-11-04',48.75,10002,'','Nie'),
(10046,10002,'Sklep','2021-11-23','2021-11-23',10.58,10002,'','Nie'),
(10047,10002,'Ikea','2021-11-08','2021-11-08',137.92,10010,'','Nie'),
(10048,10002,'Stacja benzynowa','2021-11-20','2021-11-20',99.99,10008,'','Nie'),
(10049,10002,'Sklep','2021-11-30','2021-11-30',48.8,10002,'','Nie'),
(10050,10002,'Wycieczka','2021-11-08','2021-11-08',254,10007,'','Nie'),
(10051,10002,'Restauracja','2021-11-02','2021-11-02',140,10009,'','Nie'),
(10052,10002,'Ikea','2021-11-01','2021-11-01',199.46,10010,'','Nie'),
(10053,10002,'Vinted','2021-11-15','2021-11-15',136.8,10004,'','Nie'),
(10054,10002,'Sklep','2021-11-12','2021-11-12',116.75,10002,'','Nie'),
(10055,10002,'Sklep','2021-12-29','2021-12-29',22.85,10002,'','Nie'),
(10056,10002,'Restauracja','2021-12-29','2021-12-29',23,10009,'','Nie'),
(10057,10002,'Sklep','2021-12-03','2021-12-03',39,10002,'','Nie'),
(10058,10002,'Sklep','2021-12-02','2021-12-02',3.9,10002,'','Nie'),
(10059,10002,'Sklep','2021-12-06','2021-12-06',20.36,10002,'','Nie'),
(10060,10002,'Sklep','2021-12-16','2021-12-16',39,10002,'','Nie'),
(10061,10002,'Sklep','2021-12-27','2021-12-27',3.9,10002,'','Nie'),
(10062,10002,'Kurtka','2021-12-30','2021-12-30',410,10004,'','Nie'),
(10063,10002,'Sklep','2021-12-17','2021-12-17',155.56,10002,'','Nie'),
(10064,10002,'Sklep','2021-12-09','2021-12-09',4.8,10002,'','Nie'),
(10065,10002,'Sklep','2021-12-07','2021-12-07',106.89,10002,'','Nie'),
(10066,10002,'Sklep','2021-12-24','2021-12-24',61.79,10002,'','Nie'),
(10067,10002,'Sklep','2021-12-05','2021-12-05',13.37,10002,'','Nie'),
(10068,10002,'Stacja benzynowa','2021-12-23','2021-12-23',84.95,10008,'','Nie'),
(10069,10002,'Stacja benzynowa','2021-12-23','2021-12-23',100.27,10008,'','Nie'),
(10070,10002,'Sklep','2021-12-29','2021-12-29',83.42,10002,'','Nie'),
(10071,10002,'Sklep','2021-12-19','2021-12-19',16.99,10002,'','Nie'),
(10072,10002,'Klub','2021-12-31','2021-12-31',34,10009,'','Nie'),
(10073,10002,'Klub','2021-12-01','2021-12-01',13,10009,'','Nie'),
(10074,10002,'Klub','2021-12-28','2021-12-28',63,10009,'','Nie'),
(10075,10002,'Klub','2021-12-09','2021-12-09',30,10009,'','Nie'),
(10076,10002,'Stacja benzynowa','2021-12-21','2021-12-21',42,10008,'','Nie'),
(10077,10002,'Sklep','2021-12-11','2021-12-11',17.39,10002,'','Nie'),
(10078,10002,'Stacja benzynowa','2021-12-28','2021-12-28',99.99,10008,'','Nie'),
(10079,10002,'Sklep','2021-12-17','2021-12-17',67.92,10002,'','Nie'),
(10080,10002,'Pepco','2021-12-28','2021-12-28',90,10010,'','Nie'),
(10081,10002,'Restauracja','2021-12-10','2021-12-10',15,10009,'','Nie'),
(10082,10002,'Ikea','2021-12-20','2021-12-20',55.98,10010,'','Nie'),
(10083,10002,'Sklep','2021-12-04','2021-12-04',86.04,10002,'','Nie'),
(10084,10002,'Stacja benzynowa','2021-12-20','2021-12-20',5.98,10008,'','Nie'),
(10085,10002,'Sklep','2021-12-17','2021-12-17',67.5,10002,'','Nie'),
(10086,10002,'Decathlon','2021-12-22','2021-12-22',81.97,10004,'','Nie'),
(10087,10002,'Plecak','2021-12-18','2021-12-18',145.9,10004,'','Nie'),
(10088,10002,'Korki','2021-12-26','2021-12-26',100,10005,'','Nie'),
(10089,10002,'Sklep','2021-12-08','2021-12-08',14.94,10002,'','Nie'),
(10090,10002,'Sklep','2021-12-10','2021-12-10',20,10002,'','Nie'),
(10091,10002,'Restauracja','2021-12-06','2021-12-06',89,10009,'','Nie'),
(10092,10002,'Sklep','2021-12-07','2021-12-07',14.99,10002,'','Nie'),
(10093,10002,'Spodnie','2021-12-18','2021-12-18',139,10004,'','Nie'),
(10094,10002,'MPK','2021-12-27','2021-12-27',41.48,10008,'','Nie'),
(10095,10002,'Klub','2021-12-04','2021-12-04',8,10009,'','Nie'),
(10096,10002,'Klub','2021-12-07','2021-12-07',33,10009,'','Nie'),
(10097,10002,'Klub','2021-12-26','2021-12-26',60,10009,'','Nie'),
(10098,10002,'Sklep','2021-12-27','2021-12-27',39,10002,'','Nie'),
(10099,10002,'Sklep','2021-12-25','2021-12-25',3.5,10002,'','Nie'),
(10100,10002,'Rekawice','2022-01-12','2022-01-12',259,10005,'','Nie'),
(10101,10002,'Sklep','2022-01-31','2022-01-31',90,10002,'','Nie'),
(10102,10002,'Restauracja','2022-01-23','2022-01-23',20,10009,'','Nie'),
(10103,10002,'Sklep','2022-01-03','2022-01-03',50.3,10002,'','Nie'),
(10104,10002,'Sylwester','2022-01-27','2022-01-27',349,10009,'','Nie'),
(10105,10002,'Sklep','2022-01-08','2022-01-08',30.45,10002,'','Nie'),
(10106,10002,'Sklep','2022-01-03','2022-01-03',27,10002,'','Nie'),
(10107,10002,'Sklep','2022-01-29','2022-01-29',90.28,10002,'','Nie'),
(10108,10002,'MPK','2022-01-08','2022-01-08',20,10008,'','Nie'),
(10109,10002,'Sklep','2022-01-01','2022-01-01',7.79,10002,'','Nie'),
(10110,10002,'Apteka','2022-01-26','2022-01-26',16.88,10011,'','Nie'),
(10111,10002,'Stacja benzynowa','2022-01-14','2022-01-14',100.02,10008,'','Nie'),
(10112,10002,'Sklep','2022-01-21','2022-01-21',51.14,10002,'','Nie'),
(10113,10002,'Leroy Merlin','2022-01-04','2022-01-04',25.49,10010,'','Nie'),
(10114,10002,'Leroy Merlin','2022-01-13','2022-01-13',49.99,10010,'','Nie'),
(10115,10002,'Sklep','2022-01-13','2022-01-13',48.8,10002,'','Nie'),
(10116,10002,'Sklep','2022-01-15','2022-01-15',131.51,10002,'','Nie'),
(10117,10002,'Sklep','2022-01-09','2022-01-09',44.83,10002,'','Nie'),
(10118,10002,'Stacja benzynowa','2022-01-03','2022-01-03',99.85,10008,'','Nie'),
(10119,10002,'Apteka','2022-01-27','2022-01-27',24.95,10011,'','Nie'),
(10120,10002,'Sklep','2022-01-20','2022-01-20',21.92,10002,'','Nie'),
(10121,10002,'Stacja benzynowa','2022-01-28','2022-01-28',90.22,10008,'','Nie'),
(10122,10002,'Bus','2022-01-25','2022-01-25',30,10007,'','Nie'),
(10123,10002,'Sklep','2022-01-09','2022-01-09',15.33,10002,'','Nie'),
(10124,10002,'Bus','2022-01-06','2022-01-06',52.89,10007,'','Nie'),
(10125,10002,'Sklep','2022-01-23','2022-01-23',109.11,10002,'','Nie'),
(10126,10002,'Stacja benzynowa','2022-01-17','2022-01-17',199.58,10008,'','Nie'),
(10127,10002,'Mechanik','2022-01-16','2022-01-16',265,10011,'','Nie'),
(10128,10002,'Sklep','2022-01-28','2022-01-28',43.48,10002,'','Nie'),
(10129,10002,'Sklep','2022-01-16','2022-01-16',32.99,10002,'','Nie'),
(10130,10002,'Stacja benzynowa','2022-01-23','2022-01-23',143.52,10008,'','Nie'),
(10131,10002,'Kawa','2022-01-12','2022-01-12',8.99,10009,'','Nie'),
(10132,10002,'Sklep','2022-01-31','2022-01-31',3.58,10002,'','Nie'),
(10133,10002,'Sklep','2022-01-10','2022-01-10',5.59,10002,'','Nie'),
(10134,10002,'Sklep','2022-01-14','2022-01-14',28.11,10002,'','Nie')
;

DROP TABLE IF EXISTS BANKACCOUNT;
CREATE TABLE BANKACCOUNT (
  bankaccountname 	VARCHAR(250) 		DEFAULT NULL,
  bankaccountid 	INT   				PRIMARY KEY,
  usernameid 		INT 				DEFAULT NULL, foreign key (usernameid) references USERSLIST(usernameid),
  comment 			VARCHAR(250) 		DEFAULT NULL,
  percentage 			VARCHAR(250) 		DEFAULT NULL
);

INSERT INTO BANKACCOUNT (bankaccountid, usernameid, bankaccountname,comment,percentage) VALUES
  (10001,10002,'ING','',1),
  (10002,10002,'Revolut','',2),
  (10003,10002,'PKO','',0)
  ;