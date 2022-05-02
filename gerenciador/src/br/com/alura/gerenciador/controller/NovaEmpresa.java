package br.com.alura.gerenciador.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class NovaEmpresa implements Execute{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		return "redirect:ListaEmpresas";
		//response.sendRedirect("entrada?acao=ListaEmpresas");
	}
}
