Exerc�cio 2
Modelar (n�o precisa implementar) o seguinte problema:
O almoxarifado de uma empresa estoca materiais e deve fazer o controle disso. Para cada material ali depositado, deve-se saber o seu c�digo 
num�rico, seu nome e o seu saldo (quantidade em estoque no momento). O saldo pode ser alterado quando h� retiradas ou abastecimentos, o 
nome pode ser mudado e deve-se mostrar os dados do material quando necess�rio. O sistema deve permitir as opera��es de entrada e sa�da do 
estoque e montar uma lista de produtos em estoque.

Almoxarifado
--> faz inventariar(Lista produtos)
--> faz retirarProduto(Produto)
--> faz abastecer(Produto)

Produto
--> sabe c�digo num�rico
--> sabe nome
--> sabe saldo