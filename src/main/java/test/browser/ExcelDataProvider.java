package test.browser;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {

    @Test(dataProvider = "testData")
    public void testDataProvider(String username, String password) {
        System.out.println(username + " ---->" + password);
    }

    public static void main(String args[]) {
        ExcelDataProvider dataProvider = new ExcelDataProvider();
        Object[][] data = dataProvider.getTestData();
        for (Object[] row : data) {
            for (Object celValue : row) {
                System.out.print("cel value:" + celValue);
                System.out.println();
            }
        }
    }

    @DataProvider(name = "testData")
    public Object[][] getTestData() {
        String path = System.getProperty("user.dir");
        ExcelUtils excelUtils = new ExcelUtils(path + "/src/test/resources/data/data.xlsx", "Login");
        int rowCount = excelUtils.rowCount();
        int colCount = excelUtils.colCount();

        Object[][] data = new Object[rowCount][colCount];
        for (int i = 1; i < rowCount; i++) {
            if (excelUtils.getCellDataInString(i, 2).contains("Yes")) {
                for (int j = 0; j < colCount; j++) {
                    data[i - 1][j] = excelUtils.getCellDataInString(i, j);
                }
            }
        }
        return data;
    }


}
