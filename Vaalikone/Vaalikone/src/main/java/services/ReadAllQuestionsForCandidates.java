package services;

import java.io.*;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import org.eclipse.persistence.oxm.MediaType;

import dao.JpaDao;

import java.util.ArrayList;
import java.util.List;
import data.*;

@WebServlet("/ReadAllQuestionsForCandidates")
public class ReadAllQuestionsForCandidates extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
		//Tähän restful servicen osoite ja mitä metodia sieltä haetaan
		String uri = "http://127.0.0.1:8080/rest/questionserviceforcandidate/getquestions";
		
		//Client builder
		Client asiakas=ClientBuilder.newClient();
		WebTarget wt=asiakas.target(uri);
		Builder b=wt.request();
		
		//Create a GenericType to be able to get List of objects
		//This will be the second parameter of post method
		GenericType<List<Question>> genericList = new GenericType<List<Question>>() {};
		
		//QuestionService.javasta vastaanotettu lista tallennetaan returnedList-muuttujaan
		List<Question> returnedList=b.get(genericList);
		//returnedList saa nimen "questionlist"
	    request.setAttribute("questionlist", returnedList);
	    //lähetetään questionlist jsp:lle
	    RequestDispatcher rd=request.getRequestDispatcher("./jsp/readallquestions_candidates.jsp");
		rd.forward(request, response);
  }
}