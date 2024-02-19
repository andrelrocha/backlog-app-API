package rocha.andre.api.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;
import rocha.andre.api.domain.imageGame.DTO.ImageGameDTO;
import rocha.andre.api.domain.imageGame.DTO.ImageGameReturnDTO;

public interface ImageGameService {
    ImageGameReturnDTO createImageGame(MultipartFile file, long gameId);
}
