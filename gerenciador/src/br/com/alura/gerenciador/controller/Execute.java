package br.com.alura.gerenciador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Execute {

	String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
