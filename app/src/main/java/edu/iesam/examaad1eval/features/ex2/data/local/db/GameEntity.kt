package edu.iesam.examaad1eval.features.ex2.data.local.db

import androidx.room.*

const val GAME_TABLE_NAME = "game"
const val GAME_ID = "game_id"

@Entity(tableName = GAME_TABLE_NAME)
class GameEntity(
    @PrimaryKey @ColumnInfo(name = GAME_ID) var id: String,
    @ColumnInfo(name = "title") var title: String,
)