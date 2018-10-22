package br.serpro.tv;

import java.util.List;

public class TV {
	
	private Integer indiceCanalAtivo = 0;
	private List<Integer> listaCanais;
	private byte volume = 0;
	private boolean estaLigada = false;

	public TV (List<Integer> listaCanais) {
		this.listaCanais = listaCanais;
	}
	
	public Integer mudarCanalNr(Integer nrCanal) {
		for (Integer integer : listaCanais) {
			if (nrCanal.equals(listaCanais.get(integer))) {
				return indiceCanalAtivo;
			}
		} return indiceCanalAtivo;
		
	}

	public int aumentarCanal() {
		return listaCanais.get(indiceCanalAtivo);
	}

	public int diminuirCanal() {
//		if (listaCanais[CanalAtivo] > 0) {
//			CanalAtivo = listaCanais[CanalAtivo-1];
//		}
		return indiceCanalAtivo;
	}

	public int aumentarVolume() {
		int volumeAtual = this.volume;
		if (volumeAtual++ <= 50) {
			volume++;
		}
		return volume;
	}

	public int diminuirVolume() {
		int volumeAtual = this.volume;
		if (volumeAtual-- > 0) {
			volume--;
		}
		return volume;
	}

	public void ligaDesliga() {
		estaLigada=!estaLigada;
	}

	

}
