package rocha.andre.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import rocha.andre.api.domain.game.DTO.GameDTO;
import rocha.andre.api.domain.game.Game;
import rocha.andre.api.domain.game.useCase.CRUD.GetAllGamesPageable;
import rocha.andre.api.domain.game.useCase.CRUD.GetRandomGame;
import rocha.andre.api.domain.game.useCase.CRUD.ReturnAllGamesUseCase;
import rocha.andre.api.domain.game.useCase.Sheet.ConvertGamesOnDBtoCSV;
import rocha.andre.api.domain.game.useCase.Sheet.ExcelToCSVConverter;
import rocha.andre.api.domain.game.useCase.Sheet.SaveGamesOnDB;
import rocha.andre.api.service.GameService;

import java.io.IOException;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private ExcelToCSVConverter excelToCSVConverter;

    @Autowired
    private ConvertGamesOnDBtoCSV convertGamesOnDBtoCSV;

    @Autowired
    private GetAllGamesPageable getAllGamesPageable;

    @Autowired
    private GetRandomGame getRandomGame;

    @Autowired
    private SaveGamesOnDB saveGamesOnDB;

    @Autowired
    private ReturnAllGamesUseCase returnAllGamesUseCase;

    @Override
    public String excelToCSV() {
        var string = excelToCSVConverter.convertXlsxToCsv();
        return string;
    }

    @Override
    public List<Game> saveGamesOnDb() throws IOException {
        var gamesOnDb = saveGamesOnDB.saveGamesOnDataBase();
        return gamesOnDb;
    }

    @Override
    public String gamesToCSV() {
        var string = convertGamesOnDBtoCSV.convertGamesToCSV();
        return string;
    }

    @Override
    public List<GameDTO> getAllGames() {
        var games = returnAllGamesUseCase.returnAllGames();
        return games;
    }

    @Override
    public Page<GameDTO> getGamesPageable(Pageable pageable) {
        var gamesPageable = getAllGamesPageable.getGamesPageable(pageable);
        return gamesPageable;
    }

    @Override
    public GameDTO suggestionGame() {
        var game = getRandomGame.suggestionGame();
        return game;
    }
}
