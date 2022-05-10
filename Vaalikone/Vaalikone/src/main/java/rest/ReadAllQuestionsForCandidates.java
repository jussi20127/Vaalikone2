package rest;

import java.io.*;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.JpaDao;

import java.util.ArrayList;
import java.util.List;
import data.*;

@WebServlet("/ReadAllQuestionsForCandidates")
public class ReadAllQuestionsForCandidates extends HttpServlet {

	//luodaan EntityManagerFactory, jotta sovelluksessa voidaan käsitellä/hakea entityjä tietokannasta
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("r8vaalikone");
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {
	  //Luodaan EntityManager olio hallinnoimaan persistence unitin määrittämiä entityjä
	  //EM tarkkailee entity objecteja muutosten varalta ja siirtää muutokset tietokantaan
	  EntityManager em=emf.createEntityManager();
	  //Luodaan uusi JpaDao-olio, jotta päästään käsiksi JpaDao-luokan metodeihin
	  //Käytetään olion konstruktorin attribuuttina luotua EntityManageria
	  JpaDao jpadao = new JpaDao(em);
	  //Otetaan yhteys JpaDaoon ja tallennetaan List-tyyppiseen "list"-listaan readQuestions-metodista saadut tiedot
	  List list = jpadao.readQuestions();
	  //Annetaan listille nimeksi questionlist, valmistaudutaan lähettämään se jsp:lle
	  request.setAttribute("questionlist", list);
	  //Lähetetään questionlist jsp:lle nähtäväksi
	  RequestDispatcher rd=request.getRequestDispatcher("./jsp/readallquestions_candidates.jsp");
	  rd.forward(request, response);
  }
}