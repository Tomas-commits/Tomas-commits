package lt.bit.sportClub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lt.bit.sportClub.classes.RezervedVacancies;
import lt.bit.sportClub.entities.Client;
import lt.bit.sportClub.repositories.ClientRepository;

@Service
public class ClientServices {
	
	@Autowired
	ClientRepository clientRepository;
	
	public List<Client> getClients(){
		return clientRepository.findAll();
	}
	
	public Client findByUsername(String username) {
		return clientRepository.findByUsername(username);
	}

	
	public Client addClient(Client client) {
		client.setPassword( (new BCryptPasswordEncoder()).encode(client.getPassword()));
		return clientRepository.save(client);
	}
	
	public Client getClientById(Integer id) {
		return clientRepository.findById(id).orElse(null);
	}
	
	public Client updateClient(Client client) {
		Client old=this.getClientById(client.getId());
		old.setName(client.getName());
		
		old.setSurname(client.getSurname());
		old.setPhone(client.getPhone());
		old.setEmail(client.getEmail());
		old.setUsername(client.getUsername());
		old.setRole(client.getRole());
		old.setPassword( (new BCryptPasswordEncoder()).encode(client.getPassword()));
		clientRepository.save(old);
		return old;
	}
	
	public void deleteClient(Integer id) {
		clientRepository.deleteById(id);
	}
	
	public List<RezervedVacancies> rezervedVacancies(){
		return clientRepository.rezervedVacancies();
	} 
	
	
}
