package servlets;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.ApoliceDAO;
import models.Apolice;
import models.Corretora;
import models.Segurado;
import models.Veiculo;
import models.Cobertura;

//import database.ApoliceDAO;

import java.util.ArrayList;
import java.util.Calendar;


@WebServlet("/ApoliceController")
public class ApoliceController extends HttpServlet {
	
	private static final long serialVersionUID = 1L; 
	private ArrayList<Apolice> apolices = new ArrayList<Apolice>();
	//private ApoliceDAO apoliceDAO;
	
    public ApoliceController() {
        super();        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String S_id = request.getParameter("id");
		if(S_id != null){
			int id = Integer.parseInt(S_id);
			for(Apolice a : this.apolices){
				if(a.getId() == id){
					request.setAttribute("apolice", a);
					RequestDispatcher requestDispatcher =
					 getServletContext().getRequestDispatcher("/detalheApolice.jsp");
					requestDispatcher.forward(request, response);
					break;
				}
			}	
		}
		else{
			Calendar cal_inicio = Calendar.getInstance();
		    cal_inicio.set(Calendar.YEAR, 1997);

		    // We will have to increment the month field by 1

		    cal_inicio.set(Calendar.MONTH, 8);

		        // As the month indexing starts with 0

		    cal_inicio.set(Calendar.DAY_OF_MONTH, 20);
		        //apoliceDAO = new ApoliceDAO();
		    this.apolices.clear();
		    ApoliceDAO apoliceDAO = new ApoliceDAO();
		    try {
				this.apolices = apoliceDAO.getAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    //this.apolices.add(new Apolice(2,"Itau", "Fox", "Rafael", "Basica", cal_inicio, cal_inicio, "Ativo" ));
		    //this.apolices.add(new Apolice(10,"Porto", "UP", "Renan", "Basica", cal_inicio, cal_inicio, "Ativo" ));
			request.setAttribute("lista", this.apolices);
			RequestDispatcher requestDispatcher =
			 getServletContext().getRequestDispatcher("/listaApolices.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String button = request.getParameter("button");
		if ("salvar".equals(button)) {
			ApoliceDAO apoliceDao = new ApoliceDAO();
			try {
				apoliceDao.update("status", request.getParameter("status"), request.getParameter("idApolice"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				System.out.println("Finally");
				response.sendRedirect(request.getContextPath() + "/ApoliceController");
			}
			
        }
	}

}