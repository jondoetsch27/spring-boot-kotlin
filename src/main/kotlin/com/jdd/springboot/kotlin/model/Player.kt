package com.jdd.springboot.kotlin.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Player constructor(

    @JsonProperty("playerId")
    val playerId: String,

    @JsonProperty("playerFirstName")
    val playerFirstName: String,

    @JsonProperty("playerLastName")
    val playerLastName: String,

    @JsonProperty("playerNumber")
    val playerNumber: String,

    @JsonProperty("playerPosition")
    val playerPosition: String,

    @JsonProperty("playerTeam")
    val playerTeam: String
)