    package com.example.productadvertisement

import android.content.res.TypedArray
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.productadvertisement.databinding.ActivityMainBinding

    class MainActivity : AppCompatActivity() {
        lateinit var prodnames: Array<String>
        lateinit var imageprod: TypedArray
        lateinit var srno: Array<String>
        lateinit var prodprice: Array<String>
        lateinit var advimage:TypedArray
        private lateinit var binding: ActivityMainBinding
        private lateinit var recyclerProducts: RecyclerView
        private lateinit var products: ArrayList<Product>
        private lateinit var advertisements: ArrayList<Adv>
        private lateinit var generalAdapter: GeneralAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

            allResources()
            initProducts()
            initAdvertisement()
            initViews()


        }
        open fun allResources() {

            prodnames = resources.getStringArray(R.array.productnames)
            imageprod = resources.obtainTypedArray(R.array.productimages)
            srno = resources.getStringArray(R.array.srno)
            prodprice = resources.getStringArray(R.array.productprices)
            advimage=resources.obtainTypedArray(R.array.advertisement)
        }

        open fun initViews() {

            binding.recycleritems.setLayoutManager(
                LinearLayoutManager(
                    this,
                    LinearLayoutManager.VERTICAL,
                    false
                )
            )

            generalAdapter = GeneralAdapter(products, advertisements)
            binding.recycleritems.adapter=generalAdapter

        }


        open fun initProducts() {
            products = java.util.ArrayList()
            val length: Int = imageprod.length()
            for (i in 0 .. length-1) {
                products.add(
                        Product(
                            imageprod.getDrawable(i),
                            srno.get(i),
                            prodnames.get(i),
                            prodprice.get(i),
                        )
                )
                    }

            }

        open fun initAdvertisement() {

            advertisements = java.util.ArrayList()
            val length: Int = advimage.length()
            for (i in 0 .. length-1) {
                advertisements.add(
                    Adv(
                        advimage.getDrawable(i)
                )
                )
            }
        }
    }


