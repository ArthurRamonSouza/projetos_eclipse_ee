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

public class AlteraEmpresa implements Execute{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeEmpresa = request.getParameter("nome");
		String paramData = request.getParameter("data");
		String paramId = request.getParameter("id");
		
		Integer id = Integer.valueOf(paramId);
		Date dataAbertura = null;
		try {
			dataAbertura = new SimpleDateFormat("dd/MM/yyyy").parse(paramData);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Banco banco = new Banco();
		Empresa emp = banco.buscaEmpresaPelaId(id);
		emp.setNome(nomeEmpresa);
		emp.setDataAbertura(dataAbertura);
		
		System.out.println("Empresa " + emp.getNome() + " teve alterações nos dados.");
		return "redirect:ListaEmpresas";
		//response.sendRedirect("response:entrada?acao=ListaEmpresas");
	}
}
