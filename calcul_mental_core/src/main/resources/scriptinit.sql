DROP TABLE calcul_mental.utilisateur;
CREATE TABLE calcul_mental.utilisateur(id INTEGER PRIMARY KEY NOT NULL, nom VARCHAR(255) UNIQUE NOT NULL , maxlvl INTEGER, maxscore INTEGER);
INSERT INTO calcul_mental.utilisateur(id, nom, maxlvl, maxscore) VALUES (1, 'player1', 2, 6);