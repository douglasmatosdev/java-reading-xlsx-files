import lombok.Cleanup;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadFile {

    public List<Table> create() throws IOException {

        List<Table> tables = new ArrayList<>();

            @Cleanup FileInputStream file = new FileInputStream("src/main/resources/teste.xlsx");

                Workbook workbook = new XSSFWorkbook(file);

                Sheet sheet = workbook.getSheetAt(0);

                List<Row> rows = (List<Row>) toList(sheet.iterator());

                rows.remove(0);

                rows.forEach(row -> {
                    List<Cell> cells = (List<Cell>) toList(row.cellIterator());

                    Table table = Table.builder()
                            .intialHour(cells.get(0).getDateCellValue())
                            .endHour(cells.get(1).getDateCellValue())
                            .totalHour(cells.get(2).getDateCellValue())
                            .description(cells.get(3).getStringCellValue())
                            .build();

                    tables.add(table);

                });
        return tables;
    }

    public List<?> toList(Iterator<?> iterator) {
        return IteratorUtils.toList(iterator);
    }

    public void loggerTableValues(List<Table> tables) {
        tables.forEach(System.out::println);
    }
}
