USE culdampolla;

INSERT INTO `adreces` VALUES (1,'Eladio Isle',400,null,null,'Washington',13163,'Sri Lanka');
INSERT INTO `adreces` VALUES (2,'Shanon Route',26708,null,null,'Overland Park',29550,'Dominican Republic');
INSERT INTO `adreces` VALUES (3,'Taya Meadow',033,null,null,'Gilbert',94242,'Georgia');

SELECT * FROM adreces;

INSERT INTO `proveidors` VALUES (1,'LUNETTES',1,123456789,234567890,'H09991159');
INSERT INTO `proveidors` VALUES (2,'OPTIK',2,987654321,125634789,'F19480771');
INSERT INTO `proveidors` VALUES (3,'VISIO',3,192837465,908979695,'A99369142');

SELECT * FROM proveidors;

INSERT INTO `ulleres` VALUES (1,'Boss',2.00,2.00,'flotant','Verda','Blau','Blau',49.00,1);
INSERT INTO `ulleres` VALUES (2,'Siroko',-2.00,-2.00,'pasta','Lila','Blau','Blau',35.00,2);
INSERT INTO `ulleres` VALUES (3,'Tous',4.00,4.00,'metàllica','Negra','Blau','Blau',59.00,3);

SELECT * FROM ulleres;

INSERT INTO `empleats` VALUES (1);
INSERT INTO `empleats` VALUES (2);
INSERT INTO `empleats` VALUES (3);

SELECT * FROM empleats;

INSERT INTO `clients` VALUES (1,'Pepe',06933,123456789,'pepe@hotmail.com',now());
INSERT INTO `clients` VALUES (2,'Jordi',16341,987654321,'jordi@gmail.com',now());
INSERT INTO `clients` VALUES (3,'Toni',65725,987659493,'toni@gmail.com',now());

SELECT * FROM clients;

INSERT INTO `vendes` VALUES (1,1,1,now());
INSERT INTO `vendes` VALUES (2,2,2,now());
INSERT INTO `vendes` VALUES (3,3,3,now());

SELECT * FROM vendes;

INSERT INTO `factures` VALUES (1,1,1,1,1,1,now());
INSERT INTO `factures` VALUES (2,2,2,2,2,2,now());
INSERT INTO `factures` VALUES (2,3,3,3,3,3,now());

SELECT * FROM factures;