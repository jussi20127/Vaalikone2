package data;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.JoinColumn;


/**
 * The persistent class for the answers database table.
 * 
 */
@Entity
@Table(name="answers")
@NamedQuery(name="Answer.findAll", query="SELECT a FROM Answer a")
public class Answer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int vastaus;

	//bi-directional many-to-one association to Candidate
	@ManyToOne (cascade = CascadeType.PERSIST)
	private Candidate candidate;

	//bi-directional many-to-one association to Subject
	@ManyToOne (cascade = CascadeType.PERSIST)
	private Subject subject;

	//bi-directional many-to-one association to Question
	@ManyToOne (cascade = CascadeType.PERSIST)
	private Question question;

	public Answer() {
	}

	public Answer(int vastaus) {
		// TODO Auto-generated constructor stub
		this.vastaus=vastaus;
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVastaus() {
		return this.vastaus;
	}

	public void setVastaus(int vastaus) {
		this.vastaus = vastaus;
	}

	public Candidate getCandidate() {
		return this.candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}