package com.example.imdmarket

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imdmarket.databinding.ActivityListarBinding
import com.example.imdmarket.sharedPreferencesUtils.Utils

class ListarActivity : AppCompatActivity(){
    private lateinit var binding: ActivityListarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val currentProducts: ArrayList<String> = Utils.getProducts(this)

        val recyclerView = binding.productRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ProductAdapter(currentProducts)
    }

}