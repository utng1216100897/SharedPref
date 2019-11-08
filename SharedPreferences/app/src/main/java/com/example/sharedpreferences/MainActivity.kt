package com.example.sharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val preferencias  = getSharedPreferences("agenda", Context.MODE_PRIVATE)

        btnGuardar.setOnClickListener {
            // objetp para edición
            val editor = preferencias.edit()
            editor.putString(txtNombre.text.toString(),
                txtDatos.text.toString())
            editor.commit()
            Toast.makeText(this,"Datos grabados",Toast.LENGTH_LONG).show()
            txtNombre.setText("")
            txtDatos.setText("")
        }
        btnRecuperar.setOnClickListener {
            val datos = preferencias.getString(txtNombre.text.toString(),"")
            if (datos.length == 0) {
                Toast.makeText(
                    this, "No existe dicho nombre en  la agenda",
                    Toast.LENGTH_LONG
                ).show()
            }else{
                txtDatos.setText(datos)
            }

        }
    }
}
