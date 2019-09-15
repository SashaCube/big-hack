package com.cubesoft.oleksandr.havryliuk.big_hack.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cubesoft.oleksandr.havryliuk.big_hack.R
import com.cubesoft.oleksandr.havryliuk.big_hack.ui.student.StudentActivity
import com.cubesoft.oleksandr.havryliuk.big_hack.ui.teacher.TeacherActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initView()
    }

    private fun initView() {
        tv_login.setOnClickListener {
            if (ed_login.text.trim().toString() == "student") {
                showStudentActivity()
            } else {
                showTeacherActivity()
            }
        }
    }

    private fun showStudentActivity() {
        startActivity(Intent(this, StudentActivity::class.java))

    }

    private fun showTeacherActivity() {
        startActivity(Intent(this, TeacherActivity::class.java))
    }
}