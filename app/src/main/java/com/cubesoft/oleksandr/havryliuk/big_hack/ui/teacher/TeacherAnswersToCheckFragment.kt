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
import com.cubesoft.oleksandr.havryliuk.big_hack.utils.Utils
import kotlinx.android.synthetic.main.fragment_teacher_answers_to_check.view.*

class TeacherAnswersToCheckFragment : Fragment() {

    lateinit var viewAdapter: AnswerAdapter
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

        loadData()

    }

    fun loadData() {
        GetDataStore().getAnswersByTaskId(currentTask.id, object : Utils.LoadData<List<Answer>> {
            override fun onData(data: List<Answer>?) {
                if (data != null) {
                    viewAdapter.update(data)

                } else {
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