package com.cubesoft.oleksandr.havryliuk.big_hack.data

import androidx.lifecycle.MutableLiveData
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Answer
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Mark
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Task
import com.cubesoft.oleksandr.havryliuk.big_hack.presentation.IRepository
import com.cubesoft.oleksandr.havryliuk.big_hack.remote.IGetDataStore
import com.cubesoft.oleksandr.havryliuk.big_hack.remote.ISendDataStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository constructor(
    val storeGet: IGetDataStore,
    val storeSend: ISendDataStore
) : IRepository {

    val message = MutableLiveData<String>()

    override suspend fun getTasks() = withContext(Dispatchers.IO) {
        val tasks = mutableListOf<Task>()
        try {
            val newTasks = storeGet.getTasks()
            tasks.addAll(newTasks)
        } catch (e: Exception) {
            message.postValue("getTask error")
        }

        tasks
    }

    override suspend fun getTasksByTeacherId(teacherId: String) = withContext(Dispatchers.IO) {
        val tasks = mutableListOf<Task>()
        try {
            val newTasks = storeGet.getTasksByTeacherId(teacherId)
            tasks.addAll(newTasks)
        } catch (e: Exception) {
            message.postValue("getTaskByTeacherId error")
        }

        tasks
    }

    override suspend fun getTasksByClassId(classId: String) = withContext(Dispatchers.IO) {
        val tasks = mutableListOf<Task>()
        try {
            val newTasks = storeGet.getTasksByClassId(classId)
            tasks.addAll(newTasks)
        } catch (e: Exception) {
            message.postValue("getTaskByClassId error")
        }

        tasks
    }

    override suspend fun sendTask(task: Task) = withContext(Dispatchers.IO) {
        try {
            storeSend.sendTask(task)
        } catch (e: Exception) {
            message.postValue("getTaskByClassId error")
        }
    }

    override suspend fun getAnswersByTaskId(taskId: Int): List<Answer> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getMark(answerId: Int): Mark {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun sendMark(mark: Mark) = withContext(Dispatchers.IO) {
        try {
            storeSend.sendMark(mark)
        } catch (e: Exception) {
            message.postValue("getTaskByClassId error")
        }
    }

}