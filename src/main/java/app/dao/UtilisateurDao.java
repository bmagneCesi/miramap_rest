package app.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import app.data.Utilisateur;
import app.data.made.UtilisateurMade;
import constante.BaseDeDonnees;

public class UtilisateurDao extends GenericDao{
	
	public UtilisateurDao(){
		this.table = "Utilisateur";
	}

	public Utilisateur is(Utilisateur utilisateur) {
		String tmpMail;
		String tmpPass;
		Utilisateur res = null;
		try {
			// Création d'un objet Statement
			Statement state = (Statement) this.conn.createStatement();

			// L'objet ResultSet contient le résultat de la requête SQL
			ResultSet utilisateurs = state.executeQuery("SELECT * FROM Utilisateur;");
			while (utilisateurs.next()) {
				tmpMail = utilisateurs.getString("mail");
				tmpPass = utilisateurs.getString("password");
				if (utilisateur.getPassword().equals(tmpPass) && utilisateur.getMail().equals(tmpMail)) {
					res = new Utilisateur();
					// ResultSet adresse = state.executeQuery("SELECT A.adresse
					// AS adresse, V.code_postal AS code_postal, V.libelle AS
					// ville, R.libelle AS region FROM Adresse AS A, Ville AS V,
					// Region AS R WHERE A.id_adresse = " +
					// utilisateur.getLong("id_adresse") + " AND A.id_ville =
					// V.id_ville AND V.id_region = R.id_region ;");
					// ResultSet typeUtilisateur = state.executeQuery("SELECT
					// T.libelle AS type_utilisateur FROM Type_utilisateur AS T
					// WHERE T.id_type_utilisateur = " +
					// utilisateur.getLong("id_type_utilisateur") + " ;");
					res.setIdEmploye(utilisateurs.getInt("id_employe"));
					res.setMail(utilisateur.getMail());
					res.setPassword(utilisateur.getPassword());
					res.setNom(utilisateurs.getString("nom"));
					res.setPrenom(utilisateurs.getString("prenom"));
					res.setDateNaissance(utilisateurs.getDate("date_naissance"));
					res.setCivilite(utilisateurs.getString("civilite"));
					res.setTelephone(utilisateurs.getString("telephone"));
					res.setNationalite(utilisateurs.getString("nationalite"));
					res.setIdAdresse(utilisateurs.getInt("id_adresse"));
					res.setIdTypeUtilisateur(utilisateurs.getInt("id_type_utilisateur"));
					// this.adresse = adresse.getString("adresse");
					// this.code_postal = adresse.getString("code_postal");
					// this.ville = adresse.getString("ville");
					// this.region = adresse.getString("region");
					// this.type_utilisateur =
					// typeUtilisateur.getString("type_utilisateur");
					break;
				}

			}
			this.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}

	/**
	 * 
	 * @return true si l'utilisateur est valide et donc inserer en base, false
	 *         sinon
	 */
	public boolean inscription(UtilisateurMade util) {
		SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
		String date = "\'" + formater.format(util.getDateNaissance()) + "\'";
		try {
			this.conn = (Connection) DriverManager.getConnection(BaseDeDonnees.URL.getBdd(),
					BaseDeDonnees.USER.getBdd(), BaseDeDonnees.PASSWD.getBdd());

			// Création d'un objet Statement
			Statement state = (Statement) this.conn.createStatement();

			// L'objet ResultSet contient le résultat de la requête SQL
			ResultSet doublon = state
					.executeQuery("SELECT id_employe FROM Utilisateur WHERE mail = " + util.getMail() + " ;");
			ResultSet region;
			ResultSet ville;
			ResultSet adresse;
			ResultSet typeUtilisateur;
			@SuppressWarnings("unused")
			ResultSet utilisateur;
			// verifie que l'utilisateur n'existe pas
			if (doublon.next())
				return false;
			else {

				typeUtilisateur = state.executeQuery(
						"SELECT * FROM Type_utilisateur WHERE libelle = " + util.getType_utilisateur() + ";");
				if (!typeUtilisateur.next())
					return false;
				typeUtilisateur.next();

				// verifie la region et le rentre en base en cas de besoin
				region = state.executeQuery("SELECT * FROM Region WHERE libelle = " + util.getRegion() + " ;");
				if (!region.next()) {
					region = state.executeQuery("INSERT INTO Region(libelle) VALUES(\"" + util.getRegion() + "\");");
					region = state.executeQuery("SELECT * FROM Region WHERE libelle = " + util.getRegion() + " ;");
				}
				region.next();

				ville = state.executeQuery("SELECT * FROM Ville WHERE code_postal = " + util.getCode_postal()
						+ ", libelle = " + util.getVille() + ", id_region = " + region.getLong("id_region") + ";");
				if (!ville.next()) {
					ville = state.executeQuery(
							"INSERT INTO Ville(code_postal, libelle, id_region) VALUES(\"" + util.getCode_postal()
									+ "\",\"" + util.getVille() + "\",\"" + region.getLong("id_region") + "\" );");
					ville = state.executeQuery("SELECT * FROM Ville WHERE code_postal = " + util.getCode_postal()
							+ ", libelle = " + util.getVille() + ", id_region = " + region.getLong("id_region") + ";");
				}
				ville.next();

				adresse = state.executeQuery("SELECT * FROM Adresse WHERE adresse = " + util.getAdresse()
						+ ", id_ville = " + ville.getLong("id_ville") + ";");
				if (!adresse.next()) {
					adresse = state.executeQuery("INSERT INTO Adresse(adresse, id_ville) VALUES(\"" + util.getAdresse()
							+ "\",\"" + ville.getLong("id_ville") + "\");");
					adresse = state.executeQuery("SELECT * FROM Adresse WHERE adresse = " + util.getAdresse()
							+ ", id_ville = " + ville.getLong("id_ville") + ";");
				}
				adresse.next();

				utilisateur = state.executeQuery(
						"INSERT INTO Utilisateur(mail,password,nom,prenom,date_naissance,civilite,telephone,nationalite,id_adresse,id_type_utilisateur) "
								+ "VALUES(\"" + util.getMail() + "\" ,\"" + util.getPassword() + "\" ,\""
								+ util.getNom() + "\",\"" + util.getPrenom() + "\",\"" + date + "\",\""
								+ util.getCivilite() + "\",\"" + util.getTelephone() + "\",\"" + util.getNationalite()
								+ "\",\"" + adresse.getLong("id_adresse") + "\",\""
								+ typeUtilisateur.getLong("id_type_utilisateur") + "\";");
			}
			this.conn.close();
		} catch (SQLException e) {
			try {
				this.conn.rollback();
				this.conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
