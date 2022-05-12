package rest;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
		public List<String> getOneCandidate(@FormParam("id") int id)
		{
			 EntityManager em=emf.createEntityManager();
			JpaDao jpadao = new JpaDao(em);
			List<String> list = jpadao.readCandidate(id);
			return list;
	}
}
