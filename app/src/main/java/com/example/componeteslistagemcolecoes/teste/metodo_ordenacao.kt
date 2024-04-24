package com.example.componeteslistagemcolecoes.teste

fun main() {
    val listanomes = listOf("walder", "carlos", "zilda", "amanda", "abobora")
    val listanumero = listOf(10,89,1,5,0,37)

    //sorted - ordena de forma crescente
    //sortedDescending - ordena de forma decrescente
    println(listanomes.sorted())
    println(listanumero.sortedDescending())
}