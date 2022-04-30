package data;

public class Questions {
	private int id;
	private String kysymys;
	private String aihe;
	public Questions(String id, String kysymys, String aihe) {
		// TODO Auto-generated constructor stub
		setKysymys_Id(id);
		this.kysymys=kysymys;
		this.aihe=aihe;
	}
	public Questions() {
		// TODO Auto-generated constructor stub
	}
	public int getKysymys_Id() {
		return id;
	}
	public int getId() {
		return id;
	}
	public void setKysymys_Id(int id) {
		this.id = id;
	}
	public void setKysymys_Id(String id) {
		try {
			this.id = Integer.parseInt(id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}
	public String getKysymys() {
		return kysymys;
	}
	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}
	public String getAihe() {
		return aihe;
	}
	public void setAihe(String aihe) {
		this.aihe = aihe;
	}
	
}
