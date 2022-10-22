package listgenerator;

import java.io.File;
import java.io.FileInputStream;
import java.util.Collection;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;



public class List {

    private Collection<String> ip;
    private Collection<Collection<String>> ipList;

    public List(String filePath){
        
        try {
            FileInputStream file = new FileInputStream(new File(filePath));

            // Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            // Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            // Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                // For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    // Check the cell type and format accordingly
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "t");
                            break;
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "t");
                            break;
                        case BLANK:
                            break;
                        case BOOLEAN:
                            break;
                        case ERROR:
                            break;
                        case FORMULA:
                            break;
                        case _NONE:
                            break;
                        default:
                            break;
                    }
                }
                System.out.println("");
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new List("C:/Users/ruben/Desktop/Jobb/excelips.xlsx");
    }

    
}
