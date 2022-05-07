package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Answers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int vastaus;
	
	//bi-directional many-to-one association to Candidate
		@ManyToOne
		@JoinColumn(name="id")
		private Candidates candidate;
	
	//bi-directional many-to-one association to Subject
			@ManyToOne
			@JoinColumn(name="id")
			private Subjects subject;
			
	//bi-directional many-to-one association to Question
	@ManyToOne
	@JoinColumn(name="id")
	private Questions question;

	
	// CONSTRUCTORIT
	public Answers() {
		super();
	}
	public Answers(int id, Questions question, Candidates candidate, int vastaus, Subjects subject) {
		super();
		this.id = id;
		this.question = question;
		this.candidate = candidate;
		this.vastaus = vastaus;
		this.subject = subject;
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
	public int getVastaus() {
		return vastaus;
	}
	public void setVastaus(int vastaus) {
		this.vastaus = vastaus;
	}
	public void setVastaus(String vastaus) {
		try {
			this.vastaus = Integer.parseInt(vastaus);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}
	
	public Candidates getCandidate() {
		return this.candidate;
	}

	public void setCandidate(Candidates candidate) {
		this.candidate = candidate;
	}
	
	public Questions getQuestion() {
		return this.question;
	}

	public void setQuestion(Questions question) {
		this.question = question;
	}
	
	public Subjects getSubject() {
		return this.subject;
	}

	public void setSubject(Subjects subject) {
		this.subject = subject;
	}
	
	public String toString() {
		return id+": "+vastaus+" / "+question.getId()+" / "+subject.getId()+" / "+candidate.getId();
	}
}
