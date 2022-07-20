import java.util.Date;

public class Player {
	private int id;
	private String name;
	private String nationality;
	private Date birthdate;
	private int titles;
	public Player(int id, String name, String nationality, Date birthdate, int titles) {
		super();
		this.id = id;
		this.name = name;
		this.nationality = nationality;
		this.birthdate = birthdate;
		this.titles = titles;
	}
	
	public Player() {
		super();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getNationality() {
		return nationality;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public int getTitles() {
		return titles;
	}
	
	

}
