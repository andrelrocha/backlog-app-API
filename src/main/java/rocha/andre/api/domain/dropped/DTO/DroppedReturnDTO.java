package rocha.andre.api.domain.dropped.DTO;

import rocha.andre.api.domain.dropped.Dropped;

public record DroppedReturnDTO(long id, String name, String console, int note, String genre, String reason, long gameId) {
    public DroppedReturnDTO(Dropped dropped) {
        this(dropped.getId(), dropped.getName(), dropped.getConsole(), dropped.getNote(), dropped.getGenre(), dropped.getReason(), dropped.getGame().getId());
    }
}
