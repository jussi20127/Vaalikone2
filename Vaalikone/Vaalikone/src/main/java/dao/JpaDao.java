package dao;

import javax.persistence.EntityManager;

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
		
		public void deleteAnswer(Answers answer) {
			
		}
		public void updateAnswer(Answers answer) {
			
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
		
		public void deleteCandidate(Candidates candidate) {
			
		}
		public void updateCandidate(Candidates candidate) {
			
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
		
		public void deleteQuestion(Questions question) {
			
		}
		public void updateQuestion(Questions question) {
			
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
		
		public void deleteSubject(Subjects subject) {
			
		}
		public void updateSubject(Subjects subject) {
			
		}
}
