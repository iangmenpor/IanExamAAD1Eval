package edu.iesam.examaad1eval.features.ex2.data.local.db.mappers


import edu.iesam.examaad1eval.features.ex2.data.local.db.GameEntity
import edu.iesam.examaad1eval.features.ex2.data.local.db.GameWithPlayers
import edu.iesam.examaad1eval.features.ex2.model.Game

fun GameWithPlayers.toDomain(): Game = Game(this.game.id, this.game.title, this.players.toDomain() )

fun Game.toEntity(): GameEntity = GameEntity(id, title)