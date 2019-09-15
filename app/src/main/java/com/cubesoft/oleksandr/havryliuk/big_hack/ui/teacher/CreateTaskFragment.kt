package com.cubesoft.oleksandr.havryliuk.big_hack.ui.teacher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.cubesoft.oleksandr.havryliuk.big_hack.R
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Task
import com.cubesoft.oleksandr.havryliuk.big_hack.remote.SendDataStore
import com.cubesoft.oleksandr.havryliuk.big_hack.ui.teacher.TeacherMyTaskFragment.Companion.TEACHER_ID
import kotlinx.android.synthetic.main.fragment_create_task.view.*
import org.jetbrains.anko.doAsync

class CreateTaskFragment : Fragment() {

    private lateinit var name: EditText
    private lateinit var body: EditText
    private lateinit var classId: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_create_task, container, false)

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
        val task = Task(
            name.text.trim().toString(),
            body.text.trim().toString(),
            TEACHER_ID,
            classId.text.trim().toString(),
            "",
            ""
        )

        doAsync { SendDataStore().sendTask(task) }
        (activity as TeacherActivity).showTeacherMyTasksFragment()
    }

}