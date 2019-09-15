package com.cubesoft.oleksandr.havryliuk.big_hack.ui.teacher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cubesoft.oleksandr.havryliuk.big_hack.R

class TeacherCheckFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_teacher_check, container, false)

        initAdapter()
        initView()

        return root
    }

    private fun initAdapter(){

    }


    private fun initView() {
    }

}