package app.data;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Produit database table.
 * 
 */
@Entity
@NamedQuery(name="Produit.findAll", query="SELECT p FROM Produit p")
public class Produit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_produit")
	private int idProduit;

	@Column(name="id_consomateur")
	private int idConsomateur;

	private String libelle;

	@Column(name="prix_unitaire")
	private int prixUnitaire;

	private int quantite;

	public Produit() {
	}

	public int getIdProduit() {
		return this.idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public int getIdConsomateur() {
		return this.idConsomateur;
	}

	public void setIdConsomateur(int idConsomateur) {
		this.idConsomateur = idConsomateur;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getPrixUnitaire() {
		return this.prixUnitaire;
	}

	public void setPrixUnitaire(int prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public int getQuantite() {
		return this.quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

}