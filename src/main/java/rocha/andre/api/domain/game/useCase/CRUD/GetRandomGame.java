package rocha.andre.api.domain.game.useCase.CRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rocha.andre.api.domain.game.DTO.GameDTO;
import rocha.andre.api.domain.game.GameRepository;

import java.util.Random;

@Component
public class GetRandomGame {
    @Autowired
    private GameRepository repository;

    public GameDTO suggestionGame() {
        var lastId = repository.findLastId();

        var random = new Random();
        long randomId = random.nextInt((int) lastId) + 1;

        var gameExists = repository.existsById(randomId);

        while (!gameExists) {
            randomId = random.nextInt((int) lastId) + 1;

            gameExists = repository.existsById(randomId);
        }

        var idSuggestion = String.valueOf(randomId);
        var gameSuggestion = repository.findByIdToHandle(idSuggestion);

        return new GameDTO(gameSuggestion);
    }
}
