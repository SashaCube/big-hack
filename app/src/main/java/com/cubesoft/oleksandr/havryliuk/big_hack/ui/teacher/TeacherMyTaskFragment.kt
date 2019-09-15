package com.cubesoft.oleksandr.havryliuk.big_hack.ui.teacher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cubesoft.oleksandr.havryliuk.big_hack.R
import com.cubesoft.oleksandr.havryliuk.big_hack.remote.GetDataStore
import com.cubesoft.oleksandr.havryliuk.big_hack.utils.toast
import kotlinx.android.synthetic.main.fragment_teacher_check.recycler_view
import kotlinx.android.synthetic.main.fragment_teacher_my_task.*

class TeacherMyTaskFragment : Fragment() {

    lateinit var viewAdapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_teacher_my_task, container, false)

        initAdapter()
        initView()

        return root
    }

    private fun initAdapter() {
        viewAdapter = TaskAdapter {
            context?.toast("Task onClick")
        }
    }


    private fun initView() {
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = viewAdapter
        }
        
        fab.setOnClickListener {
            context?.toast("Create Task")
        }


        GetDataStore().getTasksByTeacherId(TEACHER_ID)

    }

    companion object {
        const val TEACHER_ID = "TEACHER_ID"
    }

}