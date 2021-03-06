package data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the candidates database table.
 * 
 */
@Entity
@Table(name="candidates")
@NamedQuery(name="Candidate.findAll", query="SELECT c FROM Candidate c")
public class Candidate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String ammatti;

	private String etunimi;

	private int ika;

	private String kotipaikkakunta;

	private int numero;

	private String sukunimi;
	
	private String puolue;

	//bi-directional many-to-one association to Answer
	@OneToMany(mappedBy="candidate", cascade = CascadeType.PERSIST)
	private List<Answer> answers;
	
	@OneToMany(mappedBy="candidate", cascade = CascadeType.PERSIST)
	private List<Question> questions;

	//bi-directional many-to-one association to Party
	@ManyToOne
	@PrimaryKeyJoinColumn(name="PUOLUE_ID")
	private Party party;
	
	public Candidate(String id, String sukunimi, String etunimi,String puolue, String numero, String kotipaikkakunta, String ika, String ammatti) {
		// Puolue-luokan rakentaja
		setId(id);
		this.sukunimi=sukunimi;
		this.etunimi=etunimi;
		setNumero(numero);
		this.setPuolue(puolue);
		this.kotipaikkakunta=kotipaikkakunta;
		setIka(ika);
		this.ammatti=ammatti;
	}
	public Candidate(String sukunimi, String etunimi, String puolue, int numero, String kotipaikkakunta, int ika, String ammatti) {
		setId(id);
		this.sukunimi=sukunimi;
		this.etunimi=etunimi;
		this.puolue=puolue;
		this.numero=numero;
		this.kotipaikkakunta=kotipaikkakunta;
		this.ika=ika;
		this.ammatti=ammatti;
	}

	public Candidate() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setId(String id) {
		try {
			this.id = Integer.parseInt(id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of ika won't be changed
		}
	}

	public String getAmmatti() {
		return this.ammatti;
	}

	public void setAmmatti(String ammatti) {
		this.ammatti = ammatti;
	}

	public String getEtunimi() {
		return this.etunimi;
	}

	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}

	public int getIka() {
		return this.ika;
	}
	public String ika() {
		String age = String.valueOf(ika);
		return age;
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

	public String getKotipaikkakunta() {
		return this.kotipaikkakunta;
	}

	public void setKotipaikkakunta(String kotipaikkakunta) {
		this.kotipaikkakunta = kotipaikkakunta;
	}

	public int getNumero() {
		return this.numero;
	}

	public String numero() {
		String number = String.valueOf(numero);
		return number;
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
	public String getSukunimi() {
		return sukunimi;
		
	}

	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}

	public List<Answer> getAnswers() {
		return this.answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Answer addAnswer(Answer answer) {
		getAnswers().add(answer);
		answer.setCandidate(this);

		return answer;
	}

	public Answer removeAnswer(Answer answer) {
		getAnswers().remove(answer);
		answer.setCandidate(null);

		return answer;
	}
	public List<Question> getQuestion() {
		return this.questions;
	}

	public void setQuestion(List<Question> questions) {
		this.questions = questions;
	}

	public Question addQuestion(Question question) {
		getQuestion().add(question);
		question.setCandidate(this);

		return question;
	}

	public Question removeQuestion(Question question) {
		getQuestion().remove(question);
		question.setCandidate(null);

		return question;
	}

	public Party getParty() {
		return this.party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public String getPuolue() {
		return puolue;
	}

	public void setPuolue(String puolue) {
		this.puolue = puolue;
	}

}