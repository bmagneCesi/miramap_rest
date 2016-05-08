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

	private long id_employe = -1;
	private String mail;
	private String password;
	private String nom;
	private String prenom;
	private Date date_naissance;
	private String civilite;
	private String telephone;
	private String nationalite;
	private String adresse;
	private String code_postal;
	private String ville;
	private String region;
	private String type_utilisateur;

	/**
	 * constructeur permetant la verification de l'utilisateur en base de
	 * donné"s
	 * 
	 * @param mail
	 * @param password
	 */
	public Utilisateur(String mail, String password) {
		Connection conn;
		String tmpMail;
		String tmpPass;
		try {
			conn = DriverManager.getConnection(BaseDeDonnees.URL.getBdd(), BaseDeDonnees.USER.getBdd(),
					BaseDeDonnees.PASSWD.getBdd());

			// Création d'un objet Statement
			Statement state = conn.createStatement();

			// L'objet ResultSet contient le résultat de la requête SQL
			ResultSet utilisateur = state.executeQuery("SELECT * FROM Utilisateur;");
			while (utilisateur.next()) {
				tmpMail = utilisateur.getString("mail");
				tmpPass = utilisateur.getString("password");
				if (password.equals(tmpPass) && mail.equals(tmpMail)) {
					ResultSet adresse = state.executeQuery("SELECT A.adresse AS adresse, V.code_postal AS code_postal, V.libelle AS ville, R.libelle AS region FROM Adresse AS A, Ville AS V, Region AS R WHERE A.id_adresse = " + utilisateur.getLong("id_adresse") + " AND A.id_ville = V.id_ville AND V.id_region = R.id_region ;");
					ResultSet typeUtilisateur = state.executeQuery("SELECT T.libelle AS type_utilisateur FROM Type_utilisateur AS T WHERE T.id_type_utilisateur = " + utilisateur.getLong("id_type_utilisateur") + " ;");
					this.id_employe = utilisateur.getLong("id_employe");
					this.mail = mail;
					this.password = password;
					this.nom = utilisateur.getString("nom");
					this.prenom = utilisateur.getString("prenom");
					this.date_naissance = utilisateur.getDate("date_naissance");
					this.civilite = utilisateur.getString("civilite");
					this.telephone = utilisateur.getString("telephone");
					this.nationalite = utilisateur.getString("nationalite");
					this.adresse = adresse.getString("adresse");
					this.code_postal = adresse.getString("code_postal");
					this.ville = adresse.getString("ville");
					this.region = adresse.getString("region");
					this.type_utilisateur = typeUtilisateur.getString("type_utilisateur");
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Utilisateur() {
	}

	/**
	 * 
	 * @return true si l'utilisateur est valide et donc inserer en base, false sinon
	 */
	public boolean insert() {
		Connection conn;
		SimpleDateFormat  formater = new SimpleDateFormat("yyyy/MM/dd");
		System.out.println(this.date_naissance);
		String date = "\'" + formater.format(this.date_naissance) + "\'";
		try {
			conn = DriverManager.getConnection(BaseDeDonnees.URL.getBdd(), BaseDeDonnees.USER.getBdd(),
					BaseDeDonnees.PASSWD.getBdd());

			// Création d'un objet Statement
			Statement state = conn.createStatement();

			// L'objet ResultSet contient le résultat de la requête SQL
			ResultSet doublon = state.executeQuery("SELECT id_employe FROM Utilisateur WHERE mail = " + this.mail + " ;");
			ResultSet region;
			ResultSet ville;
			ResultSet adresse;
			ResultSet typeUtilisateur;
			ResultSet utilisateur;
			//verifie que l'utilisateur n'existe pas
			if(doublon.next())
				return false;
			else{
				
				typeUtilisateur = state.executeQuery("SELECT * FROM Type_utilisateur WHERE libelle = " +this.type_utilisateur+ ";");
				if(!typeUtilisateur.next())
					return false;
				typeUtilisateur.next();
				
				// verifie la region et le rentre en base en cas de besoin
				region = state.executeQuery("SELECT * FROM Region WHERE libelle = " + this.region + " ;");
				if(!region.next()){
					region = state.executeQuery("INSERT INTO Region(libelle) VALUES(\"" + this.region + "\");");
					region = state.executeQuery("SELECT * FROM Region WHERE libelle = " + this.region + " ;");
				}
				region.next();
				
				ville = state.executeQuery("SELECT * FROM Ville WHERE code_postal = " + this.code_postal + ", libelle = " + this.ville + ", id_region = " + region.getLong("id_region") + ";");
				if(!ville.next()){
					ville = state.executeQuery("INSERT INTO Ville(code_postal, libelle, id_region) VALUES(\"" + this.code_postal + "\",\"" + this.ville + "\",\"" + region.getLong("id_region") + "\" );");
					ville = state.executeQuery("SELECT * FROM Ville WHERE code_postal = " + this.code_postal + ", libelle = " + this.ville + ", id_region = " + region.getLong("id_region") + ";");
				}
				ville.next();
				
				adresse = state.executeQuery("SELECT * FROM Adresse WHERE adresse = " +this.adresse+ ", id_ville = " + ville.getLong("id_ville") + ";");
				if(!adresse.next()){
					adresse = state.executeQuery("INSERT INTO Adresse(adresse, id_ville) VALUES(\"" + this.adresse + "\",\"" + ville.getLong("id_ville") + "\");");
					adresse = state.executeQuery("SELECT * FROM Adresse WHERE adresse = " +this.adresse+ ", id_ville = " + ville.getLong("id_ville") + ";");
				}
				adresse.next();

				utilisateur = state.executeQuery("INSERT INTO Utilisateur(mail,password,nom,prenom,date_naissance,civilite,telephone,nationalite,id_adresse,id_type_utilisateur) "
						+ "VALUES(\"" + this.mail + "\" ,\"" + this.password+ "\" ,\"" +this.nom + "\",\"" +this.prenom + "\",\"" + date + "\",\"" + this.civilite+ "\",\"" + this.telephone+ "\",\"" + this.nationalite+ "\",\"" + adresse.getLong("id_adresse")+ "\",\"" +typeUtilisateur.getLong("id_type_utilisateur") + "\";");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void setDate_naissance(String date_naissance) {
		SimpleDateFormat formater = null;
		formater = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.date_naissance = formater.parse(date_naissance);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public long getId_employe() {
		return id_employe;
	}

	public void setId_employe(long id_employe) {
		this.id_employe = id_employe;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDate_naissance() {
		return date_naissance;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

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
