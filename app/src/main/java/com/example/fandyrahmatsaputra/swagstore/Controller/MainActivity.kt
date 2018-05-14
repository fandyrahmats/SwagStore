package com.example.fandyrahmatsaputra.swagstore.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.fandyrahmatsaputra.swagstore.Adapters.CategoryAdapter
import com.example.fandyrahmatsaputra.swagstore.Model.Category
import com.example.fandyrahmatsaputra.swagstore.R
import com.example.fandyrahmatsaputra.swagstore.Service.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = CategoryAdapter(this, DataService.categories)
        lv_categories.adapter = adapter
    }
}
