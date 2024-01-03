package rocha.andre.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rocha.andre.api.domain.game.DTO.GameDTO;
import rocha.andre.api.domain.game.Game;
import rocha.andre.api.domain.game.useCase.CRUD.GetAllGamesPageable;
import rocha.andre.api.domain.game.useCase.CRUD.GetRandomGame;
import rocha.andre.api.domain.game.useCase.CRUD.ReturnAllGamesUseCase;
import rocha.andre.api.domain.game.useCase.Sheet.ConvertGamesOnDBtoCSV;
import rocha.andre.api.domain.game.useCase.Sheet.ExcelToCSVConverter;
import rocha.andre.api.domain.game.useCase.Sheet.SaveGamesOnDB;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {
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

    @GetMapping("/tocsv")
    public ResponseEntity excelToCSV() {
        var string = excelToCSVConverter.convertXlsxToCsv();
        return ResponseEntity.ok(string);
    }

    @GetMapping("/saveondb")
    private ResponseEntity<List<Game>> saveGamesOnDb() throws IOException {
        var gamesOnDb = saveGamesOnDB.saveGamesOnDataBase();
        return ResponseEntity.ok(gamesOnDb);
    }

    @GetMapping("/fromdbtocsv")
    public ResponseEntity gamesToXLSX() {
        var string = convertGamesOnDBtoCSV.convertGamesToCSV();
        return ResponseEntity.ok(string);
    }

    @GetMapping
    public ResponseEntity<List<GameDTO>> getAllGames() {
        var games = returnAllGamesUseCase.returnAllGames();
        return ResponseEntity.ok(games);
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<GameDTO>> getGamesPageable(@RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "25") int size,
                                                          @RequestParam(defaultValue = "name") String sortField,
                                                          @RequestParam(defaultValue = "asc") String sortOrder) {
        var pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortOrder), sortField));
        var gamesPageable = getAllGamesPageable.getGamesPageable(pageable);
        return ResponseEntity.ok(gamesPageable);
    }

    @GetMapping("/suggestion")
    public ResponseEntity<GameDTO> suggestionGame() {
        var game = getRandomGame.suggestionGame();
        return ResponseEntity.ok(game);
    }
}
