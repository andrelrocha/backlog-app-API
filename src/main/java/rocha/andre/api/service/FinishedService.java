package rocha.andre.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rocha.andre.api.domain.finished.DTO.FinishedDTO;
import rocha.andre.api.domain.finished.DTO.FinishedReturnDTO;
import rocha.andre.api.domain.finished.DTO.FinishedUpdateDTO;

public interface FinishedService {
    FinishedReturnDTO createFinished(FinishedDTO data);
    public void deleteFinished(long id);

    Page<FinishedReturnDTO> getFinished(Pageable pageable);
    FinishedReturnDTO getFinishedById(long id);
    public FinishedReturnDTO getFinishedByGameId(long gameId);

    FinishedReturnDTO updateFinished(FinishedUpdateDTO data, long id);
}
