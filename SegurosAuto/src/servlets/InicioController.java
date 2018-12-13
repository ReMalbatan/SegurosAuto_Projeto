package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InicioController
 */
@WebServlet("/")
public class InicioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InicioController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String logado = (request.getParameter("logado") == null) ? "" : request.getParameter("logado");
		if(!logado.equals("")) {
			RequestDispatcher requestDispatcher =
					getServletContext().getRequestDispatcher("/home.jsp");
			requestDispatcher.forward(request, response);
		}
		else {
			RequestDispatcher requestDispatcher =
					getServletContext().getRequestDispatcher("/telaInicial.jsp");
			requestDispatcher.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		if(!login.equals(null) && !senha.equals(null)) {
			if(login.equals("admin") && senha.equals("admin")) {
				RequestDispatcher requestDispatcher =
						getServletContext().getRequestDispatcher("/home.jsp");
				requestDispatcher.forward(request, response);
			}
		}
		else {
			RequestDispatcher requestDispatcher =
					getServletContext().getRequestDispatcher("/telaInicial.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
