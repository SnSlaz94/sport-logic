-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema sportlogic
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sportlogic
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sportlogic` DEFAULT CHARACTER SET utf8mb4 ;
USE `sportlogic` ;

-- -----------------------------------------------------
-- Table `sportlogic`.`personas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sportlogic`.`personas` (
  `id_persona` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NULL DEFAULT NULL,
  `apellido` VARCHAR(255) NULL DEFAULT NULL,
  `documento` VARCHAR(255) NULL DEFAULT NULL,
  `fecha_nacimiento` DATE NULL DEFAULT NULL,
  `telefono` VARCHAR(255) NULL DEFAULT NULL,
  `direccion` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_persona`),
  UNIQUE INDEX `documento` (`documento` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `sportlogic`.`directivos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sportlogic`.`directivos` (
  `id_directivo` INT(11) NOT NULL AUTO_INCREMENT,
  `id_persona` INT(11) NULL DEFAULT NULL,
  `cargo` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id_directivo`),
  INDEX `id_persona` (`id_persona` ASC),
  CONSTRAINT `directivos_ibfk_1`
    FOREIGN KEY (`id_persona`)
    REFERENCES `sportlogic`.`personas` (`id_persona`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `sportlogic`.`entrenadores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sportlogic`.`entrenadores` (
  `id_entrenador` INT(11) NOT NULL AUTO_INCREMENT,
  `id_persona` INT(11) NULL DEFAULT NULL,
  `licencia_entrenador` VARCHAR(50) NULL DEFAULT NULL,
  `experiencia_anios` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_entrenador`),
  INDEX `id_persona` (`id_persona` ASC),
  CONSTRAINT `entrenadores_ibfk_1`
    FOREIGN KEY (`id_persona`)
    REFERENCES `sportlogic`.`personas` (`id_persona`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `sportlogic`.`jugadores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sportlogic`.`jugadores` (
  `id_jugador` INT(11) NOT NULL AUTO_INCREMENT,
  `id_persona` INT(11) NULL DEFAULT NULL,
  `posicion_campo` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_jugador`),
  INDEX `id_persona` (`id_persona` ASC),
  CONSTRAINT `jugadores_ibfk_1`
    FOREIGN KEY (`id_persona`)
    REFERENCES `sportlogic`.`personas` (`id_persona`)
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `sportlogic`.`examenes_medicos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sportlogic`.`examenes_medicos` (
  `id_examen` INT(11) NOT NULL AUTO_INCREMENT,
  `id_jugador` INT(11) NULL DEFAULT NULL,
  `tipo_examen` VARCHAR(100) NULL DEFAULT NULL,
  `fecha_examen` DATE NULL DEFAULT NULL,
  `resultado` VARCHAR(255) NULL DEFAULT NULL,
  `observaciones` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_examen`),
  INDEX `id_jugador` (`id_jugador` ASC),
  CONSTRAINT `examenes_medicos_ibfk_1`
    FOREIGN KEY (`id_jugador`)
    REFERENCES `sportlogic`.`jugadores` (`id_jugador`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `sportlogic`.`medicos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sportlogic`.`medicos` (
  `id_medico` INT(11) NOT NULL AUTO_INCREMENT,
  `id_persona` INT(11) NULL DEFAULT NULL,
  `especialidad` VARCHAR(255) NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `nombre` VARCHAR(255) NULL DEFAULT NULL,
  `telefono` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_medico`),
  INDEX `id_persona` (`id_persona` ASC),
  CONSTRAINT `medicos_ibfk_1`
    FOREIGN KEY (`id_persona`)
    REFERENCES `sportlogic`.`personas` (`id_persona`)
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `sportlogic`.`fichas_medicas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sportlogic`.`fichas_medicas` (
  `id_ficha` INT(11) NOT NULL AUTO_INCREMENT,
  `fecha_revision` DATE NULL DEFAULT NULL,
  `historial_clinico` VARCHAR(1000) NULL DEFAULT NULL,
  `observaciones` VARCHAR(1000) NULL DEFAULT NULL,
  `id_jugador` INT(11) NULL DEFAULT NULL,
  `id_medico` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_ficha`),
  INDEX `FK1qf3sqtp03muqiccfryji8g0g` (`id_jugador` ASC),
  INDEX `FK7oiyqbytvxn7hdsdfdbmjnuah` (`id_medico` ASC),
  CONSTRAINT `FK1qf3sqtp03muqiccfryji8g0g`
    FOREIGN KEY (`id_jugador`)
    REFERENCES `sportlogic`.`jugadores` (`id_jugador`),
  CONSTRAINT `FK7oiyqbytvxn7hdsdfdbmjnuah`
    FOREIGN KEY (`id_medico`)
    REFERENCES `sportlogic`.`medicos` (`id_medico`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `sportlogic`.`horarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sportlogic`.`horarios` (
  `id_horario` INT(11) NOT NULL AUTO_INCREMENT,
  `dia_semana` VARCHAR(255) NULL DEFAULT NULL,
  `hora_inicio` TIME NULL DEFAULT NULL,
  `hora_fin` TIME NULL DEFAULT NULL,
  `lugar` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_horario`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `sportlogic`.`lesiones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sportlogic`.`lesiones` (
  `id_lesion` INT(11) NOT NULL AUTO_INCREMENT,
  `id_jugador` INT(11) NULL DEFAULT NULL,
  `tipo_lesion` VARCHAR(100) NULL DEFAULT NULL,
  `fecha_inicio` DATE NULL DEFAULT NULL,
  `estado` ENUM('Activa', 'Recuperada') NULL DEFAULT NULL,
  PRIMARY KEY (`id_lesion`),
  INDEX `id_jugador` (`id_jugador` ASC),
  CONSTRAINT `lesiones_ibfk_1`
    FOREIGN KEY (`id_jugador`)
    REFERENCES `sportlogic`.`jugadores` (`id_jugador`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `sportlogic`.`incapacidades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sportlogic`.`incapacidades` (
  `id_incapacidad` INT(11) NOT NULL AUTO_INCREMENT,
  `id_lesion` INT(11) NULL DEFAULT NULL,
  `fecha_inicio` DATE NULL DEFAULT NULL,
  `fecha_fin` DATE NULL DEFAULT NULL,
  `descripcion` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_incapacidad`),
  INDEX `id_lesion` (`id_lesion` ASC),
  CONSTRAINT `incapacidades_ibfk_1`
    FOREIGN KEY (`id_lesion`)
    REFERENCES `sportlogic`.`lesiones` (`id_lesion`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `sportlogic`.`sesiones_entrenamiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sportlogic`.`sesiones_entrenamiento` (
  `id_sesion` INT(11) NOT NULL AUTO_INCREMENT,
  `id_horario` INT(11) NULL DEFAULT NULL,
  `objetivo_sesion` VARCHAR(255) NULL DEFAULT NULL,
  `descripcion_actividades` VARCHAR(255) NULL DEFAULT NULL,
  `fecha` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id_sesion`),
  INDEX `id_horario` (`id_horario` ASC),
  CONSTRAINT `sesiones_entrenamiento_ibfk_1`
    FOREIGN KEY (`id_horario`)
    REFERENCES `sportlogic`.`horarios` (`id_horario`)
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `sportlogic`.`rendimiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sportlogic`.`rendimiento` (
  `id_rendimiento` INT(11) NOT NULL AUTO_INCREMENT,
  `id_jugador` INT(11) NULL DEFAULT NULL,
  `id_sesion` INT(11) NULL DEFAULT NULL,
  `calificacion` TINYINT(4) NULL DEFAULT NULL,
  `comentarios_tecnicos` VARCHAR(255) NULL DEFAULT NULL,
  `fecha_registro` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id_rendimiento`),
  INDEX `id_jugador` (`id_jugador` ASC),
  INDEX `id_sesion` (`id_sesion` ASC),
  CONSTRAINT `rendimiento_ibfk_1`
    FOREIGN KEY (`id_jugador`)
    REFERENCES `sportlogic`.`jugadores` (`id_jugador`)
    ON DELETE CASCADE,
  CONSTRAINT `rendimiento_ibfk_2`
    FOREIGN KEY (`id_sesion`)
    REFERENCES `sportlogic`.`sesiones_entrenamiento` (`id_sesion`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `sportlogic`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sportlogic`.`roles` (
  `id_rol` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_rol` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_rol`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `sportlogic`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sportlogic`.`usuarios` (
  `id_usuario` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `id_persona` INT(11) NULL DEFAULT NULL,
  `id_rol` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE INDEX `username` (`username` ASC),
  UNIQUE INDEX `email` (`email` ASC),
  INDEX `id_persona` (`id_persona` ASC),
  INDEX `id_rol` (`id_rol` ASC),
  CONSTRAINT `usuarios_ibfk_1`
    FOREIGN KEY (`id_persona`)
    REFERENCES `sportlogic`.`personas` (`id_persona`)
    ON DELETE CASCADE,
  CONSTRAINT `usuarios_ibfk_2`
    FOREIGN KEY (`id_rol`)
    REFERENCES `sportlogic`.`roles` (`id_rol`)
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 23
DEFAULT CHARACTER SET = utf8mb4;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
