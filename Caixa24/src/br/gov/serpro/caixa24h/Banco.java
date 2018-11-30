package br.gov.serpro.caixa24h;

import java.util.List;

public class Banco implements BancoOperavel {

	private List<Conta> contas;

	public Banco(List<Conta> contas) {
		this.contas = contas;
	}

	@Override
	public String consultarExtrato(String nrConta) throws ContaInexistenteException {
		String historico = "";
		for (Conta conta : contas) {
			if (nrConta.equals(conta.obterNrConta())) {
				historico.concat(conta.extrato());
			} else {
				throw new ContaInexistenteException("Conta inexistente!");
			}
		} 
		return historico;
	}

	@Override
	public Double consultarSaldo(String nrConta) throws ContaInexistenteException {
		for (Conta conta : contas) {
			if (nrConta.equals(conta.obterNrConta())) {
				return conta.obterSaldo();
			} else {
				throw new ContaInexistenteException("Conta inexistente!");
			}
		}
		return null;
	}

	@Override
	public void realizarTransferencia(String nrContaOrigem, String nrContaDestino, Double valor)
			throws ContaInexistenteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void realizarDeposito(String nrConta, Double valor) throws ContaInexistenteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saque(String nrConta, Double valor) throws ContaInexistenteException, SaldoInsuficienteException {
		for (Conta conta : contas) {
			if (nrConta.equals(conta.obterNrConta())) {
				conta.saque(valor);
			} else {
				throw new ContaInexistenteException("Conta inexistente!");
			}
		}
	}

}
