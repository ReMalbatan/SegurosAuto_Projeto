package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.ApoliceDAO;
import models.Apolice;

/**
 * Servlet implementation class RelatorioController
 */
@WebServlet("/RelatorioController")
public class RelatorioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Apolice> apolices = new ArrayList<Apolice>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RelatorioController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher requestDispatcher =
				getServletContext().getRequestDispatcher("/gerarRelatorio.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.apolices.clear();
		ApoliceDAO apoliceDAO = new ApoliceDAO();
		try {
			this.apolices = apoliceDAO.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(request.getParameter("filtro").equals("filtro-mes")) {
			ArrayList<Apolice> tempApolices = new ArrayList<Apolice>();
			for (Apolice a : this.apolices) {
				Calendar dataAtual = Calendar.getInstance();
				System.out.println(dataAtual.get(Calendar.MONTH));
				if((a.getInicio().get(Calendar.MONTH) == dataAtual.get(Calendar.MONTH) && a.getInicio().get(Calendar.YEAR) == dataAtual.get(Calendar.YEAR) ) || (a.getInicio().get(Calendar.MONTH) == dataAtual.get(Calendar.MONTH) - 1 && a.getInicio().get(Calendar.DATE) >= dataAtual.get(Calendar.DATE) && a.getInicio().get(Calendar.YEAR) == dataAtual.get(Calendar.YEAR))) {
					tempApolices.add(a);
				}
			}
			request.setAttribute("lista", tempApolices);
			RequestDispatcher requestDispatcher =
					getServletContext().getRequestDispatcher("/gerarRelatorio.jsp");
			requestDispatcher.forward(request, response);
		}
		else if(request.getParameter("filtro").equals("filtro-status")) {
			ArrayList<Apolice> tempApolices = new ArrayList<Apolice>();
			String statusFiltro = request.getParameter("status");
			for(Apolice a : this.apolices) {
				if(a.getStatus().equals(statusFiltro)) {
					tempApolices.add(a);
				}
			}
			request.setAttribute("lista", tempApolices);
			RequestDispatcher requestDispatcher =
					getServletContext().getRequestDispatcher("/gerarRelatorio.jsp");
			requestDispatcher.forward(request, response);
		}
		else if(request.getParameter("filtro").equals("filtro-vendedor")) {
			ArrayList<Apolice> tempApolices = new ArrayList<Apolice>();
			String statusFiltro = request.getParameter("vendedor");
		}
	}


}
