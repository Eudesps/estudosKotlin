package com.example.componeteslistagemcolecoes.teste

fun main() {

    val listaVendas = listOf(100,200,1500,800,300)
    val nomes = listOf("eudes", "maria", "pedro", "carlos")

   /* val novaLista = listaVendas.filter { valor ->
        valor >= 600 // aqui sempre vai ter uma condição que retornará (true or false)
    }*/
    //val novaLista = listaVendas.filter {it >= 500}
    val novaLista = listaVendas.filter {it >= 500}

    //verifica os nomes que contém a  letra 'a', e depos adciona o nome da nova lista
    val newlist = nomes.filter {nomes ->
        nomes.contains("a")
    }

    println(newlist)
}