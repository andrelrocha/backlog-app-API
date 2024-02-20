package rocha.andre.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import rocha.andre.api.domain.imageGame.DTO.ImageGameDTO;
import rocha.andre.api.domain.imageGame.DTO.ImageGameReturnDTO;
import rocha.andre.api.domain.imageGame.useCase.CreateImageGame;
import rocha.andre.api.service.ImageGameService;

import java.io.IOException;

@Service
public class ImageGameServiceImpl implements ImageGameService {
    @Autowired
    private CreateImageGame createImageGame;

    @Override
    public ImageGameReturnDTO createImageGame(MultipartFile file, long gameId) throws IOException {
        var ImageGameDTO = new ImageGameDTO(file, gameId);
        var imageGame = createImageGame.createImageGame(ImageGameDTO);
        return imageGame;
    }
}
