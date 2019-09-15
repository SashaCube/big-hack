package com.cubesoft.oleksandr.havryliuk.big_hack.remote

import android.util.Log
import com.cubesoft.oleksandr.havryliuk.big_hack.data.JsonParse.AnswerParse
import com.cubesoft.oleksandr.havryliuk.big_hack.data.JsonParse.MarkParse
import com.cubesoft.oleksandr.havryliuk.big_hack.data.JsonParse.TaskParse
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

    private  var taskMapper =  TaskParse()
    private  var markMapper = MarkParse()
    private  var answerMapper = AnswerParse()
    private val api = Api.create()

    fun getTasksByTeacherId(teacherId: String, callback: Utils.LoadData<List<Task>>) {
        Api.create().getEventsByTag(SendDataStore.TASK + teacherId)
            .enqueue(object : Callback<EventsContainer> {
                override fun onResponse(call: Call<EventsContainer>, response: Response<EventsContainer>) {

                    if (response.isSuccessful) {
                        Log.d("api", response.body().toString())
                        callback.onData(response.body().events.map { taskMapper.fromJson(it.value) })
                    }
                }

                override fun onFailure(call: Call<EventsContainer>, t: Throwable) {
                    Log.d("api", "error")
                    callback.onFailure()
                }
            })
    }

    fun getTasksByClassId(classId: String, callback: Utils.LoadData<List<Task>>) {
        Api.create().getEventsByTag(SendDataStore.CLASS + classId)
            .enqueue(object : Callback<EventsContainer> {
                override fun onResponse(call: Call<EventsContainer>, response: Response<EventsContainer>) {

                    if (response.isSuccessful) {
                        Log.d("api", response.body().toString())
                        callback.onData(response.body().events.map { taskMapper.fromJson(it.value) })
                    }
                }

                override fun onFailure(call: Call<EventsContainer>, t: Throwable) {
                    Log.d("api", "error")
                    callback.onFailure()
                }
            })
    }

    fun getAnswersByTaskId(taskId: String, callback: Utils.LoadData<List<Answer>>) {
        //TODO get id teacher that will check it
        Api.create().getEventsByTag(SendDataStore.ANSWER + taskId)
            .enqueue(object : Callback<EventsContainer> {
                override fun onResponse(call: Call<EventsContainer>, response: Response<EventsContainer>) {

                    if (response.isSuccessful) {
                        Log.d("api", response.body().toString())
                        callback.onData(response.body().events.map { answerMapper.fromJson(it.value) })
                    }
                }

                override fun onFailure(call: Call<EventsContainer>, t: Throwable) {
                    Log.d("api", "error")
                    callback.onFailure()
                }
            })
    }

    fun getMarkByUserId(studentId: String, callback: Utils.LoadData<List<Mark>>) {
        Api.create().getEventsByTag(SendDataStore.STUDENT + studentId)
            .enqueue(object : Callback<EventsContainer> {
                override fun onResponse(call: Call<EventsContainer>, response: Response<EventsContainer>) {

                    if (response.isSuccessful) {
                        Log.d("api", response.body().toString())
                        callback.onData(response.body().events.map { markMapper.fromJson(it.value) })
                    }
                }

                override fun onFailure(call: Call<EventsContainer>, t: Throwable) {
                    Log.d("api", "error")
                    callback.onFailure()
                }
            })
    }
}
