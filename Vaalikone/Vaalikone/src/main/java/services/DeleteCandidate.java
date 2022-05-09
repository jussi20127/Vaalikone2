package services;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao2;
import data.Candidate;

/**
 * Servlet implementation class DeleteCandidate
 */
@WebServlet(
		name="/DeleteCandidate", 
		urlPatterns={"/deletecandidate"}
		)
public class DeleteCandidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao2 dao2;
	public void init() {
		dao2=new Dao2("jdbc:mysql://localhost:3306/r8vaalikone", "jussi", "ananas100");	
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("ehdokas_id");
		ArrayList<Candidate> list=null;
		if (dao2.getConnection()) {
			list=dao2.deleteCandidate(id);
		}
		request.setAttribute("candidatelist", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/show_candidates.jsp");
		rd.forward(request, response);
	}

}
