TV e ControleRemoto

TV
- construtor (array de canais possíveis)
- canal ativo
- canais possíveis (array)
- volume (0 a 50)
- ligada ou não

Controle Remoto
- construtor (TV)
- muda o canal (através de número, e aumentar e diminuir canal [setinhas])
- liga e desliga
- aumenta diminui volume (setinhas)

Testes unitários de todas as funcionalidades no controle remoto
- Usar Asserts 

Tem que verificar:
- se o volume está dentro do intervalo possível
- se o canal existe

COLOCAR NO GIT!

package br.serpro.tv;

public class TV {
	
	private int canalAtivo;
	private int nrPossivelCanais;
	private int listaCanais[];
	private byte volume;
	private boolean estaLigada;
	
	public TV (int nrCanais) {
		if (nrCanais>0) {
			nrPossivelCanais = nrCanais;
			int contadorVetor = 1;
			for (int i = 0; i < nrPossivelCanais; i++) {
				listaCanais[i] = contadorVetor;
				contadorVetor++;
			}
		}
		canalAtivo = 0;
		volume = 0;
		estaLigada = false;
	}
	
	public int mudarCanalNr(int nrCanal) {
		if (nrCanal > 0 && nrCanal <= nrPossivelCanais) {
			canalAtivo = listaCanais[nrCanal-1];
		}
		return canalAtivo;
	}
	
	public int aumentarCanal() {
		if (listaCanais[canalAtivo] <= nrPossivelCanais) {
			canalAtivo = listaCanais[canalAtivo];
		}
		return canalAtivo;
	}
	
	public int diminuirCanal() {
		if (listaCanais[canalAtivo-2] > 0) {
			canalAtivo = listaCanais[canalAtivo-2];
		}
		return canalAtivo;
	}
	
	public int aumentarVolume() {
		volumeAtual = ;
		if (volume++ <= 50) {
			volume++;
		}
		return volume;
	}
	
	public int diminuirVolume() {
		if (volume-- > 0) {
			volume--;
		}
		return volume;
	}
	
	public void ligaDesliga() {
		estaLigada=!estaLigada;
	}

}
