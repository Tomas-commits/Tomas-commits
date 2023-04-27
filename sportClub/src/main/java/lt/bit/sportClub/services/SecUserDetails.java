package lt.bit.sportClub.services;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import lt.bit.sportClub.entities.Client;
import lt.bit.sportClub.entities.Registration;

@Service
public class SecUserDetails implements UserDetails{

	private Client client;
	
	public SecUserDetails() {
		
	}
	
	public SecUserDetails(Client client) {
		this.client=client;
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		HashSet<GrantedAuthority> auth=new HashSet<>();
		auth.add( new SimpleGrantedAuthority(this.client.getRole()));
		return auth;
	}

	@Override
	public String getPassword() {
		return this.client.getPassword();
	}

	@Override
	public String getUsername() {
		return this.client.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Client getClient() {
		return this.client;
	}

}
