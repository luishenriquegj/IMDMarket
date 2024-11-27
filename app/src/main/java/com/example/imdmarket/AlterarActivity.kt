package com.example.imdmarket

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.imdmarket.databinding.ActivityAlterarBinding

class AlterarActivity : AppCompatActivity(){
    private lateinit var binding: ActivityAlterarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlterarBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}