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
import data.Subject;

/**
 * Servlet implementation class CandidateUpdate
 */
@WebServlet(
	    name = "NewSubject",
	    urlPatterns = {"/newsubject"}
	)
	public class NewSubject extends HttpServlet {
		private Dao dao;
		public void init() {
			dao=new Dao("jdbc:mysql://localhost:3306/r8vaalikone", "jussi", "ananas100");
		}
		@Override
		public void doPost(HttpServletRequest request, HttpServletResponse response) 
		     throws IOException, ServletException {
			
			String id=request.getParameter("id");
			String aihealue=request.getParameter("aihealue");
			
			
			ArrayList<Subject> list=null;
			if (dao.getConnection()) {
				list=dao.addSubject(id,aihealue);
			}
			response.sendRedirect("AddQuestion");
		
		}
	}
