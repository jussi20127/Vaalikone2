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
 * Servlet implementation class ReadToUpdate
 */
@WebServlet("/EditUpdate")
public class EditUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao;
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/r8vaalikone", "jussi", "ananas100");
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   
    //tässä String id -muuttuja saa arvon show_questions.jsp:stä linkin mukana
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("kysymys_id");
		//alustetaan tyhjä olio luokasta Questions. Sille annetaan nimeksi 'q'
		Question q=null;
		ArrayList<Subject> list=null;
		//Mikäli saadaan yhteys tietokantaan, voidaan käyttää metodia dao.readQuestion. Metodin palauttama arvo asetetaan oliolle q tiedoiksi.
		if (dao.getConnection()) {
			q=dao.readQuestion(id);
			list=dao.readAllSubjects();
		}
		//Vastaanotetaan q-olio Daosta, annetaan sille nimeksi 'question' // Jussin edit, tuodaan myös ArrayList list, jotta voidaan valita aihealue
		request.setAttribute("question", q);
		request.setAttribute("subjectlist", list);
		//lähetetään tiedot eteenpäin editChosen.jsp:lle
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/editChosen.jsp");
		rd.forward(request, response);
	}
}
