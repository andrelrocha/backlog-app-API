package rocha.andre.api.domain.game.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rocha.andre.api.domain.game.Game;
import rocha.andre.api.domain.game.GameRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class SaveGamesOnDB {
    @Autowired
    private GameRepository repository;

    public List<Game> saveGamesOnDataBase(List<Game> games) {
        var gamesArray = new ArrayList<Game>();

        for (Game game : games) {
            var gameExists = repository.existsByName(game.getName());

            if (!gameExists) {
                gamesArray.add(game);
            }
        }

        if (gamesArray.isEmpty()) {
            throw new RuntimeException("Nenhum jogo foi adicionado ao banco de dados.");
        }

        var gamesOnDb = repository.saveAll(gamesArray);

        return gamesOnDb;
    }
}
