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

    @GetMapping(value = "/:id")
    fun get(id: String): Optional<GameModel>
    {
        return service.get(id)
    }

    @DeleteMapping(value = "/:id")
    fun remove(id: String)
    {
        service.remove(id)
    }
}