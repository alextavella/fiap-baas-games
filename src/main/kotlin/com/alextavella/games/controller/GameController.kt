package com.alextavella.games.controller

import com.alextavella.games.model.GameModel
import com.alextavella.games.service.GameService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*
import org.springframework.http.HttpStatus

@RestController
@CrossOrigin
@RequestMapping("/game")
class GameController {

    @Autowired
    lateinit var service: GameService

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun list(): List<GameModel>
    {
        return service.list()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun register(@RequestBody model: GameModel): GameModel
    {
        return service.save(model)
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun get(@PathVariable id: String): Optional<GameModel>
    {
        return service.get(id)
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    fun find(@PathVariable name: String): List<GameModel>
    {
        return service.findByName(name)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun remove(@PathVariable id: String)
    {
        service.remove(id)
    }
}