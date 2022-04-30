package data;

public class Candidates {
	private int id;
	private String sukunimi;
	private String etunimi;
	private int numero;
	private String puolue;
	private String kotipaikkakunta;
	private int ika;
	private String ammatti;
	
	public Candidates(String id, String sukunimi, String etunimi, String numero, String puolue, String kotipaikkakunta, String ika, String ammatti) {
		// Puolue-luokan rakentaja
		setCandidate_Id(id);
		this.sukunimi=sukunimi;
		this.etunimi=etunimi;
		setNumero(numero);
		this.puolue=puolue;
		this.kotipaikkakunta=kotipaikkakunta;
		setIka(ika);
		this.ammatti=ammatti;
	}
	public Candidates() {
		// Pakollinen tyhjä rakentaja
	}
	//getter ja setter id:lle
	public int getCandidate_Id() {
		return id;
	}
	public int getId() {
		return id;
	}
	public void setCandidate_Id(int id) {
		this.id = id;
	}
	public void setCandidate_Id(String id) {
		try {
			this.id = Integer.parseInt(id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}
	//getterit ja setterit sukunimelle
	public String getSukunimi() {
		return sukunimi;
	}
	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}
	//getterit ja setterit etunimelle
	public String getEtunimi() {
		return etunimi;
	}
	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}
	//getterit ja setterit numerolle
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public void setNumero(String numero) {
		try {
			this.numero = Integer.parseInt(numero);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of numero won't be changed
		}
	}
	//getterit ja setterit puolueelle
	public String getPuolue() {
		return puolue;
	}
	public void setPuolue(String puolue) {
		this.puolue = puolue;
	}
	//getterit ja setterit kotipaikkakunnalle
	public String getKotipaikkakunta() {
		return kotipaikkakunta;
	}
	public void setKotipaikkakunta(String kotipaikkakunta) {
		this.kotipaikkakunta = kotipaikkakunta;
	}
	//getterit ja setterit iälle
	public int getIka() {
		return ika;
	}
	public void setIka(int ika) {
		this.ika = ika;
	}
	public void setIka(String ika) {
		try {
			this.ika = Integer.parseInt(ika);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of ika won't be changed
		}
	}
	//getterit ja setterit ammatille
	public String getAmmatti() {
		return ammatti;
	}
	public void setAmmatti(String ammatti) {
		this.ammatti = ammatti;
	}
	
}
