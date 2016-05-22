package app.data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Adresse database table.
 * 
 */
@Entity
@NamedQuery(name="Adresse.findAll", query="SELECT a FROM Adresse a")
public class Adresse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_adresse")
	private int idAdresse;

	private String adresse;

	//bi-directional many-to-one association to Ville
	@ManyToOne
	@JoinColumn(name="id_ville")
	private Ville ville;

	//bi-directional many-to-one association to Utilisateur
//	@OneToMany(mappedBy="adresse")
//	private List<Utilisateur> utilisateurs;

	public Adresse() {
	}

	public int getIdAdresse() {
		return this.idAdresse;
	}

	public void setIdAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Ville getVille() {
		return this.ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

//	public List<Utilisateur> getUtilisateurs() {
//		return this.utilisateurs;
//	}
//
//	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
//		this.utilisateurs = utilisateurs;
//	}
//
//	public Utilisateur addUtilisateur(Utilisateur utilisateur) {
//		getUtilisateurs().add(utilisateur);
//		utilisateur.setAdresse(this);
//
//		return utilisateur;
//	}
//
//	public Utilisateur removeUtilisateur(Utilisateur utilisateur) {
//		getUtilisateurs().remove(utilisateur);
//		utilisateur.setAdresse(null);
//
//		return utilisateur;
//	}

}