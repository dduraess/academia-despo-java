Exercício 2
Modelar (não precisa implementar) o seguinte problema:
O almoxarifado de uma empresa estoca materiais e deve fazer o controle disso. Para cada material ali depositado, deve-se saber o seu código 
numérico, seu nome e o seu saldo (quantidade em estoque no momento). O saldo pode ser alterado quando há retiradas ou abastecimentos, o 
nome pode ser mudado e deve-se mostrar os dados do material quando necessário. O sistema deve permitir as operações de entrada e saída do 
estoque e montar uma lista de produtos em estoque.

Almoxarifado
--> faz inventariar(Lista produtos)
--> faz retirarProduto(Produto)
--> faz abastecer(Produto)

Produto
--> sabe código numérico
--> sabe nome
--> sabe saldo