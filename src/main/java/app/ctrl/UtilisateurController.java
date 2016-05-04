package app.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.data.Utilisateur;

@Controller
public class UtilisateurController {

    @RequestMapping(value="/utilisateur", method=RequestMethod.GET)
    public String utilisateurForm(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "utilisateur";
    }

    @RequestMapping(value="/utilisateur", method=RequestMethod.POST)
    public String utilisateurSubmit(@ModelAttribute Utilisateur utilisateur, Model model) {
        model.addAttribute("utilisateur", utilisateur);
        return "resultUtilisateur";
    }
}