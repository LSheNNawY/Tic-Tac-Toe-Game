-- MySQL Script generated by MySQL Workbench
-- Sat 27 Feb 2021 07:57:14 PM EET
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema tic_tac_toe
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tic_tac_toe
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tic_tac_toe` DEFAULT CHARACTER SET utf8mb4 ;
USE `tic_tac_toe` ;

-- -----------------------------------------------------
-- Table `tic_tac_toe`.`players`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tic_tac_toe`.`players` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `score` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `tic_tac_toe`.`games`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tic_tac_toe`.`games` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `player_1` INT(11) NOT NULL,
  `player_2` INT(11) NOT NULL,
  `winner` INT(11) NULL DEFAULT NULL,
  `status` ENUM('win', 'tie', 'abort') NOT NULL DEFAULT 'abort',
  `date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  PRIMARY KEY (`id`),
  INDEX `g_playe_1_fk_idx` (`player_1` ASC) VISIBLE,
  INDEX `g_play_2_fk_idx` (`player_2` ASC) VISIBLE,
  INDEX `g_winner_fk_idx` (`winner` ASC) VISIBLE,
  CONSTRAINT `g_play_2_fk`
    FOREIGN KEY (`player_2`)
    REFERENCES `tic_tac_toe`.`players` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `g_playe_1_fk`
    FOREIGN KEY (`player_1`)
    REFERENCES `tic_tac_toe`.`players` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `g_winner_fk`
    FOREIGN KEY (`winner`)
    REFERENCES `tic_tac_toe`.`players` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `tic_tac_toe`.`moves`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tic_tac_toe`.`moves` (
  `id` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `tic_tac_toe`.`game_moves`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tic_tac_toe`.`game_moves` (
  `game_id` INT(11) NOT NULL,
  `player_id` INT(11) NOT NULL,
  `move_id` INT(11) NOT NULL,
  PRIMARY KEY (`game_id`, `player_id`, `move_id`),
  INDEX `gm_player_fk_idx` (`player_id` ASC) VISIBLE,
  INDEX `gm_move_fk_idx` (`move_id` ASC) VISIBLE,
  CONSTRAINT `gm_game_fk`
    FOREIGN KEY (`game_id`)
    REFERENCES `tic_tac_toe`.`games` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `gm_move_fk`
    FOREIGN KEY (`move_id`)
    REFERENCES `tic_tac_toe`.`moves` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `gm_player_fk`
    FOREIGN KEY (`player_id`)
    REFERENCES `tic_tac_toe`.`players` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;