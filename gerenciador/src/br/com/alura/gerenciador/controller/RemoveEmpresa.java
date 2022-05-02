package br.com.alura.gerenciador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;

public class RemoveEmpresa implements Execute{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idParam = request.getParameter("id");
		Integer id = Integer.valueOf(idParam);
		Banco banco = new Banco();
		banco.removeEmpresa(id);
		System.out.println("Empresa com id " + id + " foi removida!");

		return "redirect:ListaEmpresas";
		//response.sendRedirect("entrada?acao=ListaEmpresas");
	}
}
