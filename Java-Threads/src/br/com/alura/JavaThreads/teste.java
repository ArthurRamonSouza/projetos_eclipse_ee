package br.com.alura.JavaThreads;

public class teste {

	public static void main(String[] args) {
		Runnable tarefa = new ImprimeString();
		Thread thread = new Thread(tarefa);
		thread.start();
		

	}

}
