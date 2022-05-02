package br.com.alura.gerenciador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Usuario;

public class Login implements Execute {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		Banco banco = new Banco();
		Usuario usuarioEncontrado = banco.buscaUsuario(login, senha);

		if (usuarioEncontrado != null) {
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", usuarioEncontrado);
			System.out.println("Usuario " + usuarioEncontrado.getLogin() + " logado.");
			return "redirect:ListaEmpresas";
		} else {
			return "redirect:LoginForm";
		}
	}
}
