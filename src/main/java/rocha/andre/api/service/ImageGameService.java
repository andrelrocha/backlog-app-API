package rocha.andre.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;
import rocha.andre.api.domain.imageGame.DTO.ImageGameDTO;
import rocha.andre.api.domain.imageGame.DTO.ImageGameIdDTO;
import rocha.andre.api.domain.imageGame.DTO.ImageGameReturnDTO;

import java.io.IOException;
import java.util.ArrayList;

public interface ImageGameService {
    ImageGameReturnDTO addImageGame(MultipartFile file, long gameId) throws IOException;

    byte[] returnImage(long gameId) throws Exception;
    Page<ImageGameIdDTO> returnAllIds(Pageable pageable);
    Page<ImageGameReturnDTO> returnAllImages(Pageable pageable);
}
