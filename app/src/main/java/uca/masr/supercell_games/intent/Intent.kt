package uca.masr.supercell_games.intent

sealed class Intent{
    object GetGameEvent: Intent()
    object None: Intent()
}
