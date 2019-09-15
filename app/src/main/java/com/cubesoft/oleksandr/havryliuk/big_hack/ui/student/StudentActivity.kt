package com.cubesoft.oleksandr.havryliuk.big_hack.ui.student

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cubesoft.oleksandr.havryliuk.big_hack.R
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Task
import com.cubesoft.oleksandr.havryliuk.big_hack.utils.addFragment
import kotlinx.android.synthetic.main.activity_student.*

class StudentActivity : AppCompatActivity() {

    lateinit var currenTask: Task

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)


        initView()
        showStudentTasksFragment()
    }

    private fun initView() {

        tv_mark_button.setOnClickListener {
            showStudentMarksFragment()
        }

        tv_my_task_button.setOnClickListener {
            showStudentTasksFragment()
        }
    }

    fun showStudentMarksFragment() {
        header.text = "Оцінки"
        addFragment(supportFragmentManager, R.id.fragment_container, StudentMarksFragment())
    }

    fun showStudentTasksFragment() {
        header.text = "Завдання"
        addFragment(supportFragmentManager, R.id.fragment_container, StudentTasksFragment())
    }

    fun showCreateAnswerFragment(task: Task) {
        header.text = "Відповідь На Завдання"
        currenTask = task
        addFragment(supportFragmentManager, R.id.fragment_container, StudentAnswerFragment())
    }
}