package edu.iesam.examaad1eval.features.ex2.data.local.db.mappers

import edu.iesam.examaad1eval.features.ex2.data.local.db.GameWithPlayers
import edu.iesam.examaad1eval.features.ex2.data.local.db.PlayerEntity
import edu.iesam.examaad1eval.features.ex2.model.Player

fun PlayerEntity.toDomain(): Player =
    Player(this.id, this.name)

fun List<PlayerEntity>.toDomain(): List<Player> =
    this.map { it.toDomain() }

fun Player.toEntity(gameId: String): PlayerEntity =
    PlayerEntity(this.id, gameId, this.name)

fun List<GameWithPlayers>.toEntity(): List<PlayerEntity>  = TODO()
