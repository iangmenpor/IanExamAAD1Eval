package edu.iesam.examaad1eval.features.ex2.data.local.db

import androidx.room.Embedded
import androidx.room.Relation

data class GameWithPlayers(
    @Embedded val game: GameEntity,
    @Relation(
        parentColumn = "game_id",
        entityColumn = "player_id"
    )
    val players: List<PlayerEntity>
)
