-- Script de création de la base de données ParcInformatique
CREATE DATABASE IF NOT EXISTS parc_informatique CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE parc_informatique;

-- Table Materiel
CREATE TABLE IF NOT EXISTS materiel (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    ref VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    marque VARCHAR(255) NOT NULL,
    etat VARCHAR(50) NOT NULL,
    date_achat DATE NOT NULL
);

-- Table Employe
CREATE TABLE IF NOT EXISTS employe (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    service VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

-- Table Affectation
CREATE TABLE IF NOT EXISTS affectation (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    date_debut DATE NOT NULL,
    date_fin DATE,
    statut VARCHAR(50) NOT NULL,
    materiel_id BIGINT,
    employe_id BIGINT,
    FOREIGN KEY (materiel_id) REFERENCES materiel(id) ON DELETE CASCADE,
    FOREIGN KEY (employe_id) REFERENCES employe(id) ON DELETE CASCADE
);

-- Quelques données de test (optionnel)
-- INSERT INTO materiel (ref, type, marque, etat, date_achat) VALUES ('PC001', 'PC', 'Dell', 'OK', '2023-05-10');
-- INSERT INTO employe (nom, service, email) VALUES ('Ahmed Alami', 'Informatique', 'ahmed@example.com');
