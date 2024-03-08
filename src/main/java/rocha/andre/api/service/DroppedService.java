package rocha.andre.api.service;

import rocha.andre.api.domain.dropped.DTO.DroppedDTO;
import rocha.andre.api.domain.dropped.DTO.DroppedReturnDTO;

public interface DroppedService {
    DroppedReturnDTO addGameToDropped(DroppedDTO data);
}
