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
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Mark
import com.cubesoft.oleksandr.havryliuk.big_hack.remote.GetDataStore
import com.cubesoft.oleksandr.havryliuk.big_hack.ui.adapter.MarkAdapter
import com.cubesoft.oleksandr.havryliuk.big_hack.utils.Utils
import com.cubesoft.oleksandr.havryliuk.big_hack.utils.toast
import kotlinx.android.synthetic.main.fragment_teacher_my_task.view.*

class StudentMarksFragment : Fragment() {

    lateinit var viewAdapter: MarkAdapter
    private lateinit var swLayout: SwipeRefreshLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_student_mark, container, false)

        initAdapter()
        initView(root)

        return root
    }

    private fun initAdapter() {
        viewAdapter = MarkAdapter {
            context?.toast("Task onClick")
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

    private fun loadData() {
        swLayout.isRefreshing = true
        GetDataStore().getMarkByUserId(USER_ID, object : Utils.LoadData<List<Mark>> {
            override fun onData(data: List<Mark>?) {
                if (data != null) {
                    viewAdapter.update(data)
                } else {
                    Log.d("Mark_Student", "data is null")
                }

                swLayout.isRefreshing = false
            }

            override fun onFailure() {
                Log.d("Mark_Student", "failure")
                swLayout.isRefreshing = false
            }

        })
    }

    companion object {
        const val USER_ID = "USER"
    }

}