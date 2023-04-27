package lt.bit.sportClub.classes;

public class RezervedVacancies {
	private Integer id;
	
	private String name;
	
	private long rezerved;
	
	private Integer open;
	
	public RezervedVacancies() {		

	}	
	
	

	public RezervedVacancies(Integer id, String name, long rezerved, Integer open) {
		super();
		this.id = id;
		this.name = name;
		this.rezerved = rezerved;
		this.open = open;
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
	
	public long getRezerved() {
		return rezerved;
	}

	public void setRezerved(Integer rezerved) {
		this.rezerved = rezerved;
	}

	
	public Integer getOpen() {
		return open;
	}

	public void setOpen(Integer open) {
		this.open = open;
	}

	@Override
	public String toString() {
		return "RezervedVacancies [id=" + id + ", name=" + name + ", rezerved=" + rezerved + "]";
	}

	public Integer left () {
		return (int) (this.open - this.rezerved);
	}
	

}
