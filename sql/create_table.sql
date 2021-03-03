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
    role_general int         NOT NULL,
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

insert into sport (nom)
values ('Acrosport');
insert into sport (nom)
values ('Aerobic');
insert into sport (nom)
values ('Aéromodélisme');
insert into sport (nom)
values ('Aikido');
insert into sport (nom)
values ('Airsoft');
insert into sport (nom)
values ('Alpinisme');
insert into sport (nom)
values ('Athlétisme');
insert into sport (nom)
values ('Aviron');
insert into sport (nom)
values ('Babyfoot');
insert into sport (nom)
values ('Badminton');
insert into sport (nom)
values ('Baseball');
insert into sport (nom)
values ('Basketball');
insert into sport (nom)
values ('Beach soccer');
insert into sport (nom)
values ('Beach tennis');
insert into sport (nom)
values ('Beach volley');
insert into sport (nom)
values ('Billard');
insert into sport (nom)
values ('Boxe');
insert into sport (nom)
values ('Boxe anglaise');
insert into sport (nom)
values ('Boxe chinoise');
insert into sport (nom)
values ('Boxe française');
insert into sport (nom)
values ('Boxe thaïlandaise');
insert into sport (nom)
values ('Bras de fer');
insert into sport (nom)
values ('Catch');
insert into sport (nom)
values ('Combat');
insert into sport (nom)
values ('Curling');
insert into sport (nom)
values ('E-sport');
insert into sport (nom)
values ('Echecs');
insert into sport (nom)
values ('Enduro');
insert into sport (nom)
values ('Escrime');
insert into sport (nom)
values ('Extreme Football League');
insert into sport (nom)
values ('Football');
insert into sport (nom)
values ('Football américain');
insert into sport (nom)
values ('Football australien');
insert into sport (nom)
values ('Full contact');
insert into sport (nom)
values ('Futsal');
insert into sport (nom)
values ('Gymnastique');
insert into sport (nom)
values ('Gymnastique artistique');
insert into sport (nom)
values ('Gymnastique rythmique');
insert into sport (nom)
values ('Haltérophilie');
insert into sport (nom)
values ('Handball');
insert into sport (nom)
values ('Handisport');
insert into sport (nom)
values ('Hockey');
insert into sport (nom)
values ('Hockey sur gazon');
insert into sport (nom)
values ('Hockey sur glace');
insert into sport (nom)
values ('Horse ball');
insert into sport (nom)
values ('Ju-Jitsu');
insert into sport (nom)
values ('Judo');
insert into sport (nom)
values ('Karaté');
insert into sport (nom)
values ('Karting');
insert into sport (nom)
values ('Kick boxing');
insert into sport (nom)
values ('Krav-maga');
insert into sport (nom)
values ('Kung fu');
insert into sport (nom)
values ('Lancer du javelot');
insert into sport (nom)
values ('Lancer du marteau');
insert into sport (nom)
values ('Lancer du poids');
insert into sport (nom)
values ('Lutte');
insert into sport (nom)
values ('Marche');
insert into sport (nom)
values ('Marche nordique');
insert into sport (nom)
values ('Monocycle');
insert into sport (nom)
values ('Natation');
insert into sport (nom)
values ('Natation synchronisée');
insert into sport (nom)
values ('Paintball');
insert into sport (nom)
values ('Patinage');
insert into sport (nom)
values ('Patinage artistique');
insert into sport (nom)
values ('Patinage de vitesse');
insert into sport (nom)
values ('Pentathlon');
insert into sport (nom)
values ('Pétanque');
insert into sport (nom)
values ('Planche à voile');
insert into sport (nom)
values ('Plongeon');
insert into sport (nom)
values ('Rallycross');
insert into sport (nom)
values ('Rugby');
insert into sport (nom)
values ('Rugby subaquatique');
insert into sport (nom)
values ('Saut à la perche');
insert into sport (nom)
values ('Saut en longueur');
insert into sport (nom)
values ('Ski acrobatique');
insert into sport (nom)
values ('Ski alpin');
insert into sport (nom)
values ('Ski de fond');
insert into sport (nom)
values ('Skicross');
insert into sport (nom)
values ('Snowboard');
insert into sport (nom)
values ('Snowkite');
insert into sport (nom)
values ('Softball');
insert into sport (nom)
values ('Speed riding');
insert into sport (nom)
values ('Squash');
insert into sport (nom)
values ('Sumo');
insert into sport (nom)
values ('Taekwondo');
insert into sport (nom)
values ('Tennis');
insert into sport (nom)
values ('Tennis de table');
insert into sport (nom)
values ('Teqball');
insert into sport (nom)
values ('Tir');
insert into sport (nom)
values ("Tir à l'arc");
insert into sport (nom)
values ('Trail');
insert into sport (nom)
values ('Trampoline');
insert into sport (nom)
values ('Triathlon');
insert into sport (nom)
values ('ULM');
insert into sport (nom)
values ('Ultimate');
insert into sport (nom)
values ('Ultimate fresbee');
insert into sport (nom)
values ('Volleyball');
insert into sport (nom)
values ('Waterpolo');
