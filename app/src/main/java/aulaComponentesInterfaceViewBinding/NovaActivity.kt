package aulaComponentesInterfaceViewBinding

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.componeteslistagemcolecoes.R
import com.example.componeteslistagemcolecoes.databinding.ActivityNovaBinding
import com.example.componeteslistagemcolecoes.databinding.ActivityToolbarActionbarBinding

class NovaActivity : AppCompatActivity() {
    private val binding by lazy { ActivityNovaBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        inicializarToolBar()
    }

    private fun inicializarToolBar() {
        binding.includeToolbar.clLogo.visibility = View.GONE
        binding.includeToolbar.tbPrincipal.title = "Upload vídeo"
        setSupportActionBar(binding.includeToolbar.tbPrincipal)

       /* ATIVA O BOTÃO DE VOLTAR  - E a relação entre as activity, ou seja, a tela que será defifinida
        para ser a apresentada quando o botão for acionado, foi definida lá no AndroidManifest pelo
        android:parentActivityName*/
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}