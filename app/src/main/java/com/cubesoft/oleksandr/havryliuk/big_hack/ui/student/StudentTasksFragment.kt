package com.cubesoft.oleksandr.havryliuk.big_hack.ui.student

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.cubesoft.oleksandr.havryliuk.big_hack.R
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Answer
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Task
import com.cubesoft.oleksandr.havryliuk.big_hack.remote.GetDataStore
import com.cubesoft.oleksandr.havryliuk.big_hack.ui.adapter.TaskAdapter
import com.cubesoft.oleksandr.havryliuk.big_hack.utils.Utils
import kotlinx.android.synthetic.main.fragment_teacher_my_task.view.*

class StudentTasksFragment : Fragment() {

    lateinit var viewAdapter: TaskAdapter
    lateinit var emptyView: View
    private lateinit var swLayout: SwipeRefreshLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_student_task, container, false)

        initAdapter()
        initView(root)

        return root
    }

    private fun initAdapter() {
        viewAdapter = TaskAdapter {
            (activity as StudentActivity).showCreateAnswerFragment(it)
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

    private fun loadData() {
        swLayout.isRefreshing = true
        GetDataStore().getTasksByClassId(SCHOOL_ID, object : Utils.LoadData<List<Task>> {
            override fun onData(data: List<Task>?) {
                if (data != null) {
                    viewAdapter.update(data)
                    if(data.isEmpty()){
                        emptyView.visibility = View.VISIBLE
                    } else{
                        emptyView.visibility = View.GONE
                    }                } else {
                    Log.d("Student_Task", "data is null")
                }

                swLayout.isRefreshing = false
            }

            override fun onFailure() {
                Log.d("Student_Task", "failure")
                swLayout.isRefreshing = false
            }

        })
    }

    companion object {
        const val SCHOOL_ID = "10Б"
    }

}