package rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import dao.JpaDao;
import data.Question;
import data.Answer;
import data.Candidate;

@Path("/questionansweringservice") 
public class QuestionAnsweringService {
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("r8vaalikone");
	
	@GET
	@Path("/getquestionstoanswer")
	@Produces(MediaType.APPLICATION_JSON)
	public void getQuestions(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		 EntityManager em=emf.createEntityManager();
			JpaDao jpadao = new JpaDao(em);
			List<Question> list = jpadao.readQuestions();
			Map<String, List<Question>> questionsBySubject = list.stream().collect(Collectors.groupingBy(Question::getAihealue));
			 for (Map.Entry<String, List<Question>> entry: questionsBySubject.entrySet()) {
				 ArrayList<String> newList = new ArrayList<>();
				 newList.add(entry.getKey() + entry.getValue());
			 }
		
			RequestDispatcher rd=request.getRequestDispatcher("/jsp/questions_answers.jsp");
			request.setAttribute("questionslist", questionsBySubject);
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	
	@GET
	@Path("/checkmyanswers/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	public void checkMyAnswers(@PathParam("id") int id,@Context HttpServletRequest request, @Context HttpServletResponse response) {
		 EntityManager em=emf.createEntityManager();
			JpaDao jpadao = new JpaDao(em);
			Candidate candidate = jpadao.getCandidateByID(id);
			List<Answer> list2 = candidate.getAnswers();
			
			RequestDispatcher rd=request.getRequestDispatcher("/jsp/questions_answers.jsp");
			request.setAttribute("answerlist", list2);
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}
		

}
	
	

