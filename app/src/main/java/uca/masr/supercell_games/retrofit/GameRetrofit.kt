package uca.masr.supercell_games.retrofit

import retrofit2.http.GET

interface GameRetrofit {
    @GET("games")
    suspend fun get () : List<GameNetworkEntity>
}