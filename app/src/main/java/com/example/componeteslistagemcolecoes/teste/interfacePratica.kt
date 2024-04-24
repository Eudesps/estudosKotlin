package com.example.componeteslistagemcolecoes.teste
//DRY - Dont Repeat Yourself (Não repita código)
//Divisão de responsabilidades - as clases têm que ser responsável de fazer apenas 1 coisa
//Alto Acoplamento e Baixo Acoplamento
//Classes devem UTILIZAR outras classes e não CRIAR (instâciar) outras classes - A exeções!!!

class Musico(val instrumento: Instrumento){
    fun tocar(){
        instrumento.sendoTocado()
    }
}

class Violao: Instrumento(){ //DOIS TIPOS: Violão, Instrumento
    override fun sendoTocado() {
        println("Utilizando cordas")
        println("Para tocar violão")
    }
    fun ajustarCordas(){
        println("Ajustando cordas")
    }
}

class Bateria: Instrumento(){ //DOIS TIPOS: Violão, Instrumento
    override fun sendoTocado() {
        println("Utilizando baquetas")
        println("Para tocar bateria")
    }
    fun ajustarBaqueta(){
        println("Ajustar baquetas")
    }
}

abstract class Instrumento{
    abstract fun sendoTocado()
}

fun main() {
    // TELA 01
    val violao1 = Violao()
    val musico1 = Musico(violao1)
    musico1.tocar()
    println("----------------")

    //TELA 02
    val violao2 = Violao()
    val musico2 = Musico(violao2)
    musico2.tocar()
    println("----------------")

    //TELA 03
    val bateria1 = Bateria()
    val musico3 = Musico(bateria1)
    musico3.tocar()
}