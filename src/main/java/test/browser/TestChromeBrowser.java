package test.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestChromeBrowser {
    public static void main(String args[]) {
        String projectPath = System.getProperty("user.dir");
      //  System.setProperty("webdriver.chrome.driver","/Users/Satya/Documents/venky/test-selinium/drivers/chrome/chromedriver");

        System.setProperty("webdriver.chrome.driver",projectPath+"/drivers/chrome/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev");
        driver.close();
        driver.quit();
    }
}
