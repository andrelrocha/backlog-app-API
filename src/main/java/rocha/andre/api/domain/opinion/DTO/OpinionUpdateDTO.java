package rocha.andre.api.domain.opinion.DTO;

public record OpinionUpdateDTO(String name,
                               String console,
                               int note,
                               String opinion,
                               int metacritic,
                               String genre) {

}
