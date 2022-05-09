package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Question;
import data.Subject;

import java.io.Console;
import java.sql.Connection;

public class Dao {
	private String url;
	private String user;
	private String pass;
	private Connection conn;
	
	public Dao(String url, String user, String pass) {
		this.url=url;
		this.user=user;
		this.pass=pass;
	}
	//luodaan yhteys mysql:ään
	public boolean getConnection() {
		try {
	        if (conn == null || conn.isClosed()) {
	            try {
	                Class.forName("com.mysql.jdbc.Driver").newInstance();
	            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
	                throw new SQLException(e);
	            }
	            conn = DriverManager.getConnection(url, user, pass);
	        }
	        return true;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	public ArrayList<Question> readAllQuestions() {
		ArrayList<Question> list=new ArrayList<>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery("select * from questions");
			while (RS.next()){
				Question q=new Question();
				q.setId(RS.getInt("id"));
				q.setKysymys(RS.getString("kysymys"));
				q.setAihealue(RS.getString("aihealue"));
				list.add(q);
			}
			return list;
		}
		catch(SQLException e) {
			return null;
		}
	}
	//Päivitetään kysymykset, metodi ottaa vastaan parametrin 'q' Update.javasta
	public ArrayList<Question> updateQuestion(Question q) {
		try {
			//luodaan jälleen sql-kyselyitä. Kun tehdään update... set, ei voida pistää monta muokattavaa arvoa peräjälkeen, vaan kaikki tarvitsevat oman sql-kyselyn
			String sql="update questions set kysymys=? where id=?";
			String sql2="update questions set aihealue=? where id=?";
			int id = q.getId();
			String idStr = Integer.toString(id);
			PreparedStatement pstmt=conn.prepareStatement(sql);
			PreparedStatement pstmt2=conn.prepareStatement(sql2);
			//PreparedStatement pstmt=conn.prepareStatement(sql3);
			pstmt.setString(1, q.getKysymys());
			pstmt.setInt(2, q.getId());
			
			pstmt2.setString(1, q.getAihealue());
			pstmt2.setInt(2, q.getId());
			
			//suoritetaan kyselyt, päivitetään tiedot ja seuraavaa näkymää varten palautetaan päivitetty kysymyslista kutsumalla readAllQuestions-metodia Daosta
			pstmt.executeUpdate();
			pstmt2.executeUpdate();
			return readAllQuestions();
		}
		catch(SQLException e) {
			return null;
		}
	}
	public ArrayList<Question> deleteQuestion(String id) {
		try {
			String sql="delete from questions where id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			return readAllQuestions();
		}
		catch(SQLException e) {
			return null;
		}
	}
	//Tähän saavutaan EditUpdate.javasta, readQuestion ottaa vastaan muuttujan id, joka saatiin alunperin show_questions.jsp:stä
	public Question readQuestion(String id) {
		//alustetaan luokan Questions tyhjä olio 'q'
		Question q=null;
		try {
			//asetetaan muuttujaan 'sql' mysql-kysely
			//luodaan muuttuja pstmt, johon edellinen kysely pistetään
			//pstmt:n sulkeissa oleva '1' merkitsee ensimmäistä tyhjää paikkaa kyselyssä eli ekaa '=?'-kohtaa. Tähän asetetaan arvo 'id' (joka saatiin edellä EdiUpdatesta).
			String sql="select * from questions where id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			//Muuttuja valmiin sql-kyselyn suorittamiseksi
			ResultSet RS=pstmt.executeQuery();
			//niin kauan kuin taulukosta löytyy kyselyä vastaavia arvoja, jatketaan läpikäyntiä ja asetetaan kannasta löytyvät arvot q-olion attribuuteiksi
			while (RS.next()){
				q=new Question();
				q.setId(RS.getInt("id"));
				q.setKysymys(RS.getString("kysymys"));
				q.setAihealue(RS.getString("aihealue"));
				
			}
			//palautetaan q-olio EditUpdateen
			return q;
		}
		catch(SQLException e) {
			return null;
		}
	}
	public ArrayList<Question> addQuestion(String kysymys, String aihealue) {
		try {
			String sql="insert into questions (kysymys,aihealue) values(?,?)";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, kysymys);
			pstmt.setString(2, aihealue);
			pstmt.executeUpdate();
			return readAllQuestions();
		}
		catch(SQLException e) {
			System.out.println("Ei onnistunut");
			return null;
		}
	}
	
	//-------------- AIHEALUEET --------------------------------------------------------
	
	public ArrayList<Subject> readAllSubjects() {
		ArrayList<Subject> list=new ArrayList<>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery("select * from subjects");
			while (RS.next()){
				Subject s=new Subject();
				s.setId(RS.getInt("id"));
				s.setAihealue(RS.getString("aihealue"));
				list.add(s);
			}
			return list;
		}
		catch(SQLException e) {
			return null;
		}
	}
	public ArrayList<Subject> addSubject(String id, String aihealue) {
		try {
			String sql="insert into subjects values(?,?)";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, aihealue);
			pstmt.executeUpdate();
			return readAllSubjects();
		}
		catch(SQLException e) {
			System.out.println("Ei onnistunut");
			return null;
		}
	}
}
