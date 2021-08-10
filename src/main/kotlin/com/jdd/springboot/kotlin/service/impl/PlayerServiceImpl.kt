package com.jdd.springboot.kotlin.service.impl

import com.jdd.springboot.kotlin.model.Player
import com.jdd.springboot.kotlin.repository.PlayerRepository
import com.jdd.springboot.kotlin.service.PlayerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PlayerServiceImpl : PlayerService {

    @Autowired
    lateinit var playerRepository: PlayerRepository

    override fun listPlayers(): List<Player> {
        return playerRepository.findAll().toList()
    }

    override fun readPlayer(playerName: String): Player {
        return playerRepository.findById(playerName).get()
    }

    override fun createPlayer(newPlayer: Player): Player {
        return playerRepository.save(newPlayer)
    }

    override fun updatePlayer(newPlayer: Player): Player {
        playerRepository.deleteById(newPlayer.playerId)
        return playerRepository.save(newPlayer)
    }

    override fun deletePlayer(oldPlayer: Player): Player {
        playerRepository.deleteById(oldPlayer.playerId)
        return oldPlayer
    }
}