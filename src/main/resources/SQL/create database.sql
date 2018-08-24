-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema library
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema library
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `library` DEFAULT CHARACTER SET utf8 ;
USE `library` ;

-- -----------------------------------------------------
-- Table `library`.`Author`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library`.`Author` (
  `idAuthor` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `patronymic` VARCHAR(45) NULL,
  `surname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAuthor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library`.`User` (
  `idUser` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `patronymic` VARCHAR(45) NULL,
  `surname` VARCHAR(45) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `isLibrarian` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`idUser`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`Genre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library`.`Genre` (
  `idGenre` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idGenre`),
  UNIQUE INDEX `description_UNIQUE` (`description` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`Book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library`.`Book` (
  `idBook` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `idAuthor` INT NULL,
  `idGenre` INT NULL DEFAULT -1,
  PRIMARY KEY (`idBook`),
  INDEX `fk_Books_Authors1_idx` (`idAuthor` ASC),
  INDEX `fk_Book_Genre1_idx` (`idGenre` ASC),
  CONSTRAINT `fk_Books_Authors1`
    FOREIGN KEY (`idAuthor`)
    REFERENCES `library`.`Author` (`idAuthor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Book_Genre1`
    FOREIGN KEY (`idGenre`)
    REFERENCES `library`.`Genre` (`idGenre`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`Status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library`.`Status` (
  `idStatus` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idStatus`),
  UNIQUE INDEX `description_UNIQUE` (`description` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`BookRequest`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library`.`BookRequest` (
  `idBookRequest` INT NOT NULL AUTO_INCREMENT,
  `idReader` INT NOT NULL,
  `idBook` INT NOT NULL,
  `idStatus` INT NOT NULL DEFAULT 1,
  `idLibrarian` INT NULL,
  PRIMARY KEY (`idBookRequest`),
  INDEX `fk_BookRequest_Books1_idx` (`idBook` ASC),
  INDEX `fk_BookRequest_Status1_idx` (`idStatus` ASC),
  INDEX `fk_BookRequest_User1_idx` (`idReader` ASC),
  INDEX `fk_BookRequest_User2_idx` (`idLibrarian` ASC),
  CONSTRAINT `fk_BookRequest_Books1`
    FOREIGN KEY (`idBook`)
    REFERENCES `library`.`Book` (`idBook`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_BookRequest_Status1`
    FOREIGN KEY (`idStatus`)
    REFERENCES `library`.`Status` (`idStatus`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_BookRequest_User1`
    FOREIGN KEY (`idReader`)
    REFERENCES `library`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_BookRequest_User2`
    FOREIGN KEY (`idLibrarian`)
    REFERENCES `library`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `library`.`Author`
-- -----------------------------------------------------
START TRANSACTION;
USE `library`;
INSERT INTO `library`.`Author` (`idAuthor`, `name`, `patronymic`, `surname`) VALUES (DEFAULT, 'Александр', 'Сергеевич', 'Пушкин');
INSERT INTO `library`.`Author` (`idAuthor`, `name`, `patronymic`, `surname`) VALUES (DEFAULT, 'Лев', 'Николаевич', 'Толстой');
INSERT INTO `library`.`Author` (`idAuthor`, `name`, `patronymic`, `surname`) VALUES (DEFAULT, 'Федор', 'Михайлович', 'Достоевский');
INSERT INTO `library`.`Author` (`idAuthor`, `name`, `patronymic`, `surname`) VALUES (DEFAULT, 'Михаил', 'Афанасьевич', 'Булгаков');
INSERT INTO `library`.`Author` (`idAuthor`, `name`, `patronymic`, `surname`) VALUES (DEFAULT, 'Николай', 'Васильевич', 'Гоголь');
INSERT INTO `library`.`Author` (`idAuthor`, `name`, `patronymic`, `surname`) VALUES (DEFAULT, 'Жюль', NULL, 'Верн');
INSERT INTO `library`.`Author` (`idAuthor`, `name`, `patronymic`, `surname`) VALUES (DEFAULT, 'Артур', NULL, 'Конан Дойл');
INSERT INTO `library`.`Author` (`idAuthor`, `name`, `patronymic`, `surname`) VALUES (DEFAULT, 'Марк', NULL, 'Твен');
INSERT INTO `library`.`Author` (`idAuthor`, `name`, `patronymic`, `surname`) VALUES (DEFAULT, 'Джон', NULL, 'Толкин');
INSERT INTO `library`.`Author` (`idAuthor`, `name`, `patronymic`, `surname`) VALUES (DEFAULT, 'Гебрерт', NULL, 'Шилдт');
INSERT INTO `library`.`Author` (`idAuthor`, `name`, `patronymic`, `surname`) VALUES (DEFAULT, 'Агата', NULL, 'Кристи');
INSERT INTO `library`.`Author` (`idAuthor`, `name`, `patronymic`, `surname`) VALUES (-1, 'Неизвестен', '', '');

COMMIT;


-- -----------------------------------------------------
-- Data for table `library`.`User`
-- -----------------------------------------------------
START TRANSACTION;
USE `library`;
INSERT INTO `library`.`User` (`idUser`, `name`, `patronymic`, `surname`, `login`, `password`, `isLibrarian`) VALUES (DEFAULT, 'Иван', 'Иванович', 'Иванов', 'ivanov', 'ivan', DEFAULT);
INSERT INTO `library`.`User` (`idUser`, `name`, `patronymic`, `surname`, `login`, `password`, `isLibrarian`) VALUES (DEFAULT, 'Петр', 'Петрович', 'Петров', 'petrov', 'petr', DEFAULT);
INSERT INTO `library`.`User` (`idUser`, `name`, `patronymic`, `surname`, `login`, `password`, `isLibrarian`) VALUES (DEFAULT, 'Сидор', 'Сидорович', 'Сидоров', 'sidorov', 'sidor', DEFAULT);
INSERT INTO `library`.`User` (`idUser`, `name`, `patronymic`, `surname`, `login`, `password`, `isLibrarian`) VALUES (DEFAULT, 'Вася', '', 'Пупкин', 'pupkin', 'vasya', true);
INSERT INTO `library`.`User` (`idUser`, `name`, `patronymic`, `surname`, `login`, `password`, `isLibrarian`) VALUES (DEFAULT, 'Андрей', 'Андреевич', 'Андреев', 'andreev', 'andrey', DEFAULT);
INSERT INTO `library`.`User` (`idUser`, `name`, `patronymic`, `surname`, `login`, `password`, `isLibrarian`) VALUES (DEFAULT, 'Михаил', 'Михайлович', 'Михайлов', 'mikhailov', 'mikhail', DEFAULT);

COMMIT;


-- -----------------------------------------------------
-- Data for table `library`.`Genre`
-- -----------------------------------------------------
START TRANSACTION;
USE `library`;
INSERT INTO `library`.`Genre` (`idGenre`, `description`) VALUES (DEFAULT, 'классика');
INSERT INTO `library`.`Genre` (`idGenre`, `description`) VALUES (DEFAULT, 'фантастика');
INSERT INTO `library`.`Genre` (`idGenre`, `description`) VALUES (DEFAULT, 'детектив');
INSERT INTO `library`.`Genre` (`idGenre`, `description`) VALUES (DEFAULT, 'научная литература');
INSERT INTO `library`.`Genre` (`idGenre`, `description`) VALUES (DEFAULT, 'фэнтези');
INSERT INTO `library`.`Genre` (`idGenre`, `description`) VALUES (DEFAULT, 'исторический роман');
INSERT INTO `library`.`Genre` (`idGenre`, `description`) VALUES (DEFAULT, 'сказки');
INSERT INTO `library`.`Genre` (`idGenre`, `description`) VALUES (DEFAULT, 'юмор');
INSERT INTO `library`.`Genre` (`idGenre`, `description`) VALUES (DEFAULT, 'о еде');
INSERT INTO `library`.`Genre` (`idGenre`, `description`) VALUES (DEFAULT, 'руководство');
INSERT INTO `library`.`Genre` (`idGenre`, `description`) VALUES (DEFAULT, 'энциклопедия');
INSERT INTO `library`.`Genre` (`idGenre`, `description`) VALUES (DEFAULT, 'словарь');
INSERT INTO `library`.`Genre` (`idGenre`, `description`) VALUES (DEFAULT, 'ужасы');
INSERT INTO `library`.`Genre` (`idGenre`, `description`) VALUES (DEFAULT, 'справочник');
INSERT INTO `library`.`Genre` (`idGenre`, `description`) VALUES (-1, 'другое');

COMMIT;


-- -----------------------------------------------------
-- Data for table `library`.`Book`
-- -----------------------------------------------------
START TRANSACTION;
USE `library`;
INSERT INTO `library`.`Book` (`idBook`, `title`, `idAuthor`, `idGenre`) VALUES (DEFAULT, 'Хоббит', 9, -1);
INSERT INTO `library`.`Book` (`idBook`, `title`, `idAuthor`, `idGenre`) VALUES (DEFAULT, 'Евгений Онегин', 1, -1);
INSERT INTO `library`.`Book` (`idBook`, `title`, `idAuthor`, `idGenre`) VALUES (DEFAULT, 'Java 8', 10, -1);
INSERT INTO `library`.`Book` (`idBook`, `title`, `idAuthor`, `idGenre`) VALUES (DEFAULT, 'Война и Мир', 2, -1);
INSERT INTO `library`.`Book` (`idBook`, `title`, `idAuthor`, `idGenre`) VALUES (DEFAULT, 'Таинственный остров', 6, -1);
INSERT INTO `library`.`Book` (`idBook`, `title`, `idAuthor`, `idGenre`) VALUES (DEFAULT, '20 тысяч лье под водой', 6, -1);
INSERT INTO `library`.`Book` (`idBook`, `title`, `idAuthor`, `idGenre`) VALUES (DEFAULT, '10 негритят', 11, -1);
INSERT INTO `library`.`Book` (`idBook`, `title`, `idAuthor`, `idGenre`) VALUES (DEFAULT, 'Вий', 5, -1);
INSERT INTO `library`.`Book` (`idBook`, `title`, `idAuthor`, `idGenre`) VALUES (DEFAULT, 'Хоббит', 9, -1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `library`.`Status`
-- -----------------------------------------------------
START TRANSACTION;
USE `library`;
INSERT INTO `library`.`Status` (`idStatus`, `description`) VALUES (1, 'запрос');
INSERT INTO `library`.`Status` (`idStatus`, `description`) VALUES (DEFAULT, 'обработано');
INSERT INTO `library`.`Status` (`idStatus`, `description`) VALUES (DEFAULT, 'выдано');
INSERT INTO `library`.`Status` (`idStatus`, `description`) VALUES (DEFAULT, 'возврат');

COMMIT;


-- -----------------------------------------------------
-- Data for table `library`.`BookRequest`
-- -----------------------------------------------------
START TRANSACTION;
USE `library`;
INSERT INTO `library`.`BookRequest` (`idBookRequest`, `idReader`, `idBook`, `idStatus`, `idLibrarian`) VALUES (DEFAULT, 1, 1, 2, 1);
INSERT INTO `library`.`BookRequest` (`idBookRequest`, `idReader`, `idBook`, `idStatus`, `idLibrarian`) VALUES (DEFAULT, 1, 2, 1, NULL);
INSERT INTO `library`.`BookRequest` (`idBookRequest`, `idReader`, `idBook`, `idStatus`, `idLibrarian`) VALUES (DEFAULT, 2, 4, 1, NULL);
INSERT INTO `library`.`BookRequest` (`idBookRequest`, `idReader`, `idBook`, `idStatus`, `idLibrarian`) VALUES (DEFAULT, 4, 1, 3, 1);

COMMIT;

