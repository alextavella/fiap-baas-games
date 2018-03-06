package com.alextavella.games.controller

import com.alextavella.games.model.GameModel
import com.alextavella.games.service.GameService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@CrossOrigin
@RequestMapping(value = "/game")
class GameController {

    @Autowired
    lateinit var service: GameService

    @GetMapping
    fun list(): List<GameModel>
    {
        return service.list()
    }

    @PostMapping
    fun register(@RequestBody model: GameModel): GameModel
    {
        return service.save(model)
    }

    @GetMapping(value = "/{id}")
    fun get(@PathVariable id: String): Optional<GameModel>
    {
        return service.get(id)
    }

    @GetMapping(value = "/name/{name}")
    fun find(@PathVariable name: String): List<GameModel>
    {
        return service.findByName(name)
    }

    @DeleteMapping(value = "/{id}")
    fun remove(@PathVariable id: String)
    {
        service.remove(id)
    }
}