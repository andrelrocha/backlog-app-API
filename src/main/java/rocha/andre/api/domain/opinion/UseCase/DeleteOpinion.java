package rocha.andre.api.domain.opinion.UseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rocha.andre.api.domain.opinion.OpinionRepository;
import rocha.andre.api.infra.exceptions.ValidationException;

@Component
public class DeleteOpinion {
    @Autowired
    private OpinionRepository repository;
    
    public void deleteOpinion(long id) {
        var opinionExists = repository.existsById(id);

        if (!opinionExists) {
            throw new ValidationException("Não foi encontrada opinião com o id informado.");
        }

        repository.deleteById(id);
    }

}
