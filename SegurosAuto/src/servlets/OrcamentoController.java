package servlets;
import models.Apolice;
import models.Cobertura;
import models.Segurado;
import models.Veiculo;
import daos.ApoliceDAO;
import daos.VeiculoDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
	private ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
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
		VeiculoDAO veiculoDao = new VeiculoDAO();
		try {
			veiculos = veiculoDao.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listaVeiculos", this.veiculos);
		RequestDispatcher requestDispatcher =
		getServletContext().getRequestDispatcher("/fazerOrcamento.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VeiculoDAO veiculoDao = new VeiculoDAO();
		String button = request.getParameter("button");
		ApoliceDAO apoliceDAO = new ApoliceDAO();
		if(button.equals("buscar")){
			Veiculo veiculoSelecionado = null;
			try {
				veiculoSelecionado = veiculoDao.getById(Integer.parseInt(request.getParameter("fipeId")));
				veiculos = veiculoDao.getAll();
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("listaVeiculos", this.veiculos);
			request.setAttribute("veiculoSelecionado", veiculoSelecionado);
			RequestDispatcher requestDispatcher =
			getServletContext().getRequestDispatcher("/fazerOrcamento.jsp");
			requestDispatcher.forward(request, response);
		}
		else {
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
			String valorMercado = request.getParameter("valorMercado");
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
			
			Veiculo newVeiculo = new Veiculo(fipeId, marca, modelo, combustivel, portas, fabricacao, nPassageiros,Double.parseDouble(valorMercado));
			Segurado newSegurado = new Segurado(nome, cpf, genero, nacionalidade, profissao, telefone, endereco, email, cal);
			Cobertura newCobertura = new Cobertura(tipoCobertura,Double.parseDouble(valorMercado) , Double.parseDouble(valorDeterminado), Double.parseDouble(danosMateriais), Double.parseDouble(danosCorporais), franquiaCasco, Double.parseDouble(franquiaAcessorios));
			
			request.setAttribute("Cobertura", newCobertura);
			request.setAttribute("Segurado", newSegurado);
			request.setAttribute("Veiculo", newVeiculo);
			RequestDispatcher requestDispatcher =
					getServletContext().getRequestDispatcher("/orcamento.jsp");
					requestDispatcher.forward(request, response);
		}
		
	}

}
