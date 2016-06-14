package app.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import app.services.ConnexionService;

@Controller
public class Connexion {

	private ConnexionService connexionService;

	@RequestMapping(value = "/connexion", method = RequestMethod.POST)
//	public Utilisateur connexionSubmit(@ModelAttribute Utilisateur utilisateur, Model model) {
	public  @ResponseBody String connexionSubmit() {
		return "{\"message\":\"Created New User\"}";
//		this.connexionService = new ConnexionService();
//		Utilisateur res = connexionService.connexion(utilisateur);
//		if (res == null)
//			return res;
//		model.addAttribute("utilisateur", res);
//		return res;
	}
	@RequestMapping(value = "/connexion", method = RequestMethod.GET)
    public  @ResponseBody String getAllUsers( ModelMap model ) {

        String jsonData = "[{\"id\":\"3253123\",\"firstname\":\"Chris\",\"lastname\":\"Johnson\",\"address\":\"211, Geoffrey Drive\",\"city\":\"Newark\",\"phone\":\"999-888-6666\",\"email\":\"chrisj@yahoo.com\"},{\"id\":\"67643837\",\"firstname\":\"Bill\",\"lastname\":\"Derkson\",\"address\":\"201, Sleepy Hollow Drive\",\"city\":\"Newark\",\"phone\":\"999-777-2222\",\"email\":\"billd@gmail.com\"}]";

        return jsonData;

    }
	
//	@RequestMapping(value = "/connexion", method = RequestMethod.POST)  
//
//    public  @ResponseBody String createNewUser()   {        
//
//        //
//
//        // Code processing the input parameters
//
//        //    
//
//         String response = "{\"message\":\"Created New User - firstname: , lastname: }";
//
//        return response;
//
//    }

//	@RequestMapping(value = "/connexion", method = RequestMethod.GET)
//	public String connexionForm(Model model) {
//		model.addAttribute("utilisateur", new Utilisateur());
//		return "connexion";
//	}
}
