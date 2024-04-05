package com.buildcart.app.modules

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.buildcart.app.R
import com.buildcart.app.modules.responses.Faqs
import com.buildcart.app.modules.responses.QResponse


class FAQAdapter(var faqModel: List<Faqs>):
        RecyclerView.Adapter<FAQAdapter.FaqViewHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FaqViewHolder{
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.faq_layout, parent, false)
            return FaqViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: FAQAdapter.FaqViewHolder, position: Int) {
            return holder.bindView(faqModel[position])
        }

        override fun getItemCount(): Int {
            return faqModel.size
        }




    inner class FaqViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val questionTextView: TextView = itemView.findViewById(R.id.questiontextview)
        val answerTextView: TextView = itemView.findViewById(R.id.answertextview)

        fun bindView(postModel: Faqs) {
            questionTextView.text = postModel.question
            answerTextView.text = postModel.Answer // accessing the correct property name
        }
    }



}