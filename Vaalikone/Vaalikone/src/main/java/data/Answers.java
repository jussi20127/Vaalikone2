package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Answers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int kysymys_id;
	private int ehdokas_id;
	private int vastaus;
	private int aihealue_id;
	
	
	// CONSTRUCTORIT
	public Answers() {
		super();
	}
	public Answers(int id, int kysymys_id, int ehdokas_id, int vastaus, int aihealue_id) {
		super();
		this.id = id;
		this.kysymys_id = kysymys_id;
		this.ehdokas_id = ehdokas_id;
		this.vastaus = vastaus;
		this.aihealue_id = aihealue_id;
	}
	
	// GETTERIT JA SETTERIT
	
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
	public int getKysymys_Id() {
		return kysymys_id;
	}
	public void setKysymys_Id(int kysymys_id) {
		this.kysymys_id = kysymys_id;
	}
	public void setKysymys_Id(String kysymys_id) {
		try {
			this.id = Integer.parseInt(kysymys_id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}
	public int getEhdokas_Id() {
		return ehdokas_id;
	}
	public void setEhdokas_Id(int ehdokas_id) {
		this.ehdokas_id = ehdokas_id;
	}
	public void setEhdokas_Id(String ehdokas_id) {
		try {
			this.id = Integer.parseInt(ehdokas_id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}
	public int getVastaus() {
		return vastaus;
	}
	public void setVastaus(int vastaus) {
		this.vastaus = vastaus;
	}
	public int getAihealue_Id() {
		return aihealue_id;
	}
	public void setAihealue_Id(int aihealue_id) {
		this.aihealue_id = aihealue_id;
	}
	public void setAihealue_Id(String aihealue_id) {
		try {
			this.id = Integer.parseInt(aihealue_id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}
	

}
