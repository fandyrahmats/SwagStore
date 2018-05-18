package com.example.fandyrahmatsaputra.swagstore.Controller

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.fandyrahmatsaputra.swagstore.Adapters.ProductRecycleAdapter
import com.example.fandyrahmatsaputra.swagstore.R
import com.example.fandyrahmatsaputra.swagstore.Service.DataService
import com.example.fandyrahmatsaputra.swagstore.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : AppCompatActivity() {

    lateinit var adapter: ProductRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val getCategoryType = intent.getStringExtra(EXTRA_CATEGORY)
        adapter = ProductRecycleAdapter(this, DataService.getProducts(getCategoryType))

        var spanCount = 2
        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 3
        }

        val screenSize = resources.configuration.screenWidthDp
        if (screenSize < 720) {
            spanCount = 3
        }

        val layoutManager = GridLayoutManager(this, spanCount)
        lv_products_.layoutManager = layoutManager
        lv_products_.adapter = adapter
    }
}
