package org.commun.decorators;

import org.commun.decorator.DecoratorDeFiguras;
import org.commun.decorators.features.Linha;
import org.commun.figuras.Figura;

public class DecoradorDeFigurasLinha extends DecoratorDeFiguras {
	
	Linha linha;

	@Override
	public void decoradorDeFiguras(Figura figura) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double calcularArea() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calcularPerimetro() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String descricao() {
		// TODO Auto-generated method stub
		return null;
	}

}
