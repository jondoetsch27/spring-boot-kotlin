package com.jdd.springboot.kotlin.repository

import com.jdd.springboot.kotlin.model.Player
import org.springframework.data.repository.CrudRepository
import java.util.*

class PlayerRepository: CrudRepository<Player, String> {
    override fun <S : Player?> save(entity: S): S {
        TODO("Not yet implemented")
    }

    override fun <S : Player?> saveAll(entities: MutableIterable<S>): MutableIterable<S> {
        TODO("Not yet implemented")
    }

    override fun findById(id: String): Optional<Player> {
        TODO("Not yet implemented")
    }

    override fun existsById(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun findAll(): MutableIterable<Player> {
        TODO("Not yet implemented")
    }

    override fun findAllById(ids: MutableIterable<String>): MutableIterable<Player> {
        TODO("Not yet implemented")
    }

    override fun count(): Long {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: String) {
        TODO("Not yet implemented")
    }

    override fun delete(entity: Player) {
        TODO("Not yet implemented")
    }

    override fun deleteAll(entities: MutableIterable<Player>) {
        TODO("Not yet implemented")
    }

    override fun deleteAll() {
        TODO("Not yet implemented")
    }
}