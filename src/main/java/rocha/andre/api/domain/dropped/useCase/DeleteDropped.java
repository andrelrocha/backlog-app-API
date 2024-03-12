package rocha.andre.api.domain.dropped.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rocha.andre.api.domain.dropped.DroppedRepository;
import rocha.andre.api.domain.finished.FinishedRepository;
import rocha.andre.api.infra.exceptions.ValidationException;

@Component
public class DeleteDropped {
    @Autowired
    private DroppedRepository repository;
    
    public void deleteDropped(long id) {
        var gameDropped = repository.existsById(id);

        if (!gameDropped) {
            throw new ValidationException("Não foi encontrada jogo dropado com o id informado.");
        }

        repository.deleteById(id);
    }

}
