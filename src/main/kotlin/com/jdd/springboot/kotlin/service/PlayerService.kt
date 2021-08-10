package com.jdd.springboot.kotlin.service

import com.jdd.springboot.kotlin.model.Player
import org.springframework.http.ResponseEntity

interface PlayerService {

    public fun listPlayers(): ResponseEntity<List<Player>>
    public fun readPlayer(): ResponseEntity<Player>
    public fun createPlayer(): ResponseEntity<Player>
    public fun updatePlayer(): ResponseEntity<Player>
    public fun deletePlayer(): ResponseEntity<Player>

}