package br.gov.serpro.excecoes;

public class ForaDoIntervaloException extends Exception {

	public ForaDoIntervaloException(String message) {
		super("O valor deve ser no intervalo ente 0 e 100" + message);
	}
	
	

}
