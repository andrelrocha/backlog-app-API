package rocha.andre.api.domain.dropped.DTO;

import rocha.andre.api.domain.dropped.Dropped;
import rocha.andre.api.domain.game.Game;

public record DroppedDTO(String name, String console, int note, String reason, Game game) {

    public DroppedDTO(Dropped dropped) {
        this(dropped.getName(), dropped.getConsole(), dropped.getNote(), dropped.getReason(), dropped.getGame());
    }
}