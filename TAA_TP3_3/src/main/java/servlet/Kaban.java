package servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kaban.Fiche;
import kaban.Lieu;
import kaban.Section;
import kaban.Tableau;
import kaban.TableauDAO;

@WebServlet(name="kaban",
urlPatterns={"/Kaban"})
public class Kaban extends HttpServlet {
	
	
	private TableauDAO dao;


	public void init() {
		this.dao = new TableauDAO();
	}
	
	
	
	public void doGet(HttpServletRequest request,
						HttpServletResponse response)
		 throws ServletException, IOException {
		
		
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			
			response.setContentType("text/html");
			
			PrintWriter out = response.getWriter();
			
			
			out.println("<HTML>\n<BODY>\n" +
						"<H1>Recapitulatif des informations</H1>\n" +
						"<UL>\n" +			
						this.dao.getFirstTableau(manager).toString()
						+				
				"</BODY></HTML>");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		
		manager.close();
		factory.close();
		
		
		
		
			
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		this.init();
		
		
		
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			
			response.setContentType("text/html");
			
			PrintWriter out = response.getWriter();
			
			Tableau t = this.dao.getFirstTableau(manager);
			Section s;
			if (!t.getSections().isEmpty()) {
				s = (Section) t.getSections().toArray()[0];
			}else {
				s = new Section();
				t.addSection(s);
			}
			
			Fiche f = new Fiche();
			s.addFiches(f);
			
			f.setUrl(request.getParameter("url"));
			f.setExplication(request.getParameter("description"));
			f.setLibelle(request.getParameter("libelle"));
			f.setLieu(new Lieu(request.getParameter("lieu")));
			
		manager.persist(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		
		manager.close();
		factory.close();
		
		

	}
	
	
	
}
