package org.comun.imc;

import static org.junit.Assert.*;

import org.junit.Test;

public class PacienteTest {

	@Test
	public void testDiagnostico() {
		Paciente paciente1 = new Paciente(50, 1.78);
		System.out.println(paciente1.diagnostico());
		Paciente paciente2 = new Paciente(74, 1.6);
		System.out.println(paciente2.diagnostico());
		Paciente paciente3 = new Paciente(100, 1.62);
		System.out.println(paciente3.diagnostico());
	}

}
