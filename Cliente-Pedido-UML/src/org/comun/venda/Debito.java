package org.comun.venda;

import java.util.Date;

public class Debito extends Pagamento {

    private int numero;
    private String tipo;
    private Date dataExp;
    
    public Debito(int numero, String tipo, Date dataExp, int qtde) {
		super(qtde);
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
		return "Cartão de Débito";
	}
}
