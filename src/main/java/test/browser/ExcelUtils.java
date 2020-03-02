package test.browser;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExcelUtils {
    private XSSFWorkbook workbook = null;
    private XSSFSheet sheet = null;
    public ExcelUtils(String path, String sheetName){
        try {
            System.out.println("path::"+path);
            this.workbook = new XSSFWorkbook(new FileInputStream(path));
            this.sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }

    public int rowCount() {
        System.out.println("Sheet != null:"+(sheet != null));
        return sheet.getPhysicalNumberOfRows();
    }

    public int colCount() {
        return sheet.getRow(0).getPhysicalNumberOfCells();
    }

    public String getCellDataInString(int row, int col) {
        return sheet.getRow(row).getCell(col).getStringCellValue();
    }

    public double getCellDataInInt(int row, int col) {
        return sheet.getRow(row).getCell(col).getNumericCellValue();
    }

    public void printData() {
        Iterator<Row> rowIter = sheet.iterator();
        while(rowIter.hasNext()) {
            Iterator<Cell> cellIter = rowIter.next().cellIterator();
            while(cellIter.hasNext()) {
                System.out.print(cellIter.next().toString()+ " ");
            }
            System.out.println();
        }
    }

}
