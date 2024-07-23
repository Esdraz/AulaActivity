package com.esdraz.aulaactivityfragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var btnAbrir: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("ciclo_vida", "onCreate")
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnAbrir = findViewById(R.id.btn_abrir)
        btnAbrir.setOnClickListener {

            val intent = Intent(this, DetalhesActivity::class.java)

            //passar parametros para nova tela
//            intent.putExtra("serie", "The Witcher")
//            intent.putExtra("classificacao", 5)
//            intent.putExtra("avaliacao", 9.2)

            val serie = Serie(
                "House of the Dragon",
                "Spin-of da serie Game of Thrones",
                4.9,
                "Karen Wacker",
                "HBO"
            )

            intent.putExtra("tv-show", serie)

            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("ciclo_vida", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("ciclo_vida", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("ciclo_vida", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("ciclo_vida", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("ciclo_vida", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("ciclo_vida", "onDestroy")
    }
}
