package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Candidate;

public class Dao2 {
	private String url;
	private String user;
	private String pass;
	private Connection conn;
	
	public Dao2(String url, String user, String pass) {
		this.url=url;
		this.user=user;
		this.pass=pass;
	}
	
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
	public ArrayList<Candidate> readAllCandidates() {
		ArrayList<Candidate> list=new ArrayList<>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery("select * from candidates");
			while (RS.next()){
				Candidate c=new Candidate();
				c.setId(RS.getInt("id"));
				c.setSukunimi(RS.getString("sukunimi"));
				c.setEtunimi(RS.getString("etunimi"));
				c.setNumero(RS.getString("numero"));
				//c.setParty(RS.getString("puolue"));
				c.setKotipaikkakunta(RS.getString("kotipaikkakunta"));
				c.setIka(RS.getString("ika"));
				c.setAmmatti(RS.getString("ammatti"));
				list.add(c);
			}
			return list;
		}
		catch(SQLException e) {
			return null;
		}
	}
	public ArrayList<Candidate> updateCandidate(Candidate c) {
		try {
			//String sql="update candidates set id=? where id=?";
			String sql1="update candidates set sukunimi=? where id=?";
			String sql2="update candidates set etunimi=? where id=?";
			String sql3="update candidates set numero=? where id=?";
			//String sql4="update candidates set puolue=? where id=?";
			String sql5="update candidates set kotipaikkakunta=? where id=?";
			String sql6="update candidates set ika=? where id=?";
			String sql7="update candidates set ammatti=? where id=?";
			
			//PreparedStatement pstmt=conn.prepareStatement(sql);
			PreparedStatement pstmt1=conn.prepareStatement(sql1);
			PreparedStatement pstmt2=conn.prepareStatement(sql2);
			PreparedStatement pstmt3=conn.prepareStatement(sql3);
			//PreparedStatement pstmt4=conn.prepareStatement(sql4);
			PreparedStatement pstmt5=conn.prepareStatement(sql5);
			PreparedStatement pstmt6=conn.prepareStatement(sql6);
			PreparedStatement pstmt7=conn.prepareStatement(sql7);
			
			//pstmt.setInt(1, c.getId());
			//pstmt.setInt(2, c.getId());
			
			pstmt1.setString(1, c.getSukunimi());
			pstmt1.setInt(2, c.getId());
			
			pstmt2.setString(1, c.getEtunimi());
			pstmt2.setInt(2, c.getId());
			
			pstmt3.setInt(1, c.getNumero());
			pstmt3.setInt(2, c.getId());
			
			//pstmt4.setInt(1, c.party_id());
			//pstmt4.setInt(2, c.getId());
			
			pstmt5.setString(1, c.getKotipaikkakunta());
			pstmt5.setInt(2, c.getId());
			
			pstmt6.setInt(1, c.getIka());
			pstmt6.setInt(2, c.getId());
			
			pstmt7.setString(1, c.getAmmatti());
			pstmt7.setInt(2, c.getId());
			
			//pstmt.executeUpdate();
			pstmt1.executeUpdate();
			pstmt2.executeUpdate();
			pstmt3.executeUpdate();
			//pstmt4.executeUpdate();
			pstmt5.executeUpdate();
			pstmt6.executeUpdate();
			pstmt7.executeUpdate();
			return readAllCandidates();
		}
		catch(SQLException e) {
			return null;
		}
	}
	public ArrayList<Candidate> deleteCandidate(String id) {
		try {
			String sql="delete from candidates where id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			return readAllCandidates();
		}
		catch(SQLException e) {
			return null;
		}
	}

	public Candidate readCandidate(String id) {
		Candidate c=null;
		try {
			String sql="select * from candidates where id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet RS=pstmt.executeQuery();
			while (RS.next()){
				c=new Candidate();
				c.setId(RS.getInt("id"));
				c.setSukunimi(RS.getString("sukunimi"));
				c.setEtunimi(RS.getString("etunimi"));
				c.setNumero(RS.getInt("numero"));
				//c.setPuolue(RS.getString("puolue"));
				c.setKotipaikkakunta(RS.getString("kotipaikkakunta"));
				c.setIka(RS.getInt("ika"));
				c.setAmmatti(RS.getString("ammatti"));
				
			}
			return c;
		}
		catch(SQLException e) {
			return null;
		}
	}
	public ArrayList<Candidate> addCandidate(String sukunimi, String etunimi, String numero, String kotipaikkakunta, String ika, String ammatti) {
		try {
			String sql="insert into candidates (sukunimi,etunimi,numero,puolue_id,kotipaikkakunta,ika,ammatti) values(?,?,?,?,?,?,?)";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			//pstmt.setString(1, id);
			pstmt.setString(1, sukunimi);
			pstmt.setString(2, etunimi);
			pstmt.setString(3, numero);
			pstmt.setString(4, "1"); // TÄMÄ VIELÄ KORJATTAVA!!!
			pstmt.setString(5, kotipaikkakunta);
			pstmt.setString(6, ika);
			pstmt.setString(7, ammatti);
			pstmt.executeUpdate();
			return readAllCandidates();
		}
		catch(SQLException e) {
			System.out.println("Ei onnistunut");
			return null;
		}
	}

}
