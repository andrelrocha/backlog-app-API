package rocha.andre.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import rocha.andre.api.service.ImageGameService;

@RestController
@RequestMapping("/image")
public class ImageGameController {
    @Autowired
    private ImageGameService imageGameService;

    @PostMapping("/create/{gameId}")
    public ResponseEntity saveImageGame(@RequestPart("file") MultipartFile file, @PathVariable long gameId) {
        var imageGame = imageGameService.createImageGame(file, gameId);
        return ResponseEntity.status(HttpStatus.CREATED).body(imageGame);
    }
}
