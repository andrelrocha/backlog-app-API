package rocha.andre.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rocha.andre.api.domain.dropped.DTO.DroppedDTO;
import rocha.andre.api.domain.dropped.DTO.DroppedReturnDTO;
import rocha.andre.api.domain.dropped.DTO.DroppedUpdateDTO;

public interface DroppedService {
    DroppedReturnDTO addGameToDropped(DroppedDTO data);
    public void deleteDropped(long id);
    Page<DroppedReturnDTO> getDroppedGames(Pageable pageable);
    DroppedReturnDTO getDroppedById(long id);
    DroppedReturnDTO updateDropped(DroppedUpdateDTO data, long id);
}
