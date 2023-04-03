-- MySQL Workbench Synchronization
-- Generated: 2023-03-21 18:09
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: jordi

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `culdampolla` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin ;

CREATE TABLE IF NOT EXISTS `culdampolla`.`proveidors` (
  `idProveidor` INT(11) NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NOT NULL,
  `adreces_idAdreces` INT(11) NOT NULL,
  `telefon` INT(11) NOT NULL,
  `fax` VARCHAR(45) NOT NULL,
  `nif` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idProveidor`),
  INDEX `fk_proveidors_adreces1_idx` (`adreces_idAdreces` ASC) VISIBLE,
  CONSTRAINT `fk_proveidors_adreces1`
    FOREIGN KEY (`adreces_idAdreces`)
    REFERENCES `culdampolla`.`adreces` (`idAdreces`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_bin;

CREATE TABLE IF NOT EXISTS `culdampolla`.`clients` (
  `idClients` INT(11) NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NOT NULL,
  `codiPostal` INT(11) NOT NULL,
  `telefon` INT(11) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `dataRegistre` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `idClients_recomanat` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idClients`),
  INDEX `fk_clients_clients1_idx` (`idClients_recomanat` ASC) VISIBLE,
  CONSTRAINT `fk_clients_clients1_idx`
    FOREIGN KEY (`idClients_recomanat`)
    REFERENCES `culdampolla`.`clients` (`idClients`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_bin;

CREATE TABLE IF NOT EXISTS `culdampolla`.`ulleres` (
  `idUlleres` INT(11) NOT NULL AUTO_INCREMENT,
  `marca` VARCHAR(45) NOT NULL,
  `graduacioVE` DOUBLE NOT NULL,
  `graduacioVD` DOUBLE NOT NULL,
  `tipusMuntura` ENUM('flotant', 'pasta', 'metàllica') NOT NULL,
  `colorMuntura` VARCHAR(45) NOT NULL,
  `colorVE` VARCHAR(45) NOT NULL,
  `colorVD` VARCHAR(45) NOT NULL,
  `preu` DOUBLE NOT NULL,
  `proveidors_idProveidor` INT(11) NOT NULL,
  PRIMARY KEY (`idUlleres`, `proveidors_idProveidor`),
  INDEX `fk_ulleres_proveidors1_idx` (`proveidors_idProveidor` ASC) VISIBLE,
  CONSTRAINT `fk_ulleres_proveidors1`
    FOREIGN KEY (`proveidors_idProveidor`)
    REFERENCES `culdampolla`.`proveidors` (`idProveidor`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_bin;

CREATE TABLE IF NOT EXISTS `culdampolla`.`empleats` (
  `idEmpleats` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idEmpleats`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_bin;

CREATE TABLE IF NOT EXISTS `culdampolla`.`vendes` (
  `idVendes` INT(11) NOT NULL AUTO_INCREMENT,
  `empleats_idEmpleats` INT(11) NOT NULL,
  `clients_idClients` INT(11) NOT NULL,
  `dataVenda` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idVendes`, `empleats_idEmpleats`, `clients_idClients`),
  INDEX `fk_vendes_empleats1_idx` (`empleats_idEmpleats` ASC) VISIBLE,
  INDEX `fk_vendes_clients1_idx` (`clients_idClients` ASC) VISIBLE,
  CONSTRAINT `fk_vendes_empleats1`
    FOREIGN KEY (`empleats_idEmpleats`)
    REFERENCES `culdampolla`.`empleats` (`idEmpleats`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_vendes_clients1`
    FOREIGN KEY (`clients_idClients`)
    REFERENCES `culdampolla`.`clients` (`idClients`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_bin;

CREATE TABLE IF NOT EXISTS `culdampolla`.`adreces` (
  `idAdreces` INT(11) NOT NULL AUTO_INCREMENT,
  `carrer` VARCHAR(45) NOT NULL,
  `numero` INT(11) NULL DEFAULT NULL,
  `pis` INT(11) NULL DEFAULT NULL,
  `porta` INT(11) NULL DEFAULT NULL,
  `ciutat` VARCHAR(45) NOT NULL,
  `codiPostal` INT(11) NOT NULL,
  `pais` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAdreces`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_bin;

CREATE TABLE IF NOT EXISTS `culdampolla`.`factures` (
  `idFactures` INT(11) NOT NULL AUTO_INCREMENT,
  `ulleres_idUlleres` INT(11) NOT NULL,
  `ulleres_proveidors_idProveidor` INT(11) NOT NULL,
  `vendes_idVendes` INT(11) NOT NULL,
  `vendes_empleats_idEmpleats` INT(11) NOT NULL,
  `vendes_clients_idClients` INT(11) NOT NULL,
  PRIMARY KEY (`idFactures`, `ulleres_idUlleres`, `ulleres_proveidors_idProveidor`, `vendes_idVendes`, `vendes_empleats_idEmpleats`, `vendes_clients_idClients`),
  INDEX `fk_ulleres_has_vendes_vendes1_idx` (`vendes_idVendes` ASC, `vendes_empleats_idEmpleats` ASC, `vendes_clients_idClients` ASC) VISIBLE,
  INDEX `fk_ulleres_has_vendes_ulleres1_idx` (`ulleres_idUlleres` ASC, `ulleres_proveidors_idProveidor` ASC) VISIBLE,
  CONSTRAINT `fk_ulleres_has_vendes_ulleres1`
    FOREIGN KEY (`ulleres_idUlleres` , `ulleres_proveidors_idProveidor`)
    REFERENCES `culdampolla`.`ulleres` (`idUlleres` , `proveidors_idProveidor`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_ulleres_has_vendes_vendes1`
    FOREIGN KEY (`vendes_idVendes` , `vendes_empleats_idEmpleats` , `vendes_clients_idClients`)
    REFERENCES `culdampolla`.`vendes` (`idVendes` , `empleats_idEmpleats` , `clients_idClients`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_bin;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
