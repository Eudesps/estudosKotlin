package aulaComponentesInterfaceViewBinding

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.componeteslistagemcolecoes.R
import com.example.componeteslistagemcolecoes.databinding.ActivityViewBindingBinding

class ViewBindingActivity : AppCompatActivity() {
    //private lateinit var binding: ActivityViewBindingBinding
    private val binding by lazy { ActivityViewBindingBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.cbConfirmacao)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        /*Aqui dentro é possível usar todos os componentes sem a necessidade de colocar o ""binding
        antes de cada id*/
        with(binding){
            btnClique.setOnClickListener {  }
        }
    }
}