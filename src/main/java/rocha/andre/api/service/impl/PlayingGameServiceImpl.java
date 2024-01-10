package rocha.andre.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import rocha.andre.api.domain.playingGame.DTO.PlayingGameDTO;
import rocha.andre.api.domain.playingGame.DTO.PlayingGameReturnDTO;
import rocha.andre.api.domain.playingGame.useCase.AddPlayingGame;
import rocha.andre.api.domain.playingGame.useCase.GetPlayingGames;
import rocha.andre.api.service.PlayingGameService;

@Component
public class PlayingGameServiceImpl implements PlayingGameService {
    @Autowired
    private AddPlayingGame addPlayingGame;
    @Autowired
    private GetPlayingGames getPlayingGames;

    @Override
    public PlayingGameReturnDTO addPlayingGame(PlayingGameDTO data) {
        var playingGame = addPlayingGame.addPlayingGame(data);
        return playingGame;
    }

    @Override
    public Page<PlayingGameReturnDTO> getAllPlayingGames(Pageable pageable) {
        var playingGames = getPlayingGames.getAllPlayingGames(pageable);
        return playingGames;
    }
}
