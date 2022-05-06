package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import data.Answers;
import data.Candidates;
import data.Questions;
import data.Subjects;

public class JpaDao {
	
		private EntityManager em;
		public JpaDao(EntityManager em) {
			this.em=em;
		}
		
		//answers
		public void addAnswer(Answers answer) {
			em.getTransaction().begin();
			em.persist(answer);
			em.getTransaction().commit();
		}
		
		public Answers getAnswer(Answers answer) {
			return new Answers();
		}
		public Answers getAnswer(int id) {
			return new Answers();
		}
		
		public ArrayList<Answers> deleteAnswer(Answers answer) {
			em.getTransaction().begin();
			Answers a=em.find(Answers.class, answer.getId());
			if (a!=null) {
				em.remove(a);//The actual insertion line
			}
			em.getTransaction().commit();
			ArrayList<Answers> list=readAnswers();		
			return list;
		}
		public ArrayList<Answers> updateAnswer(Answers answer) {
			em.getTransaction().begin();
			Answers a=em.find(Answers.class, answer.getId());
			if (a!=null) {
				em.merge(answer);//The actual update line
			}
			em.getTransaction().commit();
			//Calling the method readFish() of this service
			ArrayList<Answers> list=readAnswers();		
			return list;
			
		}
		public ArrayList<Answers> readAnswers() {
			em.getTransaction().begin();
			ArrayList<Answers> list=(ArrayList<Answers>) em.createQuery("select a from Answers a").getResultList();
			em.getTransaction().commit();
			return list;
		}

		//candidates
		public void addCandidate(Candidates candidate) {
			em.getTransaction().begin();
			em.persist(candidate);
			em.getTransaction().commit();
		}
		
		public Candidates getCandidate(Candidates candidate) {
			return new Candidates();
		}
		public Candidates getCandidate(int id) {
			return new Candidates();
		}
		
		public ArrayList<Candidates> deleteCandidate(Candidates candidate) {
			em.getTransaction().begin();
			Candidates c=em.find(Candidates.class, candidate.getId());
			if (c!=null) {
				em.remove(c);//The actual insertion line
			}
			em.getTransaction().commit();
			ArrayList<Candidates> list=readCandidates();		
			return list;
		}
		public ArrayList<Candidates> updateCandidate(Candidates candidate) {
			em.getTransaction().begin();
			Candidates c=em.find(Candidates.class, candidate.getId());
			if (c!=null) {
				em.merge(candidate);//The actual update line
			}
			em.getTransaction().commit();
			//Calling the method readFish() of this service
			ArrayList<Candidates> list=readCandidates();		
			return list;
		}
		
		public ArrayList<Candidates> readCandidates() {
			em.getTransaction().begin();
			ArrayList<Candidates> list=(ArrayList<Candidates>) em.createQuery("select a from Candidates a").getResultList();
			em.getTransaction().commit();
			return list;
		}
		
		//questions
		public void addQuestion(Questions question) {
			em.getTransaction().begin();
			em.persist(question);
			em.getTransaction().commit();
		}
		
		public Questions getQuestion(Questions question) {
			return new Questions();
		}
		public Questions getQuestion(int id) {
			return new Questions();
		}
		
		public ArrayList<Questions> deleteQuestion(Questions question) {
			em.getTransaction().begin();
			Questions q=em.find(Questions.class, question.getId());
			if (q!=null) {
				em.remove(q);//The actual insertion line
			}
			em.getTransaction().commit();
			ArrayList<Questions> list=readQuestions();		
			return list;
		}
		public ArrayList<Questions> updateQuestions(Questions question) {
			em.getTransaction().begin();
			Questions q=em.find(Questions.class, question.getId());
			if (q!=null) {
				em.merge(question);//The actual update line
			}
			em.getTransaction().commit();
			//Calling the method readFish() of this service
			ArrayList<Questions> list=readQuestions();		
			return list;
		}
		
		public ArrayList<Questions> readQuestions() {
			em.getTransaction().begin();
			ArrayList<Questions> list=(ArrayList<Questions>) em.createQuery("select a from Questions a").getResultList();
			em.getTransaction().commit();
			return list;
		}
		
		//subjects - en tiedä tarvitaanko, mutta varavuoksi
		public void addSubject(Subjects subject) {
			em.getTransaction().begin();
			em.persist(subject);
			em.getTransaction().commit();
		}
		
		public Subjects getSubject(Subjects subject) {
			return new Subjects();
		}
		public Subjects getSubject(int id) {
			return new Subjects();
		}
		
		public ArrayList<Subjects> deleteSubjects(Subjects subject) {
			em.getTransaction().begin();
			Subjects s=em.find(Subjects.class, subject.getId());
			if (s!=null) {
				em.remove(s);//The actual insertion line
			}
			em.getTransaction().commit();
			ArrayList<Subjects> list=readSubjects();		
			return list;
		}
		public ArrayList<Subjects> updateSubjects(Subjects subject) {
			em.getTransaction().begin();
			Subjects s=em.find(Subjects.class, subject.getId());
			if (s!=null) {
				em.merge(subject);//The actual update line
			}
			em.getTransaction().commit();
			//Calling the method readFish() of this service
			ArrayList<Subjects> list=readSubjects();		
			return list;
		}
		
		public ArrayList<Subjects> readSubjects() {
			em.getTransaction().begin();
			ArrayList<Subjects> list=(ArrayList<Subjects>) em.createQuery("select a from Subjects a").getResultList();
			em.getTransaction().commit();
			return list;
		}
}
