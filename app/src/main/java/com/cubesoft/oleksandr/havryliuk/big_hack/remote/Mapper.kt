package com.cubesoft.oleksandr.havryliuk.big_hack.remote

interface Mapper<T>{

    fun toJson(type: T): String

    fun toJson(string: String): T
}