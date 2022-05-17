package rest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import dao.JpaDao;
import data.Answer;

@Path("/updateanswerservice") 
public class UpdateService {
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("r8vaalikone");
	
	@POST
	@Path("/updateoneanswer")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/x-www-form-urlencoded")
	public void updateOneAnswer(@FormParam("id") int id, @FormParam("uusivastaus") int vastaus,@Context HttpServletRequest request, @Context HttpServletResponse response) {
		
		
		EntityManager em=emf.createEntityManager();
		em.getEntityManagerFactory().getCache().evictAll();
		em.getTransaction().begin();
		Answer answer=em.find(Answer.class, id);
		if (answer!=null) {
			answer.setVastaus(vastaus);
			em.merge(answer);//The actual update line
		}
		em.getTransaction().commit();
		//Calling the method readFish() of this service	
	
	}	

}
