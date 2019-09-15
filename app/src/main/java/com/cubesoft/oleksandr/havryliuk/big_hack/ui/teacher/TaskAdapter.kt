package com.cubesoft.oleksandr.havryliuk.big_hack.ui.teacher

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cubesoft.oleksandr.havryliuk.big_hack.R
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Task

class TaskAdapter(
    private val onItemClickListener: (item: Task) -> Unit
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    private var data = listOf<Task>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TaskViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task: Task = data[position]
        holder.bind(task)

        holder.itemView.setOnClickListener{
            onItemClickListener(task)
        }
    }

    override fun getItemCount(): Int = data.size

    fun update(newData: List<Task>){
        data = newData
        notifyDataSetChanged()
    }

    class TaskViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_task, parent, false)) {
        private var mTitleView: TextView? = null
        private var mYearView: TextView? = null


        init {
            mTitleView = itemView.findViewById(R.id.tv_task_name)
            mYearView = itemView.findViewById(R.id.tv_class_name)
        }

        fun bind(task: Task) {
            mTitleView?.text = task.name
            mYearView?.text = task.classId
        }

    }
}
