package app.data.made;

import javax.persistence.Entity;

import app.data.Utilisateur;
@Entity
public class UtilisateurMade extends Utilisateur {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String adresse;
	private String code_postal;
	private String ville;
	private String region;
	private String type_utilisateur;
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCode_postal() {
		return code_postal;
	}
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getType_utilisateur() {
		return type_utilisateur;
	}
	public void setType_utilisateur(String type_utilisateur) {
		this.type_utilisateur = type_utilisateur;
	}
	

}
