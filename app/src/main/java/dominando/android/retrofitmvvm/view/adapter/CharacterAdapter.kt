package dominando.android.retrofitmvvm.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import dominando.android.retrofitmvvm.R
import dominando.android.retrofitmvvm.model.Result


class CharacterAdapter(private var resultList: List<Result>) :
    RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = resultList[position]
        holder.bind(result)
    }

    override fun getItemCount(): Int = resultList.size


    fun setUpdate(results: List<Result>?) {
        resultList = results!!
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var nome: TextView = itemView.findViewById(R.id.txtCharacter)
        private var img: ImageView = itemView.findViewById(R.id.imgCharacter)

        fun bind(result: Result) {
            nome.text = result.name
            Picasso.get().load(result.image).into(img)
        }
    }
}