
-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Ven 19 Août 2016 à 17:35
-- Version du serveur: 5.5.24-log
-- Version de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `memoiregdc`
--

-- --------------------------------------------------------

--
-- Structure de la table `administrateur`
--

CREATE TABLE IF NOT EXISTS `administrateur` (
  `username` varchar(150) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `avoirquestion`
--

CREATE TABLE IF NOT EXISTS `avoirquestion` (
  `idFicheTest` int(11) NOT NULL,
  `idQuestion` int(11) NOT NULL,
  PRIMARY KEY (`idFicheTest`,`idQuestion`),
  KEY `FK_EST_POSEE` (`idQuestion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `avoirreponse`
--

CREATE TABLE IF NOT EXISTS `avoirreponse` (
  `idReponse` int(11) NOT NULL,
  `idQuestion` int(11) NOT NULL,
  PRIMARY KEY (`idReponse`,`idQuestion`),
  KEY `FK_A` (`idQuestion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `bdd`
--

CREATE TABLE IF NOT EXISTS `bdd` (
  `idTypeDeProfil` int(11) NOT NULL,
  `domaine` varchar(254) NOT NULL DEFAULT '',
  `niveau` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`idTypeDeProfil`,`domaine`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `bdd`
--

INSERT INTO `bdd` (`idTypeDeProfil`, `domaine`, `niveau`) VALUES
(32, 'domaine1', NULL),
(34, 'SQL server', NULL),
(39, 'Oracle', NULL),
(39, 'SQL server', NULL),
(40, 'Oracle', NULL),
(40, 'SQL server', NULL),
(43, 'Oracle', NULL),
(43, 'SQL server', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `candidat`
--

CREATE TABLE IF NOT EXISTS `candidat` (
  `username` varchar(150) NOT NULL,
  `idTypeDeProfil` int(11) NOT NULL,
  PRIMARY KEY (`username`),
  KEY `FK_association1` (`idTypeDeProfil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `candidat`
--

INSERT INTO `candidat` (`username`, `idTypeDeProfil`) VALUES
('doudou6', 32),
('doudou8', 34),
('Abdoulaye', 39),
('username1', 40),
('username3', 43);

-- --------------------------------------------------------

--
-- Structure de la table `cherchercandidat`
--

CREATE TABLE IF NOT EXISTS `cherchercandidat` (
  `Rec_username` varchar(150) NOT NULL,
  `username` varchar(150) NOT NULL,
  PRIMARY KEY (`Rec_username`,`username`),
  KEY `FK_chercherCandidat` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `consulternotification`
--

CREATE TABLE IF NOT EXISTS `consulternotification` (
  `username` varchar(150) NOT NULL,
  `idNotification` int(11) NOT NULL,
  PRIMARY KEY (`username`,`idNotification`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `contactercandidat`
--

CREATE TABLE IF NOT EXISTS `contactercandidat` (
  `Rec_username` varchar(150) NOT NULL,
  `username` varchar(150) NOT NULL,
  PRIMARY KEY (`Rec_username`,`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `entretien`
--

CREATE TABLE IF NOT EXISTS `entretien` (
  `idEntretien` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(150) NOT NULL,
  `typeEntretien` varchar(254) DEFAULT NULL,
  `dateDebEntreti` datetime DEFAULT NULL,
  `ateFinEntreti` datetime DEFAULT NULL,
  `resultat` bigint(20) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEntretien`),
  KEY `FK_fixerEntretien` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `experiencesprofessionnelles`
--

CREATE TABLE IF NOT EXISTS `experiencesprofessionnelles` (
  `idTypeDeProfil` int(11) NOT NULL,
  `description` varchar(50000) DEFAULT NULL,
  `datededebut` date NOT NULL DEFAULT '0000-00-00',
  `datefin` date NOT NULL,
  `fonction` varchar(650) DEFAULT NULL,
  `environnement` varchar(3000) DEFAULT NULL,
  `projet` varchar(3000) DEFAULT NULL,
  `missionsRealisees` varchar(3000) DEFAULT NULL,
  PRIMARY KEY (`idTypeDeProfil`,`datededebut`,`datefin`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `experiencesprofessionnelles`
--

INSERT INTO `experiencesprofessionnelles` (`idTypeDeProfil`, `description`, `datededebut`, `datefin`, `fonction`, `environnement`, `projet`, `missionsRealisees`) VALUES
(43, NULL, '2016-08-12', '2016-08-12', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `faireuntest`
--

CREATE TABLE IF NOT EXISTS `faireuntest` (
  `username` varchar(150) NOT NULL,
  `idFicheTest` int(11) NOT NULL,
  PRIMARY KEY (`username`,`idFicheTest`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `fichedeposte`
--

CREATE TABLE IF NOT EXISTS `fichedeposte` (
  `idFichePoste` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(150) NOT NULL,
  `intitulePoste` varchar(254) DEFAULT NULL,
  `description` varchar(3000) DEFAULT NULL,
  `qualiteRequise` varchar(3000) DEFAULT NULL,
  `connaissanceTechni` varchar(3000) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`idFichePoste`),
  KEY `FK_saisirFichePost` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `fichedetest`
--

CREATE TABLE IF NOT EXISTS `fichedetest` (
  `idFicheTest` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(150) NOT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`idFicheTest`),
  KEY `FK_concevoirFicheTest` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `formation`
--

CREATE TABLE IF NOT EXISTS `formation` (
  `idTypeDeProfil` int(11) NOT NULL,
  `nomDiplome` varchar(254) NOT NULL DEFAULT '',
  `universite` varchar(254) DEFAULT NULL,
  `anneeObtention` date DEFAULT NULL,
  `mention` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`idTypeDeProfil`,`nomDiplome`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `formation`
--

INSERT INTO `formation` (`idTypeDeProfil`, `nomDiplome`, `universite`, `anneeObtention`, `mention`) VALUES
(34, 'Licence', NULL, NULL, NULL),
(34, 'Master', NULL, NULL, NULL),
(39, 'Licence', NULL, NULL, NULL),
(39, 'Master', NULL, NULL, NULL),
(40, 'Licence', NULL, NULL, NULL),
(40, 'Master', NULL, NULL, NULL),
(43, 'Licence', NULL, NULL, NULL),
(43, 'Master', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `langages`
--

CREATE TABLE IF NOT EXISTS `langages` (
  `idTypeDeProfil` int(11) NOT NULL,
  `domaine` varchar(254) NOT NULL DEFAULT '',
  `niveau` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`idTypeDeProfil`,`domaine`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `langages`
--

INSERT INTO `langages` (`idTypeDeProfil`, `domaine`, `niveau`) VALUES
(39, 'java', NULL),
(39, 'XML', NULL),
(40, 'java', NULL),
(40, 'XML', NULL),
(43, 'java', NULL),
(43, 'XML', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `langues`
--

CREATE TABLE IF NOT EXISTS `langues` (
  `idTypeDeProfil` int(11) NOT NULL,
  `nom` varchar(254) NOT NULL DEFAULT '',
  `niveau` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`idTypeDeProfil`,`nom`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `langues`
--

INSERT INTO `langues` (`idTypeDeProfil`, `nom`, `niveau`) VALUES
(39, 'En', NULL),
(39, 'fr', NULL),
(40, 'En', NULL),
(40, 'fr', NULL),
(43, 'En', NULL),
(43, 'fr', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `listequestion`
--

CREATE TABLE IF NOT EXISTS `listequestion` (
  `idQuestion` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(3000) DEFAULT NULL,
  PRIMARY KEY (`idQuestion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `listereponse`
--

CREATE TABLE IF NOT EXISTS `listereponse` (
  `idReponse` int(11) NOT NULL AUTO_INCREMENT,
  `reponse` varchar(3000) DEFAULT NULL,
  PRIMARY KEY (`idReponse`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `materielssystemesexploitation`
--

CREATE TABLE IF NOT EXISTS `materielssystemesexploitation` (
  `idTypeDeProfil` int(11) NOT NULL,
  `domaine` varchar(254) NOT NULL DEFAULT '',
  `niveau` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`idTypeDeProfil`,`domaine`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `materielssystemesexploitation`
--

INSERT INTO `materielssystemesexploitation` (`idTypeDeProfil`, `domaine`, `niveau`) VALUES
(39, 'Linux', NULL),
(39, 'Windows', NULL),
(40, 'Linux', NULL),
(40, 'Windows', NULL),
(43, 'Linux', NULL),
(43, 'Windows', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `methodologie`
--

CREATE TABLE IF NOT EXISTS `methodologie` (
  `idTypeDeProfil` int(11) NOT NULL,
  `domaine` varchar(254) NOT NULL DEFAULT '',
  `niveau` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`idTypeDeProfil`,`domaine`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `methodologie`
--

INSERT INTO `methodologie` (`idTypeDeProfil`, `domaine`, `niveau`) VALUES
(39, 'metho1', NULL),
(39, 'metho2', NULL),
(40, 'metho1', NULL),
(40, 'metho2', NULL),
(43, 'metho1', NULL),
(43, 'metho2', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `modelisation`
--

CREATE TABLE IF NOT EXISTS `modelisation` (
  `idTypeDeProfil` int(11) NOT NULL,
  `domaine` varchar(254) NOT NULL DEFAULT '',
  `niveau` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`idTypeDeProfil`,`domaine`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `modelisation`
--

INSERT INTO `modelisation` (`idTypeDeProfil`, `domaine`, `niveau`) VALUES
(39, 'Model1', NULL),
(39, 'Model2', NULL),
(40, 'Model1', NULL),
(40, 'Model2', NULL),
(43, 'Model1', NULL),
(43, 'Model2', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `notification`
--

CREATE TABLE IF NOT EXISTS `notification` (
  `idNotification` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(150) NOT NULL,
  `destinateur` varchar(254) DEFAULT NULL,
  `destinataire` varchar(6000) DEFAULT NULL,
  `corpsMessage` varchar(50000) DEFAULT NULL,
  `pj` mediumblob NOT NULL,
  `dateNotification` datetime DEFAULT NULL,
  PRIMARY KEY (`idNotification`),
  KEY `FK_envoyerNotification` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `outils`
--

CREATE TABLE IF NOT EXISTS `outils` (
  `idTypeDeProfil` int(11) NOT NULL,
  `domaine` varchar(254) NOT NULL DEFAULT '',
  `niveau` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`idTypeDeProfil`,`domaine`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `outils`
--

INSERT INTO `outils` (`idTypeDeProfil`, `domaine`, `niveau`) VALUES
(39, 'outil 1', NULL),
(39, 'outil 2', NULL),
(40, 'outil 1', NULL),
(40, 'outil 2', NULL),
(43, 'outil 1', NULL),
(43, 'outil 2', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `profil`
--

CREATE TABLE IF NOT EXISTS `profil` (
  `idTypeDeProfil` int(11) NOT NULL AUTO_INCREMENT,
  `nombreAnneesExperience` int(11) DEFAULT NULL,
  `principalesCompetences` varchar(1000) DEFAULT NULL,
  `competencesFonctionnelles` varchar(1000) DEFAULT NULL,
  `etatProfil` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`idTypeDeProfil`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=44 ;

--
-- Contenu de la table `profil`
--

INSERT INTO `profil` (`idTypeDeProfil`, `nombreAnneesExperience`, `principalesCompetences`, `competencesFonctionnelles`, `etatProfil`) VALUES
(32, NULL, NULL, NULL, NULL),
(33, NULL, NULL, NULL, NULL),
(34, NULL, NULL, NULL, NULL),
(35, NULL, NULL, NULL, NULL),
(36, NULL, NULL, NULL, NULL),
(37, NULL, NULL, NULL, NULL),
(38, NULL, NULL, NULL, NULL),
(39, NULL, NULL, NULL, NULL),
(40, NULL, NULL, NULL, NULL),
(43, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `profilgl`
--

CREATE TABLE IF NOT EXISTS `profilgl` (
  `idTypeDeProfil` int(11) NOT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`idTypeDeProfil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `profilgl`
--

INSERT INTO `profilgl` (`idTypeDeProfil`, `version`) VALUES
(32, 0),
(33, 0),
(34, 0),
(35, 0),
(36, 0),
(37, 0),
(38, 0),
(39, 0),
(40, 0),
(43, 0);

-- --------------------------------------------------------

--
-- Structure de la table `recruteur`
--

CREATE TABLE IF NOT EXISTS `recruteur` (
  `username` varchar(150) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `suivreentrtien`
--

CREATE TABLE IF NOT EXISTS `suivreentrtien` (
  `username` varchar(150) NOT NULL,
  `idEntretien` int(11) NOT NULL,
  PRIMARY KEY (`username`,`idEntretien`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(150) CHARACTER SET latin1 NOT NULL,
  `nom` varchar(254) CHARACTER SET latin1 DEFAULT NULL,
  `prenom` varchar(254) CHARACTER SET latin1 DEFAULT NULL,
  `localisation` varchar(500) CHARACTER SET latin1 DEFAULT NULL,
  `mail` varchar(254) CHARACTER SET latin1 DEFAULT NULL,
  `telephone` varchar(254) CHARACTER SET latin1 DEFAULT NULL,
  `password` varchar(254) CHARACTER SET latin1 NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  `specialite` varchar(254) CHARACTER SET latin1 DEFAULT NULL,
  `dateDeNaissance` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`username`, `nom`, `prenom`, `localisation`, `mail`, `telephone`, `password`, `enabled`, `specialite`, `dateDeNaissance`, `version`) VALUES
('Abdoulaye', 'DIOP', 'kDiop', 'KM', 'diop@gmail.com', '771047524', 'diop48', 1, 'IGL', '3890-12-20 00:00:00', 1),
('ahmet', 'CISSE', 'Ahmet', 'Parcelles', 'ahmet.dame@hotmail.fr', '771047524', 'ahmet', 1, 'g?nie logiciel', '1989-01-09 00:00:00', 1),
('anonymousUser', 'Utilisateur anonyme', NULL, NULL, NULL, NULL, '', 1, NULL, NULL, NULL),
('baba', 'GOUGIABY', 'Baba', 'Pikine', 'baba@gmail.com', '775248596', 'baba', 1, 'RT', '1992-06-07 00:00:00', 1),
('camara', 'CAMARA', 'Ousmane', 'Kolda', 'ouz@gmail.com', '778529635', 'camara', 1, 'g?nie logiciel', '1990-07-19 00:00:00', 1),
('doudou4', 'CISSE', 'Doudou', 'KM', 'doudou@gmail.com', '771047524', 'doudou4', 1, 'IGL', '3890-12-20 00:00:00', 1),
('doudou5', 'CISSE', 'Doudou', 'KM', 'doudou@gmail.com', '771047524', 'doudou5', 1, 'IGL', '3890-12-20 00:00:00', 1),
('doudou6', 'CISSE', 'kDoudou', 'KM', 'doudou@gmail.com', '771047524', 'doudou5', 1, 'IGL', '3890-12-20 00:00:00', 1),
('doudou7', 'CISSE', 'kDoudou', 'KM', 'doudou@gmail.com', '771047524', 'doudou7', 1, 'IGL', '3890-12-20 00:00:00', 1),
('doudou8', 'CISSE', 'kDoudou', 'KM', 'doudou@gmail.com', '771047524', 'doudou8', 1, 'IGL', '3890-12-20 00:00:00', 1),
('maymouna', 'GUEYE', 'Maymouna', 'UCAD', 'gueye@hotmail.fr', '775025485', 'maymouna', 1, 'g?nie logiciel', '1990-07-25 00:00:00', 1),
('username1', 'DIOP', 'kDiop', 'KM', 'diop@gmail.com', '771047524', 'diop48', 1, 'IGL', '3890-12-20 00:00:00', 1),
('username3', 'DIOP', 'kDiop', 'KM', 'diop@gmail.com', '771047524', 'diop48', 1, 'IGL', '3890-12-20 00:00:00', 1);

-- --------------------------------------------------------

--
-- Structure de la table `user_roles`
--

CREATE TABLE IF NOT EXISTS `user_roles` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(150) NOT NULL,
  `role` varchar(100) NOT NULL,
  PRIMARY KEY (`user_role_id`),
  UNIQUE KEY `uni_username_role` (`role`,`username`),
  KEY `fk_username_idx` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Contenu de la table `user_roles`
--

INSERT INTO `user_roles` (`user_role_id`, `username`, `role`) VALUES
(1, 'ahmet', 'ROLE_ADMIN'),
(11, 'ahmet', 'ROLE_ANONYMOUS'),
(10, 'anonymousUser', 'ROLE_ANONYMOUS'),
(12, 'baba', 'ROLE_ANONYMOUS'),
(13, 'camara', 'ROLE_ANONYMOUS'),
(7, 'ahmet', 'ROLE_CANDIDAT'),
(4, 'baba', 'ROLE_CANDIDAT'),
(6, 'ahmet', 'ROLE_RECRUTEUR'),
(5, 'camara', 'ROLE_RECRUTEUR');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `administrateur`
--
ALTER TABLE `administrateur`
  ADD CONSTRAINT `FK_GENERALISATION_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`);

--
-- Contraintes pour la table `avoirquestion`
--
ALTER TABLE `avoirquestion`
  ADD CONSTRAINT `FK_A2` FOREIGN KEY (`idFicheTest`) REFERENCES `fichedetest` (`idFicheTest`),
  ADD CONSTRAINT `FK_EST_POSEE` FOREIGN KEY (`idQuestion`) REFERENCES `listequestion` (`idQuestion`);

--
-- Contraintes pour la table `avoirreponse`
--
ALTER TABLE `avoirreponse`
  ADD CONSTRAINT `FK_A` FOREIGN KEY (`idQuestion`) REFERENCES `listequestion` (`idQuestion`),
  ADD CONSTRAINT `FK_EST` FOREIGN KEY (`idReponse`) REFERENCES `listereponse` (`idReponse`);

--
-- Contraintes pour la table `bdd`
--
ALTER TABLE `bdd`
  ADD CONSTRAINT `FK_association14` FOREIGN KEY (`idTypeDeProfil`) REFERENCES `profilgl` (`idTypeDeProfil`);

--
-- Contraintes pour la table `candidat`
--
ALTER TABLE `candidat`
  ADD CONSTRAINT `FK_association1` FOREIGN KEY (`idTypeDeProfil`) REFERENCES `profil` (`idTypeDeProfil`),
  ADD CONSTRAINT `FK_GENERALISATION_2` FOREIGN KEY (`username`) REFERENCES `users` (`username`);

--
-- Contraintes pour la table `cherchercandidat`
--
ALTER TABLE `cherchercandidat`
  ADD CONSTRAINT `FK_chercherCandidat` FOREIGN KEY (`username`) REFERENCES `candidat` (`username`);

--
-- Contraintes pour la table `entretien`
--
ALTER TABLE `entretien`
  ADD CONSTRAINT `FK_fixerEntretien` FOREIGN KEY (`username`) REFERENCES `recruteur` (`username`);

--
-- Contraintes pour la table `experiencesprofessionnelles`
--
ALTER TABLE `experiencesprofessionnelles`
  ADD CONSTRAINT `FK_association13` FOREIGN KEY (`idTypeDeProfil`) REFERENCES `profilgl` (`idTypeDeProfil`);

--
-- Contraintes pour la table `fichedeposte`
--
ALTER TABLE `fichedeposte`
  ADD CONSTRAINT `FK_saisirFichePost` FOREIGN KEY (`username`) REFERENCES `recruteur` (`username`);

--
-- Contraintes pour la table `fichedetest`
--
ALTER TABLE `fichedetest`
  ADD CONSTRAINT `FK_concevoirFicheTest` FOREIGN KEY (`username`) REFERENCES `recruteur` (`username`);

--
-- Contraintes pour la table `formation`
--
ALTER TABLE `formation`
  ADD CONSTRAINT `FK_association3` FOREIGN KEY (`idTypeDeProfil`) REFERENCES `profilgl` (`idTypeDeProfil`);

--
-- Contraintes pour la table `langages`
--
ALTER TABLE `langages`
  ADD CONSTRAINT `FK_association9` FOREIGN KEY (`idTypeDeProfil`) REFERENCES `profilgl` (`idTypeDeProfil`);

--
-- Contraintes pour la table `langues`
--
ALTER TABLE `langues`
  ADD CONSTRAINT `FK_association12` FOREIGN KEY (`idTypeDeProfil`) REFERENCES `profilgl` (`idTypeDeProfil`);

--
-- Contraintes pour la table `materielssystemesexploitation`
--
ALTER TABLE `materielssystemesexploitation`
  ADD CONSTRAINT `FK_association10` FOREIGN KEY (`idTypeDeProfil`) REFERENCES `profilgl` (`idTypeDeProfil`);

--
-- Contraintes pour la table `methodologie`
--
ALTER TABLE `methodologie`
  ADD CONSTRAINT `FK_association7` FOREIGN KEY (`idTypeDeProfil`) REFERENCES `profilgl` (`idTypeDeProfil`);

--
-- Contraintes pour la table `modelisation`
--
ALTER TABLE `modelisation`
  ADD CONSTRAINT `FK_association8` FOREIGN KEY (`idTypeDeProfil`) REFERENCES `profilgl` (`idTypeDeProfil`);

--
-- Contraintes pour la table `notification`
--
ALTER TABLE `notification`
  ADD CONSTRAINT `FK_envoyerNotification` FOREIGN KEY (`username`) REFERENCES `recruteur` (`username`);

--
-- Contraintes pour la table `outils`
--
ALTER TABLE `outils`
  ADD CONSTRAINT `FK_association11` FOREIGN KEY (`idTypeDeProfil`) REFERENCES `profilgl` (`idTypeDeProfil`);

--
-- Contraintes pour la table `profilgl`
--
ALTER TABLE `profilgl`
  ADD CONSTRAINT `FK_GENERALISATION_4` FOREIGN KEY (`idTypeDeProfil`) REFERENCES `profil` (`idTypeDeProfil`);

--
-- Contraintes pour la table `recruteur`
--
ALTER TABLE `recruteur`
  ADD CONSTRAINT `FK_GENERALISATION_3` FOREIGN KEY (`username`) REFERENCES `users` (`username`);

--
-- Contraintes pour la table `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `fk_username1` FOREIGN KEY (`username`) REFERENCES `users` (`username`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
