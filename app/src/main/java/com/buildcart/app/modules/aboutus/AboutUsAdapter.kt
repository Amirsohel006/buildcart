package com.buildcart.app.modules.aboutus
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.buildcart.app.R
import com.buildcart.app.modules.responses.AboutResponse

class AboutUsAdapter(val postModel: List<AboutResponse>): RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent,false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return postModel.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        return holder.bindView(postModel[position])
    }
}

class PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    private val txtIntroduction: TextView =itemView.findViewById(R.id.txtIntruductionTitlle)
   // private val txtHistory: TextView =itemView.findViewById(R.id.txthistory)
    private val description:TextView=itemView.findViewById(R.id.txtDescriptionofIntruduction)


    fun bindView(postModel: AboutResponse){
        txtIntroduction.text=postModel.heading
       // txtHistory.text=postModel.history
        description.text=postModel.description
    }
}