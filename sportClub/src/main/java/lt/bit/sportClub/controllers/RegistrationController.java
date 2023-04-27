package lt.bit.sportClub.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lt.bit.sportClub.entities.Registration;
import lt.bit.sportClub.entities.Workout;
import lt.bit.sportClub.services.ClientServices;
import lt.bit.sportClub.services.RegistrationService;
import lt.bit.sportClub.services.WorkoutService;

@Controller
public class RegistrationController {

	@Autowired
	RegistrationService registrationService;
	
	@Autowired
	WorkoutService workoutService;
	
	@Autowired
	ClientServices clientservice;
	
	@GetMapping("/registrations")
	public String registrations(Model model, Authentication auth) {
			model.addAttribute("registrations", registrationService.getMyRegistrations());		
		return "registrations";
	}
	
	@GetMapping ("/workoutRegistration")
	public String clients(Model model) {
		model.addAttribute("workouts", workoutService.getWorkouts());
		model.addAttribute("registrations", registrationService.getMyRegistrations());
		return "workout_registration";
		
	}
	
	@PostMapping("/newRegistration")
	public String newRegistration(@RequestParam("workoutId") Integer id, Model model) {
		registrationService.newRegistration(id);
		return "redirect:/registrations";
	}
	
	@GetMapping("/removeRegistration")
	public String removeRegistration (@RequestParam("id")Integer id) {
		registrationService.removeRegistration(id);
		return "redirect:/registrations";
	}
	
}
