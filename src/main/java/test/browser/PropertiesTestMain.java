package test.browser;

import java.io.*;
import java.util.Properties;

public class PropertiesTestMain {
    public static void main(String ... args) throws IOException {
        Properties properties = new Properties();
        String projectPath = System.getProperty("user.dir");
        FileInputStream inputStream = new FileInputStream(projectPath+"/src/test/resources/config/google_test.properties");
        properties.load(inputStream);
        properties.setProperty("result","pass");
        FileOutputStream fileOutputStream = new FileOutputStream(projectPath+"/src/test/resources/config/google_test.properties");
        properties.store(fileOutputStream,null);
        System.out.println("browser value::"+properties.getProperty("browser"));

    }
}
