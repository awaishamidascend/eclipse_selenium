package test_cases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class logs {

    WebDriver driver = null;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void print() {
        if (driver != null) {
            driver.get("https://srca.ascend.com.sa/");
        } else { 
            System.out.println("WebDriver is null. Make sure setUp method is executed before print method.");
        }
    }

    @AfterClass
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
