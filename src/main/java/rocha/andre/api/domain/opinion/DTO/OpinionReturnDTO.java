package rocha.andre.api.domain.opinion.DTO;

import rocha.andre.api.domain.opinion.Opinion;

public record OpinionReturnDTO(
        long id,
        String name,
        String console,
        int note,
        String opinion,
        long gameId,
        int metacritic,
        String genre
) {

    public OpinionReturnDTO(Opinion opinion) {
        this(
                opinion.getId(),
                opinion.getName(),
                opinion.getConsole(),
                opinion.getNote(),
                opinion.getOpinion(),
                opinion.getGame().getId(),
                opinion.getMetacritic(),
                opinion.getGenre()
        );
    }
}
