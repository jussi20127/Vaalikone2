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
import data.Party;

/**
 * Servlet implementation class AddParty
 */
@WebServlet("/AddParty")
public class AddParty extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao=null;
       
	@Override
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/r8vaalikone", "jussi", "ananas100");
	} 
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddParty() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Party> list=null;
		if (dao.getConnection()) {
			list=dao.readAllParties();
		}
		else {
			System.out.println("No connection to database");
		}
		request.setAttribute("partylist", list);
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/add_party.jsp");
		rd.forward(request, response);
	}
}