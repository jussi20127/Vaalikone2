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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import dao.JpaDao;
import data.Question;

@Path("/questionbysubject") 
public class QuestionBySubject {
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("r8vaalikone");
	
	@GET
	@Path("/getquestions")
	@Produces(MediaType.APPLICATION_JSON)
	public void getQuestions(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		 EntityManager em=emf.createEntityManager();
		 em.getEntityManagerFactory().getCache().evictAll();
			JpaDao jpadao = new JpaDao(em);
			List<Question> list = jpadao.readQuestions();
			Map<String, List<Question>> questionsBySubject = list.stream().collect(Collectors.groupingBy(Question::getAihealue));
			 for (Map.Entry<String, List<Question>> entry: questionsBySubject.entrySet()) {
				 ArrayList<String> newList = new ArrayList<>();
				 newList.add(entry.getKey() + entry.getValue());
			 }
			RequestDispatcher rd=request.getRequestDispatcher("/jsp/questions_and_subjects.jsp");
			request.setAttribute("questionslist", questionsBySubject);
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}	
	
}


