package com.esdraz.aulaactivityfragment

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetalhesActivity : AppCompatActivity() {

    private lateinit var btnFechar: Button
    private lateinit var textSerie: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnFechar = findViewById(R.id.btn_fechar)
        textSerie = findViewById(R.id.textSerie)

        //bundle tem todos os parametros passados
        val bundle = intent.extras
        if (bundle != null) {
//            val serie = bundle.getString("serie")
//            val classificacao = bundle.getInt("classificacao")
//            val avaliacao = bundle.getDouble("avaliacao")
//
//            val resultado = "Serie: $serie - class: $classificacao/5 - aval: $avaliacao"

            val serie = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//                bundle.getSerializable("tv-show", Serie::class.java)
                bundle.getParcelable("tv-show", Serie::class.java)
            } else {
//                bundle.getSerializable("tv-show") as Serie //forma antiga
                bundle.getParcelable("tv-show")
            }

//            textSerie.text = resultado
            textSerie.text = "${serie?.nome} - ${serie?.avaliacoes} - ${serie?.descricao}"
        }
        btnFechar.setOnClickListener {
            finish()
        }
    }
}