package services;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.GenericType;

import data.Candidate;

@WebServlet("/ReadOneCandidateInfo")
public class ReadOneCandidateInfo extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
	
		//Tähän restful servicen osoite ja mitä metodia sieltä haetaan
				String uri = "http://127.0.0.1:8080/rest/candidateinfoservice/getcandidateinfo/";	 
				
				//Client builder
				Client asiakas=ClientBuilder.newClient();
				WebTarget wt=asiakas.target(uri);
				Builder b=wt.request();
				
				Candidate candidate = b.get(Candidate.class);
				
				//returnedList saa nimen "candidatelist"
			    request.setAttribute("candidate", candidate);
				
				 RequestDispatcher rd=request.getRequestDispatcher("./jsp/read_one_candidate.jsp");
				  rd.forward(request, response);
	}
}
