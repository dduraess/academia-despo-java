package br.gov.serpro.excecoes;

public class Principal {

	public static void main(String[] args) throws Exception{
		a(-100);
	}
	
	public static void a(int i) { 
		try {
			b(i);
		} catch (Exception e) {
			System.out.println("Tratando a exceção: " + e.getMessage());
		} System.out.println("Terminando a execução de a()");
		
	}
	
	public static void b(int i) throws Exception{
		System.out.println("Executando b() com " + i);
		if(i > 0) {
			throw new Exception("msg!");
		} System.out.println("Terminando a execução de b()");
		
	}

}
