package com.cubesoft.oleksandr.havryliuk.big_hack.presentation

import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Answer
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Mark
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Task
import com.cubesoft.oleksandr.havryliuk.big_hack.remote.IGetDataStore
import com.cubesoft.oleksandr.havryliuk.big_hack.remote.ISendDataStore

interface IRepository {

    suspend fun getTasks() : List<Task>

    suspend fun getTasksByTeacherId(teacherId: String) : List<Task>

    suspend fun getTasksByClassId(classId: String) : List<Task>

    suspend fun sendTask(task: Task)

    //TODO: suspend fun getClasses() : List<StudentClass> we will get it from constants to simplify

    suspend fun getAnswersByTaskId(taskId: Int):  List<Answer>

    suspend fun getMark(answerId: Int): Mark

    suspend fun sendMark(mark: Mark)
}