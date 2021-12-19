package HW12.tests;

import HW12.pages.ClickPage;
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

public class ClickTests
{
    WebDriver driver;
    ClickPage clickPage;

    @BeforeMethod
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }

    @Test
    public void testDoubleClick()
    {
        clickPage = new ClickPage(driver);
        clickPage.openClickPage();

        clickPage.removeTrash();
        clickPage.clickButton();
        Assert.assertEquals(driver.findElement(By.id("doubleClickMessage")).isDisplayed(), true);
    }

    @Test
    public void testRigtClick()
    {
        clickPage = new ClickPage(driver);
        clickPage.openClickPage();

        clickPage.removeTrash();
        clickPage.rightClick();
        Assert.assertEquals(driver.findElement(By.id("rightClickMessage")).isDisplayed(), true);
    }

    @Test
    public void testDynamicClick()
    {
        clickPage = new ClickPage(driver);
        clickPage.openClickPage();

        clickPage.removeTrash();
        clickPage.dynamicClick();
        Assert.assertEquals(driver.findElement(By.id("dynamicClickMessage")).isDisplayed(), true);
    }
}






















































