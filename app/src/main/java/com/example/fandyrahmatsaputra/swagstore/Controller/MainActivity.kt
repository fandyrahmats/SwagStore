package com.example.fandyrahmatsaputra.swagstore.Controller

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
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = CategoryRecycleAdapter(this, DataService.categories)
        lv_categories.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        lv_categories.layoutManager = layoutManager
        lv_categories.setHasFixedSize(true)
    }
}
