package org.comun.venda;

public class Item {
	
	private Double pesoEntrega;
	private Double precoPorUnidade;
	private String descricao;
	
	public Item(Double pesoEntrega, String descricao, Double precoPorUnidade) {
		super();
		this.pesoEntrega = pesoEntrega;
		this.descricao = descricao;
		this.precoPorUnidade = precoPorUnidade;
	}

	public Double getPeso() {
		return pesoEntrega;
	}

	public Double getPrecoPelaQuantidade(int quantidade) {
		return  precoPorUnidade * quantidade;
	}
	

}
