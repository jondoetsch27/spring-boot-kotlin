package com.jdd.springboot.kotlin.controller

import com.jdd.springboot.kotlin.exception.DuplicatePlayerException
import com.jdd.springboot.kotlin.exception.PlayerNotFoundException
import com.jdd.springboot.kotlin.model.Player
import com.jdd.springboot.kotlin.service.impl.PlayerServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class PlayerController {

    @Autowired
    lateinit var playerService: PlayerServiceImpl

    @GetMapping("players/list")
    fun listPlayers(): ResponseEntity<List<Player>> {
        val playerResponseEntity = try {
            ResponseEntity(playerService.listPlayers(), HttpStatus.ACCEPTED)
        } catch (exception: PlayerNotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        } catch (exception: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
        return playerResponseEntity
    }

    @GetMapping("players/read")
    fun readPlayer(@PathVariable playerName: String): ResponseEntity<Player> {
        val playerResponseEntity = try {
            ResponseEntity(playerService.readPlayer(playerName), HttpStatus.ACCEPTED)
        } catch (exception: PlayerNotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        } catch (exception: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
        return playerResponseEntity
    }

    @PostMapping("players/create")
    fun createPlayer(@PathVariable player: Player): ResponseEntity<Player> {
        val playerResponseEntity = try {
            ResponseEntity(playerService.createPlayer(player), HttpStatus.CREATED)
        } catch (exception: DuplicatePlayerException) {
            ResponseEntity(HttpStatus.CONFLICT)
        } catch (exception: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
        return playerResponseEntity
    }

    @PutMapping("players/update")
    fun updatePlayer(@PathVariable player: Player): ResponseEntity<Player> {
        val playerResponseEntity = try {
            ResponseEntity(playerService.updatePlayer(player), HttpStatus.ACCEPTED)
        } catch (exception: PlayerNotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        } catch (exception: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
        return playerResponseEntity
    }

    @DeleteMapping("players/delete")
    fun deletePlayer(@PathVariable player: Player): ResponseEntity<Player> {
        val playerResponseEntity = try {
            ResponseEntity(playerService.deletePlayer(player), HttpStatus.GONE)
        } catch (exception: PlayerNotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        } catch (exception: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
        return playerResponseEntity
    }
}