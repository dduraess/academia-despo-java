package org.commun.biblioteca;

public class Livro {
	
	private String nome;
	private String usuarioAtual;
	
	public String getNome() {
		return nome;
	}

	public String getUsuarioAtual() {
		return usuarioAtual;
	}

	public Livro(String nome){
		this.nome = nome;
		this.usuarioAtual = "";
	}
	
	public void anexarUsuario(Usuario usuario) {
		usuarioAtual = usuario.getNome();
	}
	
	public boolean estaDisponivel() {
		if (usuarioAtual.equals("")) {
			return true;			
		} return false;
	}
	
}
