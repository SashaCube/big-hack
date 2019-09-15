package com.cubesoft.oleksandr.havryliuk.big_hack.ui.teacher

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.cubesoft.oleksandr.havryliuk.big_hack.R
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Task
import com.cubesoft.oleksandr.havryliuk.big_hack.remote.GetDataStore
import com.cubesoft.oleksandr.havryliuk.big_hack.ui.adapter.TaskAdapter
import com.cubesoft.oleksandr.havryliuk.big_hack.ui.student.StudentTasksFragment.Companion.SCHOOL_ID
import com.cubesoft.oleksandr.havryliuk.big_hack.utils.Utils
import kotlinx.android.synthetic.main.fragment_teacher_my_task.view.*

class TeacherTasksToCheckFragment : Fragment() {

    lateinit var viewAdapter: TaskAdapter
    private lateinit var swLayout: SwipeRefreshLayout
    lateinit var emptyView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_teacher_answers_to_check, container, false)

        initAdapter()
        initView(root)

        return root
    }

    private fun initAdapter() {
        viewAdapter = TaskAdapter {
            (activity as TeacherActivity).showTeacherAnswersToCheckFragment(it)
        }
    }


    private fun initView(root: View) {
        root.recycler_view.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = viewAdapter
        }

        swLayout = root.swipe_refresh

        swLayout.setOnRefreshListener {
            loadData()
        }

        emptyView = root.empty_view

        loadData()

    }

    fun loadData() {
        // TODO : set to real ID
        GetDataStore().getTasksByTeacherId(TeacherMyTaskFragment.TEACHER_ID, object : Utils.LoadData<List<Task>> {
            override fun onData(data: List<Task>?) {
                if (data != null) {
                    viewAdapter.update(data)
                    if(data.isEmpty()){
                        emptyView.visibility = View.VISIBLE
                    } else{
                        emptyView.visibility = View.GONE
                    }
                } else {
                    Log.d("Teacher_My_Task", "data is null")
                }

                swLayout.isRefreshing = false
            }

            override fun onFailure() {
                Log.d("Teacher_My_Task", "failure")
                swLayout.isRefreshing = false
            }

        })
    }

}