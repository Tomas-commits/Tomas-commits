package lt.bit.sportClub.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lt.bit.sportClub.services.SecUserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	SecUserService userService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.inMemoryAuthentication()
		.withUser("user").password((new BCryptPasswordEncoder()).encode("user")).roles("user")
			.and()
			.withUser("admin").password((new BCryptPasswordEncoder()).encode("admin")).roles("user","admin");
		auth
		.userDetailsService(userService)
		.passwordEncoder(passwordEncoder());
		
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.authorizeRequests()
				.antMatchers("/newClient").hasAuthority("admin")
				.antMatchers("/updateClient").hasAuthority("admin")
				.antMatchers("/deleteClient").hasAuthority("admin")
				
				.antMatchers("/files*").permitAll()
				.antMatchers("/css/*").permitAll()
				.antMatchers("/login*").permitAll()
				.antMatchers("/register*").permitAll()
				.anyRequest().authenticated()
		
		.and()
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login")
		.and()	
			.formLogin()
				.loginPage("/login")
				.failureUrl("/login-error");
		
			
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
