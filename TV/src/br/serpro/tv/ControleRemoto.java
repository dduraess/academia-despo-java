package br.serpro.tv;

public class ControleRemoto {
	
	private TV tvControlada;
	
	public ControleRemoto (TV tv) {
		this.tvControlada = tv;
	}
	
	public Integer informarCanal(Integer nrCanal) {
		tvControlada.mudarCanalNr(nrCanal);
		return tvControlada.getCanalAtivo();
	}
	
	public void powerPressed() {
		tvControlada.ligaDesliga();
	}
	
	public Integer plusChPressed() {
		tvControlada.aumentarCanal();
		return tvControlada.getCanalAtivo();
	}
	
	public Integer lessChPressed() {
		tvControlada.diminuirCanal();
		return tvControlada.getCanalAtivo();
	}
	
	public Integer plusVlPressed() {
		tvControlada.aumentarVolume();
		return tvControlada.getVolume();
	}
	
	public Integer lessVlPressed() {
		tvControlada.diminuirVolume();
		return tvControlada.getVolume();
	}

}
