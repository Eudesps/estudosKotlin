package com.example.componeteslistagemcolecoes.teste
/*Não introduz nenhuma capacidade técnica, essas funções podem deixar seu código
* mais  conciso e de fácil leitura, são atalhos para códigos que você já escreve. */
//SÃO ATALHOS, SOBRE OS CÓDIGOS QUE VOCÊ JÁ ESCREVE, DEIX-LOS MAIS CURTO.

data class Produto(
    var nome: String,
    var preco: Double
){
    fun desativar(){
        println("produto: $nome com preco: $preco foi desativado")
    }
}
fun salvarProduto(produto: Produto){

}

class AlertaMensagem(){
    fun configurarTitulo(titulo : String) = println(titulo)
    fun configurarDescricao(descricao : String) = println(descricao)

    fun configurarCancelar() = println("Ação de cancelar")
    fun configurarConfirmar() = println("Confirmar")
}

fun main() {

    val alertaMensagem = AlertaMensagem()
    /*alertaMensagem.configurarTitulo("Confirmar salvar?")
    alertaMensagem.configurarDescricao("Quer mesmo fazaer isso?")
    alertaMensagem.configurarCancelar()
    alertaMensagem.configurarConfirmar()*/

/*    alertaMensagem.apply {
        configurarTitulo("Confirmar salvar?")
        configurarDescricao("Quer mesmo fazaer isso?")
        configurarCancelar()
        configurarConfirmar()
    }*/

    val lista = listOf("pedro", "eudes", "maria")
    lista
        .map { it.uppercase() }
        .also {println(it)
        }

    /*var produto: Produto? = null

    produto = Produto("Fone", 249.00)
    *//*Com o rum, é possivel fazer diversas alterações no produto(no caso) como se eu estive
    * dentro do produto*//*
    produto?.run { desativar() }
    *//*Tanto o with como o rum utilizam o "this" posiblitando o acesso direto aos métodos*//*
   val novoProduto =  with(produto){
        desativar()
       //é usado para retornar
       this
    }*/
/*    produto = Produto("Fone", 249.00)
    produto?.let {
        it.nome = "Fone - Headset"
        it.preco = 100.00
        it
    }*/

}