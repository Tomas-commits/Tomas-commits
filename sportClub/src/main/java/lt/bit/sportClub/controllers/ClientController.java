package lt.bit.sportClub.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lt.bit.sportClub.classes.RezervedVacancies;
import lt.bit.sportClub.entities.Client;
import lt.bit.sportClub.services.ClientServices;

@Controller
public class ClientController {
	
	@Autowired
	ClientServices clientservice;
	
	@GetMapping("/")
	public String clients(Model model) {
		model.addAttribute("clients", clientservice.getClients());
		return "clients";
	}
	
	@GetMapping("/newClient")
	public String newClient(Model model) {
		model.addAttribute("client", new Client());
		return "client_new";
	}
	
	@PostMapping("/newClient")
	public String saveClient(@Valid @ModelAttribute Client client, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "client_new";
		}
		clientservice.addClient(client);		
		return "redirect:/";
	}
	@GetMapping("/updateClient")
	public String showClient(@RequestParam("id") Integer id, Model model) {
		model.addAttribute("client", clientservice.getClientById(id));
		return "client_update";
	}
	
	@PostMapping("/updateClient")
	public String updateClient(@Valid @ModelAttribute Client client, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "client_update";
		}
		clientservice.updateClient(client);
		return "redirect:/";
	}
	
	@GetMapping("/deleteClient")
	public String deleteClient (@RequestParam("id")Integer id) {
		clientservice.deleteClient(id);
		return "redirect:/";
	}
	
	
	
	

}
