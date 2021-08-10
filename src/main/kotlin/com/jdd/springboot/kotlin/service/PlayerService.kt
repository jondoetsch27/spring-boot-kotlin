package com.jdd.springboot.kotlin.service

import com.jdd.springboot.kotlin.model.Player

interface PlayerService {
    fun listPlayers(): List<Player>
    fun readPlayer(playerName: String): Player
    fun createPlayer(newPlayer: Player): Player
    fun updatePlayer(newPlayer: Player): Player
    fun deletePlayer(oldPlayer: Player): Player
}