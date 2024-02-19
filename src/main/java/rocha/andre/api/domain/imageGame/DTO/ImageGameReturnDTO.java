package rocha.andre.api.domain.imageGame.DTO;

import rocha.andre.api.domain.game.Game;
import rocha.andre.api.domain.imageGame.ImageGame;

public record ImageGameReturnDTO(byte[] imageFile, Game game) {
    public ImageGameReturnDTO(ImageGame imageGame) {
        this(imageGame.getImage(), imageGame.getGame());
    }
}
