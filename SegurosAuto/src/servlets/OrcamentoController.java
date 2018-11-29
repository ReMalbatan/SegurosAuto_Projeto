package servlets;
import models.Apolice;
import daos.ApoliceDAO;

import java.io.IOException;
import java.sql.SQLException;

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
		ApoliceDAO apoliceDAO = new ApoliceDAO();
		try {
			apoliceDAO.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		
		String tipoCobertura = request.getParameter("tipoCobertura");
		String valorMercado = request.getParameter("valorDeterminado");
		String valorDeterminado = request.getParameter("valorDeterminado");
		String danosMateriais = request.getParameter("danosMateriais");
		String danosCorporais = request.getParameter("danosCorporais");
		String franquiaCasco = request.getParameter("franquiaCasco");
		String franquiaAcessorios = request.getParameter("franquiaAcessorios");
		
		
		System.out.println(nome);
	}

}
