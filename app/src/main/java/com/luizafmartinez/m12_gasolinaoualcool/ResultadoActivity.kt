package com.luizafmartinez.m12_gasolinaoualcool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {

    private lateinit var textGasolina: TextView
    private lateinit var textAlcool: TextView
    private lateinit var textoFinal: TextView
    private lateinit var btnVoltar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        textGasolina = findViewById(R.id.text_gasolina)
        textAlcool = findViewById(R.id.text_alcool)
        textoFinal = findViewById(R.id.texto_final)
        btnVoltar = findViewById(R.id.btn_voltar)

        val bundle = intent.extras

        if (bundle != null) {

            val gasolina = bundle?.getDouble("gasolina")
            val alcool = bundle?.getDouble("alcool")
            val result = bundle?.getString("resultado")

            textGasolina.text = "Preço Gasolina: R$ $gasolina"
            textAlcool.text = "Preço Álcool: R$ $alcool"
            textoFinal.text = "$result"


            btnVoltar.setOnClickListener {
                finish()
            }
        }
    }
}