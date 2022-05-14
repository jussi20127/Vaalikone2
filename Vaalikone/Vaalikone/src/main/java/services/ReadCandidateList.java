package services;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.*;


/**
 * Servlet implementation class ReadCandidateList
 */
@WebServlet("/ReadCandidateList")
public class ReadCandidateList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("r8vaalikone");
	  @Override
	  public void doGet(HttpServletRequest request, HttpServletResponse response) 
	      throws IOException, ServletException {
		    EntityManager em=emf.createEntityManager();
		    em.getTransaction().begin();
		    List<Candidate> list=em.createQuery("select c from Candidate c").getResultList();
		    em.getTransaction().commit();
		    request.setAttribute("candidatelist", list);
		    RequestDispatcher rd=request.getRequestDispatcher("./jsp/readcandidatelist.jsp");
			rd.forward(request, response);
	  
	}
	}

