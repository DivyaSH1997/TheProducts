package com.example.productadvertisement

import android.os.Binder
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.productadvertisement.databinding.AdvViewBinding
import com.example.productadvertisement.databinding.ProductViewBinding

class GeneralAdapter(private var products : ArrayList<Product>, private var advertisements : ArrayList<Adv>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var bindingprod:ProductViewBinding
    lateinit var bindingadv: AdvViewBinding
    val VIEW_TYPE_PRODUCT = 1
    val VIEW_TYPE_ADVERTISEMENT = 2
    var i:Int=0


    class ProductViewHolder(private var bindingprod: ProductViewBinding) : RecyclerView.ViewHolder(bindingprod.root) {
        fun bind(prod:Product)
        {
            bindingprod.productObject=prod
        }

    }

    class AdvertisementViewHolder(private var bindingadv:AdvViewBinding ) : RecyclerView.ViewHolder(bindingadv.root) {
        fun bind(adv:Adv)
        {
            bindingadv.advObject=adv
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {


        if(viewType == VIEW_TYPE_PRODUCT){
            bindingprod = ProductViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

            return ProductViewHolder(bindingprod)
        }

       bindingadv=AdvViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AdvertisementViewHolder(bindingadv)
    }
    override fun getItemViewType(position: Int): Int {

            if((position+1)%3 == 0){
            return VIEW_TYPE_ADVERTISEMENT
        }
        return VIEW_TYPE_PRODUCT
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


        if(holder is ProductViewHolder){
            var product = products[position - position/3]
            holder.bind(product)

        }

        if(holder is AdvertisementViewHolder){


            var advpos = (position+1)/3 - 1
            if(advpos >= advertisements.size){
                advpos = advpos % 8
                i++
            }

            var advertisement = advertisements[advpos]
            holder.bind(advertisement)

        }
    }

    override fun getItemCount(): Int {
        return products.size + advertisements.size+i
    }


}