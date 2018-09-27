package org.comun.venda;

public class DetalhePedido {

    private int quantidade;
    private StatusImposto statusImposto;
    private Item item;
    private Double valorEntregaPorPeso;

    public DetalhePedido(int quantidade, StatusImposto statusImposto, Item item) {
        this.quantidade = quantidade;
        this.statusImposto = statusImposto;
        this.item = item;
        this.valorEntregaPorPeso = 0.5;
    }

    public enum StatusImposto {
        INCLUSO, POR_CONTA_COMPRADOR
    }

    public Double calcPeso () {
        return item.getPeso() * valorEntregaPorPeso;
    }

    public Double calcSubTotal() {
        return item.getPrecoPelaQuantidade(this.quantidade) + calcPeso();
    }

}
