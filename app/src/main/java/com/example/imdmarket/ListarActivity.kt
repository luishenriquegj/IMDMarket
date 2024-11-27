package com.example.imdmarket

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.imdmarket.databinding.ActivityListarBinding

class ListarActivity : AppCompatActivity(){
    private lateinit var binding: ActivityListarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListarBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

}