package com.cubesoft.oleksandr.havryliuk.big_hack.data.model

import com.google.gson.annotations.SerializedName

data class Answer(
    @SerializedName("id") var id: String,
    @SerializedName("taskId") var taskId: String,
    @SerializedName("classId") var classId: String,
    @SerializedName("studentId") var studentId: String,
    @SerializedName("body") var body: String
)