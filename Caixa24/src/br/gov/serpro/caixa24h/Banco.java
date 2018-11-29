package br.gov.serpro.caixa24h;

import java.util.List;

public class Banco implements BancoOperavel {

	private List<Conta> contas;

	public Banco(List<Conta> contas) {
		this.contas = contas;
	}

	@Override
	public String consultarExtrato(String nrConta) {
		String historico = "";
		for (Conta conta : contas) {
			if (nrConta.equals(conta.obterNrConta())) {
				historico = historico + conta.extrato();
			}
		}
		return historico;
	}

	@Override
	public Double consultarSaldo(String nrConta) {
		for (Conta conta : contas) {
			if (nrConta.equals(conta.obterNrConta())) {
				return conta.obterSaldo();
			}
		}
		return null;
	}

	@Override
	public void realizarTransferencia(String nrContaOrigem, String nrContaDestino, Double valor) {
		
	}

	@Override
	public void realizarDeposito(String nrConta, Double valor) {
		
	}

	@Override
	public void saque(String nrConta, Double valor) {
		for (Conta conta : contas) {
			if (nrConta.equals(conta.obterNrConta())) {
				conta.saque(valor);
			}
		}
	}

}
