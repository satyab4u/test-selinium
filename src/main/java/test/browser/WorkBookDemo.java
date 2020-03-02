package test.browser;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WorkBookDemo {

    public static void main(String args[]) throws IOException {
        String path = System.getProperty("user.dir");
        String excelPath = path+"/src/test/resources/data/data.xlsx";
        ExcelUtils excelUtils = new ExcelUtils(excelPath,"Employee");
        /*System.out.println("Rows count:"+excelUtils.rowCount());
        System.out.println("header[0]: "+excelUtils.getCellDataInString(0,0));*/
        excelUtils.printData();
        //createExcelData();
    }

    public static void createExcelData() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/data/data.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.createSheet("Employee");

        XSSFRow row0 = sheet.createRow(0);
        XSSFCell cel0 = row0.createCell(0);
        cel0.setCellValue("EmpId");

        row0.createCell(1).setCellValue("Name");
        row0.createCell(2).setCellValue("AGE");

        XSSFRow row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("1");
        row1.createCell(1).setCellValue("Ram");
        row1.createCell(2).setCellValue("20");

        XSSFRow row2 = sheet.createRow(2);
        row2.createCell(0).setCellValue("2");
        row2.createCell(1).setCellValue("Shyam");
        row2.createCell(2).setCellValue("21");

        fis.close();
        FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"/src/test/resources/data/data.xlsx");
        workbook.write(fos);
        fos.close();

    }

}
