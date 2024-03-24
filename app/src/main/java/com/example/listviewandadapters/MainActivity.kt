package com.example.listviewandadapters

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val listView = findViewById<ListView>(R.id.listView)

        val listItems = arrayListOf<String>()
        listItems.add("Learning constraint layout")
        listItems.add("Make video on project")
        listItems.add("Solve bugs in Login project")
        listItems.add("Take care of family")
        listItems.add("Meditation")
        listItems.add("Go to walk in evening")

        val adapterForListView = ArrayAdapter(this , android.R.layout.simple_list_item_1 , listItems)
        listView.adapter = adapterForListView

        listView.setOnItemClickListener { parent, view, position, id ->
            val text = (view as TextView).text.toString()
            Toast.makeText(applicationContext , "clicked on $text" , Toast.LENGTH_SHORT).show()
        }
    }
}