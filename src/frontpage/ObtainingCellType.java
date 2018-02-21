package frontpage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.microsoft.schemas.office.visio.x2012.main.CellType;

public class ObtainingCellType {

    public static void main(String[] args) throws Exception {
        String filename = "celltype.xls";

        try (FileInputStream fis = new FileInputStream(filename)) {
            HSSFWorkbook workbook = new HSSFWorkbook(fis);
            HSSFSheet sheet = workbook.getSheetAt(0);

            java.util.Iterator<Row> rows = sheet.iterator();
            while (rows.hasNext()) {
                HSSFRow row = (HSSFRow) rows.next();
                java.util.Iterator<Cell> cells = row.cellIterator();
                while (cells.hasNext()) {
                    HSSFCell cell = (HSSFCell) cells.next();

                    org.apache.poi.ss.usermodel.CellType type = cell.getCellTypeEnum();
                    if (type == CellType.STRING) {
                        System.out.println("[" + cell.getRowIndex() + ", "
                                + cell.getColumnIndex() + "] = STRING; Value = "
                                + cell.getRichStringCellValue().toString());
                    } else if (type == CellType.FLOAT) {
                        System.out.println("[" + cell.getRowIndex() + ", "
                                + cell.getColumnIndex() + "] = NUMERIC; Value = "
                                + cell.getNumericCellValue());
                    } else if (type == CellType.BOOLEAN) {
                        System.out.println("[" + cell.getRowIndex() + ", "
                                + cell.getColumnIndex() + "] = BOOLEAN; Value = "
                                + cell.getBooleanCellValue());
                    } else if (type == CellType.BLANK) {
                        System.out.println("[" + cell.getRowIndex() + ", "
                                + cell.getColumnIndex() + "] = BLANK CELL");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
