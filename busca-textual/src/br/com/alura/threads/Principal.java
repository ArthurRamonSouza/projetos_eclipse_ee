package br.com.alura.threads;

public class Principal {

	public static void main(String[] args) {

		String nomeProcurado = "ar";
		
		Thread threadAssinaturas1 = new Thread(new BuscaNome("assinaturas1.txt", nomeProcurado));
		Thread threadAssinaturas2 = new Thread(new BuscaNome("assinaturas2.txt", nomeProcurado));
		Thread threadAutores = new Thread(new BuscaNome("autores.txt", nomeProcurado));
		
		threadAssinaturas1.start();
		threadAssinaturas2.start();
		threadAutores.start();		
		
	}

}
