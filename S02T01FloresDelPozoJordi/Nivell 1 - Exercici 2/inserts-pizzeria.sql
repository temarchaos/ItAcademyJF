USE pizzeria;

INSERT INTO `categories` VALUES (1, "pizzes"),(2, "hamburgueses"),(3,"begudes");

SELECT * FROM categories;

INSERT INTO `productes` VALUES (1,"Carbonara",null,null,15,1),
							   (2,"Double Cheese",null,null,8,2),
                               (3,"Agua 33cl",null,null,1.5,3);

SELECT * FROM productes;

INSERT INTO `clients` VALUES (1,"Simon","Flores Vicente","Therese Mill 79094",00720,"Hoover","Missouri",987654321),
							 (2,"Juana","Perez Molinero","Camila Isle 269",55470,"Jacksonville","Maryland",987654321),
                             (3,"Aina","Puente Sanchez","Gladyce Via 0124",84921,"West Des Moines","Utah",987654321);
                             
SELECT * FROM clients;

INSERT INTO `botigues` VALUES (1,"Curtis Cape 472",08069,"Bowie","New York"),
							  (2,"Cronin Spur 12828",18574,"Manchester","Vermont"),
                              (3,"Arthur Hill 697",39088,"Minot","Washington");

SELECT * FROM botigues;

INSERT INTO `empleats` VALUES (1,"Neus","Neira Gutierrez","12345678K",987654321,"cuiner/a",1),
							  (2,"Victor-Manuel","Tirado Morillas","12345678K",987654321,"repartidor/a",2),
                              (3,"Feliciana","Morillas Barros","12345678K",987654321,"repartidor/a",3);

SELECT * FROM empleats;

INSERT INTO `comandes` VALUES (1,now(),1,1,1,1,9.5),
							  (2,now(),0,2,2,2,15),
                              (3,now(),1,3,3,3,16.5);

SELECT * FROM comandes;

INSERT INTO `productes_has_comandes` VALUES (2,1,1),
											(3,1,1),
                                            (1,2,1),
                                            (1,3,1),
                                            (3,1,1);

SELECT * FROM productes_has_comandes;