package rocha.andre.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rocha.andre.api.domain.game.DTO.GameDTO;
import rocha.andre.api.domain.game.Game;

import java.io.IOException;
import java.util.List;

public interface GameService {
    String excelToCSV();

    List<Game> saveGamesOnDb() throws IOException;

    String gamesToCSV();

    List<GameDTO> getAllGames();

    Page<GameDTO> getGamesPageable(Pageable pageable);

    GameDTO suggestionGame();
}
