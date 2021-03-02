package com.example.listas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), NoticiasAdapter.NoticiasHolder.ClickListener {
    private var noticias: MutableList<Noticia> = mutableListOf();
    //Aqui está el error
    val adaptador= NoticiasAdapter(this, noticias)
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

        actualizar()

        //listaNoticia.setOnClickListener(update())

        val btnqlero: Button = findViewById(R.id.btnAnadir)
        btnqlero.setOnClickListener {agregarElemento()  }

    }

    /**private fun update(): View.OnClickListener? {
        noticias.set(0, Noticia("Actualizado", "https://ismorbo.com/wp-content/uploads/2016/07/Arctic-Monkeys-AM-Elephant.jpg"))
    }**/

    private fun agregarElemento(){
        noticias.add(Noticia("Elemento Nuevo","https://img.youtube.com/vi/bpOSxM0rNPM/0.jpg") )
        actualizar()
    }
    fun actualizar(){
        val listaNoticia: RecyclerView = findViewById(R.id.listaNoticias)
        listaNoticia.layoutManager = LinearLayoutManager(this)
        listaNoticia.adapter = adaptador
    }

    override fun onItemClicked(position: Int) {
        noticias[position]= Noticia("Actualizado", "https://chordsandcommas.files.wordpress.com/2018/05/tranquility-base-acrtic-monkeys.jpg")
            actualizar()
    }

    override fun onItemLongClicked(position: Int): Boolean {
        noticias.removeAt(position)
        actualizar()
        return true
    }


}

