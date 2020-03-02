package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ChromeGoogleTest {

    private WebDriver driver;

   /* @BeforeClass
    public void setUpClass() {
        System.out.println("Before Class");
    }*/


    @BeforeClass
    public void setUpTest() throws IOException {
        System.out.println("Before Test");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        final Properties properties = PropertiesUtility.getProperties();
        properties.stringPropertyNames()
                .stream()
                .map(key -> key +" ::"+ properties.getProperty(key))
                .forEach(System.out::println);
    }

    @Test
    public void testChromeBrowser() throws InterruptedException {
        System.out.println("Test method");
        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("Automation");
        driver.findElement(By.name("q")).sendKeys(Keys.ESCAPE);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        TimeUnit.SECONDS.sleep(3);

    }


    @AfterTest
    public void tearDown() {
        System.out.println("TearDown method");
        driver.quit();
    }

}
