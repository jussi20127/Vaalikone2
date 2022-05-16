package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.PathParam;

import data.Answer;
import data.Candidate;
import data.Question;
import data.Subject;

public class JpaDao {
		
		private EntityManager em;
		public JpaDao(EntityManager em) {
			this.em=em;
		}
		
		//answers
		public void addAnswer(Answer answer) {
			em.getTransaction().begin();
			em.persist(answer);
			em.getTransaction().commit();
		}
		
		public Answer getAnswer(Answer answer) {
			return new Answer();
		}
		public Answer getAnswer(int id) {
			return new Answer();
		}
		
		public List<Answer> deleteAnswer(int id) {
			em.getTransaction().begin();
			Answer a=em.find(Answer.class, id);
			if (a!=null) {
				em.remove(a);//The actual insertion line
			}
			em.getTransaction().commit();
			List<Answer> list=readAnswers();		
			return list;
		}
		public List<Answer> updateAnswer(Answer answer) {
			em.getTransaction().begin();
			Answer a=em.find(Answer.class, answer.getId());
			if (a!=null) {
				em.merge(answer);//The actual update line
			}
			em.getTransaction().commit();
			//Calling the method readFish() of this service
			List<Answer> list=readAnswers();		
			return list;
			
		}
		public List<Answer> readAnswers() {
			em.getTransaction().begin();
			List<Answer> list=(List<Answer>) em.createQuery("select a from Answer a").getResultList();
			em.getTransaction().commit();
			return list;
		}

		//candidates
		public void addCandidate(Candidate candidate) {
			em.getTransaction().begin();
			em.persist(candidate);
			em.getTransaction().commit();
		}
		
		public Candidate getCandidate(Candidate candidate) {
			return new Candidate();
		}
		public Candidate getCandidateByID(int id) {
			em.getTransaction().begin();
			Candidate c=em.find(Candidate.class, id);
			em.getTransaction().commit();
			return c;
		}
		
		public List<Candidate> readOneCandidate(int id) {
			em.getTransaction().begin();
			Candidate c=em.find(Candidate.class, id);
			ArrayList<Candidate> list = new ArrayList<>();
			list.add(c);
			em.getTransaction().commit();
			return list;
		}
		public List<Candidate> readOneCandidateByNumber(int nro) {
			em.getTransaction().begin();
			Query q=em.createQuery("select c from Candidate c where c.numero like :numero");
			q.setParameter("numero", nro);
			List<Candidate> list=q.getResultList();
			em.getTransaction().commit();
			em.close();
			return list;
		}
		
		public List<String> readCandidate(int id) {
			em.getTransaction().begin();
			Candidate c=em.find(Candidate.class, id);
			ArrayList<String> list = new ArrayList<>();
			list.add(c.getEtunimi());
			list.add(c.getSukunimi());
			list.add(c.numero());
			list.add(c.getPuolue());
			list.add(c.ika());
			list.add(c.getKotipaikkakunta());
			list.add(c.getAmmatti());
			em.getTransaction().commit();
			return list;
		}	
		
		public ArrayList<Candidate> deleteCandidate(Candidate candidate) {
			em.getTransaction().begin();
			Candidate c=em.find(Candidate.class, candidate.getId());
			if (c!=null) {
				em.remove(c);//The actual insertion line
			}
			em.getTransaction().commit();
			ArrayList<Candidate> list=readCandidates();		
			return list;
		}
		public ArrayList<Candidate> updateCandidate(Candidate candidate) {
			em.getTransaction().begin();
			Candidate c=em.find(Candidate.class, candidate.getId());
			if (c!=null) {
				em.merge(candidate);//The actual update line
			}
			em.getTransaction().commit();
			//Calling the method readFish() of this service
			ArrayList<Candidate> list=readCandidates();		
			return list;
		}
		
		public ArrayList<Candidate> readCandidates() {
			em.getTransaction().begin();
			ArrayList<Candidate> list=(ArrayList<Candidate>) em.createQuery("select a from Candidates a").getResultList();
			em.getTransaction().commit();
			return list;
		}
		
		//questions
		public void addQuestion(Question question) {
			em.getTransaction().begin();
			em.persist(question);
			em.getTransaction().commit();
		}
		
		public Question getQuestion(Question question) {
			return new Question();
		}
		public Question getQuestion(int id) {
			return new Question();
		}
		
		
		
		public List<Question> deleteQuestion(Question question) {
			em.getTransaction().begin();
			Question q=em.find(Question.class, question.getId());
			if (q!=null) {
				em.remove(q);//The actual insertion line
			}
			em.getTransaction().commit();
			List<Question> list=readQuestions();		
			return list;
		}
		public List<Question> updateQuestions(Question question) {
			em.getTransaction().begin();
			Question q=em.find(Question.class, question.getId());
			if (q!=null) {
				em.merge(question);//The actual update line
			}
			em.getTransaction().commit();
			//Calling the method readQuestions() of this service
			List<Question> list=readQuestions();		
			return list;
		}
		//Palautetaan kaikki kysymykset
		public List<Question> readQuestions() {
			em.getTransaction().begin();
			List<Question> list=(List<Question>) em.createQuery("select a from Question a").getResultList();
			em.getTransaction().commit();
			return list;
		}
		
		//haetaan yksi kysmys
		public Question readOneQuestion(int id) {
			em.getTransaction().begin();
			Question q=em.find(Question.class, id);
			em.getTransaction().commit();
			return q;
		}	
		
		//subjects - en tiedä tarvitaanko, mutta varavuoksi
		public void addSubject(Subject subject) {
			em.getTransaction().begin();
			em.persist(subject);
			em.getTransaction().commit();
		}
		
		public Subject getSubject(Subject subject) {
			return new Subject();
		}
		public Subject getSubject(int id) {
			return new Subject();
		}
		
		public ArrayList<Subject> deleteSubjects(Subject subject) {
			em.getTransaction().begin();
			Subject s=em.find(Subject.class, subject.getId());
			if (s!=null) {
				em.remove(s);//The actual insertion line
			}
			em.getTransaction().commit();
			ArrayList<Subject> list=readSubjects();		
			return list;
		}
		public ArrayList<Subject> updateSubjects(Subject subject) {
			em.getTransaction().begin();
			Subject s=em.find(Subject.class, subject.getId());
			if (s!=null) {
				em.merge(subject);//The actual update line
			}
			em.getTransaction().commit();
			//Calling the method readFish() of this service
			ArrayList<Subject> list=readSubjects();		
			return list;
		}
		
		public ArrayList<Subject> readSubjects() {
			em.getTransaction().begin();
			ArrayList<Subject> list=(ArrayList<Subject>) em.createQuery("select a from Subjects a").getResultList();
			em.getTransaction().commit();
			return list;
		}
}
