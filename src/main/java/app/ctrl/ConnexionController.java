package app.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.data.Utilisateur;

@Controller
public class ConnexionController {
	
    @RequestMapping(value="/connexion", method=RequestMethod.GET)
    public String connexionForm(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "connexion";
    }

    @RequestMapping(value="/connexion", method=RequestMethod.POST)
    public String connexionSubmit(@ModelAttribute Utilisateur utilisateur, Model model) {
//        model.addAttribute("utilisateur", utilisateur);
        Utilisateur res = new Utilisateur(utilisateur.getMail(),utilisateur.getPassword());
        model.addAttribute("utilisateur", res);
        return "resultConnexion";
    }
}
