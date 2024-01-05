package rocha.andre.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rocha.andre.api.domain.game.DTO.GameDTO;
import rocha.andre.api.domain.game.DTO.GameReturnDTO;
import rocha.andre.api.domain.game.Game;
import rocha.andre.api.service.GameService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    public ResponseEntity<Resource> gamesToCSV() throws IOException {
        try {
            var csvFile = gameService.gamesToCSV();
            var path = Paths.get(csvFile.getAbsolutePath());
            var resource = new ByteArrayResource(Files.readAllBytes(path));

            var headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=backlogondb.csv");

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(csvFile.length())
                    .contentType(MediaType.parseMediaType("application/octet-stream"))
                    .body(resource);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<GameDTO>> getAllGames() {
        var games = gameService.getAllGames();
        return ResponseEntity.ok(games);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameReturnDTO> getGamesPageable(@PathVariable Long id) {
        var game = gameService.getGameById(id);
        return ResponseEntity.ok(game);
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<GameReturnDTO>> getGamesPageable(@RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "25") int size,
                                                          @RequestParam(defaultValue = "name") String sortField,
                                                          @RequestParam(defaultValue = "asc") String sortOrder) {
        var pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortOrder), sortField));
        var gamesPageable = gameService.getGamesPageable(pageable);
        return ResponseEntity.ok(gamesPageable);
    }

    @GetMapping("/suggestion")
    public ResponseEntity<GameReturnDTO> suggestionGame() {
        var game = gameService.suggestionGame();
        return ResponseEntity.ok(game);
    }
}
