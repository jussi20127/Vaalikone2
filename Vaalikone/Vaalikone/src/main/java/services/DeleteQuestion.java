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
import data.Questions;
import data.Questions;

/**
 * Servlet implementation class ShowFish
 */
@WebServlet(
	    name = "DeleteQuestion",
	    urlPatterns = {"/deleteQuestion"}
	)
	public class DeleteQuestion extends HttpServlet {
		private Dao dao;
		public void init() {
			dao=new Dao("jdbc:mysql://localhost:3306/r8vaalikone", "jussi", "ananas100");
		}
		@Override
		public void doGet(HttpServletRequest request, HttpServletResponse response) 
		     throws IOException, ServletException {
			String id=request.getParameter("kysymys_id");
			ArrayList<Questions> list=null;
			if (dao.getConnection()) {
				list=dao.deleteQuestion(id);
			}
			request.setAttribute("questionlist", list);
			RequestDispatcher rd=request.getRequestDispatcher("/jsp/show_questions.jsp");
			rd.forward(request, response);
		}
	}