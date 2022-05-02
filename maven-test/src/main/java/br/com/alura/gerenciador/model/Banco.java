package br.com.alura.gerenciador.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<>();
	private static List<Usuario> logins = new ArrayList<>();
	private static Integer chaveSequencial = 1;

	static {

		Empresa empresa1 = new Empresa();
		empresa1.setId(chaveSequencial++);
		empresa1.setNome("Alura");
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Caelum");
		lista.add(empresa1);
		lista.add(empresa2);

		Usuario user1 = new Usuario();
		user1.setLogin("arthur");
		user1.setSenha("1234");
		Usuario user2 = new Usuario();
		user2.setLogin("adm");
		user2.setSenha("1234");
		logins.add(user1);
		logins.add(user2);

	}

	public void add(Empresa empresa) {
		empresa.setId(chaveSequencial++);
		Banco.lista.add(empresa);
	}

	public List<Empresa> getListaEmpresas() {
		return Banco.lista;
	}

	public void removeEmpresa(int id) {

		Iterator<Empresa> it = lista.iterator();

		while (it.hasNext()) {
			Empresa emp = it.next();
			if (emp.getId() == id) {
				it.remove();
			}
		}
	}

	public Empresa buscaEmpresaPelaId(int id) {
		for (Empresa empresa : lista) {
			if (empresa.getId() == id) {
				return empresa;

			}
		}
		return null;

	}

	public Usuario buscaUsuario(String login, String senha) {
		for (Usuario user : logins) {
			if (user.ehIgual(login, senha)) {
				return user;
			}
		}
		return null;
	}
}
