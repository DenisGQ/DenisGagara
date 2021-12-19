package HW12.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ClickPage
{
    WebDriver driver;

    By adsTrash = By.id("fixedban");
    By doubleClickBtn = By.id("doubleClickBtn");
    By rightClickBtn = By.id("rightClickBtn");
    By dynamicClickBtn = By.cssSelector(".mt-4 > button:not(#rightClickBtn.btn.btn-primary)");


    public static final String buttonsURL = "https://demoqa.com/buttons";

    public ClickPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openClickPage() {
        driver.get(buttonsURL);
    }

    public void removeTrash()
    {
        WebElement trash = driver.findElement(adsTrash);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].parentNode.removeChild(arguments[0])", trash);
    }

    public void clickButton()
    {
        Actions actions = new Actions(driver);
        WebElement button = driver.findElement(doubleClickBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        actions.doubleClick(button).perform();
    }

    public void rightClick()
    {
        Actions actions = new Actions(driver);
        WebElement button = driver.findElement(rightClickBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        actions.contextClick(button).perform();
    }

    public void dynamicClick()
    {
        Actions actions = new Actions(driver);
        WebElement button = driver.findElement(dynamicClickBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        actions.click(button).perform();
    }
}
