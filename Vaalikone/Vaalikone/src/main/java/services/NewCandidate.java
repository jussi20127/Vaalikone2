package services;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dao.Dao2;
import data.Candidate;
import data.Party;

/**
 * Servlet implementation class CandidateUpdate
 */
@WebServlet(
	    name = "NewCandidate",
	    urlPatterns = {"/newcandidate"}
	)
	public class NewCandidate extends HttpServlet {
		private Dao dao;
		private Dao2 dao2;
		public void init() {
			dao=new Dao("jdbc:mysql://localhost:3306/r8vaalikone", "jussi", "ananas100");
			dao2=new Dao2("jdbc:mysql://localhost:3306/r8vaalikone", "jussi", "ananas100");
		}
		@Override
		public void doPost(HttpServletRequest request, HttpServletResponse response) 
		     throws IOException, ServletException {
			
			ArrayList<Party> list1=null;
			if (dao.getConnection()) {
				list1 = dao.readAllParties();
				
			}
			
			
			//String id=request.getParameter("ehdokas_id");
			String sukunimi=request.getParameter("sukunimi");
			String etunimi=request.getParameter("etunimi");
			String numero=request.getParameter("numero");
			
			String puolue_id=request.getParameter("puolue_id");
			Party p = list1.get(Integer.parseInt(puolue_id)-1);
			String puolue=p.getPuolue();
			
			String kotipaikkakunta=request.getParameter("kotipaikkakunta");
			String ika=request.getParameter("ika");
			String ammatti=request.getParameter("ammatti");
			
			ArrayList<Candidate> list=null;
			if (dao2.getConnection()) {
				list=dao2.addCandidate(sukunimi,etunimi,numero,puolue,kotipaikkakunta,ika,ammatti,puolue_id);
			}
			response.sendRedirect("ShowCandidates");
		
		}
	}