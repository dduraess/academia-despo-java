package org.comun.venda;

import java.util.List;

public class Cliente {
	
   /**
	* 
	* @startuml
	* Cliente "1" --> "0.." Pedido :faz 
	* Class Cliente {
	* - nome
	* - endereco
	* }
	* Pedido "1" o-- "1..*" DetalhePedido :tem 
	* Class Pedido {
	* - data
	* - status
	* + calcTax()
	* + calcTotal()
	* + calcTotalPeso()
	* } 
	* DetalhePedido "0..*" *--> "1" Item :tem
	* Class DetalhePedido {
	* - quantidade
	* - statusImposto
	* + calcSubTotal()
	* + calcPeso()
	* } 
	* Class Item {
	* - peso
	* - entrega
	* - descricao
	* + getPrecoPelaQuantidade()
	* + getPeso()
	* }
	* Pedido "1" --> "1..*" Pagamento :refere-se a
	* Class Pagamento {
	* - quantidade 
	* }  
	* Pagamento <|-- Dinheiro 
	* Class Dinheiro {
	* - dinheiroOferecido
	* }
	* Pagamento <|-- CartaoCredito 
	* Class CartaoCredito {
	* - numero
	* - tipo
	* - dataExp
	* + isAutorizado()
	* }
	* Pagamento <|-- Cheque 
	* Class Cheque {
	* - nomeBando
	* - idBanco
	* + isAutorizado()
	* }
	* @enduml
	*/
	
	private String nome;
	private String endereco;
	private List<Pedido> pedidos;


	public Cliente(String nome, String endereco, List<Pedido> pedidos) {
		this.nome = nome;
		this.endereco = endereco;
		this.pedidos = pedidos;
	}

}
