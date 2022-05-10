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
import data.Subject;

/**
 * Servlet implementation class ReadToUpdate
 */
@WebServlet("/readCandidateToUpdate")
public class ReadCandidateToUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao;
	private Dao2 dao2;
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/r8vaalikone", "jussi", "ananas100");
		dao2=new Dao2("jdbc:mysql://localhost:3306/r8vaalikone", "jussi", "ananas100");
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadCandidateToUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("ehdokas_id");
		Candidate c=null;
		ArrayList<Party> list=null;
		if (dao2.getConnection() && dao.getConnection()) {
			list=dao.readAllParties();
			c=dao2.readCandidate(id);
		}
		request.setAttribute("candidatelist", c);
		request.setAttribute("partylist", list);
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showcandidatetoedit.jsp");
		rd.forward(request, response);
	}
}
