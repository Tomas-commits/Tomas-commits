package lt.bit.sportClub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import lt.bit.sportClub.entities.Client;
import lt.bit.sportClub.entities.Registration;
import lt.bit.sportClub.entities.Workout;
import lt.bit.sportClub.repositories.ClientRepository;
import lt.bit.sportClub.repositories.RegistrationRepository;
import lt.bit.sportClub.repositories.WorkoutRepository;

@Service
public class RegistrationService {
	
	@Autowired
	RegistrationRepository registrationRepository;
	
	@Autowired
	WorkoutRepository workoutRepository;
	
	@Autowired
	ClientRepository clientRepository;
	


	public List<Registration> getMyRegistrations(){
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		if (auth==null) return null;
		SecUserDetails secUser=(SecUserDetails)auth.getPrincipal();
		return registrationRepository.findByClientId(secUser.getClient().getId());
	}
	
	public Registration newRegistration(Integer workoutId) {		
		Registration registration=new Registration();
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		if (auth==null) return null;
		SecUserDetails secUser=(SecUserDetails)auth.getPrincipal();
		long millis=System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		registration.setRegistrationDate(date);
		registration.setClient(clientRepository.getById(secUser.getClient().getId()));
		registration.setWorkout(workoutRepository.getById(workoutId));
		return registrationRepository.save(registration);
	}
	
	public void removeRegistration(Integer id) {
		registrationRepository.deleteById(id);
	}

	
}
