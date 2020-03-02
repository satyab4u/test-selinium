package test.browser;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {

    @Test(dataProvider = "testData")
    public void testDataProvider(String username, String password) {
        System.out.println(username+" ---->"+password);
    }

    @DataProvider(name = "testData")
    public Object[][] getTestData() {
        String path = System.getProperty("user.dir");
        ExcelUtils excelUtils = new ExcelUtils(path+"/src/test/resources/data/data.xlsx","Login");
        int rowCount = excelUtils.rowCount();
        int colCount = excelUtils.colCount();

        Object[][] data = new Object[rowCount][colCount];
        for(int i=1;i<rowCount;i++) {
            for(int j=0;j< colCount; j++) {
                data[i-1][j] = excelUtils.getCellDataInString(i,j);
            }
        }
        return data;
    }


}
