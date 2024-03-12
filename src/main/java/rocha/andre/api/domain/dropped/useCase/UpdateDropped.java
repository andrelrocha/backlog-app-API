package rocha.andre.api.domain.dropped.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rocha.andre.api.domain.dropped.DTO.DroppedReturnDTO;
import rocha.andre.api.domain.dropped.DTO.DroppedUpdateDTO;
import rocha.andre.api.domain.dropped.DroppedRepository;
import rocha.andre.api.domain.finished.DTO.FinishedReturnDTO;
import rocha.andre.api.domain.finished.DTO.FinishedUpdateDTO;
import rocha.andre.api.domain.finished.FinishedRepository;
import rocha.andre.api.infra.exceptions.ValidationException;

@Component
public class UpdateDropped {

    @Autowired
    private DroppedRepository repository;

    public DroppedReturnDTO updateDropped(DroppedUpdateDTO data, long id) {
        var dropped = repository.findById(id)
                .orElseThrow(() -> new ValidationException("Não foi encontrada opinião com o id informado."));

        dropped.updateDropped(data);
        var opinionOnDB = repository.save(dropped);

        return new DroppedReturnDTO(opinionOnDB);
    }

}
