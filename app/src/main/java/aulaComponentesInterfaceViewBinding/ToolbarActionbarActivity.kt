package aulaComponentesInterfaceViewBinding

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.MenuProvider
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.componeteslistagemcolecoes.R
import com.example.componeteslistagemcolecoes.databinding.ActivityToolbarActionbarBinding

class ToolbarActionbarActivity : AppCompatActivity() {
    private val binding by lazy { ActivityToolbarActionbarBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //esse método remove a toolbar especificamente na activity onde o método for chamado.
        //supportActionBar?.hide()
        //inicializarActionBar()

        inicializarToolBar()
    }

    private fun inicializarToolBar() {
        binding.tbPrincipal.title = "Fass"
        binding.tbPrincipal.setTitleTextColor(
            ContextCompat.getColor(this, R.color.white)
        )
    }

    private fun inicializarActionBar() {
        addMenuProvider(
            object: MenuProvider{
                override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                    menuInflater.inflate(R.menu.menu_principal, menu)
                }

                override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                    when(menuItem.itemId){
                        R.id.item_pesquisar -> {
                            Toast.makeText(applicationContext, "Item PESQUISA clicado", Toast.LENGTH_SHORT).show()
                        }
                        R.id.item_adicionar -> {
                            Toast.makeText(applicationContext, "Item ADICIONAR clicado", Toast.LENGTH_SHORT).show()
                        }
                        R.id.item_config -> {
                            Toast.makeText(applicationContext, "Item CONFIGURAÇÃO clicado", Toast.LENGTH_SHORT).show()
                        }
                        R.id.item_sair -> {
                            Toast.makeText(applicationContext, "Item SAIR clicado", Toast.LENGTH_SHORT).show()
                        }
                    }
                    return true
                }

            }
        )
    }

    /*override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_principal, menu)
        return true
    }

    *//*Não é necesário adicionar um evento de click, esse método já fiz isso, pois ele só será
    chamado quando um item for clicado.*//*
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        *//*Quando for clicado o item clicado e identificado e é possível identificar qual foi por
        meio do id do item.*//*
        when(item.itemId){
            R.id.item_pesquisar -> {
                Toast.makeText(this, "Item PESQUISA clicado", Toast.LENGTH_SHORT).show()
            }
            R.id.item_adicionar -> {
                Toast.makeText(this, "Item ADICIONAR clicado", Toast.LENGTH_SHORT).show()
            }
            R.id.item_config -> {
                Toast.makeText(this, "Item CONFIGURAÇÃO clicado", Toast.LENGTH_SHORT).show()
            }
            R.id.item_sair -> {
                Toast.makeText(this, "Item SAIR clicado", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }*/
}