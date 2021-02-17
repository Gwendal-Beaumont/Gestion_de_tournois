-- Création de la base de données
CREATE DATABASE tst CHARACTER SET utf8 COLLATE utf8_general_ci;

-- Création de l'utilisateur tst
CREATE USER 'tst'@'localhost' IDENTIFIED BY 'tst';

-- Authorisations
GRANT ALL PRIVILEGES ON tst.* TO 'tst'@'localhost';

-- Création de la table des utilisateurs
CREATE TABLE tst.utilisateur (
                                 id int NOT NULL AUTO_INCREMENT,
                                 nom varchar(20) NOT NULL,
                                 login varchar(20) NOT NULL,
                                 password varchar(20) NOT NULL,
                                 PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Rajout du rôle général, changement du nom en username et du login en email pour l'utilisateur
ALTER TABLE tst.utilisateur ADD (role_general int DEFAULT 0);
ALTER TABLE tst.utilisateur CHANGE nom username varchar(20);
ALTER TABLE tst.utilisateur CHANGE login email varchar(20);

-- REVERT
ALTER TABLE tst.utilisateur CHANGE username nom varchar(20);
ALTER TABLE tst.utilisateur CHANGE email login varchar(20);

-- Création de la table des sports
CREATE TABLE tst.sport(
    id int NOT NULL AUTO_INCREMENT,
    nom varchar(20) NOT NULL,
    CONSTRAINT pkSport PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Création de la table des équipes
CREATE TABLE tst.equipe(
    id int NOT NULL AUTO_INCREMENT,
    nom varchar(20) NOT NULL,
    CONSTRAINT pkEquipe PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Création de la table des tournois
CREATE TABLE tst.tournoi(
    id int NOT NULL AUTO_INCREMENT,
    nom varchar(30) NOT NULL,
    id_sport int NOT NULL,
    visibility boolean NOT NULL,
    date_debut DATETIME NOT NULL,
    proprietaire int NOT NULL,
    CONSTRAINT pkTournoi PRIMARY KEY (id),
    CONSTRAINT fkSportTournoi FOREIGN KEY (id_sport) REFERENCES sport(id),
    CONSTRAINT fkTournoiProprietaire FOREIGN KEY (proprietaire) REFERENCES utilisateur(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Création de la table des matchs
CREATE TABLE tst.match(
    id int NOT NULL AUTO_INCREMENT,
    id_tournoi int NOT NULL,
    date_match DATETIME NOT NULL,
    equipe1 int NOT NULL,
    equipe2 int NOT NULL,
    score_equipe1 int NOT NULL,
    score_equipe2 int NOT NULL,
    CONSTRAINT pkMatch PRIMARY KEY (id),
    CONSTRAINT fkMatchTournoi FOREIGN KEY (id_tournoi) REFERENCES tournoi(id),
    CONSTRAINT fkMatchEquipe1 FOREIGN KEY (equipe1) REFERENCES equipe(id),
    CONSTRAINT fkMatchEquipe2 FOREIGN KEY (equipe2) REFERENCES equipe(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Création de la table d'association tournoi/équipe
CREATE TABLE tst.tournoi_equipe(
    id_tournoi int NOT NULL,
    id_equipe int NOT NULL,
    CONSTRAINT fkTournoi FOREIGN KEY (id_tournoi) REFERENCES tournoi(id),
    CONSTRAINT fkEquipe FOREIGN KEY (id_equipe) REFERENCES equipe(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Création de la table des administrateurs
CREATE TABLE tst.administrateur(
    id_tournoi int NOT NULL,
    id_joueur int NOT NULL,
    CONSTRAINT fkAdminTournoi FOREIGN KEY (id_tournoi) REFERENCES tournoi(id),
    CONSTRAINT fkAdminJoueur FOREIGN KEY (id_joueur) REFERENCES utilisateur(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Création de la table d'association utilisateur/équipe
CREATE TABLE tst.equipe_utilisateur(
    id_equipe int NOT NULL,
    id_joueur int NOT NULL,
    CONSTRAINT fkEquipeEquipe FOREIGN KEY (id_equipe) REFERENCES equipe(id),
    CONSTRAINT fkEquipeJoueur FOREIGN KEY (id_joueur) REFERENCES utilisateur(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
