package lt.bit.sportClub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.bit.sportClub.entities.Workout;
import lt.bit.sportClub.repositories.WorkoutRepository;

@Service
public class WorkoutService {
	
	@Autowired
	WorkoutRepository workoutrepository;
	
	public List<Workout> getWorkouts(){
		return workoutrepository.findAll();
	}

}
