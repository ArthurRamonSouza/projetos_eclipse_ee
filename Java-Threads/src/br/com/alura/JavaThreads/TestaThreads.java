package br.com.alura.JavaThreads;

public class TestaThreads {
	
	public static void main(String[] args) {
		//jconsole para monitorar os threads
		Runnable tarefa = new ImprimeString();
		Thread thread = new Thread(tarefa);
		thread.start();
	}

}
