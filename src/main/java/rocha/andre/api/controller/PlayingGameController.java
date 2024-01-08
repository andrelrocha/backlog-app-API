package rocha.andre.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rocha.andre.api.domain.playingGame.DTO.PlayingGameDTO;
import rocha.andre.api.domain.playingGame.DTO.PlayingGameReturnDTO;
import rocha.andre.api.service.PlayingGameService;

@RestController
@RequestMapping("/playing")
public class PlayingGameController {
    @Autowired
    private PlayingGameService playingGameService;

    @PostMapping("/add")
    public ResponseEntity<PlayingGameReturnDTO> addPlayingGames(@RequestBody PlayingGameDTO dto) {
        var playingGame = playingGameService.addPlayingGame(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(playingGame);
    }
}
