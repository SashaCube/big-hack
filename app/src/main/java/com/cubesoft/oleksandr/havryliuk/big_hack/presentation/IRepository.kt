package com.cubesoft.oleksandr.havryliuk.big_hack.presentation

interface IRepository {

    fun getTasks() //: List<Task>

    fun getTasksByTeacherId(teacherId: Long)
}