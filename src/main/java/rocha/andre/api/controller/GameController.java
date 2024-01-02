package rocha.andre.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rocha.andre.api.domain.game.Game;
import rocha.andre.api.domain.game.useCase.ConvertCSVinGames;
import rocha.andre.api.domain.game.useCase.ExcelToCSVConverter;
import rocha.andre.api.domain.game.useCase.SaveGamesOnDB;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    private ExcelToCSVConverter excelToCSVConverter;

    @Autowired
    private ConvertCSVinGames convertCSVinGames;

    @Autowired
    private SaveGamesOnDB saveGamesOnDB;

    @GetMapping("/tocsv")
    public String excekToCSV() {
        excelToCSVConverter.convertXlsxToCsv();
        return "DEU CERTO!";
    }

    @GetMapping("/printcsv")
    private List<Game> returnAllGamesAsObject() throws IOException {

        var games = convertCSVinGames.readGamesFromCSV();
        for(Game game : games) {
            System.out.println(game);
        }

        return games;
    }

    @GetMapping("/saveondb")
    private ResponseEntity<List<Game>> saveGamesOnDb() throws IOException {
        var games = convertCSVinGames.readGamesFromCSV();

        var gamesOnDb = saveGamesOnDB.saveGamesOnDataBase(games);

        return ResponseEntity.ok(gamesOnDb);
    }
}
