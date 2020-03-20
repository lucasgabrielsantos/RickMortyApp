//package dominando.android.retrofitmvvm.view.adapter
//
//import android.view.View
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.squareup.picasso.Picasso
//import dominando.android.retrofitmvvm.R
//import dominando.android.retrofitmvvm.model.Result
//
//
//class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//    var nome: TextView = itemView.findViewById(R.id.txtCharacter)
//    var img: ImageView = itemView.findViewById(R.id.imgCharacter)
//
//    fun onBind(result: Result?) {
//        nome.text = result?.name
//        Picasso.get().load(result?.image).into(img)
//    }
//
//}