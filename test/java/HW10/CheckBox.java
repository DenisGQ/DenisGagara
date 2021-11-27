package HW10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
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
    public void checkboxCheck() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/checkbox");

        WebElement trash = driver.findElement(By.id("fixedban"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].parentNode.removeChild(arguments[0])", trash);

        WebElement expandAll = driver.findElement(By.xpath("//*[@class = 'rct-option rct-option-expand-all']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", expandAll);
        Thread.sleep(500);
        expandAll.click();

        Assert.assertEquals(driver.findElement(By.id("tree-node-wordFile")).isSelected(), false) ;
        Assert.assertEquals(driver.findElement(By.id("tree-node-excelFile")).isSelected(), false) ;

        driver.findElement(By.xpath("//*[@class = 'rct-title'][contains(text(), 'Word File.doc')]")).click();
        driver.findElement(By.xpath("//*[@class = 'rct-title'][contains(text(), 'Excel File.doc')]")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//*[@class = 'text-success' ][contains(text(), 'downloads')]")).isDisplayed(), true);
    }
}
