package listgenerator;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;



public class List {

    private Map<String, Collection<Integer>> machineInfo;
    private Collection<Map<String, Integer>> MachineList;
    private Collection<Integer> values;

    public List(String filePath){
        
        this.machineInfo = new HashMap<String, Collection<Integer>>();
        this.MachineList = new ArrayList<Map<String,Integer>>();

        try {
            FileInputStream file = new FileInputStream(new File(filePath));

            // Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            // Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            // Iterate through each rows one by one

            String dummykey = "";
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                // For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                this.values = new ArrayList<>();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    
                    // Check the cell type and format accordingly
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            //System.out.print(cell.getNumericCellValue() + "t");
                            // machineInfo.put(dummykey, (int) cell.getNumericCellValue());
                            values.add((int) cell.getNumericCellValue());
                            break;
                        case STRING:
                            //System.out.print(cell.getStringCellValue() + "s");
                            machineInfo.put(cell.getStringCellValue(), null);
                            dummykey = cell.getStringCellValue();
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
                machineInfo.put(dummykey, values);
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map<String, Collection<Integer>> getMachineInfo() {
        for (Map.Entry<String,Collection<Integer>> map : machineInfo.entrySet()) {
            System.out.println("key: " + map.getKey() + " | values: " + map.getValue());
            System.out.println("------------------------------------------------------------------");
        }
        
        return machineInfo;
    }
    public static void main(String[] args) {
        List l = new List("C:/Users/ruben/Desktop/Jobb/excelips.xlsx");
        l.getMachineInfo();

    }

    
}
