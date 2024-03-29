package rocha.andre.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import rocha.andre.api.domain.dropped.DTO.DroppedDTO;
import rocha.andre.api.domain.dropped.DTO.DroppedReturnDTO;
import rocha.andre.api.domain.dropped.DTO.DroppedUpdateDTO;
import rocha.andre.api.domain.dropped.useCase.*;
import rocha.andre.api.service.DroppedService;

@Service
public class DroppedServiceImpl implements DroppedService {
    @Autowired
    private AddGameToDropped addGameToDropped;
    @Autowired
    private DeleteDropped deleteDropped;
    @Autowired
    private GetDropped getDropped;
    @Autowired
    private GetDroppedByID getDroppedByID;
    @Autowired
    private UpdateDropped updateDropped;

    @Override
    public DroppedReturnDTO addGameToDropped(DroppedDTO data) {
        var droppedGame = addGameToDropped.addGameToDropped(data);
        return droppedGame;
    }

    @Override
    public void deleteDropped(long id) {
        deleteDropped.deleteDropped(id);
    }

    @Override
    public Page<DroppedReturnDTO> getDroppedGames(Pageable pageable) {
        var droppedGames = getDropped.getDroppedGames(pageable);
        return droppedGames;
    }

    @Override
    public DroppedReturnDTO getDroppedById(long id) {
        var droppedGame = getDroppedByID.getDroppedById(id);
        return droppedGame;
    }

    @Override
    public DroppedReturnDTO updateDropped(DroppedUpdateDTO data, long id) {
        var droppedUpdated = updateDropped.updateDropped(data, id);
        return droppedUpdated;
    }
}
