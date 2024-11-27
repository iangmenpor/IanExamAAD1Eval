package edu.iesam.examaad1eval.features.ex2.data.local.db.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import edu.iesam.examaad1eval.features.ex2.data.local.db.PlayerEntity

class PlayerConverter {

    @TypeConverter
    fun from(player: String): PlayerEntity {
        return Gson().fromJson(player, PlayerEntity::class.java)
    }

    @TypeConverter
    fun to(player: PlayerEntity): String {
        return Gson().toJson(player)
    }

    @TypeConverter
    fun fromList(players: List<PlayerEntity>): String {
        return Gson().toJson(players)
    }

    @TypeConverter
    fun toList(playersJson: String): List<PlayerEntity> {
        return Gson().fromJson(playersJson, Array<PlayerEntity>::class.java).toList()
    }
}