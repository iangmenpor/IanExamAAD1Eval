package edu.iesam.examaad1eval.features.ex2.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import kotlin.math.abs

@Dao
abstract class Ex2Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun saveGames(vararg games : GameEntity)

    @Transaction
    @Query("SELECT * FROM $GAME_TABLE_NAME")
    abstract fun getGames(): List<GameEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun savePlayers(vararg players : PlayerEntity)

    @Query("SELECT * FROM $PLAYER_TABLE_NAME")
    abstract fun getPlayers(): List<PlayerEntity>

    @Transaction
    @Query("SELECT * FROM $GAME_TABLE_NAME")
    abstract fun getUsersWithPlayers(): List<GameWithPlayers>

}