package rocha.andre.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import rocha.andre.api.domain.opinion.DTO.OpinionDTO;
import rocha.andre.api.domain.opinion.DTO.OpinionReturnDTO;
import rocha.andre.api.domain.opinion.UseCase.CreateOpinion;
import rocha.andre.api.domain.opinion.UseCase.GetOpinionByID;
import rocha.andre.api.domain.opinion.UseCase.GetOpinions;
import rocha.andre.api.service.OpinionService;

@Service
public class OpinionServiceImpl implements OpinionService {
    @Autowired
    private CreateOpinion createOpinion;
    @Autowired
    private GetOpinions getOpinions;
    @Autowired
    private GetOpinionByID getOpinionByID;

    public OpinionReturnDTO createOpinion(OpinionDTO data) {
        var opinion = createOpinion.createOpinion(data);
        return opinion;
    }

    @Override
    public Page<OpinionReturnDTO> getOpinions(Pageable pageable) {
        var opinions = getOpinions.getOpinions(pageable);
        return opinions;
    }

    @Override
    public OpinionReturnDTO getOpinionById(long id) {
        var opinion = getOpinionByID.getOpinionById(id);
        return opinion;
    }
}
