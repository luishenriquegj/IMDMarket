package com.example.imdmarket

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.imdmarket.databinding.ActivityDeletarBinding
import com.example.imdmarket.sharedPreferencesUtils.Utils.Companion.deleteProductById

class DeletarActivity : AppCompatActivity(){
    private lateinit var binding: ActivityDeletarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeletarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val deleteBtn = binding.deleteBtn
        val cancelBtn = binding.cancelBtn

        deleteBtn.setOnClickListener {
            val productIdInput = binding.productIdInput.text.toString().toIntOrNull()

            if (productIdInput == null) {
                Toast.makeText(this, "Please insert a valid product ID", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(!deleteProductById(this,productIdInput)){
                Toast.makeText(this, "Product with Id not found!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else{
                Toast.makeText(this, "Product deleted with success", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MenuActivity::class.java))
                finish()
                return@setOnClickListener
            }



        }
        cancelBtn.setOnClickListener {
            startActivity(Intent(this@DeletarActivity, MenuActivity::class.java))
            finish()
            return@setOnClickListener
        }
    }
}
