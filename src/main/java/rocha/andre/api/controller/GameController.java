package rocha.andre.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rocha.andre.api.domain.game.useCase.ExcelToCSVConverter;

@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    private ExcelToCSVConverter excelToCSVConverter;

    @GetMapping("/tocsv")
    public String excekToCSV() {
        excelToCSVConverter.convertXlsxToCsv();
        return "DEU CERTO!";
    }
}
