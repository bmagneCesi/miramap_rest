package app.services;

import app.dao.UtilisateurDao;
import app.data.Utilisateur;
import app.data.made.UtilisateurMade;

public class ConnexionService {

	public Utilisateur connexion(Utilisateur utilisateur) {
		// this.entityManager =
		// Persistence.createEntityManagerFactory("colibri").createEntityManager();
		UtilisateurDao utilisateurDao = new UtilisateurDao();
		Utilisateur tmp = new Utilisateur();
		tmp.setMail(utilisateur.getMail());
		tmp.setPassword(utilisateur.getPassword());
		return utilisateurDao.is(tmp);
	}

	public Utilisateur inscription(UtilisateurMade utilisateur) {
		UtilisateurDao utilisateurDao = new UtilisateurDao();
		boolean b = utilisateurDao.inscription(utilisateur);
		if(b == true)
			return this.connexion(utilisateur);
		return null;
	}

}
