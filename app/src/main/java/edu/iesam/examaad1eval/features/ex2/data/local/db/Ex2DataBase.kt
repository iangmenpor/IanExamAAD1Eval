package edu.iesam.examaad1eval.features.ex2.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import edu.iesam.examaad1eval.features.ex2.data.local.db.converters.PlayerConverter

@Database(entities = [GameEntity::class, PlayerEntity::class], version = 1, exportSchema = false)
@TypeConverters(PlayerConverter::class)
abstract class Ex2DataBase : RoomDatabase() {

    abstract fun ex2Dao(): Ex2Dao

}