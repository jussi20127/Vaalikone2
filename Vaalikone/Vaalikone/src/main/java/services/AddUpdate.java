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
import data.Questions;

/**
 * Servlet implementation class AddUpdate
 */
@WebServlet(
	    name = "AddUpdate",
	    urlPatterns = {"/addupdate"}
	)
	public class AddUpdate extends HttpServlet {
		private Dao dao;
		public void init() {
			dao=new Dao("jdbc:mysql://localhost:3306/r8vaalikone", "jussi", "ananas100");
		}
		@Override
		public void doPost(HttpServletRequest request, HttpServletResponse response) 
		     throws IOException, ServletException {
			
			String kysymys_id=request.getParameter("kysymys_numero");
			String kysymys=request.getParameter("kysymys");
			String aihe=request.getParameter("aihe");
			ArrayList<Questions> list=null;
			if (dao.getConnection()) {
				list=dao.addQuestion(kysymys_id,kysymys,aihe);
			}
			response.sendRedirect("ShowQuestions");
		
		}
	}
