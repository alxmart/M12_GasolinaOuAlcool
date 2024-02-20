package com.luizafmartinez.m12_gasolinaoualcool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var textInputAlcool: TextInputLayout
    private lateinit var editAlcool: TextInputEditText

    private lateinit var textInputGasolina: TextInputLayout
    private lateinit var editGasolina: TextInputEditText

    private lateinit var btnCalcular: Button
    private lateinit var textResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inicializarComponentesInterface()

        btnCalcular.setOnClickListener {

            calcularMelhorPreco()
        }
    }

    private fun calcularMelhorPreco() {

        val precoAlcool = editAlcool.text.toString()
        val precoGasolina = editGasolina.text.toString()

        val resultadoValidacao = validarCampos(precoAlcool, precoGasolina)

        if ( resultadoValidacao ) {
            // Se (valorAlcool / valorGAsolina) >= 0.7 é melhor usar Gasolina
            // senão, é melhor usar álcool

            val precoAlcoolDouble = precoAlcool.toDouble()
            val precoGasolinaDouble = precoGasolina.toDouble()

            val resultado = precoAlcoolDouble / precoGasolinaDouble

            if ( resultado >= 0.7 ) {
                textResultado.text = " Melhor usar GASOLINA"
            } else {
                textResultado.text = " Melhor usar ÁLCOOL"
            }
        }
    }

    private fun validarCampos(pAlcool: String, pGasolina: String): Boolean {

        textInputAlcool.error = null
        textInputGasolina.error = null

        if ( pAlcool.isEmpty() ) {
            textInputAlcool.error = "Digite o preço do álcool"
            return false
        } else if ( pGasolina.isEmpty() ) {
            textInputGasolina.error = "Digite o preço da gasolina"
            return false
        }

        return true
    }

    private fun inicializarComponentesInterface() {

        textInputAlcool = findViewById(R.id.text_input_alcool)
        editAlcool = findViewById(R.id.edit_alcool)

        textInputGasolina = findViewById(R.id.text_input_gasolina)
        editGasolina = findViewById(R.id.edit_gasolina)

        btnCalcular = findViewById(R.id.btn_calcular)
        textResultado = findViewById(R.id.text_resultado)
    }

}