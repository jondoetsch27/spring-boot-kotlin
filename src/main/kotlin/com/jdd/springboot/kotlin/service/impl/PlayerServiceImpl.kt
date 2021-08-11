package com.jdd.springboot.kotlin.service.impl

import com.jdd.springboot.kotlin.exception.DuplicatePlayerException
import com.jdd.springboot.kotlin.exception.PlayerNotFoundException
import com.jdd.springboot.kotlin.model.Player
import com.jdd.springboot.kotlin.repository.PlayerRepository
import com.jdd.springboot.kotlin.service.PlayerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PlayerServiceImpl : PlayerService {

    @Autowired
    lateinit var playerRepository: PlayerRepository

    @Transactional
    override fun listPlayers(): List<Player> {
        return playerRepository.findAll().toList().ifEmpty {
            throw PlayerNotFoundException()
        }
    }

    @Transactional
    override fun readPlayer(playerName: String): Player {
        return if (playerRepository.findById(playerName).isPresent) {
            playerRepository.findById(playerName).get()
        } else {
            throw PlayerNotFoundException()
        }
    }

    @Transactional
    override fun createPlayer(newPlayer: Player): Player {
        return if (playerRepository.existsById(newPlayer.playerId)) {
            throw DuplicatePlayerException()
        } else {
            playerRepository.save(newPlayer)
        }
    }

    @Transactional
    override fun updatePlayer(newPlayer: Player): Player {
        if (playerRepository.existsById(newPlayer.playerId)) {
            playerRepository.deleteById(newPlayer.playerId)
        } else {
            throw PlayerNotFoundException()
        }
        return playerRepository.save(newPlayer)
    }

    @Transactional
    override fun deletePlayer(oldPlayer: Player): Player {
        if (playerRepository.existsById(oldPlayer.playerId)) {
            playerRepository.deleteById(oldPlayer.playerId)
        } else {
            throw PlayerNotFoundException()
        }
        return oldPlayer
    }
}