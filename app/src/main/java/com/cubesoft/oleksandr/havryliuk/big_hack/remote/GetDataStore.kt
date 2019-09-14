package com.cubesoft.oleksandr.havryliuk.big_hack.remote

import android.util.Log
import com.cubesoft.oleksandr.havryliuk.big_hack.data.api.Api
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Answer
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.EventsContainer
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Mark
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Task
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetDataStore : IGetDataStore{

    val api = Api.create()

    override fun getTasks(): List<Task> {
        val call = Api.create().getEventsByTag("Thisiscustomtag2")
        call.enqueue(object : Callback<EventsContainer> {
            override fun onResponse(call: Call<EventsContainer>, response: Response<EventsContainer>) {
                Log.d("api", response.body().toString())
            }

            override fun onFailure(call: Call<EventsContainer>, t: Throwable) {
                Log.d("api", "error")
            }
        })

        return listOf()
    }

    override fun getTasksByTeacherId(teacherId: String): List<Task> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getTasksByClassId(classId: String): List<Task> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAnswersByTaskId(taskId: Int): List<Answer> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMark(answerId: Int): Mark {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
