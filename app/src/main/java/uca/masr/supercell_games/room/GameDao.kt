package uca.masr.supercell_games.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GameDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(catEntity: GameCacheEntity): Long
    @Query("select * from juegos")
    suspend fun get(): List<GameCacheEntity>
}