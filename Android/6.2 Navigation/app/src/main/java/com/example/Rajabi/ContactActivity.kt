package com.example.Rajabi

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.Rajabi.databinding.ActivityContactBinding
import com.example.Rajabi.databinding.ActivityMainBinding

class ContactActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Contact"
        //reacts to the click on the button acceuil
        binding.btnAcceuil.setOnClickListener {
            // we create the intent, which needs:
            //1. the current context (this)
            //2. the class of the activity to start (MainActivity::class.java)
            val intent = Intent(this, MainActivity::class.java)
            // we start the activity
            startActivity(intent)
        }

    }
}