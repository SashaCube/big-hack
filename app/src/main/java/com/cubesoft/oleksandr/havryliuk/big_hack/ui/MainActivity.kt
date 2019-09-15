package com.cubesoft.oleksandr.havryliuk.big_hack.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.cubesoft.oleksandr.havryliuk.big_hack.R
import com.cubesoft.oleksandr.havryliuk.big_hack.ui.teacher.TeacherActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        doAsync {  Test().main()}
//
//
//        val call = Api.create().getEventsByTag("Thisiscustomtag2")
//        call.enqueue(object : Callback<EventsContainer> {
//            override fun onResponse(call: Call<EventsContainer>, response: Response<EventsContainer>) {
//               Log.d("api", response.body().toString())
//            }
//
//            override fun onFailure(call: Call<EventsContainer>, t: Throwable) {
//                Log.d("api", "error")
//            }
//        })

        startActivity(Intent(this, LoginActivity::class.java))

    }
}
