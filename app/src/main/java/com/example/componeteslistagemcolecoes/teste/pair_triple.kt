package com.example.componeteslistagemcolecoes.teste

fun main() {
    //val localizacao = Pair(678,673)
    //val localizacao = 678 to 673

    //é posssivel colocar outros tipos de dados aqui também, como uma String também
    val localizacao = Triple(894, 125, 789)
    println(localizacao.first)
    println(localizacao.second)
    println(localizacao.third)
}