package rocha.andre.api.service;

import rocha.andre.api.domain.playingGame.DTO.PlayingGameDTO;
import rocha.andre.api.domain.playingGame.DTO.PlayingGameReturnDTO;

public interface PlayingGameService {
    PlayingGameReturnDTO addPlayingGame(PlayingGameDTO data);
}
