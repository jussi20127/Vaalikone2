package data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Questions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String kysymys;
	private String aihe;
	
	//bi-directional many-to-one association to Subject
		@ManyToOne
		@JoinColumn(name="id")
		private Subjects subject;
		
	//bi-directional many-to-one association to Answers
	@OneToMany(mappedBy="question")
	private List<Answers> answerlist;
	
	public Questions(String id, String kysymys, Subjects subject) {
		// TODO Auto-generated constructor stub
		setKysymys_Id(id);
		this.kysymys=kysymys;
		this.subject=subject;
	}
	
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
	
	public String getAihe() {
		return aihe;
	}
	public void setAihe(String aihe) {
		this.aihe = aihe;
	}
	
	public String getKysymys() {
		return kysymys;
	}
	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}
	public Subjects getSubject() {
		return this.subject;
	}

	public void setSubject(Subjects subject) {
		this.subject = subject;
	}

	//yhteys answers
	public List<Answers> getAnswerlist() {
		if (this.answerlist==null) {
			answerlist=new ArrayList<>();
		}
		return this.answerlist;
	}

	public void setAnswerlist(List<Answers> answerlist) {
		this.answerlist = answerlist;
	}

	public Answers addAnswer(Answers answer) {
		getAnswerlist().add(answer);
		answer.setQuestion(this);

		return answer;
	}

	public Answers removeAnswer(Answers answer) {
		getAnswerlist().remove(answer);
		answer.setQuestion(null);
		return answer;
	}
	
}
