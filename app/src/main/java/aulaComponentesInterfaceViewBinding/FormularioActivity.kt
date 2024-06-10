package aulaComponentesInterfaceViewBinding

import android.net.Uri.Builder
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.componeteslistagemcolecoes.R
import com.example.componeteslistagemcolecoes.databinding.ActivityFormularioBinding
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
import com.google.android.material.snackbar.Snackbar

class FormularioActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFormularioBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        spinnerExibicao()
        with(binding){
            btnEnviar.setOnClickListener {
                //checkbox()
                //radioButton()
                //switchToggle()
                //criarSnackBar(it)
                //Snackbar.make(it,"Alteração feita com sucesso", Snackbar.LENGTH_LONG ).show()
                //caixaDialogoAlerta()
                spinnerSelecionarCategoria()

            }

            /*cbConfirmacao.setOnCheckedChangeListener { _, isChecked ->
                val resultado = if(isChecked) "SIM" else "NÃO"
                binding.textResultado.text = "Valor selecionado $resultado"
            }*/

            /*
            cbConfirmacao.setOnClickListener {
                val selecionado = binding.cbConfirmacao.isChecked
                val resultado = if(selecionado) "SIM" else "NÃO"
                binding.textResultado.text = "Valor selecionado $resultado"
            }*/

            /*rbMasculino.setOnClickListener {  }
            rbMasculino.setOnCheckedChangeListener { buttonView, isChecked ->  }*/
        }
    }

    private fun spinnerSelecionarCategoria() {
        //SELECIONANDO UM ITEM EM SPINNER
        val itemSelecionado = binding.spinnerCategoria.selectedItem
        val itemPosicao = binding.spinnerCategoria.selectedItemPosition

        if (itemPosicao == 0){
            Toast.makeText(this, "Selecione um item", Toast.LENGTH_SHORT).show()
        }else{
            binding.textResultado.text = "Selecionado: $itemSelecionado, pos: $itemPosicao"
        }
    }

    private fun spinnerExibicao() {
        val categorias = listOf("--","Casacos", "Camisetas", "Short", "Calça")
        binding.spinnerCategoria.adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            categorias
        )

        binding.spinnerCategoria.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //val itemSelecionado = parent?.getItemAtPosition(position)
                val itemSelecionado = parent?.selectedItem
                binding.textResultado.text = itemSelecionado.toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}

        }
    }

    private fun caixaDialogoAlerta() {
        //MANEIRA USANDO O ENCADIAMENTO DE MÉTODOS
        AlertDialog.Builder(this)
            .setTitle("Confirmar exclusão?")
            .setMessage("Tem certeza de que quer remover esse item?")
            .setNegativeButton("CANCELAR"){ _,posicao ->
                Toast.makeText(this, "Cancelar clicado", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("REMOVER"){ _, posicao ->
                Toast.makeText(this, "Remover ($posicao)", Toast.LENGTH_SHORT).show()
            }
            .setCancelable(false)
            .create()
            .show()

       /* val alertBuider = AlertDialog.Builder(this)
        alertBuider.setTitle("Confirmar exclusão?")
        alertBuider.setMessage("Tem certeza de que quer remover esse item?")

        alertBuider.setNegativeButton("CANCELAR"){ _,posicao ->
            Toast.makeText(this, "Cancelar clicado", Toast.LENGTH_SHORT).show()
        }
        alertBuider.setPositiveButton("REMOVER"){ _, posicao ->
            Toast.makeText(this, "Remover ($posicao)", Toast.LENGTH_SHORT).show()
        }

        *//*esse método força o usuário a tomar uma decição do AlertDioalog, não dando ao usuário a
        posibilidade de sair desse alert sem antes fazer uma escolha.*//*
        alertBuider.setCancelable(false)
        alertBuider.setNeutralButton("Ajuda"){ _, posicao ->
            Toast.makeText(this, "Ajuda", Toast.LENGTH_SHORT).show()
        }
        alertBuider.setIcon(R.drawable.baseline_add_alert_24)

        val alertDialog = alertBuider.create().show()*/
    }

    private fun criarSnackBar(view: View) {
        val snackbar = Snackbar.make(view, "Alteração feita", Snackbar.LENGTH_LONG)

        snackbar.setAction("Desfazer"){
            Toast.makeText(this, "Desfeito", Toast.LENGTH_SHORT).show()
        }

        //MUDANDO CORES DOS COMPONENTES DA SNACKBAR
        /*snackbar.setTextColor(ContextCompat.getColor(
                this, R.color.black
            ))
        snackbar.setActionTextColor(ContextCompat.getColor(
            this, android.R.color.holo_blue_light
        ))
        snackbar.setBackgroundTint(ContextCompat.getColor(
            this, android.R.color.holo_green_light
        ))*/

        snackbar.show()
    }

    private fun switchToggle() {
        val Switchmarcado = binding.switchNotificacoes.isChecked
        val ToggleMarcado = binding.toggleAtivo.isChecked

        val text = "Swite: $Switchmarcado , Toggle: $ToggleMarcado"

        binding.textResultado.text = text
    }

    private fun radioButton(){
        /*val selecionado = binding.rbMasculino.isChecked
        binding.textResultado.text = if(selecionado) "Masculino" else "Feminino"*/

        val idItemSelecionado = binding.rgSexo.checkedRadioButtonId
        binding.textResultado.text = when(idItemSelecionado){
            R.id.rbMasculino -> "Masculino"
            R.id.rbFeminino -> "Feminino"
            else -> "Nada selecionado"
        }
        binding.rgSexo.clearCheck()
    }
    private fun checkbox(){
        val selecionado = binding.cbConfirmacao.isChecked
        val resultado = if(selecionado) "SIM" else "NÃO"
        binding.textResultado.text = "Valor selecionado $resultado"
    }
}