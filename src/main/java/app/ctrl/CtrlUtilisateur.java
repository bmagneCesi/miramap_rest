package app.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.data.Utilisateur;

@RestController
public class CtrlUtilisateur {

    @RequestMapping("/utilisateur")
    public Utilisateur utilisateur(){
		return new Utilisateur();	
    }
}