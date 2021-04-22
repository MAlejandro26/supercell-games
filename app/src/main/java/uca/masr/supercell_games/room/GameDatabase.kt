package uca.masr.supercell_games.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [GameCacheEntity::class], version = 1)
abstract class GameDatabase : RoomDatabase() {
    companion object{
        val DATABASE_NAME = "GameDB"
    }
    abstract fun gameDao() : GameDao
}