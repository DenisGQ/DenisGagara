package HW10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

public class Practice {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void automationPracticeForm() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");

        WebElement ads = driver.findElement(By.id("adplus-anchor"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].parentNode.removeChild(arguments[0])", ads);

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Lorem");

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Ipsum");

        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys("lorem@ipsum.com");

        WebElement gender = driver.findElement(By.id("gender-radio-1"));
        gender.click();

        WebElement userNumber = driver.findElement(By.id("userNumber"));
        userNumber.sendKeys("0001112233");

        WebElement birth = driver.findElement(By.id("dateOfBirthInput"));
        birth.click();
        WebElement monthElement = driver.findElement(By.className("react-datepicker__month-select"));
        Select selectMonth = new Select(monthElement);
        selectMonth.selectByVisibleText("December");
        WebElement yearElement = driver.findElement(By.className("react-datepicker__year-select"));
        Select selectYear = new Select(yearElement);
        selectYear.selectByVisibleText("1912");
        WebElement dayElement = driver.findElement(By.xpath("//*[contains(@class, 'eact-datepicker__day react-datepicker__day--012')]"));
        dayElement.click();

        WebElement subjectsContainer = driver.findElement(By.id("subjectsInput"));
        subjectsContainer.sendKeys("Hin");
        subjectsContainer.sendKeys(Keys.ENTER);

        WebElement hobbies2 = driver.findElement(By.id("hobbies-checkbox-2"));
        hobbies2.click();

        WebElement hobbies3 = driver.findElement(By.id("hobbies-checkbox-3"));
        hobbies3.click();

        WebElement uploadPicture = driver.findElement(By.id("uploadPicture"));
        uploadPicture.sendKeys("C:\\Users\\UncleYorick\\Downloads\\WallpaperDog-17216155.jpg");

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("22, Grove Street, Los Santos");

        WebDriverWait state = new WebDriverWait(driver, 20);
        state.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("react-select-3-input")))).sendKeys("NCR", Keys.ENTER);

        WebDriverWait city = new WebDriverWait(driver, 20);
        city.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("react-select-4-input")))).sendKeys("Noida", Keys.ENTER);

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        Assert.assertEquals(driver.findElement(By.xpath("//*[@class = 'modal-content']")).isDisplayed(), true);
    }
}
