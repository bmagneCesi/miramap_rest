package app.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.data.Utilisateur;

@Controller
public class UtilisateurController {

//	@RequestMapping(value = "/connexion", method = RequestMethod.POST)
//	public String connexionSubmit(@ModelAttribute Utilisateur utilisateur, Model model) {
//		// model.addAttribute("utilisateur", utilisateur);
//		Utilisateur res = new Utilisateur(utilisateur.getMail(), utilisateur.getPassword());
//		model.addAttribute("utilisateur", res);
//		if (res.getId_employe() == -1)
//			return "resultConnexionFail";
//		return "resultConnexion";
//	}
//	
//	@RequestMapping(value = "/connexion", method = RequestMethod.GET)
//	public String connexionForm(Model model) {
//		model.addAttribute("utilisateur", new Utilisateur());
//		return "connexion";
//	}




//	@RequestMapping(value = "/inscription", method = RequestMethod.POST)
//	public String inscriptionSubmit(@ModelAttribute Utilisateur utilisateur, Model model) {
//		model.addAttribute("utilisateur", utilisateur);
//		if (utilisateur.insert())
//			return "resultInscription";
//		return "resultInscriptionFail";
//	}
//	
//	@RequestMapping(value = "/inscription", method = RequestMethod.GET)
//	public String inscriptionForm(Model model) {
//		model.addAttribute("utilisateur", new Utilisateur());
//		return "inscription";
//	}
}