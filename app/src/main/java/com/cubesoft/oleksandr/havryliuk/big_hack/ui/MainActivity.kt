package com.cubesoft.oleksandr.havryliuk.big_hack.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.cubesoft.oleksandr.havryliuk.big_hack.R
import com.cubesoft.oleksandr.havryliuk.big_hack.data.JsonParse.AnswerParse
import com.cubesoft.oleksandr.havryliuk.big_hack.data.api.Api
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Answer
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.EventsContainer
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Task
import com.cubesoft.oleksandr.havryliuk.big_hack.remote.GetDataStore
import com.cubesoft.oleksandr.havryliuk.big_hack.remote.SendDataStore
import com.cubesoft.oleksandr.havryliuk.big_hack.remote.Test
import com.cubesoft.oleksandr.havryliuk.big_hack.utils.Utils
import org.jetbrains.anko.doAsync
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        doAsync {
          GetDataStore().getTasksByTeacherId("sveQDMN3Fdzi0Yvm3bhkyu0uT/08wQfymhXqD0GT4vU=",object: Utils.LoadData<List<Task>>{
              override fun onData(data: List<Task>?) {
                  Log.d("Stringa - ",data.toString())
                  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
              }

              override fun onFailure() {
                  Log.d("Stringa2 - ","as")
                  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
              }
          })
//          SendDataStore().main()
        }


        val call = Api.create().getEventsByTag("Thisiscustomtag2")
        call.enqueue(object : Callback<EventsContainer> {
            override fun onResponse(call: Call<EventsContainer>, response: Response<EventsContainer>) {
               Log.d("api", response.body().toString())
            }

            override fun onFailure(call: Call<EventsContainer>, t: Throwable) {
                Log.d("api", "error")
            }
        })

    }
}
