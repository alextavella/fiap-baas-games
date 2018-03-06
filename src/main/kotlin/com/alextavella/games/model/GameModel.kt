package com.alextavella.games.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class GameModel (
        @Id val id: String?,
        var name: String,
        var urlImage: String,
        var year: Integer
)