package test_cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EFX_AMAN {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initializing WebDriverWait

        driver.get("https://efficax-obligation.ascend.com.sa/");

        System.out.println("Opened the website");

        // Fill in the email and password fields
        WebElement emailInput = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        emailInput.sendKeys("system@ascend.com");

        System.out.println("Entered email");

        WebElement passwordInput = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        passwordInput.sendKeys("eod777");

        System.out.println("Entered password");

        // Add a wait of 20 seconds after entering the password
        Thread.sleep(20000);

        System.out.println("Waited for 20 seconds");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        System.out.println("Clicked on the submit button");
    }
}
