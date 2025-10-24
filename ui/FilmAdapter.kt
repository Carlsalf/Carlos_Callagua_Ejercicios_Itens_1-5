package es.ua.eps.filmoteca.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import es.ua.eps.filmoteca.R
import es.ua.eps.filmoteca.model.Film


class FilmAdapter(
    private val items: List<Film>,
    private val onClick: (Film) -> Unit
) : RecyclerView.Adapter<FilmAdapter.VH>() {

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.txtTitle)
        val year: TextView = itemView.findViewById(R.id.txtYear)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_film, parent, false)
        return VH(v)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        val film = items[position]
        holder.title.text = film.title
        holder.year.text = film.year.toString()
        holder.itemView.setOnClickListener { onClick(film) }
    }
}
