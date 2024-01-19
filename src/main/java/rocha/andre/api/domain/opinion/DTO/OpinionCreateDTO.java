package rocha.andre.api.domain.opinion.DTO;

import rocha.andre.api.domain.game.Game;

public record OpinionCreateDTO(String name,
                               String console,
                               int note,
                               String opinion,
                               Game game) {
    public OpinionCreateDTO(OpinionDTO dto, String name, String console, Game game) {
        this(name, console, dto.note(), dto.opinion(), game);
    }
}
