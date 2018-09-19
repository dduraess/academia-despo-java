import static org.junit.Assert.assertEquals;

import org.comun.imc.Paciente;
import org.junit.Before;
import org.junit.Test;

public class IMCTest {
	
	Paciente paciente1;
	Paciente paciente2;
	Paciente paciente3;
	
	@Before
	public void criarPacienteAntes() {
		paciente1 = new Paciente("Antonio", 89, 1.76);
		paciente2 = new Paciente("Joana", 65, 1.70);
		paciente3 = new Paciente("Jacob", 109, 1.58);
	}
	
	@Test
	public void testarCalculoIMC () {
		assertEquals("Sobrepeso", paciente1.diagnostico());
		assertEquals("Peso normal", paciente2.diagnostico());
		assertEquals("Obesidade grau III", paciente3.diagnostico());
	}

}
