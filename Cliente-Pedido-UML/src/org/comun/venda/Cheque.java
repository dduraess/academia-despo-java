package org.comun.venda;

import java.util.Date;

public class CartaoCredito extends Pagamento {

    private int numero;
    private String tipo;
    private Date dataExp;

    public boolean isAutorizado() {
        return false;
    }
}
