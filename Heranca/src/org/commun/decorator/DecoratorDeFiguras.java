package org.commun.decorator;

import org.commun.figuras.Figura;

public abstract class DecoratorDeFiguras implements Figura {
	
	Figura figuraDecorada;
	
	public abstract void decoradorDeFiguras (Figura figura);

}
