package Java;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FetchExcel {
    static String SAMPLE_PERSON_DATA_FILE_PATH = System.getProperty("user.dir")+"\\src\\resources\\Sample-Invoice-Data.xlsx";
    public static HashMap<String,HashMap<Integer,ArrayList<String>>> returnExcelData(){
        HashMap<String,HashMap<Integer,ArrayList<String>>> excelValues= new HashMap<>();
        HashMap<Integer,ArrayList<String>> sheetValues= new HashMap<>();
        File file = new File(SAMPLE_PERSON_DATA_FILE_PATH);
        try {
            InputStream fileInputStream = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            DataFormatter dataFormatter = new DataFormatter();
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                ArrayList<String> columnValues=new ArrayList<>();
                XSSFSheet sheet=workbook.getSheetAt(i);
                for (Row row: sheet) {
                    for(Cell cell: row) {
                        String cellValue = dataFormatter.formatCellValue(cell);
                        columnValues.add(cellValue);
                        System.out.print(cellValue + "\t");
                    }
                    sheetValues.put(row.getRowNum(),columnValues);
                    System.out.println();
                }
                excelValues.put(sheet.getSheetName(),sheetValues);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return excelValues;

    }


}
