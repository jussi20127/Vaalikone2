package rest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
	public void saveAllAnswers(@FormParam ("id") int id, @FormParam ("question_id") int kysymys_id, @FormParam ("vastaus") int numero,
			@Context HttpServletRequest request, @Context HttpServletResponse response) {
		
		System.out.print("ehdokas"+id);
		System.out.print("kysymys"+kysymys_id);
		System.out.print("vastaus"+numero);
		 EntityManager em=emf.createEntityManager();
		 JpaDao jpadao = new JpaDao(em);
		 Answer answer = new Answer(numero);
		 Candidate candidate = jpadao.getCandidate(id);
		 candidate.addAnswer(answer);
		 jpadao.addCandidate(candidate);
		 
		 
		 
//		 Question question = jpadao.getQuestion(kysymys_id);
//		
//		 answer.setVastaus(numero);
//		 answer.setQuestion(question);
////		 answer.setCandidate(candidate);
//		 jpadao.addAnswer(answer);
	}
}
