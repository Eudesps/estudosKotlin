package com.example.componeteslistagemcolecoes.teste

var nome = "56" //Escopo Global
class Pessoa(){
    val nome = ""
}

fun execultar(){
    nome = "Mudei na função execultar" //Escopo local, as chavez {} são usadas geralmente para identificar os escopos
}
fun main() {
    println(nome)
    execultar()
    println(nome)
nome = "Mudei no main"
    println(nome)

}