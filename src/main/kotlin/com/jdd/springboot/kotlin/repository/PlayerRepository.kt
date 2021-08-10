package com.jdd.springboot.kotlin.repository

import com.jdd.springboot.kotlin.model.Player
import org.springframework.data.repository.CrudRepository

interface PlayerRepository : CrudRepository<Player, String> {
}