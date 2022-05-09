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
import data.Question;

/**
 * Servlet implementation class ShowCandidates
 */
@WebServlet("/ShowCandidates")
public class ShowCandidates extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao2 dao2=null;
	
	@Override
	public void init() {
		dao2=new Dao2("jdbc:mysql://localhost:3306/r8vaalikone", "jussi", "ananas100");
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCandidates() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Candidate> list=null;
		if (dao2.getConnection()) {
			list=dao2.readAllCandidates();
		}
		else {
			System.out.println("No connection to database");
		}
		request.setAttribute("candidatelist", list);
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/show_candidates.jsp");
		rd.forward(request, response);
	}

}
