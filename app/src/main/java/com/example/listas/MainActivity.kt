package com.example.listas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var noticias: MutableList<Noticia> = mutableListOf();

    //private val adaptador: NoticiasAdapter = NoticiasAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        noticias.add(
            Noticia(
                "Random Acces Memories",
                "https://images-na.ssl-images-amazon.com/images/I/61Uxg-SWExL._SL1500_.jpg"
            )
        )
        noticias.add(
            Noticia(
                "Discovery",
                "https://upload.wikimedia.org/wikipedia/en/thumb/a/ae/Daft_Punk_-_Discovery.jpg/220px-Daft_Punk_-_Discovery.jpg"
            )
        )

        val adaptador: NoticiasAdapter = NoticiasAdapter(noticias)
        val listaNoticia: RecyclerView = findViewById(R.id.listaNoticias)
        listaNoticia.layoutManager = LinearLayoutManager(this)
        listaNoticia.adapter = adaptador

        //listaNoticia.setOnClickListener(update())

        val btnqlero: Button = findViewById(R.id.btnAnadir)
        btnqlero.setOnClickListener {agregarElemento()  }

    }

    /**private fun update(): View.OnClickListener? {
        noticias.set(0, Noticia("Actualizado", "https://ismorbo.com/wp-content/uploads/2016/07/Arctic-Monkeys-AM-Elephant.jpg"))
    }**/

    private fun agregarElemento(){
        noticias.add(Noticia("Elemento Nuevo","https://img.youtube.com/vi/bpOSxM0rNPM/0.jpg") )
        val adaptador: NoticiasAdapter = NoticiasAdapter(noticias)
        val listaNoticia: RecyclerView = findViewById(R.id.listaNoticias)
        listaNoticia.layoutManager = LinearLayoutManager(this)
        listaNoticia.adapter = adaptador
    }

}

