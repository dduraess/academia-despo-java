package br.gov.serpro.conta.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.gov.serpro.conta.ContaCorrente;
import br.gov.serpro.conta.ContaCorrenteRegular;

public class TaxaContaCorrenteRegularTest {

    @Test
    public void deveSerAlta() {

        // Given
        ContaCorrente contaCorrente = new ContaCorrenteRegular();

        // When
        double taxaJuros = contaCorrente.calcularTaxaJuros();

        // Then
        assertEquals(5.0, taxaJuros, 0);
    }

}
