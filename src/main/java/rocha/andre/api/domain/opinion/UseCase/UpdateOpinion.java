package rocha.andre.api.domain.opinion.UseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rocha.andre.api.domain.opinion.DTO.OpinionReturnDTO;
import rocha.andre.api.domain.opinion.DTO.OpinionUpdateDTO;
import rocha.andre.api.domain.opinion.OpinionRepository;
import rocha.andre.api.infra.exceptions.ValidationException;

@Component
public class UpdateOpinion {

    @Autowired
    private OpinionRepository repository;

    public OpinionReturnDTO updateOpinion(OpinionUpdateDTO data, long id) {
        var opinion = repository.findById(id)
                .orElseThrow(() -> new ValidationException("Não foi encontrada opinião com o id informado."));

        opinion.updateOpinion(data);
        var opinionOnDB = repository.save(opinion);

        return new OpinionReturnDTO(opinionOnDB);
    }

}
