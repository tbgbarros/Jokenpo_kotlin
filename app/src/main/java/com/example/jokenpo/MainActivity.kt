package com.example.jokenpo

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.jokenpo.Jogo.Escolha.*

class MainActivity : AppCompatActivity() {

    private lateinit var jogojokenpo: Jogo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        jogojokenpo = Jogo()

        val btnPedra = findViewById<ImageButton>(R.id.btnPedra)
        val btnPapel = findViewById<ImageButton>(R.id.btnPapel)
        val btnTesoura = findViewById<ImageButton>(R.id.btnTesoura)

        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        val imgComputador = findViewById<ImageView>(R.id.imgComputador)

            btnPedra.setOnClickListener {
                jogar(PEDRA, txtResultado, imgComputador)
            }

            btnPapel.setOnClickListener {
                jogar(PAPEL, txtResultado, imgComputador)
            }

            btnTesoura.setOnClickListener {
                jogar(TESOURA, txtResultado, imgComputador)
            }

    }
    private fun jogar(escolhaUsuario: Jogo.Escolha, txtResultado: TextView, imgComputador: ImageView){
        val escolhaComputador = jogojokenpo.jogadaComputador()
        imgComputador.setImageResource(getImageResource(escolhaComputador))

        val resultado = jogojokenpo.determinarVencedor(escolhaUsuario, escolhaComputador)
        txtResultado.text = resultado
    }

    private fun getImageResource(escolha: Jogo.Escolha): Int {
        return when (escolha) {
            PEDRA -> R.drawable.pedra
            PAPEL -> R.drawable.papel
            TESOURA -> R.drawable.tesoura
        }
    }
}
