package com.alextavella.games.service

import com.alextavella.games.model.GameModel
import com.alextavella.games.repository.GameRespository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class GameService {

    @Autowired
    lateinit var repository: GameRespository

    fun list() : List<GameModel>
    {
        return repository.findAll()
    }

    fun save(model: GameModel): GameModel
    {
        return repository.save(model)
    }

    fun get(id: String): Optional<GameModel>
    {
        return repository.findById(id)
    }

    fun remove(id: String)
    {
        return repository.deleteById(id)
    }

    fun findByName(name: String): List<GameModel>
    {
        return repository.findByNameIgnoreCaseContaining(name)
    }
}