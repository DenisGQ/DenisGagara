package HW10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClickTest
{
    WebDriver driver;

    @BeforeMethod
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
    }

    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }

    @Test
    public void testDoubleClick() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/buttons");

        WebElement trash = driver.findElement(By.id("fixedban"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].parentNode.removeChild(arguments[0])", trash);

        Actions actions = new Actions(driver);
        WebElement button = driver.findElement(By.id("doubleClickBtn"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        Thread.sleep(500);
        actions.doubleClick(button).perform();
        Assert.assertEquals(driver.findElement(By.id("doubleClickMessage")).isDisplayed(), true);
    }
        @Test
        public void testRigtClick() throws InterruptedException {
            driver = new ChromeDriver();
            driver.get("https://demoqa.com/buttons");

            WebElement trash = driver.findElement(By.id("fixedban"));
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].parentNode.removeChild(arguments[0])", trash);

            Actions actions = new Actions(driver);
            WebElement button = driver.findElement(By.id("rightClickBtn"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
            Thread.sleep(500);
            actions.contextClick(button).perform();
            Assert.assertEquals(driver.findElement(By.id("rightClickMessage")).isDisplayed(), true);
        }

        @Test
        public void testDynamicClick () throws InterruptedException {
            driver = new ChromeDriver();
            driver.get("https://demoqa.com/buttons");

            WebElement trash = driver.findElement(By.id("fixedban"));
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].parentNode.removeChild(arguments[0])", trash);

            Actions actions = new Actions(driver);
            WebElement button = driver.findElement(By.cssSelector(".mt-4 > button:not(#rightClickBtn.btn.btn-primary)"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
            Thread.sleep(500);
            actions.click(button).perform();
            Assert.assertEquals(driver.findElement(By.id("dynamicClickMessage")).isDisplayed(), true);
        }
    }