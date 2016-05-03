#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: Producteur
#------------------------------------------------------------

CREATE TABLE Producteur(
        id_producteur int (11) Auto_increment  NOT NULL ,
        Nom           Varchar (25) ,
        Prenom        Varchar (25) ,
        Adresse       Varchar (25) ,
        id_ville      Int NOT NULL ,
        PRIMARY KEY (id_producteur )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Ville
#------------------------------------------------------------

CREATE TABLE Ville(
        id_ville    int (11) Auto_increment  NOT NULL ,
        libelle     Varchar (25) ,
        code_postal Int ,
        id_region   Int NOT NULL ,
        PRIMARY KEY (id_ville )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Region
#------------------------------------------------------------

CREATE TABLE Region(
        id_region int (11) Auto_increment  NOT NULL ,
        libelle   Varchar (25) ,
        PRIMARY KEY (id_region )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Consomateur
#------------------------------------------------------------

CREATE TABLE Consomateur(
        id_consomateur int (11) Auto_increment  NOT NULL ,
        Nom            Varchar (25) ,
        Prenom         Varchar (25) ,
        adresse        Varchar (25) ,
        id_ville       Int NOT NULL ,
        PRIMARY KEY (id_consomateur )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Contrat
#------------------------------------------------------------

CREATE TABLE Contrat(
        id_contrat     int (11) Auto_increment  NOT NULL ,
        libelle        Varchar (25) ,
        contenu        Varchar (25) ,
        debut          Date ,
        fin            Date ,
        id_consomateur Int NOT NULL ,
        id_AMAP        Int NOT NULL ,
        id_producteur  Int NOT NULL ,
        PRIMARY KEY (id_contrat )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: AMAP
#------------------------------------------------------------

CREATE TABLE AMAP(
        id_AMAP    int (11) Auto_increment  NOT NULL ,
        libelle    Varchar (25) ,
        adresse    Varchar (25) ,
        id_ville   Int NOT NULL ,
        id_MIRAMAP Int NOT NULL ,
        PRIMARY KEY (id_AMAP )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: MIRAMAP
#------------------------------------------------------------

CREATE TABLE MIRAMAP(
        id_MIRAMAP int (11) Auto_increment  NOT NULL ,
        libelle    Varchar (25) ,
        adresse    Varchar (25) ,
        id_ville   Int NOT NULL ,
        PRIMARY KEY (id_MIRAMAP )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Lieu_distribution
#------------------------------------------------------------

CREATE TABLE Lieu_distribution(
        id_lieu_distribution      int (11) Auto_increment  NOT NULL ,
        adresse                   Varchar (25) ,
        id_ville                  Int NOT NULL ,
        id_type_lieu_distribution Int NOT NULL ,
        PRIMARY KEY (id_lieu_distribution )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Type_lieu_distribution
#------------------------------------------------------------

CREATE TABLE Type_lieu_distribution(
        id_type_lieu_distribution int (11) Auto_increment  NOT NULL ,
        libelle                   Varchar (25) ,
        PRIMARY KEY (id_type_lieu_distribution )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Entrepot
#------------------------------------------------------------

CREATE TABLE Entrepot(
        id_entrepot         int (11) Auto_increment  NOT NULL ,
        libelle             Varchar (25) ,
        adresse             Varchar (25) ,
        stock_max           Int ,
        nombre_vehicule_max Int ,
        id_ville            Int NOT NULL ,
        PRIMARY KEY (id_entrepot )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Panier
#------------------------------------------------------------

CREATE TABLE Panier(
        id_panier int (11) Auto_increment  NOT NULL ,
        libelle   Varchar (25) ,
        prix      Int ,
        PRIMARY KEY (id_panier )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Livraison
#------------------------------------------------------------

CREATE TABLE Livraison(
        id_livraison         int (11) Auto_increment  NOT NULL ,
        libelle              Varchar (25) ,
        date_livraison       Date ,
        id_lieu_distribution Int NOT NULL ,
        id_entrepot          Int NOT NULL ,
        id_type_livraison    Int NOT NULL ,
        id_producteur        Int NOT NULL ,
        PRIMARY KEY (id_livraison )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Type_livraison
#------------------------------------------------------------

CREATE TABLE Type_livraison(
        id_type_livraison int (11) Auto_increment  NOT NULL ,
        libelle           Varchar (25) ,
        PRIMARY KEY (id_type_livraison )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Produit
#------------------------------------------------------------

CREATE TABLE Produit(
        id_produit     int (11) Auto_increment  NOT NULL ,
        libelle        Varchar (25) ,
        prix_unitaire  Int ,
        quantite       Int ,
        id_consomateur Int NOT NULL ,
        PRIMARY KEY (id_produit )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Contrat_pro
#------------------------------------------------------------

CREATE TABLE Contrat_pro(
        id_contrat_pro int (11) Auto_increment  NOT NULL ,
        debut          Date ,
        fin            Date ,
        fonction       Varchar (25) ,
        salaire        Int ,
        date_signature Date ,
        id_employe     Int NOT NULL ,
        id_AMAP        Int NOT NULL ,
        id_MIRAMAP     Int NOT NULL ,
        PRIMARY KEY (id_contrat_pro )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Employe
#------------------------------------------------------------

CREATE TABLE Employe(
        id_employe     int (11) Auto_increment  NOT NULL ,
        nom            Varchar (25) ,
        prenom         Varchar (25) ,
        date_naissance Date ,
        civilite       Varchar (25) ,
        adresse        Varchar (25) ,
        telephone      Varchar (25) ,
        nationalite    Varchar (25) ,
        id_ville       Int NOT NULL ,
        PRIMARY KEY (id_employe )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: livrer (produitEntrepot)
#------------------------------------------------------------

CREATE TABLE livrer__produitEntrepot_(
        quantite_livrer Int ,
        id_panier       Int NOT NULL ,
        id_entrepot     Int NOT NULL ,
        PRIMARY KEY (id_panier ,id_entrepot )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: fournir (ProduitCommande)
#------------------------------------------------------------

CREATE TABLE fournir__ProduitCommande_(
        type_panier Varchar (25) ,
        id_panier   Int NOT NULL ,
        id_contrat  Int NOT NULL ,
        PRIMARY KEY (id_panier ,id_contrat )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: contenir (PanierProduit)
#------------------------------------------------------------

CREATE TABLE contenir__PanierProduit_(
        quantite   Int ,
        id_panier  Int NOT NULL ,
        id_produit Int NOT NULL ,
        PRIMARY KEY (id_panier ,id_produit )
)ENGINE=InnoDB;

ALTER TABLE Producteur ADD CONSTRAINT FK_Producteur_id_ville FOREIGN KEY (id_ville) REFERENCES Ville(id_ville);
ALTER TABLE Ville ADD CONSTRAINT FK_Ville_id_region FOREIGN KEY (id_region) REFERENCES Region(id_region);
ALTER TABLE Consomateur ADD CONSTRAINT FK_Consomateur_id_ville FOREIGN KEY (id_ville) REFERENCES Ville(id_ville);
ALTER TABLE Contrat ADD CONSTRAINT FK_Contrat_id_consomateur FOREIGN KEY (id_consomateur) REFERENCES Consomateur(id_consomateur);
ALTER TABLE Contrat ADD CONSTRAINT FK_Contrat_id_AMAP FOREIGN KEY (id_AMAP) REFERENCES AMAP(id_AMAP);
ALTER TABLE Contrat ADD CONSTRAINT FK_Contrat_id_producteur FOREIGN KEY (id_producteur) REFERENCES Producteur(id_producteur);
ALTER TABLE AMAP ADD CONSTRAINT FK_AMAP_id_ville FOREIGN KEY (id_ville) REFERENCES Ville(id_ville);
ALTER TABLE AMAP ADD CONSTRAINT FK_AMAP_id_MIRAMAP FOREIGN KEY (id_MIRAMAP) REFERENCES MIRAMAP(id_MIRAMAP);
ALTER TABLE MIRAMAP ADD CONSTRAINT FK_MIRAMAP_id_ville FOREIGN KEY (id_ville) REFERENCES Ville(id_ville);
ALTER TABLE Lieu_distribution ADD CONSTRAINT FK_Lieu_distribution_id_ville FOREIGN KEY (id_ville) REFERENCES Ville(id_ville);
ALTER TABLE Lieu_distribution ADD CONSTRAINT FK_Lieu_distribution_id_type_lieu_distribution FOREIGN KEY (id_type_lieu_distribution) REFERENCES Type_lieu_distribution(id_type_lieu_distribution);
ALTER TABLE Entrepot ADD CONSTRAINT FK_Entrepot_id_ville FOREIGN KEY (id_ville) REFERENCES Ville(id_ville);
ALTER TABLE Livraison ADD CONSTRAINT FK_Livraison_id_lieu_distribution FOREIGN KEY (id_lieu_distribution) REFERENCES Lieu_distribution(id_lieu_distribution);
ALTER TABLE Livraison ADD CONSTRAINT FK_Livraison_id_entrepot FOREIGN KEY (id_entrepot) REFERENCES Entrepot(id_entrepot);
ALTER TABLE Livraison ADD CONSTRAINT FK_Livraison_id_type_livraison FOREIGN KEY (id_type_livraison) REFERENCES Type_livraison(id_type_livraison);
ALTER TABLE Livraison ADD CONSTRAINT FK_Livraison_id_producteur FOREIGN KEY (id_producteur) REFERENCES Producteur(id_producteur);
ALTER TABLE Produit ADD CONSTRAINT FK_Produit_id_consomateur FOREIGN KEY (id_consomateur) REFERENCES Consomateur(id_consomateur);
ALTER TABLE Contrat_pro ADD CONSTRAINT FK_Contrat_pro_id_employe FOREIGN KEY (id_employe) REFERENCES Employe(id_employe);
ALTER TABLE Contrat_pro ADD CONSTRAINT FK_Contrat_pro_id_AMAP FOREIGN KEY (id_AMAP) REFERENCES AMAP(id_AMAP);
ALTER TABLE Contrat_pro ADD CONSTRAINT FK_Contrat_pro_id_MIRAMAP FOREIGN KEY (id_MIRAMAP) REFERENCES MIRAMAP(id_MIRAMAP);
ALTER TABLE Employe ADD CONSTRAINT FK_Employe_id_ville FOREIGN KEY (id_ville) REFERENCES Ville(id_ville);
ALTER TABLE livrer__produitEntrepot_ ADD CONSTRAINT FK_livrer__produitEntrepot__id_panier FOREIGN KEY (id_panier) REFERENCES Panier(id_panier);
ALTER TABLE livrer__produitEntrepot_ ADD CONSTRAINT FK_livrer__produitEntrepot__id_entrepot FOREIGN KEY (id_entrepot) REFERENCES Entrepot(id_entrepot);
ALTER TABLE fournir__ProduitCommande_ ADD CONSTRAINT FK_fournir__ProduitCommande__id_panier FOREIGN KEY (id_panier) REFERENCES Panier(id_panier);
ALTER TABLE fournir__ProduitCommande_ ADD CONSTRAINT FK_fournir__ProduitCommande__id_contrat FOREIGN KEY (id_contrat) REFERENCES Contrat(id_contrat);
ALTER TABLE contenir__PanierProduit_ ADD CONSTRAINT FK_contenir__PanierProduit__id_panier FOREIGN KEY (id_panier) REFERENCES Panier(id_panier);
ALTER TABLE contenir__PanierProduit_ ADD CONSTRAINT FK_contenir__PanierProduit__id_produit FOREIGN KEY (id_produit) REFERENCES Produit(id_produit);
