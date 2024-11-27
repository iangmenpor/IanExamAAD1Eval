package edu.iesam.examaad1eval.features.ex2.model

interface Ex2Repository {
    suspend fun saveGames(games: List<Game>)
    suspend fun getGames(): List<Game>
    suspend fun savePlayers(players: List<Player>)
    suspend fun getPlayers(): List<Player>
}