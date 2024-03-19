package test_cases;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ELA_srca {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://srca.ascend.com.sa/");
        System.out.println("Opened URL: " + driver.getCurrentUrl());
        
        driver.findElement(By.id("email")).sendKeys("awais.hamid@ascend.com.sa");
        System.out.println("Entered email");

        driver.findElement(By.id("password")).sendKeys("A9zfm8#Z_e6(cr");
        System.out.println("Entered password");

        driver.findElement(By.cssSelector("button[type='submit']")).click();
        System.out.println("Clicked on submit button");

        driver.manage().window().maximize(); // Maximizing the browser window
        System.out.println("Maximized the browser window");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        System.out.println("Set up timeouts");

        // Click on the dropdown to open the options
        WebElement dropdown = driver.findElement(By.cssSelector(".select__value-container.css-1hwfws3"));
        dropdown.click();
        System.out.println("Clicked on dropdown");

        // Find all the dropdown options
        List<WebElement> options = driver.findElements(By.cssSelector(".select__menu-list .select__option"));

        // Get the second option from the list (index starts from 0)
        WebElement secondOption = options.get(1);

        // Click on the second option
        secondOption.click();
        System.out.println("Selected second option from dropdown");

        driver.findElement(By.xpath("//button[contains(@class, 'waves-effect') and contains(@class, 'CustomButton') and contains(@class, 'p-2') and contains(@class, 'btn') and contains(@class, 'btn-secondary') and contains(@class, 'btn-block')]")).click();
        System.out.println("Clicked on button");

        // Check if the "User" element is visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement dashboardElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Users')]")));
            if (dashboardElement.isDisplayed()) {
                System.out.println("User Module Found");
            }
        } catch (TimeoutException e) {
            System.out.println("User Module Not Found");
        }

    }
}