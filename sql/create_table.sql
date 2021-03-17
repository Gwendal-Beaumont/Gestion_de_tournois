-- Création de la base de données
CREATE
    DATABASE tst CHARACTER SET utf8 COLLATE utf8_general_ci;

-- Création de l'utilisateur tst
CREATE
    USER 'tst'@'localhost' IDENTIFIED BY 'tst';

-- Authorisations
GRANT ALL PRIVILEGES ON tst.* TO
    'tst'@'localhost';

-- Création de la table des utilisateurs
CREATE TABLE tst.utilisateur
(
    id           int         NOT NULL AUTO_INCREMENT,
    username     varchar(20) NOT NULL,
    email        varchar(20) NOT NULL,
    password     varchar(20) NOT NULL,
    role_general int         NOT NULL DEFAULT 0,
    PRIMARY KEY (id)
);

-- Création de la table des sports
CREATE TABLE tst.sport
(
    id  int         NOT NULL AUTO_INCREMENT,
    nom varchar(50) NOT NULL,
    CONSTRAINT pkSport PRIMARY KEY (id)
);

-- Création de la table des équipes
CREATE TABLE tst.equipe
(
    id  int         NOT NULL AUTO_INCREMENT,
    nom varchar(50) NOT NULL,
    CONSTRAINT pkEquipe PRIMARY KEY (id)
);

-- Création de la table des tournois
CREATE TABLE tst.tournoi
(
    id           int         NOT NULL AUTO_INCREMENT,
    nom          varchar(50) NOT NULL,
    id_sport     int         NOT NULL,
    visibility   boolean     NOT NULL,
    date_debut   DATETIME    NOT NULL,
    proprietaire int         NOT NULL,
    CONSTRAINT pkTournoi PRIMARY KEY (id),
    CONSTRAINT fkSportTournoi FOREIGN KEY (id_sport) REFERENCES sport (id),
    CONSTRAINT fkTournoiProprietaire FOREIGN KEY (proprietaire) REFERENCES utilisateur (id)
);

-- Création de la table des matchs
CREATE TABLE tst.match
(
    id            int      NOT NULL AUTO_INCREMENT,
    id_tournoi    int      NOT NULL,
    date_match    DATETIME NOT NULL,
    equipe1       int      NOT NULL,
    equipe2       int      NOT NULL,
    score_equipe1 int      NOT NULL,
    score_equipe2 int      NOT NULL,
    CONSTRAINT pkMatch PRIMARY KEY (id),
    CONSTRAINT fkMatchTournoi FOREIGN KEY (id_tournoi) REFERENCES tournoi (id),
    CONSTRAINT fkMatchEquipe1 FOREIGN KEY (equipe1) REFERENCES equipe (id),
    CONSTRAINT fkMatchEquipe2 FOREIGN KEY (equipe2) REFERENCES equipe (id)
);

-- Création de la table d'association tournoi/équipe
CREATE TABLE tst.tournoi_equipe
(
    id_tournoi int NOT NULL,
    id_equipe  int NOT NULL,
    CONSTRAINT fkTournoi FOREIGN KEY (id_tournoi) REFERENCES tournoi (id),
    CONSTRAINT fkEquipe FOREIGN KEY (id_equipe) REFERENCES equipe (id)
);

-- Création de la table des administrateurs
CREATE TABLE tst.administrateur
(
    id_tournoi int NOT NULL,
    id_joueur  int NOT NULL,
    CONSTRAINT fkAdminTournoi FOREIGN KEY (id_tournoi) REFERENCES tournoi (id),
    CONSTRAINT fkAdminJoueur FOREIGN KEY (id_joueur) REFERENCES utilisateur (id)
);

-- Création de la table d'association utilisateur/équipe
CREATE TABLE tst.equipe_joueur
(
    id_equipe int NOT NULL,
    id_joueur int NOT NULL,
    role      int,
    CONSTRAINT fkEquipeEquipe FOREIGN KEY (id_equipe) REFERENCES equipe (id),
    CONSTRAINT fkEquipeJoueur FOREIGN KEY (id_joueur) REFERENCES utilisateur (id)
);

insert into tst.sport(nom)
values ('Acrosport');
insert into tst.sport(nom)
values ('Aerobic');
insert into tst.sport (nom)
values ('Aéromodélisme');
insert into tst.sport (nom)
values ('Aikido');
insert into tst.sport (nom)
values ('Airsoft');
insert into tst.sport (nom)
values ('Alpinisme');
insert into tst.sport (nom)
values ('Athlétisme');
insert into tst.sport (nom)
values ('Aviron');
insert into tst.sport (nom)
values ('Babyfoot');
insert into tst.sport (nom)
values ('Badminton');
insert into tst.sport (nom)
values ('Baseball');
insert into tst.sport (nom)
values ('Basketball');
insert into tst.sport (nom)
values ('Beach soccer');
insert into tst.sport (nom)
values ('Beach tennis');
insert into tst.sport (nom)
values ('Beach volley');
insert into tst.sport (nom)
values ('Billard');
insert into tst.sport (nom)
values ('Boxe');
insert into tst.sport (nom)
values ('Boxe anglaise');
insert into tst.sport (nom)
values ('Boxe chinoise');
insert into tst.sport (nom)
values ('Boxe française');
insert into tst.sport (nom)
values ('Boxe thaïlandaise');
insert into tst.sport (nom)
values ('Bras de fer');
insert into tst.sport (nom)
values ('Catch');
insert into tst.sport (nom)
values ('Combat');
insert into tst.sport (nom)
values ('Curling');
insert into tst.sport (nom)
values ('E-sport');
insert into tst.sport (nom)
values ('Echecs');
insert into tst.sport (nom)
values ('Enduro');
insert into tst.sport (nom)
values ('Escrime');
insert into tst.sport (nom)
values ('Extreme Football League');
insert into tst.sport (nom)
values ('Football');
insert into tst.sport (nom)
values ('Football américain');
insert into tst.sport (nom)
values ('Football australien');
insert into tst.sport (nom)
values ('Full contact');
insert into tst.sport (nom)
values ('Futsal');
insert into tst.sport (nom)
values ('Gymnastique');
insert into tst.sport (nom)
values ('Gymnastique artistique');
insert into tst.sport (nom)
values ('Gymnastique rythmique');
insert into tst.sport (nom)
values ('Haltérophilie');
insert into tst.sport (nom)
values ('Handball');
insert into tst.sport (nom)
values ('Handisport');
insert into tst.sport (nom)
values ('Hockey');
insert into tst.sport (nom)
values ('Hockey sur gazon');
insert into tst.sport (nom)
values ('Hockey sur glace');
insert into tst.sport (nom)
values ('Horse ball');
insert into tst.sport (nom)
values ('Ju-Jitsu');
insert into tst.sport (nom)
values ('Judo');
insert into tst.sport (nom)
values ('Karaté');
insert into tst.sport (nom)
values ('Karting');
insert into tst.sport (nom)
values ('Kick boxing');
insert into tst.sport (nom)
values ('Krav-maga');
insert into tst.sport (nom)
values ('Kung fu');
insert into tst.sport (nom)
values ('Lancer du javelot');
insert into tst.sport (nom)
values ('Lancer du marteau');
insert into tst.sport (nom)
values ('Lancer du poids');
insert into tst.sport (nom)
values ('Lutte');
insert into tst.sport (nom)
values ('Marche');
insert into tst.sport (nom)
values ('Marche nordique');
insert into tst.sport (nom)
values ('Monocycle');
insert into tst.sport (nom)
values ('Natation');
insert into tst.sport (nom)
values ('Natation synchronisée');
insert into tst.sport (nom)
values ('Paintball');
insert into tst.sport (nom)
values ('Patinage');
insert into tst.sport (nom)
values ('Patinage artistique');
insert into tst.sport (nom)
values ('Patinage de vitesse');
insert into tst.sport (nom)
values ('Pentathlon');
insert into tst.sport (nom)
values ('Pétanque');
insert into tst.sport (nom)
values ('Planche à voile');
insert into tst.sport (nom)
values ('Plongeon');
insert into tst.sport (nom)
values ('Rallycross');
insert into tst.sport (nom)
values ('Rugby');
insert into tst.sport (nom)
values ('Rugby subaquatique');
insert into tst.sport (nom)
values ('Saut à la perche');
insert into tst.sport (nom)
values ('Saut en longueur');
insert into tst.sport (nom)
values ('Ski acrobatique');
insert into tst.sport (nom)
values ('Ski alpin');
insert into tst.sport (nom)
values ('Ski de fond');
insert into tst.sport (nom)
values ('Skicross');
insert into tst.sport (nom)
values ('Snowboard');
insert into tst.sport (nom)
values ('Snowkite');
insert into tst.sport (nom)
values ('Softball');
insert into tst.sport (nom)
values ('Speed riding');
insert into tst.sport (nom)
values ('Squash');
insert into tst.sport (nom)
values ('Sumo');
insert into tst.sport (nom)
values ('Taekwondo');
insert into tst.sport (nom)
values ('Tennis');
insert into tst.sport (nom)
values ('Tennis de table');
insert into tst.sport (nom)
values ('Teqball');
insert into tst.sport (nom)
values ('Tir');
insert into tst.sport (nom)
values ('Trail');
insert into tst.sport (nom)
values ('Trampoline');
insert into tst.sport (nom)
values ('Triathlon');
insert into tst.sport (nom)
values ('ULM');
insert into tst.sport (nom)
values ('Ultimate');
insert into tst.sport (nom)
values ('Ultimate fresbee');
insert into tst.sport (nom)
values ('Volleyball');
insert into tst.sport (nom)
values ('Waterpolo');