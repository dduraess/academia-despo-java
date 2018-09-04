package org.comun.comercio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CompraTest {

	@Test
	public void compraAVistaTest() {
		Compra novaCompraAVista = new Compra(500);
		assertEquals(500, novaCompraAVista.getValorTotal());
		assertEquals(500, novaCompraAVista.getValorParcela());
		assertEquals(1, novaCompraAVista.getNrParcelas());
	}

	@Test
	public void compraParceladaTest() {
		Compra novaCompraParcelada = new Compra(5, 100);
		assertEquals(500, novaCompraParcelada.getValorTotal());
		assertEquals(100, novaCompraParcelada.getValorParcela());
		assertEquals(5, novaCompraParcelada.getNrParcelas());
	}

}
