package rocha.andre.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rocha.andre.api.domain.game.Game;
import rocha.andre.api.domain.game.useCase.ConvertGamesInCSV;
import rocha.andre.api.domain.game.useCase.ExcelToCSVConverter;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    private ExcelToCSVConverter excelToCSVConverter;

    @Autowired
    private ConvertGamesInCSV convertGamesInCSV;

    @GetMapping("/tocsv")
    public String excekToCSV() {
        excelToCSVConverter.convertXlsxToCsv();
        return "DEU CERTO!";
    }

    @GetMapping("/printcsv")
    private List<Game> returnAllGamesAsObject() throws IOException {


        var games = convertGamesInCSV.readGamesFromCSV();
        for(Game game : games) {
            System.out.println(game);
        }

        return games;
    }
}
