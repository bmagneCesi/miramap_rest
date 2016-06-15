package app.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;

import app.data.Utilisateur;
import app.services.ConnexionService;

@Controller
public class Connexion extends AbstractController{

	private ConnexionService connexionService;

//	@CrossOrigin(origins = "http://localhost:8888")
	@RequestMapping(value = "/connexion", method = RequestMethod.POST)
	public  @ResponseBody String connexionSubmit() {
		return "{\"message\":\"Created New User\"}";

	}
	
//	@CrossOrigin(origins = "http://localhost:8888")
//	@RequestMapping(value = "/connexion", method = RequestMethod.POST)
//	public String connexionSubmit(@ModelAttribute Utilisateur utilisateur, Model model) {
//		this.connexionService = new ConnexionService();
//		Utilisateur res = connexionService.connexion(utilisateur);
//		if (res == null)
//			return "Error";
//		model.addAttribute("utilisateur", res);
//		try {
//			System.out.println("okydoky");
//			return this.mapper.writeValueAsString(res);
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//			return "Json processing Exception";
//		}
//	}
	
	@RequestMapping(value = "/connexion", method = RequestMethod.GET)
    public  @ResponseBody String getAllUsers( ModelMap model ) {

        String jsonData = "[{\"id\":\"3253123\",\"firstname\":\"Chris\",\"lastname\":\"Johnson\",\"address\":\"211, Geoffrey Drive\",\"city\":\"Newark\",\"phone\":\"999-888-6666\",\"email\":\"chrisj@yahoo.com\"},{\"id\":\"67643837\",\"firstname\":\"Bill\",\"lastname\":\"Derkson\",\"address\":\"201, Sleepy Hollow Drive\",\"city\":\"Newark\",\"phone\":\"999-777-2222\",\"email\":\"billd@gmail.com\"}]";

        return jsonData;

    }

//	@RequestMapping(value = "/connexion", method = RequestMethod.GET)
//	public String connexionForm(Model model) {
//		model.addAttribute("utilisateur", new Utilisateur());
//		return "connexion";
//	}
}
