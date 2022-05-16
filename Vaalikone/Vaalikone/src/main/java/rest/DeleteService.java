package rest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import dao.JpaDao;
import data.Answer;
import data.Candidate;
import data.Question;

@Path("/deleteanswerservice") 
public class DeleteService {
	//luodaan EntityManagerFactory emf, joka käyttää tietokantaa r8vaalikone
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("r8vaalikone");
	
	@GET
	@Path("/deleteAnswer/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteAnswer(@PathParam("id") int id, @Context HttpServletRequest request, @Context HttpServletResponse response) {
		System.out.println("Vastauksen id on :" + id);
		EntityManager em=emf.createEntityManager();
		JpaDao jpadao = new JpaDao(em);
		jpadao.deleteAnswer(id);
		
	}	

}
