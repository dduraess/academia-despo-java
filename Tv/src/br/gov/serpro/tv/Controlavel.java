package br.gov.serpro.tv;

public interface Controlavel {
	
	public Boolean ligaDesliga(); 
	public Integer irParaProximaMedia();
	public Integer irParaMediaAnterior();
	public Integer irParaMediaNr(Integer nrMedia);
	public Integer aumentarSom();
	public Integer diminuirSom();

}
