package uca.masr.supercell_games.utils

import uca.masr.supercell_games.model.Game
import java.lang.Exception

sealed class DataState {
    object Idle:DataState()
    data class Success(val games:List<Game>) : DataState()
    data class Error(val exception: Exception) : DataState()
    object Loading: DataState()

}
