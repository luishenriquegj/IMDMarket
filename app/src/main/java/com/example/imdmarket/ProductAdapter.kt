package com.example.imdmarket

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException

class ProductAdapter(private val productList: ArrayList<String>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productName: TextView = itemView.findViewById(R.id.productName)
        val productCode: TextView = itemView.findViewById(R.id.productCode)
        val productStock: TextView = itemView.findViewById(R.id.productStock)
        val productDescription: TextView = itemView.findViewById(R.id.productDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val productJson: String = productList[position]
        val gson = Gson()
        try {
            val product: Product = gson.fromJson(productJson, Product::class.java)
            holder.productName.text = product.name
            holder.productCode.text = product.id.toString()
            holder.productStock.text = product.stock.toString()
            holder.productDescription.text = product.description
        } catch (e: JsonSyntaxException) {
            Log.e("ProductAdapter", "Failed to parse product JSON", e)
        }

    }

    override fun getItemCount(): Int {
        return productList.size
    }
}
