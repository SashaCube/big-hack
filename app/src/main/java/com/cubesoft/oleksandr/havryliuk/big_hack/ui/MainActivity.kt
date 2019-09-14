package com.cubesoft.oleksandr.havryliuk.big_hack.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cubesoft.oleksandr.havryliuk.big_hack.R
import com.cubesoft.oleksandr.havryliuk.big_hack.remote.Test
import org.jetbrains.anko.doAsync


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doAsync { Test().main(); }

    }
}
