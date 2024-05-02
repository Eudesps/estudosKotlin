package com.example.componeteslistagemcolecoes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MensagemAdapter(
    /*Estou passado como parâmetro uma String para que o nome seja enviado para a outra tela,
    no caso para a LinearLayoutActivity*/
    private val clique: (String) -> Unit
): Adapter<MensagemAdapter.MensagemViweHolder>() {
   // MensagemViweHolder - é a classe que vai armezenar a visualização

    private var listaMensagens = mutableListOf<Mensagem>()

    fun atualizarListaDados(lista: MutableList<Mensagem>){
        //listaMensagens.addAll(lista)
        listaMensagens = lista
        notifyDataSetChanged()
    }
    inner class MensagemViweHolder(val itemview: View): ViewHolder(itemview){
       /* val textNome: TextView = itemview.findViewById(R.id.text_nome)
        val textUtima: TextView = itemview.findViewById(R.id.text_ultima)
        val textHorario: TextView = itemview.findViewById(R.id.text_horario)*/

       val textNome: TextView = itemview.findViewById(R.id.text_card_nome)
       val textUtima: TextView = itemview.findViewById(R.id.text_card_ultima)
       val imagePerfil: ImageView = itemview.findViewById(R.id.image_card_view)
       val cardView: CardView = itemview.findViewById(R.id.card_view_layout)

       fun bind(mensagem: Mensagem){ //Conectar com a interface com o objeto view
           textNome.text = mensagem.nome
           textUtima.text = mensagem.ultima

           val contexto = imagePerfil.context
           imagePerfil.setOnClickListener {
               Toast.makeText( contexto, "Olá ${mensagem.nome}", Toast.LENGTH_SHORT ).show()
           }
           val contextocard = imagePerfil.context
           cardView.setOnClickListener {
              clique(mensagem.nome)
           }
       }
    }

    //Esse método vai criar a visualização
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MensagemViweHolder {
       val layoutInflater = LayoutInflater.from(
           parent.context
       )
       /*val itemview = layoutInflater.inflate(
            R.layout.item_lista,parent,false
       )*/
        val itemview = layoutInflater.inflate(
            R.layout.item_cardview,parent,false
        )
        return MensagemViweHolder(itemview)
    }

    //getItemCount - Recupera a quantidade de itens, ele vai contar a quantidade de itens
    override fun getItemCount(): Int =  listaMensagens.size

    //Ao vincular o ViewHolder - Aqui é possivel acessar os recursos da visualização
    override fun onBindViewHolder(holder: MensagemViweHolder, position: Int) {
        val mensagem = listaMensagens[position]
        holder.bind(mensagem)
        //Aqui irá ser aplicado os eventos de cliques

    }
}