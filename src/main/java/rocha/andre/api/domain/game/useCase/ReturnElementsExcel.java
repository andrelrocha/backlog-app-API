package rocha.andre.api.domain.game.useCase;

import org.springframework.stereotype.Component;
import org.apache.poi.ss.usermodel.*;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;


@Component
public class ReturnElementsExcel {
    /*
    public void readExcelFile() {
        try {
            Resource resource = new ClassPathResource("xlsx/backlog.xlsx");
            Workbook workbook = WorkbookFactory.create(resource.getInputStream());
            Sheet sheet = workbook.getSheetAt(0); // Seu arquivo tem apenas uma planilha?

            for (Row row : sheet) {
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t");
                            break;
                        default:
                            System.out.print("Unknown Type\t");
                    }
                }
                System.out.println();
            }
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
    }
     */

}
