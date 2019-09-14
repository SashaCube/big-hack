package com.cubesoft.oleksandr.havryliuk.big_hack.presentation

import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Answer
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Mark
import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.Task

interface IRepository {

    fun getTasks() : List<Task>

    fun getTasksByTeacherId(teacherId: String) : List<Task>

    fun getTasksByClassId(classId: String) : List<Task>

    fun sendTask(task: Task)

    //TODO: fun getClasses() : List<StudentClass> we will get it from constants to simplify

    fun getAnswersByTaskId(taskId: Int):  List<Answer>

    fun getMark(answerId: Int): Mark

    fun sendMark(mark: Mark)
}