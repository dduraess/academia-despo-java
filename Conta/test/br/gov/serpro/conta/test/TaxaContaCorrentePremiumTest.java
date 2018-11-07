package br.gov.serpro.conta.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.gov.serpro.conta.ContaCorrente;
import br.gov.serpro.conta.ContaCorrentePremium;

public class TaxaContaCorrentePremiumTest {

    @Test
    public void deveSerBaixa() {

        // Given
        ContaCorrente contaCorrente = new ContaCorrentePremium();

        // When
        double taxaJuros = contaCorrente.calcularTaxaJuros();

        // Then
        assertEquals(1.0, taxaJuros, 0);
    }

}
