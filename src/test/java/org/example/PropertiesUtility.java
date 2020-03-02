package org.example;

import java.io.*;
import java.util.Properties;

public class PropertiesUtility {

    public static String path = System.getProperty("user.dir");
    public static Properties properties = new Properties();

    public static Properties getProperties() throws IOException {
        properties.load(new FileInputStream(path+"/src/test/resources/config/google_test.properties"));
        return properties;
    }

    public static void setProperties(String key, String value) throws IOException {
        properties.setProperty(key, value);
        properties.store(new FileOutputStream(path+"/src/test/resources/config/google_test.properties"), null);
    }
}
