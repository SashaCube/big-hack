package com.cubesoft.oleksandr.havryliuk.big_hack.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cubesoft.oleksandr.havryliuk.big_hack.R
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Mark

class MarkAdapter(
    private val onItemClickListener: (item: Mark) -> Unit
) : RecyclerView.Adapter<MarkAdapter.MarkViewHolder>() {

    private var data = listOf<Mark>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarkViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MarkViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: MarkViewHolder, position: Int) {
        val Mark: Mark = data[position]
        holder.bind(Mark)

        holder.itemView.setOnClickListener {
            onItemClickListener(Mark)
        }
    }

    override fun getItemCount(): Int = data.size

    fun update(newData: List<Mark>) {
        data = newData
        notifyDataSetChanged()
    }

    class MarkViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_mark, parent, false)) {
        private var mMarkView: TextView? = null
        private var mTaskNamewView: TextView? = null


        init {
            mMarkView = itemView.findViewById(R.id.tv_mark)
            mTaskNamewView = itemView.findViewById(R.id.tv_task_name)
        }

        fun bind(Mark: Mark) {
            mMarkView?.text = Mark.body
            mTaskNamewView?.text = Mark.taskId
        }

    }
}