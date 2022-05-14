package data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the questions database table.
 * 
 */
@Entity
@Table(name="questions")
@NamedQuery(name="Question.findAll", query="SELECT q FROM Question q")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String aihealue;

	private String kysymys;

	//bi-directional many-to-one association to Answer
	@OneToMany(mappedBy="question")
	private List<Answer> answers;
	
	public Question(String id, String kysymys, String aihe) {
		// TODO Auto-generated constructor stub
		setId(id);
		this.kysymys=kysymys;
		this.aihealue=aihe;
	}

	public Question() {
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

	public String getAihealue() {
		return aihealue;
	}

	public void setAihealue(String aihealue) {
		this.aihealue = aihealue;
	}

	public String getKysymys() {
		return kysymys;
	}

	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}

	public List<Answer> getAnswers() {
		return this.answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Answer addAnswer(Answer answer) {
		getAnswers().add(answer);
		answer.setQuestion(this);

		return answer;
	}

	public Answer removeAnswer(Answer answer) {
		getAnswers().remove(answer);
		answer.setQuestion(null);

		return answer;
	}
	public String toString() {
		return this.aihealue+" "+this.kysymys;
	}
}