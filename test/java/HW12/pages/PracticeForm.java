package HW12.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticeForm {
    WebDriver driver;

    By blockTabPracticeFrom = By.xpath("//span[contains(text(), 'Practice')]");
    By adsTrash = By.id("fixedban");
    By inFirstName = By.id("firstName");
    By inLastName = By.id("lastName");
    By inUserEmail = By.id("userEmail");
    By rbGender = By.id("gender-radio-1");
    By inUserNumber = By.id("userNumber");
    By inDateOfBirthInput = By.id("dateOfBirthInput");
    By monthElement = By.className("react-datepicker__month-select");
    By yearElement = By.className("react-datepicker__year-select");
    By dayElement = By.xpath("//*[contains(@class, 'eact-datepicker__day react-datepicker__day--012')]");
    By subjectsContainer = By.id("subjectsInput");
    By checkHobbies1 = By.id("hobbies-checkbox-1");
    By checkHobbies2 = By.id("hobbies-checkbox-2");
    By checkHobbies3 = By.id("hobbies-checkbox-3");
    By uploadPicture = By.id("uploadPicture");
    By currentAddress = By.id("currentAddress");
    By selectState = By.id("react-select-3-input");
    By selectCity = By.id("react-select-4-input");
    By buttonSubmit = By.id("submit");
    By modalWindow = By.xpath("//*[@class = 'modal-content']");

    public PracticeForm(WebDriver driver) {
        this.driver = driver;
    }

    public void removeTrash()
    {
        WebElement trash = driver.findElement(adsTrash);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].parentNode.removeChild(arguments[0])", trash);
    }

    public void scroll()
    {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,1000)");
    }

    public void clickTabPracticeForm() {
        driver.findElement(blockTabPracticeFrom).click();
    }

    public void setFirstName(String firstName) {
        driver.findElement(inFirstName).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(inLastName).sendKeys(lastName);
    }

    public void setUserEmail(String userEmail) {
        driver.findElement(inUserEmail).sendKeys(userEmail);
    }

    public void clickGender() {
        driver.findElement(rbGender).click();
    }

    public void setUserNumber(String userNumber) {
        driver.findElement(inUserNumber).sendKeys(userNumber);
    }

    public void clickDateOfBirthInput() {
        driver.findElement(inDateOfBirthInput).click();
    }

    public void selectMonth(String month) {
        Select selectMonth = new Select(driver.findElement(monthElement));
        selectMonth.selectByVisibleText(month);
    }

    public void selectYear(String year) {
        Select selectYear = new Select(driver.findElement(yearElement));
        selectYear.selectByVisibleText(year);
    }

    public void clickDayElement() {
        driver.findElement(dayElement).click();
    }

    public void setSubject(String subjectInput) {
        driver.findElement(subjectsContainer).sendKeys(subjectInput);
        driver.findElement(subjectsContainer).sendKeys(Keys.ENTER);
    }

    public void checkHobbies1() {
        driver.findElement(checkHobbies1).click();
    }

    public void checkHobbies2() {
        driver.findElement(checkHobbies2).click();
    }

    public void checkHobbies3() {
        driver.findElement(checkHobbies3).click();
    }

    public void uploadPicture(String pictureLink) {
        driver.findElement(uploadPicture).sendKeys(pictureLink);
    }

    public void setCurrentAdress(String currentAdress) {
        driver.findElement(currentAddress).sendKeys(currentAdress);
    }

    public void setState(String stateInput) {
        WebDriverWait state = new WebDriverWait(driver, 20);
        state.until(ExpectedConditions.elementToBeClickable(driver.findElement(selectState))).sendKeys(stateInput, Keys.ENTER);
    }

    public void setCity(String cityInput) {
        WebDriverWait city = new WebDriverWait(driver, 20);
        city.until(ExpectedConditions.elementToBeClickable(driver.findElement(selectCity))).sendKeys(cityInput, Keys.ENTER);
    }

    public void clickSubmit() {
        driver.findElement(buttonSubmit).click();
    }
}
