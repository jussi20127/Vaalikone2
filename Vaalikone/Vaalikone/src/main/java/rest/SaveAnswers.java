package rest;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import dao.JpaDao;
import data.Answer;
import data.Candidate;
import data.Question;

@Path("/saveanswers") 
public class SaveAnswers {

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("r8vaalikone");
	
	@POST
	@Path("/saveallanswers")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/x-www-form-urlencoded")
	public void saveAllAnswers(@FormParam ("id") int id, @FormParam ("question_id") List<String> kysymys_id, @FormParam ("vastaus") List<String> vastaus,
			@Context HttpServletRequest request, @Context HttpServletResponse response) {
		
		EntityManager em=emf.createEntityManager();
		
		
		Candidate c = em.find(Candidate.class, id);
		List<Answer> c1 = c.getAnswers();
		if (c1.size() < 1) {
		
			
			
			//Vastaus-listan koko
		int size = vastaus.size();
		for (int i=0; i<size; i++) {
			JpaDao jpadao = new JpaDao(em);
			
			
			
			String vastausString = vastaus.get(i);
			int vastausInt = Integer.parseInt(vastausString);
			 Answer answer = new Answer(vastausInt);
			 
			 //Otetaan kysymys_id-listasta indeksistä i String-muuttujaan arvo
			 String kysymysString = kysymys_id.get(i);
			 //Muutetaan kysymysString integeriksi
			 int kysymysInt = Integer.parseInt(kysymysString);
			 Question question = em.find(Question.class, kysymysInt);
			 Candidate candidate = em.find(Candidate.class, id);
			 
			 
			
			 candidate.addAnswer(answer);
			 answer.setQuestion(question);
			 jpadao.addCandidate(candidate);
			 System.out.print("Tallennettu vastaus on: " + vastausInt);
			 System.out.print("Tallennettu kysymys_id on: " + kysymysInt);
			 
		}
		
		//edellinen koodinpätkä, jätetty varmuuden vuoksi
		 /*EntityManager em=emf.createEntityManager();
		 JpaDao jpadao = new JpaDao(em);
		 Answer answer = new Answer(toinen2);
		 Question question = em.find(Question.class, kysymys_id);
		 Candidate candidate = em.find(Candidate.class, id); 
		 candidate.addAnswer(answer);
		 answer.setQuestion(question);
		 jpadao.addCandidate(candidate);
		 */
		
		System.out.print("Lista käyty läpi.");
		}else {
			System.out.println(c1+"täynnä");
		}
		
		EntityManager em2=emf.createEntityManager();
		JpaDao jpadao = new JpaDao(em2);
		List<Candidate> list = jpadao.readOneCandidate(id);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/read_one_candidate.jsp");
		request.setAttribute("candidateinfo", list);
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
//		 Question question = jpadao.getQuestion(kysymys_id);
//		
//		 answer.setVastaus(numero);
//		 answer.setQuestion(question);
////		 answer.setCandidate(candidate);
//		 jpadao.addAnswer(answer);
	}
}
