package br.com.alura.gerenciador.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/entrada")
public class EntradaServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String parameter = request.getParameter("acao");
		
		String nomeDaClasse = "br.com.alura.gerenciador.controller." + parameter;
		String nome = null;
		try {
			Class classe = Class.forName(nomeDaClasse);
			Execute acao = (Execute)classe.newInstance();
			nome = acao.executa(request, response); 
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			new ServletException(e);
		}
        
       String[] tipoDeDirecionamento = nome.split(":");
       if(tipoDeDirecionamento[0].equals("foward")) {
    	   RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/view/" + tipoDeDirecionamento[1]);
    	   rq.forward(request, response);
       } else {
    	   response.sendRedirect("entrada?acao=" + tipoDeDirecionamento[1]);
       }
		
		/*
		 * if(parameter.equals("ListaEmpresas")) { ListaEmpresas acao = new
		 * ListaEmpresas(); acao.executa(request, response);
		 * 
		 * } else if(parameter.equals("AlteraEmpresa")){ AlteraEmpresa acao = new
		 * AlteraEmpresa(); acao.executa(request, response);
		 * 
		 * } else if(parameter.equals("MostraEmpresa")){ MostraEmpresa acao = new
		 * MostraEmpresa(); acao.executa(request, response);
		 * 
		 * } else if(parameter.equals("NovaEmpresa")){ NovaEmpresa acao = new
		 * NovaEmpresa(); acao.executa(request, response);
		 * 
		 * } else if(parameter.equals("RemoveEmpresa")){ RemoveEmpresa acao = new
		 * RemoveEmpresa(); acao.executa(request, response);
		 * 
		 * }
		 */
	}
}
