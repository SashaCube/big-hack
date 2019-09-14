package com.cubesoft.oleksandr.havryliuk.big_hack.remote

import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Answer
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Mark
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Task

interface ISendDataStore {

    fun sendTask(task: Task)

    fun sendMark(mark: Mark)

    fun sendAnswer(answer: Answer)
}