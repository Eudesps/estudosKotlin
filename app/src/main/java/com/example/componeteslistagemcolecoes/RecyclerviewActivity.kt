package com.example.componeteslistagemcolecoes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class RecyclerviewActivity : AppCompatActivity() {

    private lateinit var rvLista: RecyclerView
    private lateinit var btnExecutar: Button
    private lateinit var mensagemAdapter: MensagemAdapter

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
        val lista = mutableListOf(
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
        btnExecutar = findViewById(R.id.btn_clique)

        //AQUI ESTOU PASSANDO UMA FUNCÃO LAMBIDA POR PARÂMETRO
        /*Se tiver apenas uma função lambida e ela é passada por último, então pode ser feita da
        forma que está aqui em baixo*/
        mensagemAdapter = MensagemAdapter {nome->
            Toast.makeText(this,"Olá $nome", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LinearLayoutActivity::class.java)
            intent.putExtra("nome", nome)
            startActivity(intent)
        }
        rvLista.adapter = mensagemAdapter
        mensagemAdapter.atualizarListaDados(lista)
        //Gerenciador de layout que está sendo aplicado no momento
        rvLista.layoutManager = LinearLayoutManager(
            this, RecyclerView.VERTICAL,false
        )
        btnExecutar.setOnClickListener {
            mensagemAdapter.executarOperacao()
            /*lista.add( Mensagem("Nova Teste", "foi ontem, hj não", "14:40"))
            mensagemAdapter.atualizarListaDados(lista)*/
        }


        /*rvLista.addItemDecoration(
            Aqui está sendo colocado uma linha separando cada item (DIVISOR)
            DividerItemDecoration(this,RecyclerView.VERTICAL)
        )*/

        //GERENCIADORES DE LAYOUT

        /*LinearLayoutManager
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