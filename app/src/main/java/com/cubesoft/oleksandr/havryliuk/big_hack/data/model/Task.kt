package com.cubesoft.oleksandr.havryliuk.big_hack.data.model

import com.google.gson.annotations.SerializedName

data class Task(
    @SerializedName("id") var id: String,
    @SerializedName("name") var name: String,
    @SerializedName("teacherId") var teacherId: String,
    @SerializedName("classId") var classId: String,
    @SerializedName("subjectId") var subjectId: String,
    @SerializedName("body") var body: String
)