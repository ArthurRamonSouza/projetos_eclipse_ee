package br.com.alura.gerenciador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class MostraEmpresa implements Execute {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("id");
		Integer id = Integer.valueOf(idParam);
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPelaId(id);
		request.setAttribute("empresa", empresa);
		System.out.println("Talvez a " + empresa.getNome() + " seja alterada.");
		return "foward:formAlteraEmpresa.jsp";
		//RequestDispatcher rq = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
		//rq.forward(request, response);
	}

}
