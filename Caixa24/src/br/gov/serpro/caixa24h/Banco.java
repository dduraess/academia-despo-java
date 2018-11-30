package br.gov.serpro.caixa24h;

import java.util.List;

public class Banco implements BancoOperavel {

	private List<Conta> contas;
	private Boolean operacaoValidada;

	public Banco(List<Conta> contas) {
		this.contas = contas;
		this.operacaoValidada = false;
	}

	@Override
	public String consultarExtrato(String nrConta) throws ContaInexistenteException {
		String historico = "";
		for (Conta conta : contas) {
			if (nrConta.equals(conta.obterNrConta())) {
				return historico.concat(conta.extrato());
			} 
		} if (!operacaoValidada) {
			throw new ContaInexistenteException("Conta inexistente!");
		} return null;
	}

	@Override
	public Double consultarSaldo(String nrConta) throws ContaInexistenteException {
		for (Conta conta : contas) {
			if (nrConta.equals(conta.obterNrConta())) {
				operacaoValidada = true;
				return conta.obterSaldo();
			} 				
		} if (!operacaoValidada) {
			throw new ContaInexistenteException("Conta inexistente!");
		} return null;
	}

	@Override
	public void realizarTransferencia(String nrContaOrigem, String nrContaDestino, Double valor)
			throws ContaInexistenteException, SaldoInsuficienteException {
//		for (Conta conta : contas) {
//			if (nrContaOrigem.equals(conta.obterNrConta())) {
//				operacaoValidada = true;
//				try {
//					conta(valor);
//				} catch (SaldoInsuficienteException e) {
//					e.printStackTrace();
//				}
//			}  
//		} if (!operacaoValidada) {
//			throw new ContaInexistenteException("Conta inexistente!");
//		}
		
	}

	@Override
	public void realizarDeposito(String nrConta, Double valor) throws ContaInexistenteException {
		
	}

	@Override
	public void saque(String nrConta, Double valor) throws ContaInexistenteException {
		for (Conta conta : contas) {
			if (nrConta.equals(conta.obterNrConta())) {
				try {
					conta.saque(valor);
					operacaoValidada = true;
				} catch (SaldoInsuficienteException e) {
					e.printStackTrace();
				}
			}  
		} if (!operacaoValidada) {
			throw new ContaInexistenteException("Conta inexistente!");
		}
	}

}
