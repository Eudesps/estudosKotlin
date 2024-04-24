package com.example.componeteslistagemcolecoes.teste

fun main() {
    val lista01 = listOf(1,2)
    val lista02 = listOf(3,4)
    val lista03 = listOf(5,6)

    val uniao = lista01.union(lista02 + lista03)
    //val uniao = lista01 + lista02 + lista03
    println(uniao )
}