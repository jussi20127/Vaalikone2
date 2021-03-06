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
import data.Question;
import data.Subject;

/**
 * Servlet implementation class ShowFish
 */
@WebServlet("/AddQuestion")
public class AddQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao=null;
	
	@Override
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/r8vaalikone", "jussi", "ananas100");
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Question> list=null;
		if (dao.getConnection()) {
			list=dao.readAllQuestions();
		}
		else {
			System.out.println("No connection to database");
		}
		ArrayList<Subject> list2=null;
		if (dao.getConnection()) {
			list2=dao.readAllSubjects();
		}
		else {
			System.out.println("No connection to database");
		}
		request.setAttribute("questionlist", list);
		request.setAttribute("subjectlist", list2);
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/add_question.jsp");
		rd.forward(request, response);
	}
}
