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
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import dao.JpaDao;
import data.Candidate;
import data.Question;

@Path("/candidateinfoservice") 
public class CandidateInfoService {

	//luodaan EntityManagerFactory emf, joka käyttää tietokantaa r8vaalikone
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("r8vaalikone");

		//Metodi, joka hakee yhden ehdokkaan tiedot ehdokkaalle näytettäväksi
		@POST
		@Path("/getcandidateinfo")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes("application/x-www-form-urlencoded")
		public void getOneCandidate(@FormParam("nro") int nro, @Context HttpServletRequest request, @Context HttpServletResponse response)
		{
			EntityManager em=emf.createEntityManager();
			JpaDao jpadao = new JpaDao(em);
			List<Candidate> list = jpadao.readOneCandidateByNumber(nro);
			RequestDispatcher rd=request.getRequestDispatcher("/jsp/read_one_candidate.jsp");
			request.setAttribute("candidateinfo", list);
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}

