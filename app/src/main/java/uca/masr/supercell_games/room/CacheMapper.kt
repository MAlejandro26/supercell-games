package uca.masr.supercell_games.room

import uca.masr.supercell_games.model.Game
import uca.masr.supercell_games.retrofit.GameNetworkEntity
import uca.masr.supercell_games.utils.EntityMapper
import javax.inject.Inject


class CacheMapper
@Inject
constructor():
    EntityMapper<GameCacheEntity, Game>{

        override fun mapFromEntity(entity: GameCacheEntity): Game {
            return Game(
                id = entity.id,
                name = entity.name,
                description = entity.description,
                image = entity.image
            )
        }

        override fun mapToEntity(domainModel: Game): GameCacheEntity {
            return GameCacheEntity(
                id = domainModel.id,
                name = domainModel.name,
                description = domainModel.description,
                image = domainModel.image
            )
        }

        fun mapFromEntityList(entities: List<GameCacheEntity>): List<Game>{
            return entities.map { mapFromEntity(it) }
        }
    }