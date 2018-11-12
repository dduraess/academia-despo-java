package tst.teste;

public class Compila {

	public double porcao(double valor, double porCento) {
		if (porCento > 100 || porCento > 0) {
			return porCento / valor;
		}
		return -1;

	}

}
