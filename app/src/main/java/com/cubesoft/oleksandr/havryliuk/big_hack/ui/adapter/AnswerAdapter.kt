package com.cubesoft.oleksandr.havryliuk.big_hack.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cubesoft.oleksandr.havryliuk.big_hack.R
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Answer

class AnswerAdapter(
    private val onItemClickListener: (item: Answer) -> Unit
) : RecyclerView.Adapter<AnswerAdapter.AnswerViewHolder>() {

    private var data = listOf<Answer>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return AnswerViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: AnswerViewHolder, position: Int) {
        val Answer: Answer = data[position]
        holder.bind(Answer)

        holder.itemView.setOnClickListener{
            onItemClickListener(Answer)
        }
    }

    override fun getItemCount(): Int = data.size

    fun update(newData: List<Answer>){
        data = newData
        notifyDataSetChanged()
    }

    class AnswerViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_answer, parent, false)) {
        private var mTitleView: TextView? = null
        private var mYearView: TextView? = null


        init {
            mTitleView = itemView.findViewById(R.id.tv_answer_name)
            mYearView = itemView.findViewById(R.id.tv_class_name)
        }

        fun bind(Answer: Answer) {
            //mTitleView?.text = Answer.name
            mYearView?.text = Answer.classId
        }

    }
}