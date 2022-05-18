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
-- Table `mydb`.`carport`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`carport` (
                                                `idCarport` INT NOT NULL AUTO_INCREMENT,
                                                `Width` INT NOT NULL,
                                                `Length` INT NOT NULL,
                                                `Price` INT NOT NULL,
                                                `Height` INT NOT NULL,
                                                `idRoof` INT NOT NULL,
                                                `idToolshed` INT NULL DEFAULT NULL,
                                                `carportType` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`idCarport`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 2
    DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`lager`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`lager` (
                                              `idLager` INT NOT NULL,
                                              PRIMARY KEY (`idLager`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`orders` (
                                               `idOrders` INT NOT NULL AUTO_INCREMENT,
                                               `idCarport` INT NOT NULL,
                                               `Date` DATE NOT NULL,
                                               `fk_idUser` INT NOT NULL,
                                               `idPartslist` INT NULL DEFAULT NULL,
                                               PRIMARY KEY (`idOrders`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`partslist`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`partslist` (
                                                  `idPartslist` INT NOT NULL AUTO_INCREMENT,
                                                  `Materials` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`idPartslist`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`roof`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`roof` (
                                             `idRoof` INT NOT NULL AUTO_INCREMENT,
                                             `roofType` VARCHAR(45) NOT NULL,
    `roofTilt` INT NULL DEFAULT NULL,
    PRIMARY KEY (`idRoof`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 2
    DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`toolshed`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`toolshed` (
                                                 `idToolshed` INT NOT NULL AUTO_INCREMENT,
                                                 `TSwidth` INT NOT NULL,
                                                 `TSLength` INT NOT NULL,
                                                 PRIMARY KEY (`idToolshed`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 3
    DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user` (
                                             `user_id` INT NOT NULL AUTO_INCREMENT,
                                             `username` VARCHAR(45) NOT NULL,
    `password` VARCHAR(45) NOT NULL,
    `email` VARCHAR(45) NOT NULL,
    `role` VARCHAR(45) NOT NULL DEFAULT 'customer',
    `balance` INT NOT NULL DEFAULT '500',
    PRIMARY KEY (`user_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
