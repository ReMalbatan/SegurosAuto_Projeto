package servlets;
import models.Apolice;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrcamentoController
 */
@WebServlet("/OrcamentoController")
public class OrcamentoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrcamentoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher =
		getServletContext().getRequestDispatcher("/fazerOrcamento.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String fipeId = request.getParameter("fipeId");
		String marca = request.getParameter("marca");
		String modelo = request.getParameter("modelo");
		String combustive = request.getParameter("combustivel");
		String portas =  request.getParameter("portas");
		String fabricacao = request.getParameter("fabricacao");
		String nPassageiros = request.getParameter("nPassageiros");
		String renavam = request.getParameter("renavam");
		String condutor = request.getParameter("condutor");
		
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String nacionalidade = request.getParameter("nacionalidade");
		String profissao = request.getParameter("profissao");
		String telefone = request.getParameter("telefone");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String nascimento = request.getParameter("nascimento");
		String genero = request.getParameter("genero");
		
		String tipoFranquia = request.getParameter("tipoFranquia");
		String valorCobertura = request.getParameter("valorCobertura");
		
		System.out.println(nome);
	}

}
