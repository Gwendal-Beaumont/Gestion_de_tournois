-- Création de la base de données
CREATE DATABASE tst CHARACTER SET utf8 COLLATE utf8_general_ci;

-- Création de l'utilisateur tst
CREATE USER 'tst'@'localhost' IDENTIFIED BY 'tst';

-- Authorisations
GRANT ALL PRIVILEGES ON tst.* TO 'tst'@'localhost';

-- Création de la table des utilisateurs
CREATE TABLE tst.utilisateur (
                                 id int(11) NOT NULL AUTO_INCREMENT,
                                 nom varchar(20) NOT NULL,
                                 login varchar(20) NOT NULL,
                                 password varchar(20) NOT NULL,
                                 PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Création de la table des sports
CREATE TABLE tst.sport(
    id int(11) NOT NULL AUTO_INCREMENT,
    nom varchar(20) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Création de la table des tournois
CREATE TABLE tst.tournament(
    id int(11) NOT NULL AUTO_INCREMENT,
    nom varchar(30) NOT NULL,
    idSport int(11) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;