package com.example.spacexmavericks.domain

import java.util.Date

data class Launch(
    val id: String?,
    val date: Date?,
    val missionName: String?,
    val rocketName: String?
)
