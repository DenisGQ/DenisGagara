package HW10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBox {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }

    @Test
    public void checkboxCheck() {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/checkbox");

        WebElement trash = driver.findElement(By.id("fixedban"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].parentNode.removeChild(arguments[0])", trash);

        WebDriverWait expandAll = new WebDriverWait(driver, 30);
        expandAll.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class = 'rct-option rct-option-expand-all']"))).click();

        Assert.assertEquals(driver.findElement(By.id("tree-node-wordFile")).isSelected(), false) ;
        Assert.assertEquals(driver.findElement(By.id("tree-node-excelFile")).isSelected(), false) ;

        driver.findElement(By.xpath("//*[@class = 'rct-title'][contains(text(), 'Word File.doc')]")).click();
        driver.findElement(By.xpath("//*[@class = 'rct-title'][contains(text(), 'Excel File.doc')]")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//*[@class = 'text-success' ][contains(text(), 'downloads')]")).isDisplayed(), true);
    }
}
