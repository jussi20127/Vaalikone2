package data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Subjects {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String aihealue;
	
	//bi-directional many-to-one association to Answers
			@OneToMany(mappedBy="subject")
			private List<Answers> answerlist;
			
	//bi-directional many-to-one association to Questions
			@OneToMany(mappedBy="subject")
			private List<Questions> questionlist;

	//CONSTRUCTORIT
	
	public Subjects() {
	}
	public Subjects(int id, String aihealue) {
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
			answer.setSubject(this);

			return answer;
		}

		public Answers removeAnswer(Answers answer) {
			getAnswerlist().remove(answer);
			answer.setSubject(null);
			return answer;
		}
		//yhteys questions
			public List<Questions> getQuestionlist() {
				if (this.questionlist==null) {
					questionlist=new ArrayList<>();
				}
				return this.questionlist;
			}

			public void setQuestionlist(List<Questions> questionlist) {
				this.questionlist = questionlist;
			}

			public Questions addQuestion(Questions question) {
				getQuestionlist().add(question);
				question.setSubject(this);

				return question;
			}

			public Questions removeQuestion(Questions question) {
				getQuestionlist().remove(question);
				question.setSubject(null);
				return question;
			}
}
