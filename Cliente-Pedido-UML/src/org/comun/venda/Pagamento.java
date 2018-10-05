package org.comun.venda;

public abstract class Pagamento {
    private int quantidade;
    
    public Pagamento (int qtde) {
    	this.setQuantidade(qtde);
    }

	public final int getQuantidade() {
		return quantidade;
	}

	public final void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public abstract String tipoPagto(); 
    
}
