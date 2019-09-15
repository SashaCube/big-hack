package com.cubesoft.oleksandr.havryliuk.big_hack.ui.teacher

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cubesoft.oleksandr.havryliuk.big_hack.R
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Answer
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Task
import com.cubesoft.oleksandr.havryliuk.big_hack.utils.addFragment
import kotlinx.android.synthetic.main.activity_student.*
import kotlinx.android.synthetic.main.activity_teacher.*
import kotlinx.android.synthetic.main.activity_teacher.header
import kotlinx.android.synthetic.main.activity_teacher.tv_my_task_button

class TeacherActivity : AppCompatActivity() {

    lateinit var currentAnswer: Answer
    lateinit var currentTask: Task

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher)


        initView()
        showTeacherMyTasksFragment()
    }

    private fun initView(){

        tv_check_button.setOnClickListener{
            showTeacherTasksToCheckFragment()
        }

        tv_my_task_button.setOnClickListener{
            showTeacherMyTasksFragment()
        }
    }

    fun showTeacherTasksToCheckFragment(){
        header.text = "Завдання На Перевірку"
        addFragment(supportFragmentManager, R.id.fragment_container, TeacherTasksToCheckFragment())
    }

    fun showTeacherAnswersToCheckFragment(task: Task){
        header.text = "Відповіді До Завдання"
        currentTask = task
        addFragment(supportFragmentManager, R.id.fragment_container, TeacherAnswersToCheckFragment())
    }

    fun showTeacherMyTasksFragment(){
        header.text = "Ваші Завдання"
        addFragment(supportFragmentManager, R.id.fragment_container, TeacherMyTaskFragment())
    }

    fun showCreateTaskFragment(){
        header.text = "Створити Завдання"
        addFragment(supportFragmentManager, R.id.fragment_container, CreateTaskFragment())
    }

    fun showTeacherCreateMarkFragment(answer: Answer){
        header.text = "Оцінити Відповідь"
        currentAnswer = answer
        addFragment(supportFragmentManager, R.id.fragment_container,TeacherCreateMarkFragment())
    }
}