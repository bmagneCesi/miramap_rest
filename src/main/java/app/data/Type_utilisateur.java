package app.data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Type_utilisateur database table.
 * 
 */
@Entity
@NamedQuery(name="Type_utilisateur.findAll", query="SELECT t FROM Type_utilisateur t")
public class Type_utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_type_utilisateur")
	private int idTypeUtilisateur;

	private String libelle;

	//bi-directional many-to-one association to Utilisateur
//	@OneToMany(mappedBy="typeUtilisateur")
//	private List<Utilisateur> utilisateurs;

	public Type_utilisateur() {
	}

	public int getIdTypeUtilisateur() {
		return this.idTypeUtilisateur;
	}

	public void setIdTypeUtilisateur(int idTypeUtilisateur) {
		this.idTypeUtilisateur = idTypeUtilisateur;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

//	public List<Utilisateur> getUtilisateurs() {
//		return this.utilisateurs;
//	}
//
//	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
//		this.utilisateurs = utilisateurs;
//	}

//	public Utilisateur addUtilisateur(Utilisateur utilisateur) {
//		getUtilisateurs().add(utilisateur);
//		utilisateur.setTypeUtilisateur(this);
//
//		return utilisateur;
//	}
//
//	public Utilisateur removeUtilisateur(Utilisateur utilisateur) {
//		getUtilisateurs().remove(utilisateur);
//		utilisateur.setTypeUtilisateur(null);
//
//		return utilisateur;
//	}

}