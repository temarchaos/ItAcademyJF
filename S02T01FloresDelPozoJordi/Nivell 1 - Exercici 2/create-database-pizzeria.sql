-- MySQL Workbench Synchronization
-- Generated: 2023-03-29 15:05
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: jordi

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `pizzeria` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `pizzeria`.`clients` (
  `idClients` INT(11) NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NOT NULL,
  `cognoms` VARCHAR(45) NOT NULL,
  `adreça` VARCHAR(45) NOT NULL,
  `codiPostal` INT(11) NOT NULL,
  `localitat` VARCHAR(45) NOT NULL,
  `provincia` VARCHAR(45) NOT NULL,
  `telefon` INT(11) NOT NULL,
  PRIMARY KEY (`idClients`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `pizzeria`.`comandes` (
  `idComandes` INT(11) NOT NULL AUTO_INCREMENT,
  `dataHora` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `domicili` TINYINT(1) NOT NULL,
  `clients_idClients` INT(11) NOT NULL,
  `empleats_idEmpleats` INT(11) NOT NULL,
  `empleats_botigues_idBotigues` INT(11) NOT NULL,
  `preuTotal` DOUBLE NOT NULL,
  PRIMARY KEY (`idComandes`, `clients_idClients`, `empleats_idEmpleats`, `empleats_botigues_idBotigues`),
  INDEX `fk_comandes_clients_idx` (`clients_idClients` ASC) VISIBLE,
  INDEX `fk_comandes_empleats1_idx` (`empleats_idEmpleats` ASC, `empleats_botigues_idBotigues` ASC) VISIBLE,
  CONSTRAINT `fk_comandes_clients`
    FOREIGN KEY (`clients_idClients`)
    REFERENCES `pizzeria`.`clients` (`idClients`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_comandes_empleats1`
    FOREIGN KEY (`empleats_idEmpleats` , `empleats_botigues_idBotigues`)
    REFERENCES `pizzeria`.`empleats` (`idEmpleats` , `botigues_idBotigues`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `pizzeria`.`productes` (
  `idProductes` INT(11) NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NOT NULL,
  `descripcio` VARCHAR(45) NULL DEFAULT NULL,
  `imatge` VARCHAR(45) NULL DEFAULT NULL,
  `preu` DOUBLE NOT NULL,
  `categories_idCategories` INT(11) NOT NULL,
  PRIMARY KEY (`idProductes`, `categories_idCategories`),
  INDEX `fk_productes_categories1_idx` (`categories_idCategories` ASC) VISIBLE,
  CONSTRAINT `fk_productes_categories1`
    FOREIGN KEY (`categories_idCategories`)
    REFERENCES `pizzeria`.`categories` (`idCategories`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `pizzeria`.`categories` (
  `idCategories` INT(11) NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCategories`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `pizzeria`.`botigues` (
  `idBotigues` INT(11) NOT NULL AUTO_INCREMENT,
  `adreça` VARCHAR(45) NOT NULL,
  `codiPostal` INT(11) NOT NULL,
  `localitat` VARCHAR(45) NOT NULL,
  `provincia` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idBotigues`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `pizzeria`.`empleats` (
  `idEmpleats` INT(11) NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NOT NULL,
  `cognoms` VARCHAR(45) NOT NULL,
  `nif` VARCHAR(45) NOT NULL,
  `telefon` INT(11) NOT NULL,
  `funcio` ENUM('cuiner/a', 'repartidor/a') NOT NULL,
  `botigues_idBotigues` INT(11) NOT NULL,
  PRIMARY KEY (`idEmpleats`, `botigues_idBotigues`),
  INDEX `fk_empleats_botigues1_idx` (`botigues_idBotigues` ASC) VISIBLE,
  CONSTRAINT `fk_empleats_botigues1`
    FOREIGN KEY (`botigues_idBotigues`)
    REFERENCES `pizzeria`.`botigues` (`idBotigues`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `pizzeria`.`productes_has_comandes` (
  `productes_idProductes` INT(11) NOT NULL,
  `productes_categories_idCategories` INT(11) NOT NULL,
  `comandes_idComandes` INT(11) NOT NULL,
  `comandes_clients_idClients` INT(11) NOT NULL,
  `comandes_empleats_idEmpleats` INT(11) NOT NULL,
  `comandes_empleats_botigues_idBotigues` INT(11) NOT NULL,
  PRIMARY KEY (`productes_idProductes`, `productes_categories_idCategories`, `comandes_idComandes`, `comandes_clients_idClients`, `comandes_empleats_idEmpleats`, `comandes_empleats_botigues_idBotigues`),
  INDEX `fk_productes_has_comandes_comandes1_idx` (`comandes_idComandes` ASC, `comandes_clients_idClients` ASC, `comandes_empleats_idEmpleats` ASC, `comandes_empleats_botigues_idBotigues` ASC) VISIBLE,
  INDEX `fk_productes_has_comandes_productes1_idx` (`productes_idProductes` ASC, `productes_categories_idCategories` ASC) VISIBLE,
  CONSTRAINT `fk_productes_has_comandes_productes1`
    FOREIGN KEY (`productes_idProductes` , `productes_categories_idCategories`)
    REFERENCES `pizzeria`.`productes` (`idProductes` , `categories_idCategories`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_productes_has_comandes_comandes1`
    FOREIGN KEY (`comandes_idComandes` , `comandes_clients_idClients` , `comandes_empleats_idEmpleats` , `comandes_empleats_botigues_idBotigues`)
    REFERENCES `pizzeria`.`comandes` (`idComandes` , `clients_idClients` , `empleats_idEmpleats` , `empleats_botigues_idBotigues`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
