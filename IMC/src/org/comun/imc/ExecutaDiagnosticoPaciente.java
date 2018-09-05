package org.comun.imc;

public class ExecutaDiagnosticoPaciente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Paciente paciente1 = new Paciente("Antonio", 50, 1.78);
		System.out.println(paciente1.nome + " esta com " + paciente1.diagnostico() );
		Paciente paciente2 = new Paciente("Maria", 74, 1.6);
		System.out.println(paciente2.nome + " esta com " + paciente2.diagnostico());
		Paciente paciente3 = new Paciente("João", 100, 1.62);
		System.out.println(paciente3.nome + " esta com " + paciente3.diagnostico());

	}

}
