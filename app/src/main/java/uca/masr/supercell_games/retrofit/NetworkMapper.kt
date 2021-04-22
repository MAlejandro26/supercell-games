package uca.masr.supercell_games.retrofit

import javax.inject.Inject
import uca.masr.supercell_games.model.Game
import uca.masr.supercell_games.utils.EntityMapper

class NetworkMapper
@Inject
constructor() : EntityMapper<GameNetworkEntity, Game>{
    override fun mapFromEntity(entity: GameNetworkEntity): Game {
        return Game(
            id = entity.id,
            name = entity.name,
            description = entity.description,
            image = entity.image
        )
    }

    override fun mapToEntity(domainModel: Game): GameNetworkEntity {
        return  GameNetworkEntity(
            id = domainModel.id,
            name = domainModel.name,
            description = domainModel.description,
            image = domainModel.image
        )
    }

    fun mapFromEntityList(entities: List<GameNetworkEntity>): List<Game>{
        return entities.map { mapFromEntity(it) }
    }
}