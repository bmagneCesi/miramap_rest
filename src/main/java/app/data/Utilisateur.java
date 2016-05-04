package app.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import constante.BaseDeDonnees;

public class Utilisateur {
	private long id_employe;
	private String mail;
	private String password;
	private String nom;
	private String prenom;
	private Date date_naissance;
	private String civilite;
	private String adresse;
	private String telephone;
	private String nationalite;
	private long id_adresse;
	private long id_type_utilisateur;

	@Deprecated
	public Utilisateur(long id_employe, String mail, String password, String nom, String prenom, Date date_naissance,
			String civilite, String adresse, String telephone, String nationalite, long id_adresse,
			long id_type_utilisateur) {

		this.id_employe = id_employe;
		this.mail = mail;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.date_naissance = date_naissance;
		this.civilite = civilite;
		this.adresse = adresse;
		this.telephone = telephone;
		this.nationalite = nationalite;
		this.id_adresse = id_adresse;
		this.id_type_utilisateur = id_type_utilisateur;
	}

	public Utilisateur() {

		try {
			Connection conn = DriverManager.getConnection(BaseDeDonnees.URL.getBdd(), BaseDeDonnees.USER.getBdd(), BaseDeDonnees.PASSWD.getBdd());

			// Création d'un objet Statement
			Statement state = conn.createStatement();

			// TODO a finir
			// L'objet ResultSet contient le résultat de la requête SQL

			ResultSet result = state.executeQuery("SELECT * FROM Type_utilisateur;");

			result.next();
			result.next();

			this.id_employe = result.getLong("id_type_utilisateur");
			this.mail = "";
			this.password = "";
			this.nom = "";
			this.prenom = "";
			this.date_naissance = new Date();
			this.civilite = "";
			this.adresse = "";
			this.telephone = "";
			this.nationalite = "";
			this.id_adresse = 1;
			this.id_type_utilisateur = 1;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public long getId_employe() {
		return id_employe;
	}

	public String getMail() {
		return mail;
	}

	public String getPassword() {
		return password;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public Date getDate_naissance() {
		return date_naissance;
	}

	public String getCivilite() {
		return civilite;
	}

	public String getAdresse() {
		return adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public String getNationalite() {
		return nationalite;
	}

	public long getId_adresse() {
		return id_adresse;
	}

	public long getId_type_utilisateur() {
		return id_type_utilisateur;
	}

}
