package rocha.andre.api.domain.imageGame.DTO;

import rocha.andre.api.domain.game.Game;
import rocha.andre.api.domain.imageGame.ImageGame;

public record ImageGameReturnDTO(long gameId, byte[] imageFile) {
    public ImageGameReturnDTO(ImageGame imageGame) {
        this(imageGame.getGame().getId(), imageGame.getImage());
    }
}
