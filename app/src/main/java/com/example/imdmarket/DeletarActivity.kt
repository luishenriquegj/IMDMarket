package com.example.imdmarket;

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.imdmarket.databinding.ActivityDeletarBinding

class DeletarActivity : AppCompatActivity(){
    private lateinit var binding: ActivityDeletarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeletarBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}
