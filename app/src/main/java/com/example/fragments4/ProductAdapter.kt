package com.example.fragmentnavigation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments4.Product
import com.example.fragments4.R
//import kotlinx.android.extensions.LayoutContainer
//import kotlinx.android.synthetic.main.list_item.*


class ProductAdapter(private val listener: (Product) -> Unit):
    ListAdapter<Product, ProductAdapter.ViewHolder>(DiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ProductAdapter.ViewHolder {
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder (val containerView: View) : RecyclerView.ViewHolder(containerView) {
        val productImage:ImageView = containerView.findViewById(R.id.product_image)
        val productName:TextView = containerView.findViewById(R.id.name)
        val productPrice:TextView = containerView.findViewById(R.id.price)
        val productDesctription:TextView = containerView.findViewById(R.id.description)

        init{
            itemView.setOnClickListener{
                listener.invoke(getItem(adapterPosition))
            }
        }

        fun bind(countryData: Product){
            with(countryData){
                productImage.setImageResource(imageId)
                productName.text = name
                productPrice.text = "Price: Rs$price"
                productDesctription.text = shortDescription
            }
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.imageId == newItem.imageId
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }
}