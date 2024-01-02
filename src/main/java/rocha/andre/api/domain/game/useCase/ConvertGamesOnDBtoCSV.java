package rocha.andre.api.domain.game.useCase;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rocha.andre.api.domain.game.Game;
import rocha.andre.api.domain.game.GameRepository;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class ConvertGamesOnDBtoCSV {
    @Autowired
    private GameRepository repository;

    public String convertGamesToCSV() {
        var games = repository.findAll();

        String csvFile = "src/main/resources/csv/backlogondb.csv";

        try (FileWriter writer = new FileWriter(csvFile)) {

            writer.append("Name,Length,Metacritic,Excitement,Genre,Played\n");

            for (Game game : games) {
                writer.append(String.format(
                        "\"%s\",%d,%d,%d,\"%s\",%b\n",
                        game.getName(),
                        game.getLength(),
                        game.getMetacritic(),
                        game.getExcitement(),
                        game.getGenre(),
                        game.isPlayed()
                ));
            }

            return "ARQUIVO CRIADO A PARTIR DO BANCO DE DADOS!!";

        } catch (IOException e) {
            e.printStackTrace();
            return "ERRO AO CRIAR O ARQUIVO!!";
        }
    }

}
