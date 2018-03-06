package com.alextavella.games.repository

import com.alextavella.games.model.GameModel
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface GameRespository : MongoRepository<GameModel, String> {

}