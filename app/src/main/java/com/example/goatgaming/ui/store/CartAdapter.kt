package com.example.goatgaming.ui.store
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.goatgaming.R

class CartAdapter(private val cartItemList: List<CartItem>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName: TextView = itemView.findViewById(R.id.cart_item_name)
        val itemPrice: TextView = itemView.findViewById(R.id.cart_item_price)
        val itemQuantity: TextView = itemView.findViewById(R.id.cart_item_quantity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.cart_fields, parent, false)
        return CartViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val currentItem = cartItemList[position]
        holder.itemName.text = currentItem.name
        holder.itemPrice.text = currentItem.price
        holder.itemQuantity.text = currentItem.quantity.toString()
    }

    override fun getItemCount(): Int {
        return cartItemList.size
    }
}
