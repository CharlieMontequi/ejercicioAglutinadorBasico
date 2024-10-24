package com.example.ejercicioaglutinadorbasico

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /** todo
         * una interfaz con nombre ape 1 y ape 2
         * una list view con dam daw asir
         * boton limpiar qeu borre los tres primer campos
         * boton enviar que muestre el texto de los campos
         */

        // pirmero fijar los campos que se van a completar a la vista
        var textEditNombre = findViewById<EditText>(R.id.editText_nombre)
        var textEditApellido1 = findViewById<EditText>(R.id.editText_apellido1)
        var textEditApellido2 = findViewById<EditText>(R.id.editText_apellido2)
        val textViewMostrar = findViewById<TextView>(R.id.textView_mostrarDatos)
        val botonLimpiar = findViewById<Button>(R.id.button_limpiar)
        val botonEnviar = findViewById<Button>(R.id.button_enviar)

        // rellenar el listview con los elementos que se pueden seleccionar
        val listViewMatriculas = findViewById<ListView>(R.id.listViewMatriculas)

        // se instancia un array y se le dan los datos desde la referencia de strings
       // val listadoMatricular : Array<String> = resources.getStringArray(R.string.arrayMatriculas)// da error diciendo que no existe la referencia pero si
        val listadoMatricular= arrayOf("DAM", "DAW", "HIGIENE", "COCINA")

        //usar el adaptador que viene con las vistas de base
        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1,listadoMatricular)
        // se le da al list view wl adaptador que se ha construido con la relacion a la vista de cada item y los datos
        listViewMatriculas.adapter = adaptador

        // como los datos se van a mostrar con un boton y no al clicar se crea una auxiliar que recoja los datos
        var itemPinchado : String =""
        listViewMatriculas.onItemClickListener= AdapterView.OnItemClickListener{_,_,posicionArray,_ ->
            val cursoSeleccionado = listadoMatricular[posicionArray]
        itemPinchado= cursoSeleccionado}

        // al pinchar en limpiar se vacian los campos de nombre y apellidos
        botonLimpiar.setOnClickListener {
            textEditNombre.text.clear()
            textEditApellido1.text.clear()
            textEditApellido2.text.clear()
        }

        //al pinchar en enviar se muestran los datos junto con el curso en el listview
        botonEnviar.setOnClickListener {
            textViewMostrar.text="Alumne: ${textEditNombre.text} ${textEditApellido1.text} ${textEditApellido2.text}\n matriculado en: $itemPinchado "
        }
    }
}