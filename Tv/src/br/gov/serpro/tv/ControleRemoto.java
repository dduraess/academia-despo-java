package br.gov.serpro.tv;

public class ControleRemoto {
	
	private Controlavel dispositivoControlavel;
	
	public ControleRemoto (Controlavel meuDispositivo) {
		this.dispositivoControlavel = meuDispositivo;
	}
	
	public Integer informarNrMedia(Integer nrMedia) {
		return dispositivoControlavel.irParaMediaNr(nrMedia);
	}
	
	public boolean powerPressed() {
		return dispositivoControlavel.ligaDesliga();
	}
	
	public Integer plusChPressed() {
		return dispositivoControlavel.irParaProximaMedia();
	}
	
	public Integer lessChPressed() {
		return dispositivoControlavel.irParaMediaAnterior();
	}
	
	public Integer plusVlPressed() {
		return dispositivoControlavel.aumentarSom();
	}
	
	public Integer lessVlPressed() {
		return dispositivoControlavel.diminuirSom();
	}

}
