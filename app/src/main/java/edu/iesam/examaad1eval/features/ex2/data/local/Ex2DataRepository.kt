package edu.iesam.examaad1eval.features.ex2.data.local

import edu.iesam.examaad1eval.features.ex2.data.local.db.Ex2Dao
import edu.iesam.examaad1eval.features.ex2.data.local.db.mappers.toDomain
import edu.iesam.examaad1eval.features.ex2.data.local.db.mappers.toEntity
import edu.iesam.examaad1eval.features.ex2.data.remote.mock.MockEx2RemoteDataSource
import edu.iesam.examaad1eval.features.ex2.model.Ex2Repository
import edu.iesam.examaad1eval.features.ex2.model.Game
import edu.iesam.examaad1eval.features.ex2.model.Player

class Ex2DataRepository(
    private val dao: Ex2Dao,
    private val remote: MockEx2RemoteDataSource
) : Ex2Repository {

    override suspend fun saveGames(games: List<Game>) {
        val entities = games.map { it.toEntity() }
        dao.saveGames(*entities.toTypedArray())
    }

    override suspend fun getGames(): List<Game> {
        val local = dao.getUsersWithPlayers()
        if (local.isEmpty()) {
            val remote = remote.getGames()
            val entities = remote.map { it.toEntity() }
            dao.saveGames(*entities.toTypedArray())
            return dao.getUsersWithPlayers().map { it.toDomain() }
        } else {
            return local.map { it.toDomain() }
        }
    }

    override suspend fun savePlayers(players: List<Player>) {
        //val entities = players.map { }
        //dao.savePlayers(*entities.toTypedArray())
    }

    override suspend fun getPlayers(): List<Player> {
        val local = dao.getPlayers()
        if (local.isEmpty()) {
            val remote = remote.getPlayers()
          //  val entities = remote.map { it.toEntity}
          //  dao.savePlayers(*entities.toTypedArray())
            return dao.getPlayers().map { it.toDomain() }
        } else {
            return local.map { it.toDomain() }
        }
    }
}