package edu.iesam.examaad1eval.features.ex2.data.local.db

import androidx.room.*

const val PLAYER_TABLE_NAME = "player"
const val PLAYER_ID = "player_id"

@Entity(tableName = PLAYER_TABLE_NAME)
class PlayerEntity (
    @PrimaryKey @ColumnInfo(name = PLAYER_ID) var id: String,
    val gameId : String,
    @ColumnInfo(name = "name") var name: String
)