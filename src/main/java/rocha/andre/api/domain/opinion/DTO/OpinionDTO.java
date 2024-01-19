package rocha.andre.api.domain.opinion.DTO;

public record OpinionDTO(
        int note,
        String opinion,
        Long gameId
) {
}
