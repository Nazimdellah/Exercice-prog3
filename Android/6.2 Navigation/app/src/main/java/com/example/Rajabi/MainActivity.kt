package com.example.Rajabi

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.Rajabi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Acceuil"

      //réagit au clic sur le button article
        binding.btnArticle.setOnClickListener {
        // on cree l'intent, qui a besoin:
            //1. du contexte actuel (this)
            //2. de la classe de l'activité à démarrer (ArticleActivity::class.java)
            val intent = Intent(this, ArticleActivity::class.java)
            // on démarre l'activité
            startActivity(intent)
        }

        //réagit au clic sur le button contact
        binding.btnContact.setOnClickListener {
            // on cree l'intent, qui a besoin:
            //1. du contexte actuel (this)
            //2. de la classe de l'activité à démarrer (ContactActivity::class.java)
            val intent = Intent(this, ContactActivity::class.java)
            // on démarre l'activité
            startActivity(intent)
        }


    }
}