package com.example.componeteslistagemcolecoes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.componeteslistagemcolecoes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        val btnExecutar = binding.btnExecutar
        btnExecutar.setOnClickListener {
            Toast.makeText(this, "Executou com sucesso!!", Toast.LENGTH_SHORT).show()
        }
    }
}