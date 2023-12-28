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
             FileWriter csvWriter = new FileWriter("src/main/resources/csv/teste.csv")) {

            Sheet sheet = workbook.getSheetAt(0);

            List<String> header = new ArrayList<>();
            Row headerRow = sheet.getRow(0);
            for (Cell cell : headerRow) {
                header.add(cell.getStringCellValue());
            }
            List<String> relevantColumns = List.of("name", "length", "metacritic", "excitement", "played", "genre", "playing");
            List<Integer> relevantColumnIndexes = new ArrayList<>();
            for (String column : relevantColumns) {
                int index = getColumnIndexByName(column, header);
                if (index != -1) {
                    relevantColumnIndexes.add(index);
                }
            }
            csvWriter.append(String.join(",", relevantColumns)).append("\n");

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                if (row != null && !isEmpty(row)) {
                    List<String> rowData = new ArrayList<>();
                    for (int columnIndex : relevantColumnIndexes) {
                        Cell cell = row.getCell(columnIndex);
                        if (cell != null) {
                            if (columnIndex == getColumnIndexByName("played", header)) {
                                String playedValue = cell.getStringCellValue().trim();
                                if (playedValue.equalsIgnoreCase("YES")) {
                                    rowData.add("true");
                                } else if (playedValue.equalsIgnoreCase("NO")) {
                                    rowData.add("false");
                                }
                            } else {
                                rowData.add(getCellValueAsString(cell));
                            }
                        } else {
                            rowData.add("");
                        }
                    }
                    csvWriter.append(String.join(",", rowData)).append("\n");
                } else {
                    break;
                }
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

    private boolean isEmpty(Row row) {
        Iterator<Cell> cellIterator = row.cellIterator();
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            if (cell.getCellType() != CellType.BLANK) {
                return false;
            }
        }
        return true;
    }
}
