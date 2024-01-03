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
import rocha.andre.api.service.GameService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping("/tocsv")
    public ResponseEntity excelToCSV() {
        var string = gameService.excelToCSV();
        return ResponseEntity.ok(string);
    }

    @GetMapping("/saveondb")
    private ResponseEntity<List<Game>> saveGamesOnDb() throws IOException {
        var games = gameService.saveGamesOnDb();
        return ResponseEntity.ok(games);
    }

    @GetMapping("/fromdbtocsv")
    public ResponseEntity gamesToCSV() {
        var string = gameService.gamesToCSV();
        return ResponseEntity.ok(string);
    }

    @GetMapping
    public ResponseEntity<List<GameDTO>> getAllGames() {
        var games = gameService.getAllGames();
        return ResponseEntity.ok(games);
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<GameDTO>> getGamesPageable(@RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "25") int size,
                                                          @RequestParam(defaultValue = "name") String sortField,
                                                          @RequestParam(defaultValue = "asc") String sortOrder) {
        var pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortOrder), sortField));
        var gamesPageable = gameService.getGamesPageable(pageable);
        return ResponseEntity.ok(gamesPageable);
    }

    @GetMapping("/suggestion")
    public ResponseEntity<GameDTO> suggestionGame() {
        var game = gameService.suggestionGame();
        return ResponseEntity.ok(game);
    }
}
