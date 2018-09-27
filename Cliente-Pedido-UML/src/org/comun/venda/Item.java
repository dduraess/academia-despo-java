package org.comun.venda;

public class Item {
	
	private Double peso;
	private Double entrega;
	private String descricao;
	
	public Item(Double peso, Double entrega, String descricao) {
		super();
		this.peso = peso;
		this.entrega = entrega;
		this.descricao = descricao;
	}

	public Double getPeso() {
		return peso;
	}

	public Double getPrecoPelaQuantidade() {
		return getPeso() * entrega;
	}
	

}
