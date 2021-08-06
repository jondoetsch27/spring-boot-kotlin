package com.jdd.springboot.kotlin.controller

import com.jdd.springboot.kotlin.model.Player
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class PlayerController {

    @GetMapping("players/list")
    public fun listPlayers(): ResponseEntity<List<Player>>? {
        return null
    }

    @GetMapping("players/read")
    public fun readPlayer(): ResponseEntity<Player>? {
        return null
    }

    @PostMapping("players/create")
    public fun createPlayer(): ResponseEntity<Player>? {
        return null
    }

    @PutMapping("players/update")
    public fun updatePlayer(): ResponseEntity<Player>? {
        return null
    }

    @DeleteMapping("players/delete")
    public fun deletePlayer(): ResponseEntity<Player>? {
        return null
    }
}