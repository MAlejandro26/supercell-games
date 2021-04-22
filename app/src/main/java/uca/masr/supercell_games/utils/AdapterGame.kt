package uca.masr.supercell_games.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uca.masr.supercell_games.model.Game
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_game.view.*
import uca.masr.supercell_games.R

class AdapterGame () : RecyclerView.Adapter<AdapterGame.ViewHolder>() {

    lateinit var items: ArrayList<Game>

    fun setGames(items: List<Game>){
        this.items = items as ArrayList<Game>
        notifyDataSetChanged()
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each picture to
        val gameImage: ImageView = view.game_image
        val name: TextView = view.name
        val description: TextView = view.description
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model= items[position]
        holder.name.text = model.name
        holder.description.text = model.description
        Picasso.get()
            .load(model.image)
            .into(holder.gameImage)
    }

    override fun getItemCount(): Int {
        return if(::items.isInitialized){
            items.size
        }else{
            0
        }
    }
}