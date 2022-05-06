package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subjects {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String aihealue;
	
	//CONSTRUCTORIT
	
	public Subjects() {
		super();
	}
	public Subjects(int id, String aihealue) {
		super();
		this.id = id;
		this.aihealue = aihealue;
	}
	
	//GETTERIT JA SETTERIT
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setId(String id) {
		try {
			this.id = Integer.parseInt(id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}
	public String getAihealue() {
		return aihealue;
	}
	public void setAihealue(String aihealue) {
		this.aihealue = aihealue;
	}
	
	
}
