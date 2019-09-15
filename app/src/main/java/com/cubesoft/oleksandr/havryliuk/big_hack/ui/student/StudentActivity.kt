package com.cubesoft.oleksandr.havryliuk.big_hack.ui.student

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cubesoft.oleksandr.havryliuk.big_hack.R
import com.cubesoft.oleksandr.havryliuk.big_hack.ui.teacher.CreateTaskFragment
import com.cubesoft.oleksandr.havryliuk.big_hack.ui.teacher.TeacherCheckFragment
import com.cubesoft.oleksandr.havryliuk.big_hack.ui.teacher.TeacherMyTaskFragment
import com.cubesoft.oleksandr.havryliuk.big_hack.utils.addFragment
import kotlinx.android.synthetic.main.activity_student.*

class StudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)


        initView()
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
        addFragment(supportFragmentManager, R.id.fragment_container, StudentMarksFragment())
    }

    fun showStudentTasksFragment() {
        addFragment(supportFragmentManager, R.id.fragment_container, StudentTasksFragment())
    }

//    fun showCreateTaskFragment() {
//        addFragment(supportFragmentManager, R.id.fragment_container, CreateTaskFragment())
//    }
}