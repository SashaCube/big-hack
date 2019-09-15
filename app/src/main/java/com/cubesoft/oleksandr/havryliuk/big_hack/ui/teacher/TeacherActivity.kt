package com.cubesoft.oleksandr.havryliuk.big_hack.ui.teacher

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cubesoft.oleksandr.havryliuk.big_hack.R
import com.cubesoft.oleksandr.havryliuk.big_hack.utils.addFragment
import kotlinx.android.synthetic.main.activity_teacher.*

class TeacherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher)


        initView()
    }

    private fun initView(){

        tv_check_button.setOnClickListener{
            showCheckTeacherFragment()
        }

        tv_my_task_button.setOnClickListener{
            showTeacherMyTasksFragment()
        }
    }

    private fun showCheckTeacherFragment(){
        addFragment(supportFragmentManager, R.id.fragment_container, TeacherCheckFragment())
    }

    private fun showTeacherMyTasksFragment(){
        addFragment(supportFragmentManager, R.id.fragment_container, TeacherMyTaskFragment())
    }
}