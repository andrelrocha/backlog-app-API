package rocha.andre.api.domain.playingGame.DTO;

import rocha.andre.api.domain.playingGame.PlayingGame;

import java.time.LocalDateTime;

public record PlayingGameReturnDTO(String name, int length, int metacritic, int excitement, String genre, LocalDateTime firstPlayed) {
    public PlayingGameReturnDTO(PlayingGame playingGame) {
        this(
                playingGame.getGame().getName(),
                playingGame.getGame().getLength(),
                playingGame.getGame().getMetacritic(),
                playingGame.getGame().getExcitement(),
                playingGame.getGame().getGenre(),
                playingGame.getFirstPlayed()
        );
    }
}
