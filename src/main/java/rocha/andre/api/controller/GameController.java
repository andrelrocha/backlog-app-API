package rocha.andre.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rocha.andre.api.domain.game.Game;
import rocha.andre.api.domain.game.useCase.ConvertCSVinGames;
import rocha.andre.api.domain.game.useCase.ConvertGamesOnDBtoCSV;
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
    private ConvertGamesOnDBtoCSV convertGamesOnDBtoCSV;

    @Autowired
    private SaveGamesOnDB saveGamesOnDB;

    @GetMapping("/tocsv")
    public ResponseEntity excekToCSV() {
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
}
