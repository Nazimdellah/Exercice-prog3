package com.example.Rajabi

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.Rajabi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

   private lateinit var listeBoutons: List<Button>

   var scoreTops = 0
    var scoreFlops = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvTops.setOnClickListener(View.OnClickListener {
            println("coucou")

        })
        listeBoutons = listOf(
            binding.btn1,
                    binding.btn2,
                    binding.btn3,
                    binding.btn4,
                    binding.btn5,
                    binding.btn6,
                    binding.btn7,
                    binding.btn8,
                    binding.btn9
        )
        for(btn in listeBoutons){
            btn.setOnClickListener(View.OnClickListener {
                reagirAuClic(it)
            })
        }
        initialiser()
    }


    fun initialiser(){
        //Choisir une caise pour le lapin pour le lapin
        //mettre tous les autres a taupe

        for(btn in listeBoutons){
            btn.setText("TAUPE")
        }
        //choisir un bouton au hasard dans la liste

        val boutonLapin: Button = listeBoutons.random()
        boutonLapin.setText("LAPIN")


    }

    fun reagirAuClic(it: View){
// détecter si le bouton appuyé est le lapin
        val boutonAppuye: Button = it as Button
        if(boutonAppuye.text == "LAPIN") {
            boutonAppuye.setText("TAUPE")
            initialiser()
            scoreTops++
        }
        else{
            scoreFlops++
            //sinon on perd
            //afficher un message
            //réinitialiser le jeu
        }
       // mettre à jour le score
        binding.tvTops.setText("Tops: $scoreTops")
        binding.tvFlops.setText("Flops: $scoreFlops")
    }
}