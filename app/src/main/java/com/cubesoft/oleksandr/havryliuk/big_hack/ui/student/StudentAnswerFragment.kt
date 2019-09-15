package com.cubesoft.oleksandr.havryliuk.big_hack.ui.student

import android.os.Build.USER
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.cubesoft.oleksandr.havryliuk.big_hack.R
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Answer
import com.cubesoft.oleksandr.havryliuk.big_hack.remote.SendDataStore
import kotlinx.android.synthetic.main.fragment_create_task.view.*
import org.jetbrains.anko.doAsync


class StudentAnswerFragment : Fragment() {

    private lateinit var name: EditText
    private lateinit var body: EditText
    private lateinit var classId: EditText

    private val currentTask by lazy {
        (activity as StudentActivity).currenTask
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_student_answer, container, false)

        initView(root)

        return root
    }

    private fun initView(root: View) {
        name = root.ed_name
        body = root.ed_body
        classId = root.ed_class_id_name

        root.tv_send_task.setOnClickListener {
            sendTask()
        }
    }

    private fun sendTask() {
        val answer = Answer(
            name.text.trim().toString(),
            body.text.trim().toString(),
            classId.text.trim().toString(),
            USER,
            body.text.trim().toString()
        )

        doAsync { SendDataStore().sendAnswer(answer) }
        (activity as StudentActivity).showStudentTasksFragment()
    }

}