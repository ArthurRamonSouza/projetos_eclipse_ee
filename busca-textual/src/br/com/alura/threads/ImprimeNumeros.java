package br.com.alura.threads;

public class ImprimeNumeros {

	public static void main(String[] args) {
		new Thread(new TarefaImprimeNumeros()).start();
		new Thread(new TarefaImprimeNumeros()).start();
	}
}
