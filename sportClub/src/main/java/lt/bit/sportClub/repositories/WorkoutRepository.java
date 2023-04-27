package lt.bit.sportClub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.bit.sportClub.entities.Workout;

public interface WorkoutRepository extends JpaRepository<Workout, Integer>{

}
