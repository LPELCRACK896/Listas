package com.example.listas
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class NoticiasAdapter(private val listener: NoticiasHolder.ClickListener, private var noticias: MutableList<Noticia>): RecyclerView.Adapter<NoticiasAdapter.NoticiasHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticiasHolder {
        val view: View =
                LayoutInflater.from(parent.context).inflate(R.layout.item_noticia, parent, false)
        return NoticiasHolder(view)
    }

    override fun getItemCount(): Int {
        return this.noticias.size
    }

    override fun onBindViewHolder(holder: NoticiasHolder, position: Int) {
        val actual: Noticia = this.noticias[position]

        holder.bind(actual, listener)
    }

     class NoticiasHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(noticias: Noticia, listener:ClickListener) = with(itemView) {
            val txtTitulo: TextView = findViewById(R.id.txtTitulo)
            val imagen: ImageView = findViewById(R.id.imagen)
            txtTitulo.text = noticias.titulo
            Picasso.get().load(noticias.imagen).into(imagen)
            setOnClickListener{
                listener.onItemClicked(adapterPosition)
            }
            setOnLongClickListener{
                listener.onItemLongClicked(adapterPosition)
            }
        }
        interface ClickListener{
            fun onItemClicked(position: Int)
            fun onItemLongClicked(position: Int): Boolean
        }

    }
}