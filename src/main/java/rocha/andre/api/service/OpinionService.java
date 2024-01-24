package rocha.andre.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rocha.andre.api.domain.opinion.DTO.OpinionDTO;
import rocha.andre.api.domain.opinion.DTO.OpinionReturnDTO;

public interface OpinionService {
    OpinionReturnDTO createOpinion(OpinionDTO data);

    Page<OpinionReturnDTO> getOpinions(Pageable pageable);
    OpinionReturnDTO getOpinionById(long id);
}
