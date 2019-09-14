package com.cubesoft.oleksandr.havryliuk.big_hack.remote

import android.util.Log
import com.cubesoft.oleksandr.havryliuk.big_hack.data.api.Api
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Answer
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.EventsContainer
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Mark
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Task
import com.cubesoft.oleksandr.havryliuk.big_hack.utils.Utils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetDataStore {

    private lateinit var taskMapper: Mapper<Task>
    private lateinit var markMapper: Mapper<Mark>
    private lateinit var answerMapper: Mapper<Answer>
    private val api = Api.create()

    fun getTasksByTeacherId(teacherId: String, callback: Utils.LoadData<List<Task>>) {
        Api.create().getEventsByTag("Thisiscustomtag2")
            .enqueue(object : Callback<EventsContainer> {
                override fun onResponse(call: Call<EventsContainer>, response: Response<EventsContainer>) {

                    if (response.isSuccessful) {
                        Log.d("api", response.body().toString())
                        callback.onData(response.body().events.map { taskMapper.toJson(it.value) })
                    }
                }

                override fun onFailure(call: Call<EventsContainer>, t: Throwable) {
                    Log.d("api", "error")
                    callback.onFailure()
                }
            })
    }

    fun getTasksByClassId(classId: String, callback: Utils.LoadData<List<Task>>) {
        Api.create().getEventsByTag("Thisiscustomtag2")
            .enqueue(object : Callback<EventsContainer> {
                override fun onResponse(call: Call<EventsContainer>, response: Response<EventsContainer>) {

                    if (response.isSuccessful) {
                        Log.d("api", response.body().toString())
                        callback.onData(response.body().events.map { taskMapper.toJson(it.value) })
                    }
                }

                override fun onFailure(call: Call<EventsContainer>, t: Throwable) {
                    Log.d("api", "error")
                    callback.onFailure()
                }
            })
    }

    fun getAnswersByTaskId(taskId: Int, callback: Utils.LoadData<List<Answer>>) {
        //TODO get id teacher that will check it
        Api.create().getEventsByTag("Thisiscustomtag2")
            .enqueue(object : Callback<EventsContainer> {
                override fun onResponse(call: Call<EventsContainer>, response: Response<EventsContainer>) {

                    if (response.isSuccessful) {
                        Log.d("api", response.body().toString())
                        callback.onData(response.body().events.map { answerMapper.toJson(it.value) })
                    }
                }

                override fun onFailure(call: Call<EventsContainer>, t: Throwable) {
                    Log.d("api", "error")
                    callback.onFailure()
                }
            })
    }

    fun getMarkByUserId(uesrId: Int, callback: Utils.LoadData<List<Mark>>) {
        Api.create().getEventsByTag("Thisiscustomtag2")
            .enqueue(object : Callback<EventsContainer> {
                override fun onResponse(call: Call<EventsContainer>, response: Response<EventsContainer>) {

                    if (response.isSuccessful) {
                        Log.d("api", response.body().toString())
                        callback.onData(response.body().events.map { markMapper.toJson(it.value) })
                    }
                }

                override fun onFailure(call: Call<EventsContainer>, t: Throwable) {
                    Log.d("api", "error")
                    callback.onFailure()
                }
            })
    }
}
