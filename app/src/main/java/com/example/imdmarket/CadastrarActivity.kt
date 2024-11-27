package com.example.imdmarket

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.imdmarket.databinding.ActivityCadastrarBinding

class CadastrarActivity: AppCompatActivity() {
    private lateinit var binding: ActivityCadastrarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastrarBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}