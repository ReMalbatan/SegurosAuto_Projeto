package servlets;
import models.Apolice;
import models.Cobertura;
import models.Segurado;
import models.Veiculo;
import daos.ApoliceDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
		String combustivel = request.getParameter("combustivel");
		int portas = Integer.parseInt(request.getParameter("portas"));
		String fabricacao = request.getParameter("fabricacao");
		int nPassageiros = Integer.parseInt(request.getParameter("nPassageiros"));
		
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date;
		Calendar cal = Calendar.getInstance();
		try {
			date = sdf.parse(nascimento);
			cal.setTime(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Veiculo newVeiculo = new Veiculo(fipeId, marca, modelo, combustivel, portas, fabricacao, nPassageiros, 0.0);
		Segurado newSegurado = new Segurado(nome, cpf, genero, nacionalidade, profissao, telefone, endereco, email, cal);
		Cobertura newCobertura = new Cobertura(tipoCobertura,0.0 , Double.parseDouble(valorDeterminado), Double.parseDouble(danosMateriais), Double.parseDouble(danosCorporais), Double.parseDouble(franquiaCasco), Double.parseDouble(franquiaAcessorios));
		
		System.out.println(nome);
	}

}
