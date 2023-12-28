package rocha.andre.api.domain.game.useCase;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ExcelToCSVConverter {

    public void convertXlsxToCsv() {
        try (InputStream inputStream = new ClassPathResource("xlsx/backlog.xlsx").getInputStream();
             Workbook workbook = new XSSFWorkbook(inputStream);
             FileWriter csvWriter = new FileWriter("src/main/resources/csv/backlog.csv")) {

            Sheet sheet = workbook.getSheetAt(0);

            List<String> header = new ArrayList<>();
            Row headerRow = sheet.getRow(0);
            for (Cell cell : headerRow) {
                header.add(cell.getStringCellValue());
            }
            csvWriter.append(String.join(",", header)).append("\n");

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                List<String> rowData = new ArrayList<>();

                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (cell.getColumnIndex() == getColumnIndexByName("played", header)) {
                        String playedValue = cell.getStringCellValue().trim();
                        if (playedValue.equalsIgnoreCase("YES")) {
                            rowData.add("true");
                        } else if (playedValue.equalsIgnoreCase("NO")) {
                            rowData.add("false");
                        }
                    } else {
                        rowData.add(getCellValueAsString(cell));
                    }
                }
                csvWriter.append(String.join(",", rowData)).append("\n");
            }
        } catch (IOException e) {
            if (e instanceof FileNotFoundException) {
                File directory = new File("csv");
                if (!directory.exists()) {
                    directory.mkdirs();
                    convertXlsxToCsv();
                } else {
                    e.printStackTrace();
                }
            } else {
                e.printStackTrace();
            }
        }
    }

    private int getColumnIndexByName(String columnName, List<String> header) {
        return header.indexOf(columnName);
    }

    private String getCellValueAsString(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }
}
