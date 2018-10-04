package org.commun.biblioteca;

public class Livro {
	
	private String nome;
	private String nomeUsuarioAtual;
	
	public String getNome() {
		return nome;
	}

	public String getUsuarioAtual() {
		return nomeUsuarioAtual;
	}

	public Livro(String nome){
		this.nome = nome;
		this.nomeUsuarioAtual = "";
	}
	
	public void anexarUsuario(Usuario usuario) {
		nomeUsuarioAtual = usuario.getNome();
	}
	
	public void desanexarUsuario(Usuario usuario) {
		if (!estaDisponivel() && usuario.getNome().equals(nomeUsuarioAtual)) {
			nomeUsuarioAtual = "";
		}
	}
	
	public boolean estaDisponivel() {
		if ("".equals(this.getUsuarioAtual())) {
			return true;			
		} return false;
	}
	
}
