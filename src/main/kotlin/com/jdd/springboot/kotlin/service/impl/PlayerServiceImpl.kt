package com.jdd.springboot.kotlin.service.impl

import com.jdd.springboot.kotlin.model.Player
import com.jdd.springboot.kotlin.service.PlayerService
import org.springframework.http.ResponseEntity

class PlayerServiceImpl: PlayerService {

    override fun listPlayers(): ResponseEntity<List<Player>> {
        TODO("Not yet implemented")
    }

    override fun readPlayer(): ResponseEntity<Player> {
        TODO("Not yet implemented")
    }

    override fun createPlayer(): ResponseEntity<Player> {
        TODO("Not yet implemented")
    }

    override fun updatePlayer(): ResponseEntity<Player> {
        TODO("Not yet implemented")
    }

    override fun deletePlayer(): ResponseEntity<Player> {
        TODO("Not yet implemented")
    }
}