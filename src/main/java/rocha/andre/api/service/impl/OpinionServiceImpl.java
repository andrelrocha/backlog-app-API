package rocha.andre.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocha.andre.api.domain.opinion.DTO.OpinionDTO;
import rocha.andre.api.domain.opinion.DTO.OpinionReturnDTO;
import rocha.andre.api.domain.opinion.UseCase.CreateOpinion;
import rocha.andre.api.service.OpinionService;

@Service
public class OpinionServiceImpl implements OpinionService {
    @Autowired
    private CreateOpinion createOpinion;

    public OpinionReturnDTO createOpinion(OpinionDTO data) {
        var opinion = createOpinion.createOpinion(data);
        return opinion;
    }
}
