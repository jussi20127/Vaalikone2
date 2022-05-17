package rest;

//HUOM! Tarkista, että importtaa oikean Listin!
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.JpaDao;
import data.Question;

//Tällä servicellä haetaan kysymyksiä ja tallennetaan vastauksia

//Servicen path
@Path("/questionserviceforcandidate")
public class QuestionServiceForCandidate {
	//luodaan EntityManagerFactory emf, joka käyttää tietokantaa r8vaalikone
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("r8vaalikone");
	
	//Metodi, joka hakee kaikki kysymykset ehdokkaalle näytettäväksi
	@GET
	//Koko path on rest/questionserviceforcandidate/getquestions
	@Path("/getquestions")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Question> getQuestions(){
		//Luodaan uusi EntityManager em
	    EntityManager em=emf.createEntityManager();
	    em.getEntityManagerFactory().getCache().evictAll();
	    //Luodaan uusi JpaDao-luokan olio, konstruktorille luotu EntityManager em
	    JpaDao jpadao = new JpaDao(em);
	    //Uusi List-tyyppinen muuttuja list, joka vastaanottaa Question-olioita
	    //luodaan kutsumalla JpaDaon metodia readQuestions
	    java.util.List<Question> list = jpadao.readQuestions();
	    //palautetaan list ReadAllQuestionsForCandidates.javalle
		return list;
	}
}
