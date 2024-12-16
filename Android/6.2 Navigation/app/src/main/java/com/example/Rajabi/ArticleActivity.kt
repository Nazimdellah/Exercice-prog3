package com.example.Rajabi

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.Rajabi.databinding.ActivityArticleBinding
import com.example.Rajabi.databinding.ActivityMainBinding

class ArticleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArticleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Article"

        //reagit au clic sur le button contact
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