package com.cubesoft.oleksandr.havryliuk.big_hack.data.model

import com.google.gson.annotations.SerializedName

data class EventsContainer(
    @SerializedName("events") val events: List<Event>,
    @SerializedName("eventsCount") val eventsCount: Int
)