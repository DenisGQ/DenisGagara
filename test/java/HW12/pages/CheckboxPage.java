package HW12.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckboxPage
{
    WebDriver driver;

    By adsTrash = By.id("fixedban");
    By expandAllBtn = By.xpath("//*[@class = 'rct-option rct-option-expand-all']");
    By cboxWordFile = By.xpath("//*[@class = 'rct-title'][contains(text(), 'Word File.doc')]");
    By cboxExcelFile = By.xpath("//*[@class = 'rct-title'][contains(text(), 'Excel File.doc')]");


    public static final String checkboxURL = "https://demoqa.com/checkbox";

    public CheckboxPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openCheckboxPage()
    {
        driver.get(checkboxURL);
    }

    public void removeTrash()
    {
        WebElement trash = driver.findElement(adsTrash);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].parentNode.removeChild(arguments[0])", trash);
    }

    public void clickExpandAll()
    {
        WebDriverWait expandAll = new WebDriverWait(driver, 30);
        expandAll.until(ExpectedConditions.elementToBeClickable(expandAllBtn)).click();
    }

    public void checkWordFile()
    {
        driver.findElement(cboxWordFile).click();
    }

    public void checkExcelFile()
    {
        driver.findElement(cboxExcelFile).click();
    }

    public void scroll()
    {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,3000)");
    }
}
