package HW12.tests;

import HW12.pages.CheckboxPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckboxTest
{
    WebDriver driver;
    CheckboxPage checkboxPage;

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
    public void checkboxCheck()
    {
        checkboxPage = new CheckboxPage(driver);
        checkboxPage.openCheckboxPage();

        checkboxPage.removeTrash();
        checkboxPage.scroll();
        checkboxPage.clickExpandAll();
        Assert.assertEquals(driver.findElement(By.id("tree-node-wordFile")).isSelected(), false) ;
        Assert.assertEquals(driver.findElement(By.id("tree-node-excelFile")).isSelected(), false) ;
        checkboxPage.checkWordFile();
        checkboxPage.checkExcelFile();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class = 'text-success' ][contains(text(), 'downloads')]")).isDisplayed(), true);
    }
}
