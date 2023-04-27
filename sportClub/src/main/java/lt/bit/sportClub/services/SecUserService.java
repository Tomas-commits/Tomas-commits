package lt.bit.sportClub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lt.bit.sportClub.entities.Client;

@Service
public class SecUserService implements UserDetailsService {

	@Autowired
	ClientServices clientService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Client client=clientService.findByUsername(username);
		if (client==null) {
			throw new UsernameNotFoundException("User is not found");
		}
		return new SecUserDetails(client);
	}



}
