package rocha.andre.api.domain.playingGame.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rocha.andre.api.domain.playingGame.DTO.PlayingGameDTO;
import rocha.andre.api.domain.playingGame.DTO.PlayingGameReturnDTO;
import rocha.andre.api.domain.playingGame.PlayingGameRepository;

@Component
public class UpdatePlayingGameUseCase {
    @Autowired
    private PlayingGameRepository repository;

    public PlayingGameReturnDTO updatePlayingGame(PlayingGameDTO data) {
        return null;
    }
}
