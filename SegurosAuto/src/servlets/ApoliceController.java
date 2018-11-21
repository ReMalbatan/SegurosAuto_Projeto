package servlets;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Apolice;
import models.Corretora;
import models.Franquia;
import models.Segurado;
import models.Veiculo;

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
		    this.apolices.add(new Apolice(2,new Corretora("Porto", "1234-5678", "corretora@corretora.net", "Joao"), new Veiculo(5, "12345", "Audi", "A3", 5), new Segurado(21, "Renan", "123.456.789-00", "Brasileiro"), new Franquia("Basica", "1500"), cal_inicio, cal_inicio, "Ativo" ));
		    this.apolices.add(new Apolice(10,new Corretora("Porto", "1234-5678", "corretora@corretora.net", "Joao"), new Veiculo(5, "12345", "Audi", "A3", 5), new Segurado(21, "Rafael", "123.456.789-00", "Brasileiro"), new Franquia("Basica", "1500"), cal_inicio, cal_inicio, "Ativo" ));
		    this.apolices.add(new Apolice(100,new Corretora("Porto", "1234-5678", "corretora@corretora.net", "Joao"), new Veiculo(5, "12345", "Audi", "A3", 5), new Segurado(21, "Jose", "123.456.789-00", "Argentino"), new Franquia("Basica", "1500"), cal_inicio, cal_inicio, "Ativo" ));

		    //this.apolices.add(new Apolice(2,"Itau", "Fox", "Rafael", "Basica", cal_inicio, cal_inicio, "Ativo" ));
		    //this.apolices.add(new Apolice(10,"Porto", "UP", "Renan", "Basica", cal_inicio, cal_inicio, "Ativo" ));
			request.setAttribute("lista", this.apolices);
			RequestDispatcher requestDispatcher =
			 getServletContext().getRequestDispatcher("/listaApolices.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}