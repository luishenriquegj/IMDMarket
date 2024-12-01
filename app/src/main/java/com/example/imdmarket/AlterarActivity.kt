package com.example.imdmarket

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.imdmarket.databinding.ActivityAlterarBinding

class AlterarActivity : AppCompatActivity(){
    private lateinit var binding: ActivityAlterarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlterarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val productName = binding.productNameInput
        val productCode = binding.productCodeInput
        val productStock = binding.stockInput
        val productDescription = binding.productDescInput

        val saveBtn = binding.saveButton
        val clearBtn = binding.clearButton

        saveBtn.setOnClickListener {
            if(productCode.text.isEmpty()){
                Toast.makeText(this, "Id is required to update a product", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if( productName.text.isEmpty() && productStock.text.isEmpty() && productDescription.text.isEmpty()){
                Toast.makeText(this, "Fill at least one of the fields to updated a product", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            Toast.makeText(this, "Product updated with with success", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MenuActivity::class.java))
            finish()
            return@setOnClickListener
        }

        clearBtn.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
            finish()
        }

    }
}