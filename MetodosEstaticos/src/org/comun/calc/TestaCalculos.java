package org.comun.calc;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestaCalculos {

	@Test
	public void test() {
		System.out.println(Calculador.randomicoIntervalo(90, 120));
		if (Calculador.validaCPF("03521447855")) {
			System.out.println("CPF valido!");
		} else {
			System.out.println("CPF invalido");
		}
		
		System.out.println(Calculador.formatarCPF("27352403809"));
	}

}
