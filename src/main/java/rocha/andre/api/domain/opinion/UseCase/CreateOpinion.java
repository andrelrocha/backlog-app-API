package rocha.andre.api.domain.opinion.UseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rocha.andre.api.domain.game.GameRepository;
import rocha.andre.api.domain.opinion.DTO.OpinionCreateDTO;
import rocha.andre.api.domain.opinion.DTO.OpinionDTO;
import rocha.andre.api.domain.opinion.DTO.OpinionReturnDTO;
import rocha.andre.api.domain.opinion.Opinion;
import rocha.andre.api.domain.opinion.OpinionRepository;
import rocha.andre.api.infra.exceptions.ValidationException;

@Component
public class CreateOpinion {
    @Autowired
    private OpinionRepository opinionRepository;

    @Autowired
    private GameRepository gameRepository;

    public OpinionReturnDTO createOpinion(OpinionDTO data) {
        var opinionExists = opinionRepository.existsByGameId(data.gameId());

        if (opinionExists) {
            throw new ValidationException("Já existe uma opinião para o jogo informado.");
        }

        var game = gameRepository.findById(data.gameId())
                .orElseThrow(() -> new ValidationException("Não foi encontrado jogo com o id informado."));

        String[] parts = game.getName().split("\\s*\\(\\s*");
        String name = parts[0].trim();
        String console = parts[1].replace(")", "").trim();

        var opinionCreateDTO = new OpinionCreateDTO(data, name, console, game);

        var opinion = new Opinion(opinionCreateDTO);

        var opinionOnDB = opinionRepository.save(opinion);

        return new OpinionReturnDTO(opinionOnDB);
    }
}
