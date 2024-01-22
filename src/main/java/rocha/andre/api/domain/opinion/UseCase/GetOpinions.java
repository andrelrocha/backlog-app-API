package rocha.andre.api.domain.opinion.UseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import rocha.andre.api.domain.opinion.DTO.OpinionReturnDTO;
import rocha.andre.api.domain.opinion.OpinionRepository;

@Component
public class GetOpinions {
    @Autowired
    private OpinionRepository repository;

    public Page<OpinionReturnDTO> getOpinions(Pageable pageable) {
        return repository.findAllOpinions(pageable).map(OpinionReturnDTO::new);
    }
}
