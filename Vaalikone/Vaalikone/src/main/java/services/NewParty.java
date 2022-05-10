package services;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import data.Party;

/**
 * Servlet implementation class NewParty
 */
@WebServlet(
	    name = "NewParty",
	    urlPatterns = {"/newparty"}
	)
	public class NewParty extends HttpServlet {
		private Dao dao;
		public void init() {
			dao=new Dao("jdbc:mysql://localhost:3306/r8vaalikone", "jussi", "ananas100");
		}
		@Override
		public void doPost(HttpServletRequest request, HttpServletResponse response) 
		     throws IOException, ServletException {
			
			String id=request.getParameter("id");
			String puolue=request.getParameter("puolue");
			
			
			ArrayList<Party> list=null;
			if (dao.getConnection()) {
				list=dao.addParty(id,puolue);
			}
			response.sendRedirect("AddCandidate");
		
		}
	}