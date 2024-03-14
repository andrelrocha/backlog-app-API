package rocha.andre.api.domain.finished.UseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rocha.andre.api.domain.finished.DTO.FinishedReturnDTO;
import rocha.andre.api.domain.finished.FinishedRepository;
import rocha.andre.api.infra.exceptions.ValidationException;

@Component
public class GetFinishedByGameID {
    @Autowired
    private FinishedRepository repository;

    public FinishedReturnDTO getFinishedByGameId(long gameId) {
        var finished = repository.findByGameId(gameId);

        if (finished == null) {
            throw new ValidationException("Não foi encontrada opinião com o id informado.");
        }

        return new FinishedReturnDTO(finished);
    }
}
