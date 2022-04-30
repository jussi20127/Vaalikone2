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
import data.Candidates;

@WebServlet(
    name = "EditedCandidateUpdate",
    urlPatterns = {"/editedcandidateupdate"}
)
public class EditedCandidateUpdate extends HttpServlet {
	private Dao2 dao;
	public void init() {
		dao=new Dao2("jdbc:mysql://localhost:3306/r8vaalikone", "jussi", "ananas100");
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException {
		response.sendRedirect("index.html");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException, ServletException {
		String id=request.getParameter("ehdokas_id");
		String sukunimi=request.getParameter("sukunimi");
		String etunimi=request.getParameter("etunimi");
		String numero=request.getParameter("numero");
		String puolue=request.getParameter("puolue");
		String kotipaikkakunta=request.getParameter("kotipaikkakunta");
		String ika=request.getParameter("ika");
		String ammatti=request.getParameter("ammatti");
		
		Candidates c=new Candidates(id, sukunimi, etunimi, numero, puolue, kotipaikkakunta, ika, ammatti);
		
		ArrayList<Candidates> list=null;
		if (dao.getConnection()) {
			list=dao.updateCandidate(c);
		}
		
		request.setAttribute("candidatelist", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/show_candidates.jsp");
		rd.forward(request, response);
	}
}