package com.cubesoft.oleksandr.havryliuk.big_hack.data.model

import com.google.gson.annotations.SerializedName


data class Teacher(
    @SerializedName("id") var id: String,
    @SerializedName("name") var name: String,
    @SerializedName("surName") var surName: String,
    @SerializedName("schoolId") var schoolId: String,
    @SerializedName("subjectId") var subjectId: String
)

