package web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dao.ISupermarcheDao;
import dao.SupermarcheDaoImpl;
import metier.entities.Supermarche;

@WebServlet(name = "cs", urlPatterns = { "/controleur", "*.do" })
public class ControleurServlet extends HttpServlet {
	ISupermarcheDao metier;

	@Override
	public void init() throws ServletException {
		metier = new SupermarcheDaoImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		if (path.equals("/index.do")) {
			request.getRequestDispatcher("supermarches.jsp").forward(request, response);
		} else if (path.equals("/chercher.do")) {
			String motCle = request.getParameter("motCle");
			SupermarcheModele model = new SupermarcheModele();
			model.setMotCle(motCle);
			List<Supermarche> supers  = metier.supermarcheParMC(motCle);
			model.setSupermarches(supers);
			request.setAttribute("model", model);
			request.getRequestDispatcher("supermarches.jsp").forward(request, response);
			
		} else if (path.equals("/saisie.do")) {
			request.getRequestDispatcher("saisieSupermarche.jsp").forward(request, response);
			
		} else if (path.equals("/save.do") && request.getMethod().equals("POST")) {
			String nom=request.getParameter("nom");
			String type=request.getParameter("type");
			String localisation=request.getParameter("localisation");

			Supermarche s = metier.save(new Supermarche(nom,type,localisation,null));
			request.setAttribute("supermarche", s);
			request.getRequestDispatcher("confirmation.jsp").forward(request, response);
			
		} else if (path.equals("/supprimer.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			metier.deleteSupermarche(id);
			response.sendRedirect("chercher.do?motCle=");
			
		} else if (path.equals("/editer.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			Supermarche s = metier.getSupermarche(id);
			request.setAttribute("supermarche", s);
			request.getRequestDispatcher("editerSupermarche.jsp").forward(request, response);
			
		} else if (path.equals("/update.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			String nom=request.getParameter("nom");
			String type=request.getParameter("type");
			String localisation=request.getParameter("localisation");

			Supermarche s = new Supermarche();
			s.setIdSupermarche(id);
			s.setNomSupermarche(nom);
			s.setType(type);
			s.setLoc(localisation);
			metier.updateSupermarche(s);
			request.setAttribute("supermarche", s);
			request.getRequestDispatcher("confirmation.jsp").forward(request, response);
		} else {
			response.sendError(Response.SC_NOT_FOUND);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}