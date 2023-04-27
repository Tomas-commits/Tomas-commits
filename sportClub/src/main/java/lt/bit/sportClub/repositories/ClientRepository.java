package lt.bit.sportClub.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import lt.bit.sportClub.classes.RezervedVacancies;
import lt.bit.sportClub.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{
	Client findByUsername(String username);

    @Query("SELECT new lt.bit.sportClub.classes.RezervedVacancies(w.id, w.name, count(*), w.vacancies) FROM Workout w JOIN w.registrations GROUP BY w")
	List<RezervedVacancies> rezervedVacancies();
	
}
