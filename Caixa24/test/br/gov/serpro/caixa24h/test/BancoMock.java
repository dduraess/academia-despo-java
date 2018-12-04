package br.gov.serpro.caixa24h.test;

import java.math.BigDecimal;
import java.util.List;

import br.gov.serpro.banco.BancoOperavel;
import br.gov.serpro.banco.OperacaoNaoValidadaException;
import br.gov.serpro.banco.SaldoInsuficienteException;
import br.gov.serpro.banco.Usuario;

public class BancoMock implements BancoOperavel {

	private List<CorrentistaMock> correntistas;
	private Boolean operacaoValidada;

	public BancoMock(List<CorrentistaMock> correntistas) {
		this.correntistas = correntistas;
		this.operacaoValidada = false;
	}

	@Override
	public void validarOperacao(Usuario usuario) throws OperacaoNaoValidadaException {
		for (CorrentistaMock correntistaMock : correntistas) {
			if (usuario.obterNrConta().equals(correntistaMock.obterNrConta())) {
				operacaoValidada = true;
			} else {
				throw new OperacaoNaoValidadaException("Operação não foi validada!");
			}
		}
	}

	@Override
	public List<Operacao> consultarExtrato(Usuario usuario) {
		if (operacaoValidada) {
			
		}
		return null;
	}

	@Override
	public BigDecimal consultarSaldo(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void realizarTransferencia(Usuario usuario, String nrContaDestino, BigDecimal valor)
			throws SaldoInsuficienteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void realizarDeposito(Usuario usuario, BigDecimal valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saque(Usuario usuario, BigDecimal valor) throws SaldoInsuficienteException {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public String consultarExtrato(String nrConta) throws OperacaoNaoValidadaException {
//		String historico = "";
//		for (ContaMock conta : contas) {
//			if (nrConta.equals(conta.obterNrConta())) {
//				return historico.concat(conta.extrato());
//			} 
//		} if (!operacaoValidada) {
//			throw new OperacaoNaoValidadaException("Conta inexistente!");
//		} return null;
//	}
//
//	@Override
//	public BigDecimal consultarSaldo(String nrConta) throws OperacaoNaoValidadaException {
//		for (ContaMock conta : contas) {
//			if (nrConta.equals(conta.obterNrConta())) {
//				operacaoValidada = true;
//				return conta.obterSaldo();
//			} 				
//		} if (!operacaoValidada) {
//			throw new OperacaoNaoValidadaException("Conta inexistente!");
//		} return null;
//	}
//
//	@Override
//	public void realizarTransferencia(String nrContaOrigem, String nrContaDestino, BigDecimal valor)
//			throws OperacaoNaoValidadaException, SaldoInsuficienteException {
//		
//		for (ContaMock conta : contas) {
//			if (nrContaOrigem.equals(conta.obterNrConta())) {
//				try {
//					conta.enviarTransferencia(nrContaDestino, valor);
//					for (ContaMock contaDestino : contas) {
//						if (nrContaDestino.equals(contaDestino.obterNrConta())) {
//							operacaoValidada = true;
//							contaDestino.receberTransferencia(nrContaOrigem, valor);
//						}
//					}
//				} catch (SaldoInsuficienteException e) {
//					e.printStackTrace();
//				}
//			}  
//		} if (!operacaoValidada) {
//			throw new OperacaoNaoValidadaException("Conta inexistente!");
//		}
//		
//	}
//
//	@Override
//	public void realizarDeposito(String nrConta, BigDecimal valor) throws OperacaoNaoValidadaException {
//		
//	}
//
//	@Override
//	public void saque(String nrConta, BigDecimal valor) throws OperacaoNaoValidadaException {
//		for (ContaMock conta : contas) {
//			if (nrConta.equals(conta.obterNrConta())) {
//				try {
//					conta.saque(valor);
//					operacaoValidada = true;
//				} catch (SaldoInsuficienteException e) {
//					e.printStackTrace();
//				}
//			}  
//		} if (!operacaoValidada) {
//			throw new OperacaoNaoValidadaException("Conta inexistente!");
//		}
//	}

}
