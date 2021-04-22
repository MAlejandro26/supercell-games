package uca.masr.supercell_games.repository

import uca.masr.supercell_games.retrofit.NetworkMapper
import uca.masr.supercell_games.retrofit.GameRetrofit
import uca.masr.supercell_games.room.CacheMapper
import uca.masr.supercell_games.room.GameDao
import uca.masr.supercell_games.utils.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class GameRepository constructor(
    private val gameDao : GameDao,
    private val gameRetrofit: GameRetrofit,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
){
    suspend fun getPlaces(): Flow<DataState> = flow{
        emit(DataState.Loading)
        delay(2000)
        try {
            val GameData = gameRetrofit.get()
            val gameMap = networkMapper.mapFromEntityList(GameData)
            for (tempGame in gameMap){
                gameDao.insert(cacheMapper.mapToEntity(tempGame))
            }
            val cachePla = gameDao.get()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cachePla)))
        }catch (e: Exception){
            emit(DataState.Error(e))
        }
    }
}