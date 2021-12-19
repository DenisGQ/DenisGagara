package HW12.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(className = "banner-image")
    WebElement banner;

    @FindBy(xpath = "//div[contains(@class, 'top-card')][2]")
    WebElement formTab;

    public static final String URL = "https://demoqa.com/";

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        driver.get(URL);
    }

    public boolean isBannerDisplayed() {
        boolean isBannerDisplayed = banner.isDisplayed();
        return isBannerDisplayed;
    }

    public void clickFormsTab() {
        formTab.click();
    }
}
