package org.comun.venda;

import java.util.Date;

public class CartaoCredito extends Pagamento {

    private int numero;
    private String tipo;
    private Date dataExp;
    
    public CartaoCredito(int numero, String tipo, Date dataExp) {
		super();
		this.numero = numero;
		this.tipo = tipo;
		this.dataExp = dataExp;
	}

	public boolean isAutorizado() {
        return false;
    }

	@Override
	public String tipoPagto() {
		// TODO Auto-generated method stub
		return "Cartão de Crédito";
	}
}
