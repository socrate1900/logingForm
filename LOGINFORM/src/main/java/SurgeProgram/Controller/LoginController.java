
package SurgeProgram.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import SurgeProgram.Form.LoginForm;

@Controller
public class LoginController {

	// To get login page
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginForm() {
		
		// here I return html name
		return "login";
	}

	// Here I am checking for login credentials
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {
		
		if (loginForm.getUsername().equals("demo") && loginForm.getPassword().equals("demo")) {
			
		// if username and password is correct , we are returning home page
			return "home";
		}
		
		// if username or password is wrong
		model.addAttribute("invalidCredentials", true);

		// returning again logain page
		return "login";
	}
}


