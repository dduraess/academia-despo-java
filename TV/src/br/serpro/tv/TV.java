package br.serpro.tv;

public class TV {
	
	private int canalAtivo = 0;
	private int nrPossivelCanais;
	private byte volume = 0;
	private boolean estaLigada = false;
	
	public TV (int nrCanais) {
		if (nrCanais>0) {
			nrPossivelCanais = nrCanais;
		}
	}
	
	public void mudarCanalNr(int nrCanal) {
		if (nrCanal > 0 && nrCanal <= nrPossivelCanais) {
			canalAtivo = nrCanal;
		}
	}
	
	public void aumentarCanal() {
		if (canalAtivo++ < nrPossivelCanais) {
			canalAtivo++;
		}
	}
	
	public void ligaDesliga() {
		estaLigada=!estaLigada;
	}
	

}
