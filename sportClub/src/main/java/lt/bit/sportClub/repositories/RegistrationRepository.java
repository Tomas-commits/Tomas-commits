package lt.bit.sportClub.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.bit.sportClub.entities.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Integer>{
	List<Registration> findByClientId(Integer clientId);


}
