package test.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ChromeTestMain {
    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
       // driver.findElement(By.name("q")).sendKeys("SatyaPrabhu Golakoti");
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Sravani Golakoti");
        driver.findElement(By.name("q")).sendKeys(Keys.ESCAPE);
        //TimeUnit.SECONDS.sleep(5);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        TimeUnit.SECONDS.sleep(5);
        //System.out.println(driver.findElements(By.xpath("//input")).size());
        driver.quit();
    }
}
