package com.jdd.springboot.kotlin.repository

import com.jdd.springboot.kotlin.model.Player
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayerRepository : CrudRepository<Player, String> {
}