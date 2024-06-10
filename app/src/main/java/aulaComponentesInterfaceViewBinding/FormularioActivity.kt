package aulaComponentesInterfaceViewBinding

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.componeteslistagemcolecoes.R
import com.example.componeteslistagemcolecoes.databinding.ActivityFormularioBinding
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

        with(binding){
            btnEnviar.setOnClickListener {
                //checkbox()
                //radioButton()
                //switchToggle()
                criarSnackBar(it)
                //Snackbar.make(it,"Alteração feita com sucesso", Snackbar.LENGTH_LONG ).show()
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