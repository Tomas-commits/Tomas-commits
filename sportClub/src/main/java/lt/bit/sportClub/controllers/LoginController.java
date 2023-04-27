package lt.bit.sportClub.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.jaas.SecurityContextLoginModule;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lt.bit.sportClub.entities.Client;
import lt.bit.sportClub.services.ClientServices;

@Controller
public class LoginController {
	
	@Autowired
	private ClientServices clientServices;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("isError", true);
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logOut(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth= SecurityContextHolder.getContext().getAuthentication();
		if (auth!=null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login";
	}
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("client", new Client());
		return "register";
	}
	
	@PostMapping("/register")
	public String onRegister(@Valid @ModelAttribute Client client, HttpServletRequest request, BindingResult result, Model model) throws ServletException {
		if (result.hasErrors()) {
			return "register";
		}
		String password=client.getPassword();
		clientServices.addClient(client);
		
		request.login(client.getUsername(), password);
		return "redirect:/";
		
	    model.addAttribute("isRegistred", true);
		return this.login();
	}
	
	
}
