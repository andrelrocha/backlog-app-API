package rocha.andre.api.domain.dropped.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rocha.andre.api.domain.dropped.DTO.DroppedReturnDTO;
import rocha.andre.api.domain.dropped.DroppedRepository;
import rocha.andre.api.domain.finished.DTO.FinishedReturnDTO;
import rocha.andre.api.infra.exceptions.ValidationException;

@Component
public class GetDroppedByID {
    @Autowired
    private DroppedRepository repository;

    public DroppedReturnDTO getDroppedById(long id) {
        var dropped = repository.findById(id)
                .orElseThrow(() -> new ValidationException("Não foi encontrado jogo dropado com o id informado."));

        return new DroppedReturnDTO(dropped);
    }
}
