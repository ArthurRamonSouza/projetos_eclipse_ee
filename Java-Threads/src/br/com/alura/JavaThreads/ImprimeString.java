package br.com.alura.JavaThreads;

public class ImprimeString implements Runnable{

	@Override
	public void run() {
		System.out.println("Novo thread iniciado.");
	}

}
