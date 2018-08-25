package Java;

import net.bytebuddy.asm.Advice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReportEngineMain {
    public static HashMap<String,HashMap<Integer,ArrayList<String>>> excelData=new HashMap<>();
    public static void main(String[] args) throws InterruptedException {
        excelData=FetchExcel.returnExcelData();
        for(Map.Entry<String, HashMap<Integer, ArrayList<String>>> sheets : excelData.entrySet()){
            HashMap<Integer, ArrayList<String>> sheetValues=sheets.getValue();
            String sheetName=sheets.getKey();
            SeleniumClass.collectData(sheetValues,sheetName);

        }


    }


}
