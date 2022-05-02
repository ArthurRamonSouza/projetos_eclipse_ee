package br.com.alura.gerenciador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovaEmpresaForm implements Execute{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "foward:novaEmpresaFormulario.jsp";
	}
}
