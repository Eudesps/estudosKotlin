package com.example.componeteslistagemcolecoes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class RecyclerviewActivity : AppCompatActivity() {

    private lateinit var rvLista: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recyclerview)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //TESTE COM UMA BASE DE DADOS UM POUCO MAIOR
        val lista = listOf(
            Mensagem("José Eudes", "Olá, tudo bem?", "10:50"),
            Mensagem("Pietro José", "Queijo com pão, ou é o contrario?", "10:50"),
            Mensagem("Maria Carla", "Olá, vem hj?", "9:15"),
            Mensagem("Maisa Souza", "Quero um carro novo", "20:10"),
            Mensagem("Manoel", "kkkkkkkkkkkkk e daí", "06:30"),
            Mensagem("Emanuel", "ontem foi muito bommm", "22:45"),
            Mensagem("Patricia", "Quero sim, pode ser para amanhã?", "21:27"),
            Mensagem("Safira", "Vou sim", "13:39"),
            Mensagem("Camila", "foi ontem, hj não", "14:40"),
            Mensagem("José Eudes", "Olá, tudo bem?", "10:50"),
            Mensagem("Pietro José", "Queijo com pão, ou é o contrario? ", "10:50"),
            Mensagem("Maria Carla", "Olá, vem hj?", "9:15"),
            Mensagem("Maisa Souza", "Quero um carro novo", "20:10"),
            Mensagem("Manoel", "kkkkkkkkkkkkk e daí", "06:30"),
            Mensagem("Emanuel", "ontem foi muito bommm", "22:45"),
            Mensagem("Patricia", "Quero sim, pode ser para amanhã?", "21:27"),
            Mensagem("Safira", "Vou sim", "13:39"),
            Mensagem("Camila", "foi ontem, hj não", "14:40")
            )

        rvLista = findViewById(R.id.rv_lista)
        rvLista.adapter = MensagemAdapter(lista)
        rvLista.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        //Gerenciadores de layout
        /*
        LinearLayoutManager
        rvLista.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        */
        /*GridLayoutManager
        SpanCount - quantidade de itens espalhados (quantidade de colunas)
        rvLista.layoutManager = GridLayoutManager(this,2)
        */
        /*
        StaggeredGridLayoutManager
        rvLista.layoutManager = StaggeredGridLayoutManager(2,RecyclerView.VERTICAL)
         */
    }
}