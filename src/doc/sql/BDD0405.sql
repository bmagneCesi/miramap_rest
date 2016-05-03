-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Mar 03 Mai 2016 à 14:37
-- Version du serveur: 5.5.47-0ubuntu0.14.04.1
-- Version de PHP: 5.5.9-1ubuntu4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `miramap`
--

-- --------------------------------------------------------

--
-- Structure de la table `Adresse`
--

CREATE TABLE IF NOT EXISTS `Adresse` (
  `id_adresse` int(11) NOT NULL AUTO_INCREMENT,
  `adresse` varchar(50) NOT NULL,
  `id_ville` int(11) NOT NULL,
  PRIMARY KEY (`id_adresse`),
  KEY `id_ville` (`id_ville`),
  KEY `id_ville_2` (`id_ville`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `AMAP`
--

CREATE TABLE IF NOT EXISTS `AMAP` (
  `id_AMAP` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(25) DEFAULT NULL,
  `adresse` varchar(25) DEFAULT NULL,
  `id_ville` int(11) NOT NULL,
  `id_MIRAMAP` int(11) NOT NULL,
  PRIMARY KEY (`id_AMAP`),
  KEY `FK_AMAP_id_ville` (`id_ville`),
  KEY `FK_AMAP_id_MIRAMAP` (`id_MIRAMAP`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `Consomateur`
--

CREATE TABLE IF NOT EXISTS `Consomateur` (
  `id_consomateur` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(25) DEFAULT NULL,
  `Prenom` varchar(25) DEFAULT NULL,
  `adresse` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id_consomateur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `contenir__PanierProduit_`
--

CREATE TABLE IF NOT EXISTS `contenir__PanierProduit_` (
  `quantite` int(11) DEFAULT NULL,
  `id_panier` int(11) NOT NULL,
  `id_produit` int(11) NOT NULL,
  PRIMARY KEY (`id_panier`,`id_produit`),
  KEY `FK_contenir__PanierProduit__id_produit` (`id_produit`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `Contrat`
--

CREATE TABLE IF NOT EXISTS `Contrat` (
  `id_contrat` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(25) DEFAULT NULL,
  `contenu` varchar(25) DEFAULT NULL,
  `debut` date DEFAULT NULL,
  `fin` date DEFAULT NULL,
  `id_consomateur` int(11) NOT NULL,
  `id_AMAP` int(11) NOT NULL,
  `id_producteur` int(11) NOT NULL,
  PRIMARY KEY (`id_contrat`),
  KEY `FK_Contrat_id_consomateur` (`id_consomateur`),
  KEY `FK_Contrat_id_AMAP` (`id_AMAP`),
  KEY `FK_Contrat_id_producteur` (`id_producteur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `Contrat_pro`
--

CREATE TABLE IF NOT EXISTS `Contrat_pro` (
  `id_contrat_pro` int(11) NOT NULL AUTO_INCREMENT,
  `debut` date DEFAULT NULL,
  `fin` date DEFAULT NULL,
  `fonction` varchar(25) DEFAULT NULL,
  `salaire` int(11) DEFAULT NULL,
  `date_signature` date DEFAULT NULL,
  `id_employe` int(11) NOT NULL,
  `id_AMAP` int(11) NOT NULL,
  `id_MIRAMAP` int(11) NOT NULL,
  PRIMARY KEY (`id_contrat_pro`),
  KEY `FK_Contrat_pro_id_employe` (`id_employe`),
  KEY `FK_Contrat_pro_id_AMAP` (`id_AMAP`),
  KEY `FK_Contrat_pro_id_MIRAMAP` (`id_MIRAMAP`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `Entrepot`
--

CREATE TABLE IF NOT EXISTS `Entrepot` (
  `id_entrepot` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(25) DEFAULT NULL,
  `adresse` varchar(25) DEFAULT NULL,
  `stock_max` int(11) DEFAULT NULL,
  `nombre_vehicule_max` int(11) DEFAULT NULL,
  `id_ville` int(11) NOT NULL,
  PRIMARY KEY (`id_entrepot`),
  KEY `FK_Entrepot_id_ville` (`id_ville`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `fournir__ProduitCommande_`
--

CREATE TABLE IF NOT EXISTS `fournir__ProduitCommande_` (
  `type_panier` varchar(25) DEFAULT NULL,
  `id_panier` int(11) NOT NULL,
  `id_contrat` int(11) NOT NULL,
  PRIMARY KEY (`id_panier`,`id_contrat`),
  KEY `FK_fournir__ProduitCommande__id_contrat` (`id_contrat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `Lieu_distribution`
--

CREATE TABLE IF NOT EXISTS `Lieu_distribution` (
  `id_lieu_distribution` int(11) NOT NULL AUTO_INCREMENT,
  `adresse` varchar(25) DEFAULT NULL,
  `id_ville` int(11) NOT NULL,
  `id_type_lieu_distribution` int(11) NOT NULL,
  PRIMARY KEY (`id_lieu_distribution`),
  KEY `FK_Lieu_distribution_id_ville` (`id_ville`),
  KEY `FK_Lieu_distribution_id_type_lieu_distribution` (`id_type_lieu_distribution`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `Livraison`
--

CREATE TABLE IF NOT EXISTS `Livraison` (
  `id_livraison` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(25) DEFAULT NULL,
  `date_livraison` date DEFAULT NULL,
  `id_lieu_distribution` int(11) NOT NULL,
  `id_entrepot` int(11) NOT NULL,
  `id_type_livraison` int(11) NOT NULL,
  `id_producteur` int(11) NOT NULL,
  PRIMARY KEY (`id_livraison`),
  KEY `FK_Livraison_id_lieu_distribution` (`id_lieu_distribution`),
  KEY `FK_Livraison_id_entrepot` (`id_entrepot`),
  KEY `FK_Livraison_id_type_livraison` (`id_type_livraison`),
  KEY `FK_Livraison_id_producteur` (`id_producteur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `livrer__produitEntrepot_`
--

CREATE TABLE IF NOT EXISTS `livrer__produitEntrepot_` (
  `quantite_livrer` int(11) DEFAULT NULL,
  `id_panier` int(11) NOT NULL,
  `id_entrepot` int(11) NOT NULL,
  PRIMARY KEY (`id_panier`,`id_entrepot`),
  KEY `FK_livrer__produitEntrepot__id_entrepot` (`id_entrepot`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `MIRAMAP`
--

CREATE TABLE IF NOT EXISTS `MIRAMAP` (
  `id_MIRAMAP` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(25) DEFAULT NULL,
  `adresse` varchar(25) DEFAULT NULL,
  `id_ville` int(11) NOT NULL,
  PRIMARY KEY (`id_MIRAMAP`),
  KEY `FK_MIRAMAP_id_ville` (`id_ville`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `Panier`
--

CREATE TABLE IF NOT EXISTS `Panier` (
  `id_panier` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(25) DEFAULT NULL,
  `prix` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_panier`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `Producteur`
--

CREATE TABLE IF NOT EXISTS `Producteur` (
  `id_producteur` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(25) DEFAULT NULL,
  `Prenom` varchar(25) DEFAULT NULL,
  `Adresse` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id_producteur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `Produit`
--

CREATE TABLE IF NOT EXISTS `Produit` (
  `id_produit` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(25) DEFAULT NULL,
  `prix_unitaire` int(11) DEFAULT NULL,
  `quantite` int(11) DEFAULT NULL,
  `id_consomateur` int(11) NOT NULL,
  PRIMARY KEY (`id_produit`),
  KEY `FK_Produit_id_consomateur` (`id_consomateur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `Region`
--

CREATE TABLE IF NOT EXISTS `Region` (
  `id_region` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id_region`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `Type_lieu_distribution`
--

CREATE TABLE IF NOT EXISTS `Type_lieu_distribution` (
  `id_type_lieu_distribution` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id_type_lieu_distribution`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `Type_livraison`
--

CREATE TABLE IF NOT EXISTS `Type_livraison` (
  `id_type_livraison` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id_type_livraison`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `Type_utilisateur`
--

CREATE TABLE IF NOT EXISTS `Type_utilisateur` (
  `id_type_utilisateur` int(11) NOT NULL,
  `libelle` varchar(35) NOT NULL,
  PRIMARY KEY (`id_type_utilisateur`),
  UNIQUE KEY `libelle` (`libelle`),
  UNIQUE KEY `id_type_utilisateur` (`id_type_utilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Type_utilisateur`
--

INSERT INTO `Type_utilisateur` (`id_type_utilisateur`, `libelle`) VALUES
(0, ''),
(1, 'Employe');

-- --------------------------------------------------------

--
-- Structure de la table `Utilisateur`
--

CREATE TABLE IF NOT EXISTS `Utilisateur` (
  `id_employe` int(11) NOT NULL AUTO_INCREMENT,
  `mail` varchar(35) NOT NULL,
  `password` varchar(40) NOT NULL,
  `nom` varchar(25) DEFAULT NULL,
  `prenom` varchar(25) DEFAULT NULL,
  `date_naissance` date DEFAULT NULL,
  `civilite` varchar(25) DEFAULT NULL,
  `telephone` varchar(25) DEFAULT NULL,
  `nationalite` varchar(25) DEFAULT NULL,
  `id_adresse` int(11) NOT NULL,
  `id_type_utilisateur` int(11) NOT NULL,
  PRIMARY KEY (`id_employe`),
  UNIQUE KEY `mail` (`mail`),
  KEY `id_adresse` (`id_adresse`),
  KEY `id_type_utilisateur` (`id_type_utilisateur`),
  KEY `id_employe` (`id_employe`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `Ville`
--

CREATE TABLE IF NOT EXISTS `Ville` (
  `id_ville` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(25) DEFAULT NULL,
  `code_postal` int(11) DEFAULT NULL,
  `id_region` int(11) NOT NULL,
  PRIMARY KEY (`id_ville`),
  KEY `FK_Ville_id_region` (`id_region`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `Adresse`
--
ALTER TABLE `Adresse`
  ADD CONSTRAINT `Adresse_ibfk_1` FOREIGN KEY (`id_ville`) REFERENCES `Ville` (`id_ville`);

--
-- Contraintes pour la table `AMAP`
--
ALTER TABLE `AMAP`
  ADD CONSTRAINT `FK_AMAP_id_MIRAMAP` FOREIGN KEY (`id_MIRAMAP`) REFERENCES `MIRAMAP` (`id_MIRAMAP`),
  ADD CONSTRAINT `FK_AMAP_id_ville` FOREIGN KEY (`id_ville`) REFERENCES `Ville` (`id_ville`);

--
-- Contraintes pour la table `contenir__PanierProduit_`
--
ALTER TABLE `contenir__PanierProduit_`
  ADD CONSTRAINT `FK_contenir__PanierProduit__id_produit` FOREIGN KEY (`id_produit`) REFERENCES `Produit` (`id_produit`),
  ADD CONSTRAINT `FK_contenir__PanierProduit__id_panier` FOREIGN KEY (`id_panier`) REFERENCES `Panier` (`id_panier`);

--
-- Contraintes pour la table `Contrat`
--
ALTER TABLE `Contrat`
  ADD CONSTRAINT `FK_Contrat_id_producteur` FOREIGN KEY (`id_producteur`) REFERENCES `Producteur` (`id_producteur`),
  ADD CONSTRAINT `FK_Contrat_id_AMAP` FOREIGN KEY (`id_AMAP`) REFERENCES `AMAP` (`id_AMAP`),
  ADD CONSTRAINT `FK_Contrat_id_consomateur` FOREIGN KEY (`id_consomateur`) REFERENCES `Consomateur` (`id_consomateur`);

--
-- Contraintes pour la table `Contrat_pro`
--
ALTER TABLE `Contrat_pro`
  ADD CONSTRAINT `FK_Contrat_pro_id_MIRAMAP` FOREIGN KEY (`id_MIRAMAP`) REFERENCES `MIRAMAP` (`id_MIRAMAP`),
  ADD CONSTRAINT `FK_Contrat_pro_id_AMAP` FOREIGN KEY (`id_AMAP`) REFERENCES `AMAP` (`id_AMAP`),
  ADD CONSTRAINT `FK_Contrat_pro_id_employe` FOREIGN KEY (`id_employe`) REFERENCES `Utilisateur` (`id_employe`);

--
-- Contraintes pour la table `Entrepot`
--
ALTER TABLE `Entrepot`
  ADD CONSTRAINT `FK_Entrepot_id_ville` FOREIGN KEY (`id_ville`) REFERENCES `Ville` (`id_ville`);

--
-- Contraintes pour la table `fournir__ProduitCommande_`
--
ALTER TABLE `fournir__ProduitCommande_`
  ADD CONSTRAINT `FK_fournir__ProduitCommande__id_contrat` FOREIGN KEY (`id_contrat`) REFERENCES `Contrat` (`id_contrat`),
  ADD CONSTRAINT `FK_fournir__ProduitCommande__id_panier` FOREIGN KEY (`id_panier`) REFERENCES `Panier` (`id_panier`);

--
-- Contraintes pour la table `Lieu_distribution`
--
ALTER TABLE `Lieu_distribution`
  ADD CONSTRAINT `FK_Lieu_distribution_id_type_lieu_distribution` FOREIGN KEY (`id_type_lieu_distribution`) REFERENCES `Type_lieu_distribution` (`id_type_lieu_distribution`),
  ADD CONSTRAINT `FK_Lieu_distribution_id_ville` FOREIGN KEY (`id_ville`) REFERENCES `Ville` (`id_ville`);

--
-- Contraintes pour la table `Livraison`
--
ALTER TABLE `Livraison`
  ADD CONSTRAINT `FK_Livraison_id_producteur` FOREIGN KEY (`id_producteur`) REFERENCES `Producteur` (`id_producteur`),
  ADD CONSTRAINT `FK_Livraison_id_entrepot` FOREIGN KEY (`id_entrepot`) REFERENCES `Entrepot` (`id_entrepot`),
  ADD CONSTRAINT `FK_Livraison_id_lieu_distribution` FOREIGN KEY (`id_lieu_distribution`) REFERENCES `Lieu_distribution` (`id_lieu_distribution`),
  ADD CONSTRAINT `FK_Livraison_id_type_livraison` FOREIGN KEY (`id_type_livraison`) REFERENCES `Type_livraison` (`id_type_livraison`);

--
-- Contraintes pour la table `livrer__produitEntrepot_`
--
ALTER TABLE `livrer__produitEntrepot_`
  ADD CONSTRAINT `FK_livrer__produitEntrepot__id_entrepot` FOREIGN KEY (`id_entrepot`) REFERENCES `Entrepot` (`id_entrepot`),
  ADD CONSTRAINT `FK_livrer__produitEntrepot__id_panier` FOREIGN KEY (`id_panier`) REFERENCES `Panier` (`id_panier`);

--
-- Contraintes pour la table `MIRAMAP`
--
ALTER TABLE `MIRAMAP`
  ADD CONSTRAINT `FK_MIRAMAP_id_ville` FOREIGN KEY (`id_ville`) REFERENCES `Ville` (`id_ville`);

--
-- Contraintes pour la table `Produit`
--
ALTER TABLE `Produit`
  ADD CONSTRAINT `FK_Produit_id_consomateur` FOREIGN KEY (`id_consomateur`) REFERENCES `Consomateur` (`id_consomateur`);

--
-- Contraintes pour la table `Utilisateur`
--
ALTER TABLE `Utilisateur`
  ADD CONSTRAINT `Utilisateur_ibfk_1` FOREIGN KEY (`id_adresse`) REFERENCES `Adresse` (`id_adresse`),
  ADD CONSTRAINT `Utilisateur_ibfk_2` FOREIGN KEY (`id_type_utilisateur`) REFERENCES `Type_utilisateur` (`id_type_utilisateur`);

--
-- Contraintes pour la table `Ville`
--
ALTER TABLE `Ville`
  ADD CONSTRAINT `FK_Ville_id_region` FOREIGN KEY (`id_region`) REFERENCES `Region` (`id_region`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;