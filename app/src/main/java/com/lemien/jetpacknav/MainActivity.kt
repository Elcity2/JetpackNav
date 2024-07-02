package com.lemien.jetpacknav

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
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
        var navController = findNavController(R.id.host)
        supportActionBar?.title = "This is testing"

        navController?.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.blankFragment12 -> supportActionBar?.title = "First"
                R.id.blankFragment22 -> supportActionBar?.title = "Second"
                R.id.blankFragment3 -> supportActionBar?.title = "Third"

            }
        }
    }
}