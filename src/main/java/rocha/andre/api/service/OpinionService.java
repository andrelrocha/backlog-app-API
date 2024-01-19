package rocha.andre.api.service;

import rocha.andre.api.domain.opinion.DTO.OpinionDTO;
import rocha.andre.api.domain.opinion.DTO.OpinionReturnDTO;

public interface OpinionService {
    OpinionReturnDTO createOpinion(OpinionDTO data);
}
