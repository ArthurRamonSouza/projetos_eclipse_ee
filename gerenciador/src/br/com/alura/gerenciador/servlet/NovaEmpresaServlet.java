package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

/**
 * Servlet implementation class NovaEmpresaServlet
 */

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeEmpresa = request.getParameter("nome");
		String dataEmpresa = request.getParameter("data");
		
		Date dataParseada = null;

		try {
			dataParseada = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataParseada);
		
		Banco banco = new Banco();
		banco.add(empresa);
		
		System.out.println("Empresa " + empresa.getNome() +" nova cadastrada!");
		System.out.println("Data de abertura:" + dataParseada + " - " + dataEmpresa);
		
		//Como atrelar dados da nossa request?
		request.setAttribute("empresa", nomeEmpresa);
		//redirecionamento client side
		response.sendRedirect("listaEmpresas");
		
		//Como encaminhamos as requests e responses para o JSP, redirecionamento sever side?
		//RequestDispatcher rDispatcher = request.getRequestDispatcher("/listaEmpresas");
		//rDispatcher.forward(request, response);
		
	}

}