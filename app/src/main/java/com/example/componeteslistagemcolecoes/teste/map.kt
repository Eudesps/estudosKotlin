package com.example.componeteslistagemcolecoes.teste

fun main() {
    //O difencial do map é que você pode definir a chave, que pode ser um número, um texto(String)
    //no List por exemplo, a própria lista que define a chave de acordo com a inserção dos valors
    //dentro da lista.
    val lista = mapOf(0 to "Eudes", "seven" to 12)
    //val listaM = mutableMapOf()

    lista.forEach {mapa ->
        println("${mapa.key} - ${mapa.value}")
    }
}