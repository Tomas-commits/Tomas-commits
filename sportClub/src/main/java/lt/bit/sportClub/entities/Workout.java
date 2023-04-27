package lt.bit.sportClub.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "workouts")
public class Workout {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private Date date;
	
	@Column
	private Integer vacancies;
	
	@Column
	private String location;
	
	private Integer leftVacancies;
	
	@OneToMany(mappedBy = "workout")
	private List<Registration> registrations;

	public Workout() {
		
	}
	
	public Workout(String name, Date date, Integer vacancies, String location) {
		this.name = name;
		this.date = date;
		this.vacancies = vacancies;
		this.location = location;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getVacancies() {
		return vacancies;
	}

	public void setVacancies(Integer vacancies) {
		this.vacancies = vacancies;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getLeftVacancies() {
		return leftVacancies;
	}

	public void setLeftVacancies(Integer leftVacancies) {
		this.leftVacancies = leftVacancies;
	}
	

	
	

}
