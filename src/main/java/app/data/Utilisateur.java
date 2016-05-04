package app.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	private String telephone;
	private String nationalite;
	private long id_adresse;
	private long id_type_utilisateur;

	public Utilisateur(String mail, String password) {
		Connection conn;
		String  tmpMail;
		String  tmpPass;
		try {
			conn = DriverManager.getConnection(BaseDeDonnees.URL.getBdd(), BaseDeDonnees.USER.getBdd(),
					BaseDeDonnees.PASSWD.getBdd());

			// Création d'un objet Statement
			Statement state = conn.createStatement();

			// TODO a finir
			// L'objet ResultSet contient le résultat de la requête SQL

			ResultSet result = state.executeQuery("SELECT * FROM Utilisateur;");
			while (result.next()) {
				tmpMail = result.getString("mail");
				tmpPass = result.getString("password");
				if (password.equals(tmpPass) && mail.equals(tmpMail)) {
					this.id_employe = result.getLong("id_employe");
					this.mail = mail;
					this.password = password;
					this.nom = result.getString("nom");
					this.prenom = result.getString("prenom");
					this.date_naissance = result.getDate("date_naissance");
					this.civilite = result.getString("civilite");
					this.telephone = result.getString("telephone");
					this.nationalite = result.getString("nationalite");
					this.id_adresse = result.getLong("id_adresse");
					this.id_type_utilisateur = result.getLong("id_type_utilisateur");
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Utilisateur() {
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

	public void setId_employe(long id_employe) {
		this.id_employe = id_employe;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setDate_naissance(String date_naissance) {
		SimpleDateFormat formater = null;
		formater = new SimpleDateFormat("dd/MM/yy");
		try {
			this.date_naissance = formater.parse(date_naissance);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public void setId_adresse(long id_adresse) {
		this.id_adresse = id_adresse;
	}

	public void setId_type_utilisateur(long id_type_utilisateur) {
		this.id_type_utilisateur = id_type_utilisateur;
	}

}
