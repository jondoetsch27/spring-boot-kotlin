package com.jdd.springboot.kotlin.repository

import com.jdd.springboot.kotlin.model.Player
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
interface PlayerRepository : CrudRepository<Player, String> {
}