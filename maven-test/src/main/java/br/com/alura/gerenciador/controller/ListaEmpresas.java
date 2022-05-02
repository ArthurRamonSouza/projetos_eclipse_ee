package br.com.alura.gerenciador.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class ListaEmpresas implements Execute{
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		List<Empresa> lista = banco.getListaEmpresas();
		request.setAttribute("empresas", lista);
		return "foward:listaEmpresasCadastradas.jsp";
		//RequestDispatcher rq = request.getRequestDispatcher("/listaEmpresasCadastradas.jsp");
		//rq.forward(request, response);
	}

}
