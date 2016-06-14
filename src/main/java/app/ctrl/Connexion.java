package app.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.data.Utilisateur;
import app.services.ConnexionService;

@Controller
public class Connexion {

	private ConnexionService connexionService;

	@RequestMapping(value = "/connexion", method = RequestMethod.POST, produces = "application/json")
	public Utilisateur connexionSubmit(@ModelAttribute Utilisateur utilisateur, Model model) {
		this.connexionService = new ConnexionService();
		Utilisateur res = connexionService.connexion(utilisateur);
//		if (res == null)
//			return res;
		model.addAttribute("utilisateur", res);
		return res;
	}

	@RequestMapping(value = "/connexion", method = RequestMethod.GET)
	public String connexionForm(Model model) {
		model.addAttribute("utilisateur", new Utilisateur());
		return "connexion";
	}
}
