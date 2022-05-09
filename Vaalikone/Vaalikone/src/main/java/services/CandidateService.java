package services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.Dao;
import dao.JpaDao;
import data.Candidate;


@Path("/candidateservice")
public class CandidateService {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("r8vaalikone");
	
	@GET
	@Path("/readcandidate/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Candidate readToUpdate(@PathParam("id")int id) {
		System.out.println("Vittu");
		EntityManager em = emf.createEntityManager();
		System.out.println("test");
		em.getTransaction().begin();
		System.out.println("test");
		Candidate c=em.find(Candidate.class, id);
		System.out.println("test");
		em.getTransaction().commit();
		System.out.println(c);
		return c;
		
	}
	}


