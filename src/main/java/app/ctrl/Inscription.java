package app.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.data.Utilisateur;
import app.data.made.UtilisateurMade;
import app.services.ConnexionService;

@Controller
public class Inscription {
	private ConnexionService connexionService;
	
	@RequestMapping(value = "/inscription", method = RequestMethod.POST)
	public String inscriptionSubmit(@ModelAttribute UtilisateurMade utilisateur, Model model) {
		this.connexionService = new ConnexionService();
		Utilisateur res = connexionService.inscription(utilisateur);
		if (res == null)
			return "resultInscriptionFail";
		model.addAttribute("utilisateur", res);
		return "resultInscription";
	}
	
	@RequestMapping(value = "/inscription", method = RequestMethod.GET)
	public String inscriptionForm(Model model) {
		model.addAttribute("utilisateur", new UtilisateurMade());
		return "inscription";
	}
}
