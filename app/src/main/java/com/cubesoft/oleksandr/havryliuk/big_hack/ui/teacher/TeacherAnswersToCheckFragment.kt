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
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Answer
import com.cubesoft.oleksandr.havryliuk.big_hack.remote.GetDataStore
import com.cubesoft.oleksandr.havryliuk.big_hack.ui.adapter.AnswerAdapter
import com.cubesoft.oleksandr.havryliuk.big_hack.ui.student.StudentTasksFragment.Companion.SCHOOL_ID
import com.cubesoft.oleksandr.havryliuk.big_hack.utils.Utils
import kotlinx.android.synthetic.main.fragment_teacher_answers_to_check.view.*
import kotlinx.android.synthetic.main.fragment_teacher_answers_to_check.view.empty_view
import kotlinx.android.synthetic.main.fragment_teacher_answers_to_check.view.recycler_view
import kotlinx.android.synthetic.main.fragment_teacher_answers_to_check.view.swipe_refresh
import kotlinx.android.synthetic.main.fragment_teacher_my_task.view.*

class TeacherAnswersToCheckFragment : Fragment() {

    lateinit var viewAdapter: AnswerAdapter
    lateinit var emptyView: View
    private lateinit var swLayout: SwipeRefreshLayout

    private val currentTask by lazy {
        (activity as TeacherActivity).currentTask
    }

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
        viewAdapter = AnswerAdapter {
            (activity as TeacherActivity).showTeacherCreateMarkFragment(it)
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
        GetDataStore().getAnswersByTaskId(currentTask.classId, object : Utils.LoadData<List<Answer>> {
            override fun onData(data: List<Answer>?) {
                if (data != null) {
                    viewAdapter.update(data)
                    if(data.isEmpty()){
                        emptyView.visibility = View.VISIBLE
                    } else{
                        emptyView.visibility = View.GONE
                    }                } else {
                    Log.d("Teacher_Answers", "data is null")
                }

                swLayout.isRefreshing = false
            }

            override fun onFailure() {
                Log.d("Teacher_Answers", "failure")
                swLayout.isRefreshing = false
            }

        })
    }

}