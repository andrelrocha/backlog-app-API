package rocha.andre.api.domain.finished.UseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rocha.andre.api.domain.finished.FinishedRepository;
import rocha.andre.api.domain.imageGame.ImageGameRepository;
import rocha.andre.api.infra.exceptions.ValidationException;

@Component
public class DeleteFinished {
    @Autowired
    private FinishedRepository repository;

    @Autowired
    private ImageGameRepository imageGameRepository;
    
    public void deleteFinished(long id) {
        var finishedGame = repository.findById(id)
                .orElseThrow(() -> new ValidationException("Não foi encontrada opinião com o id informado."));

        var finishedGameGameId = finishedGame.getGame().getId();

        try{
            repository.deleteById(id);
            imageGameRepository.deleteByGameId(finishedGameGameId);
        } catch (Exception e) {
            throw new ValidationException("Algo deu errado no processo de deletar o jogo finalizado: " + e.getMessage());
        }
    }
}
