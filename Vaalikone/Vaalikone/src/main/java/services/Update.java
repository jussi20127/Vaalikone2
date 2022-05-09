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

@WebServlet(
    name = "Update/editing",
    urlPatterns = {"/update/editing"}
)
public class Update extends HttpServlet {
	private Dao dao;
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/r8vaalikone", "jussi", "ananas100");
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException {
		response.sendRedirect("../index.html");
	}
	
	//doPost-metodi, tähän pyydetään formilta attribuutit id, kysymys ja aihe
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException, ServletException {
		String id=request.getParameter("id");
		String kysymys=request.getParameter("kysymys");
		String aihealue=request.getParameter("aihealue");
		
		//luo uuden Questions-luokan olion vastaanotetuilla attribuuteilla
		Question q=new Question(id, kysymys, aihealue);
		
		//Luodaan ArrayList Question-olion tyyppisenä, annetaan sille nimi 'list' ja arvot saadaan kutsumalla updateQuestion-metodia Daosta
		ArrayList<Question> list=null;
		if (dao.getConnection()) {
			list=dao.updateQuestion(q);
			
		}
		
		request.setAttribute("questionlist", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/show_questions.jsp");
		rd.forward(request, response);
	}
}