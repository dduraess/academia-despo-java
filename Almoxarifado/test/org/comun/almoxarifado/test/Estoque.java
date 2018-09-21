package org.comun.almoxarifado.test;

import java.util.ArrayList;
import java.util.Collection;

public class Estoque {
	
	private Collection<Material> materiais = new ArrayList<>();

	public Integer qtdeTotalDeMateriais() {
		return materiais.size();
		
	}

	public void abastecer(Material material) {
		materiais.add(material);
		
	}

	public void retirar(Material material) {
		materiais.remove(material);
		
	}

}
