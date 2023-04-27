package lt.bit.sportClub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lt.bit.sportClub.services.ClientServices;
import lt.bit.sportClub.services.WorkoutService;
import lt.bit.sportClub.classes.RezervedVacancies;

@Controller
public class WorkoutController {

	RezervedVacancies rezervedVacancies;

	@Autowired
	WorkoutService workoutService;
	
	@Autowired
	ClientServices clientservice;
	
	
	
	@GetMapping ("/workout")
	public String clients(Model model) {
		model.addAttribute("workouts", workoutService.getWorkouts());
		model.addAttribute("Vacancies", clientservice.rezervedVacancies());
		
		
		return "workouts";
		
	}
	
	
	
}

