package br.com.alura.gerenciador.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class ControladorFilter
 */
//@WebFilter("/entrada")
public class ControladorFilter implements Filter {
	
	/*
	 * @Override public void init(FilterConfig filterConfig) throws ServletException
	 * {}
	 * 
	 * @Override public void destroy() {}
	 */
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        System.out.println("ControladorFilter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        
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
	}
}