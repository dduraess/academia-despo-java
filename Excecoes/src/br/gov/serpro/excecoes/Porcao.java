package br.gov.serpro.excecoes;

public class Porcao {
	
//	public 
	
	public double porcao(double valor, double porCento) throws ForaDoIntervaloException {
		if (porCento > 100 || porCento < 0) {
			throw new ForaDoIntervaloException(String.valueOf(porCento));
		}
		
		return valor * porCento / 100;
	}
	
	public static void main(String[] args) {
		
		Porcao porcao = new Porcao();
		
		try {
			porcao.porcao(1000, -56);
		} catch (ForaDoIntervaloException e) {
			e.printStackTrace();
		}
	}

}
