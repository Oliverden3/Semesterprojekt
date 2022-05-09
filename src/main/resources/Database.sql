-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Orders` (
                                               `idOrders` INT NOT NULL AUTO_INCREMENT,
                                               `idCarport` INT NOT NULL,
                                               `Date` DATE NOT NULL,
                                               `fk_idUser` INT NOT NULL,
                                               `idPartslist` INT NULL,
                                               PRIMARY KEY (`idOrders`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`User` (
                                             `idUser` INT NOT NULL AUTO_INCREMENT,
                                             `fk_idOrders` INT NOT NULL,
                                             `Balance` INT NULL,
                                             `Username` VARCHAR(45) NULL,
    `Password` VARCHAR(45) NULL,
    `role` VARCHAR(45) NULL,
    PRIMARY KEY (`idUser`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Carport`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Carport` (
                                                `idCarport` INT NOT NULL AUTO_INCREMENT,
                                                `Width` INT NOT NULL,
                                                `Length` INT NOT NULL,
                                                `Price` INT NOT NULL,
                                                `Height` INT NOT NULL,
                                                `idRoof` INT NOT NULL,
                                                `idToolshed` INT NULL,
                                                `carportType` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`idCarport`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Roof`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Roof` (
                                             `idRoof` INT NOT NULL AUTO_INCREMENT,
                                             `roofType` VARCHAR(45) NOT NULL,
    `roofTilt` INT NULL,
    PRIMARY KEY (`idRoof`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Toolshed`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Toolshed` (
                                                 `idToolshed` INT NOT NULL AUTO_INCREMENT,
                                                 `TSwidth` INT NOT NULL,
                                                 `TSLength` INT NOT NULL,
                                                 PRIMARY KEY (`idToolshed`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Partslist`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Partslist` (
                                                  `idPartslist` INT NOT NULL AUTO_INCREMENT,
                                                  `Materials` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`idPartslist`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Lager`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Lager` (
                                              `idLager` INT NOT NULL,
                                              PRIMARY KEY (`idLager`))
    ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
