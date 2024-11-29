package com.example.imdmarket

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.imdmarket.databinding.ActivityMenuBinding


class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val addProdBtn = binding.addProductBtn
        val listBtn = binding.listProductBtn
        val removeProductBtn = binding.removeProductBtn
        val updateProductBtn = binding.updateProductBtn

        addProdBtn.setOnClickListener {
            startActivity(Intent(this, CadastrarActivity::class.java))
        }

        listBtn.setOnClickListener {
            startActivity(Intent(this, ListarActivity::class.java))
        }

        removeProductBtn.setOnClickListener {
            startActivity(Intent(this, DeletarActivity::class.java))
        }

        updateProductBtn.setOnClickListener {
            startActivity(Intent(this, AlterarActivity::class.java))
        }
    }
}