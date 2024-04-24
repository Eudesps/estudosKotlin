package com.example.componeteslistagemcolecoes.teste

fun main() {
    val lista = listOf("eudes", "maria", "edjane", "carlos")

    val novaLista = mutableListOf<String>()
    lista.forEach {nome->
        novaLista.add(nome.uppercase())
    }
    println(novaLista)

    //utilizando o método map.

    val novaListamap = lista.map {it.uppercase()}
    println(novaListamap)
}