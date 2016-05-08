package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import constante.BaseDeDonnees;

public class tmp {

	public static void main(String[] args) {
		Connection conn;
			try {
				conn = DriverManager.getConnection(BaseDeDonnees.URL.getBdd(), BaseDeDonnees.USER.getBdd(),
						BaseDeDonnees.PASSWD.getBdd());


			// Création d'un objet Statement
			Statement state = conn.createStatement();

			// L'objet ResultSet contient le résultat de la requête SQL
			ResultSet doublon = state.executeQuery("SELECT libelle FROM Type_utilisateur;");
			while(doublon.next()){
				System.out.println(doublon.getString("libelle"));
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
