package lt.bit.sportClub.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "clients")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	@NotEmpty
	@Size(min=3, max=20)
	private String name;
	
	@Column
	@NotEmpty
	@Size(min=3, max=25)
	private String surname;
	
	@Column
	@NotEmpty
	@Email
	private String email;
	
	@Column
	@Size(max=15)
	private String phone;
	
	@Column(nullable = false, unique = true)
	@NotEmpty
	private String username;
	
	@Column(nullable = false)
	@NotEmpty
	private String password;
	
	@Column(nullable = false)
	@NotEmpty
	private String role="user";
	
	@OneToMany (mappedBy = "client")
	private List<Registration> registrations;
	
	
	public Client() {
	
	}
	
	
	public Client(String name, String surname, String email, String phone) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
	}


	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
	
}
