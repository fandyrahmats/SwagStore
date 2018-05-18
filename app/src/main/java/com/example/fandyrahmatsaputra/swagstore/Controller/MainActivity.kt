package com.example.fandyrahmatsaputra.swagstore.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.fandyrahmatsaputra.swagstore.Adapters.CategoryAdapter
import com.example.fandyrahmatsaputra.swagstore.Adapters.CategoryRecycleAdapter
import com.example.fandyrahmatsaputra.swagstore.Model.Category
import com.example.fandyrahmatsaputra.swagstore.R
import com.example.fandyrahmatsaputra.swagstore.Service.DataService
import com.example.fandyrahmatsaputra.swagstore.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = CategoryRecycleAdapter(this, DataService.categories) { category ->
            val intentProductDetail = Intent(this, ProductActivity::class.java)
            intentProductDetail.putExtra(EXTRA_CATEGORY, category.title)
            startActivity(intentProductDetail)
        }

        lv_categories_.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        lv_categories_.layoutManager = layoutManager
        lv_categories_.setHasFixedSize(true)
    }
}
