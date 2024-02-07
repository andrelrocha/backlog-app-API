package rocha.andre.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import rocha.andre.api.domain.opinion.DTO.OpinionDTO;
import rocha.andre.api.domain.opinion.DTO.OpinionReturnDTO;
import rocha.andre.api.domain.opinion.DTO.OpinionUpdateDTO;
import rocha.andre.api.domain.opinion.UseCase.*;
import rocha.andre.api.service.OpinionService;

@Service
public class OpinionServiceImpl implements OpinionService {
    @Autowired
    private CreateOpinion createOpinion;
    @Autowired
    private DeleteOpinion deleteOpinion;
    @Autowired
    private GetOpinions getOpinions;
    @Autowired
    private GetOpinionByID getOpinionByID;
    @Autowired
    private UpdateOpinion updateOpinion;

    public OpinionReturnDTO createOpinion(OpinionDTO data) {
        var opinion = createOpinion.createOpinion(data);
        return opinion;
    }

    @Override
    public void deleteOpinion(long id) {
        deleteOpinion.deleteOpinion(id);
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

    @Override
    public OpinionReturnDTO updateOpinion(OpinionUpdateDTO data, long id) {
        var opinion = updateOpinion.updateOpinion(data, id);
        return opinion;
    }
}
