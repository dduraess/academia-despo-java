package br.gov.serpro.tv;

import java.util.List;

public class TV implements Controlavel {
	
	private Integer canalAtivo = 0;
	private List<Integer> listaCanais;
	private Integer volume = 0;
	private boolean estaLigada = false;

	public TV (List<Integer> listaCanais) {
		this.listaCanais = listaCanais;
	}
	
	public void mudarCanalNr(Integer nrCanal) {
		if (listaCanais.contains(nrCanal)) {
			canalAtivo = nrCanal;
		} 		
	}

	public void aumentarCanal() {
		
		//se for o último canal da lista, pega o primeiro  
		if(canalAtivo.equals(listaCanais.get(listaCanais.size() - 1))) {
			canalAtivo = listaCanais.get(0);
		} else { //senão põe o canal ativo na próxima posição
			Integer posicaoDoCanalAtivoNaLista = listaCanais.indexOf(canalAtivo); 
			canalAtivo = listaCanais.get(posicaoDoCanalAtivoNaLista + 1);
		}
	}

	public void diminuirCanal() {
		//se for o primeiro canal da lista, pega o último 
		if(canalAtivo.equals(listaCanais.get(0))) {			 
			canalAtivo = listaCanais.get(listaCanais.size() - 1);
		} else { //senão põe o canal na posição anterior 
			Integer posicaoDoCanalAtivoNaLista = listaCanais.indexOf(canalAtivo); 
			canalAtivo = listaCanais.get(posicaoDoCanalAtivoNaLista - 1);
		}
	}

	public void aumentarVolume() {
		int volumeAtual = this.volume;
		if (volumeAtual + 1 <= 50) {
			volume++;
		}
	}

	public void diminuirVolume() {
		int volumeAtual = this.volume;
		if (volumeAtual - 1 > 0) {
			volume--;
		}
	}

	public boolean ligaDesligaTV() {
		estaLigada=!estaLigada;
		return estaLigada;
	}

	public Integer getCanalAtivo() {
		return canalAtivo;
	}

	public Integer getVolume() {
		return volume;
	}

	@Override
	public Boolean ligaDesliga() {
		return ligaDesligaTV();
	}

	@Override
	public Integer irParaProximaMedia() {
		aumentarCanal();
		return getCanalAtivo();
	}

	@Override
	public Integer irParaMediaAnterior() {
		diminuirCanal();
		return getCanalAtivo();
	}

	@Override
	public Integer irParaMediaNr(Integer nrMedia) {
		mudarCanalNr(nrMedia);
		return getCanalAtivo();
	}

	@Override
	public Integer aumentarSom() {
		this.aumentarVolume();
		return getVolume();
	}

	@Override
	public Integer diminuirSom() {
		this.diminuirVolume();
		return getVolume();
	}

}
