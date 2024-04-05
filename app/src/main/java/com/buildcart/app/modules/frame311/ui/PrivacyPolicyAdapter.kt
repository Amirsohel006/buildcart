package com.buildcart.app.modules.frame311.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.buildcart.app.R
import com.buildcart.app.modules.responses.PrivacyResponse


class PrivacyPolicyAdapter(val postModel: List<PrivacyResponse>): RecyclerView.Adapter<PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.row_privacy_policy,parent,false)
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
    private val txtPrivacyPolicyCount: TextView =itemView.findViewById(R.id.txtPrivacyPolicyCount)
    private val txtPrivacyPolicy: TextView =itemView.findViewById(R.id.txtPrivacyPolicy)


    fun bindView(postModel: PrivacyResponse){
        txtPrivacyPolicyCount.text= postModel.id.toString()
        txtPrivacyPolicy.text=postModel.description
    }
}