package com.cubesoft.oleksandr.havryliuk.big_hack.data.model

import com.google.gson.annotations.SerializedName

data class Mark(
    @SerializedName("id") var id: String,
    @SerializedName("taskId") var taskId: String,
    @SerializedName("classId") var classId: String,
    @SerializedName("studentId") var subjectId: String,
    @SerializedName("teacherId") var teacherId: String,
    @SerializedName("body") var body: String
)