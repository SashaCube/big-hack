package com.cubesoft.oleksandr.havryliuk.big_hack.ui.teacher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.cubesoft.oleksandr.havryliuk.big_hack.R
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Mark
import com.cubesoft.oleksandr.havryliuk.big_hack.remote.SendDataStore
import com.cubesoft.oleksandr.havryliuk.big_hack.ui.teacher.TeacherMyTaskFragment.Companion.TEACHER_ID
import kotlinx.android.synthetic.main.fragment_teacher_answer.view.*
import org.jetbrains.anko.doAsync

class TeacherCreateMarkFragment : Fragment() {

    private lateinit var markEditText: EditText

    private val currentAnswer by lazy {
        (activity as TeacherActivity).currentAnswer
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
        markEditText = root.ed_mark

        root.tv_task_name.text = currentAnswer.taskId
        root.tv_task_body.text = currentAnswer.taskId
        root.tv_answer.text = currentAnswer.body

        root.tv_send_task.setOnClickListener {
            sendMark()
        }
    }

    private fun sendMark() {
        //TODO: set Mark id
        val mark = Mark(
            markEditText.text.trim().toString(),
            currentAnswer.taskId,
            currentAnswer.classId,
            currentAnswer.studentId,
            TEACHER_ID,
            markEditText.text.trim().toString()
        )

        doAsync { SendDataStore().sendMark(mark) }
        with(activity as TeacherActivity) { showTeacherAnswersToCheckFragment(currentTask) }
    }
}