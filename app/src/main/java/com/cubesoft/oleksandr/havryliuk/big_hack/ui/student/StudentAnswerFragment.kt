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
import kotlinx.android.synthetic.main.fragment_create_task.view.tv_send_task
import kotlinx.android.synthetic.main.fragment_student_answer.view.*
import org.jetbrains.anko.doAsync


class StudentAnswerFragment : Fragment() {

    private lateinit var body: EditText

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
        root.tv_task_name.text = currentTask.name
        root.tv_task_body.text = currentTask.body

        body = root.ed_answer
        root.tv_send_task.setOnClickListener {
            sendTask()
        }
    }

    private fun sendTask() {
        val answer = Answer(
            "ANSWER_ID",
            currentTask.name,
            currentTask.classId,
            USER,
            body.text.trim().toString()
        )

        doAsync { SendDataStore().sendAnswer(answer) }
        (activity as StudentActivity).showStudentTasksFragment()
    }

}