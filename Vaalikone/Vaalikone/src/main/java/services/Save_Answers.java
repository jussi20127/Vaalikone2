package services;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

//ehdokkaan vastausten tallentaminen
@WebServlet("/Save_Answers")

//luodaan yhteys tietokantaan
public class Save_Answers extends HttpServlet {
	 static final String dbURL = "jdbc:mysql://localhost:3306/r8vaalikone";
     static final String dbUser = "jussi";
     static final String dbPass = "ananas100";
    @Override
     public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");    
        PrintWriter out = response.getWriter();
            ResultSet rs=null;
            Connection connection = null;  
            try{
    
    HttpSession session = request.getSession();
    String[] vastaus=request.getParameterValues("vastaus");
    //String ehdokas=request.getParameter("ehdokas");
    //String[] aihealue=request.getParameterValues("aihealue");
    
    //nyt saa kysymyksen id:n tekstikentästä, jonka käyttäjä täyttää, pitäisi saada muulla keinoin
    String[] kysymys=request.getParameterValues("question_id");
    System.out.println("kysymyksen indeksi 1 on " + kysymys[1] + " ja indeksistä 2 löytyy " + kysymys[2]);
    int id = 1;
    int aihealue = 1;
    //String aihealue = request.getParameter("aihealue");
    //int ehdokas = 2;
    String ehdokas = request.getParameter("ehdokas_id");
    int o=0;


    Class.forName("com.mysql.jdbc.Driver");
connection = DriverManager.getConnection (dbURL,dbUser,dbPass);
String sql="insert into answers(id,vastaus,candidate_id, subject_id,question_id)values(?,?,?,?,?)";
PreparedStatement prep = connection.prepareStatement(sql);

/*for-loop, jossa lisätään vastaukset tietokantaan
 * joka loopilla haetaan vastaus-listalta seuraavan indeksin vastaus ja tallennetaan se tietokantaan + muut parametrit
 * id:n lisäys tietokantaan ei oikeastaan tee mitään, kun id on auto_increment, mutta ilman sitä ohjelma valittaa, joten olkoot siinä
*/
int count_updated = 0;
for(int i = 0; i < vastaus.length; i++){
	
	 prep.setInt(1, id+i);
	 System.out.println("Id on nyt "+ id+i);
	 
	 prep.setString(2, vastaus[i]);
	 System.out.println("Vastaus on nyt " + vastaus[i]);
	 
	 //prep.setString(2, ehdokas);
	 System.out.println(ehdokas);
	 prep.setString(3, ehdokas);
	 System.out.println("Ehdokas on nyt " + ehdokas);
	 
	 //prep.setString(3,aihealue[i]);
	 //System.out.println(aihealue[i]);
	 prep.setInt(4, aihealue);
	 System.out.println("Aihe on nyt " + aihealue);
	 
	 //prep.setString(3,kysymys[i]);
	 //System.out.println(kysymys[i]);
	 prep.setString(5, kysymys[i]);
	 System.out.println("Kysymys on nyt " + kysymys[i]);
	 
	 count_updated += prep.executeUpdate();
	 
	}
	prep.close();
	       }
	     catch(Exception E){
	//Any Exceptions will be caught here
	System.out.println("The error is"+E.getMessage());
	
	    }  

        finally {
            try {
                connection.close();
            }
            //virheviestit
        catch (Exception ex) {
                System.out.println("The error is"+ex.getMessage());
            }
                }

}
}
