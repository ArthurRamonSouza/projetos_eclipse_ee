package br.com.alura.threads;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BuscaNome implements Runnable {
	private String nomeArquivo;
	private String nomeProcurado;

	public BuscaNome(String nomeArquivo, String nomeProcurado) {
		this.nomeArquivo = nomeArquivo;
		this.nomeProcurado = nomeProcurado;	
	}

	@Override
	public void run() {
		
		try {
			Scanner scanner = new Scanner(new File(nomeArquivo));
			
			int numeroLinha = 1;
			
			while(scanner.hasNextLine()) {
				
				String linha = scanner.nextLine();
				
				linha.toLowerCase();
				nomeProcurado.toLowerCase();
				
				if(linha.contains(nomeProcurado)){
					System.out.println(nomeArquivo + " - " + numeroLinha + " - " + linha);
					
				}
				
			numeroLinha++;
			
			}
			
			scanner.close();
			
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		
	}

}
