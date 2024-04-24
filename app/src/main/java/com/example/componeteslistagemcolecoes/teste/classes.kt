package com.example.componeteslistagemcolecoes.teste

class Motorista(val nomeMotorista: String){
 fun dadosMotoristas() = println("Nome motorista $nomeMotorista")

 //classe aninhada (Nested class)
 /*clasCaminhao(val nomeCaminhao: String){
     fun dadosCaminhao() = println("Nome caminhao: $nomeCaminhao")
 }

 //Classe interna (inner class)
 inner class Caminhao(val nomeCaminhao: String){
     fun dadosCaminhao() = println("Nome caminhao: $nomeCaminhao, " +
             "Nome motorista: $nomeMotorista")
 }*/
}

class Usuario(){
    var nome: String = ""
        get() {
            return field.uppercase()
        }
        set(value) {
            field = "set: $value"
        }
    var idade: Int = 0
    //Se for colocado um val é possível colocar o get como valor inicial, nesse caso fazendo
    //um teste, então não é mais necessário iniciar com uma valor como: var maiorIdade = false
    val maiorIdade
        get() = idade >= 18
}

fun main() {

    val lista = arrayOf("João", "José", "Maria", "Pedro")
    println( lista[1] ) //RETORNA O ELEMENTO NO INDICE INDICADO
    println( lista.size ) // RETORNA O TAMANHO DA LISTA
    println( lista.indexOf("José") ) // RETORNA O INDICE DO ELEMENTO INFORMADO
    println( lista.first() ) // RETORNA O PRIMEIRO ELEMENTO DA LISTA
    println( lista.last() ) // RETORNA O ÚLTIMO ELEMENTO DA LISTA
    println( lista.contains("Maria") ) // VERIFICA SE O ELEMENTO INFORMADO ESTÁ NA LISTA

    val novaLista = lista.plus("Eudes") // CRIA UMA NOVA LISTA COM OS ELEMENTOS DA LISTA
    // ANTERIOR E ACRESCENTA O NOVO ITEM PASSADO COMO PARÂMETRO
    lista.shuffle() // EMBARALHA OS ELEMENTOS
    lista.forEach { item ->
        println(item)
    }

    /*val usuario = Usuario()
    usuario.nome = "Pedro"
    usuario.idade = 18

    println("nome: ${usuario.nome} idade: ${usuario.idade} maior idade: ${usuario.maiorIdade}")*/

 /*val caminhao = Motorista.Caminhao("Scania")
 caminhao.dadosCaminhao()
 val motorista = Motorista("Eudes")
 val caminhao = motorista.Caminhao("Scania")
 caminhao.dadosCaminhao()*/

}