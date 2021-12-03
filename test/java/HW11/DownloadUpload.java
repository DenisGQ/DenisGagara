package HW11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static java.util.concurrent.TimeUnit.SECONDS;

public class DownloadUpload
{
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @AfterMethod
    public void teardown() {
        File dir = new File("target\\dowloaded files");
        for (File file:dir.listFiles()) {
            file.delete();
        }
        dir.delete();
        driver.quit();
    }

    @Test
    public void loadTest() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", Paths.get("target\\dowloaded files").toFile().getAbsolutePath());
        prefs.put("safebrowsing.enabled", "false");
        prefs.put("profile.default_content_settings.popups", 0);

        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/upload-download");

        WebElement trash = driver.findElement(By.id("fixedban"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].parentNode.removeChild(arguments[0])", trash);

        WebElement download = driver.findElement(By.id("downloadButton"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", download);
        download.click();

        driver.manage().timeouts().pageLoadTimeout(100, SECONDS);

        File file = new File("target\\dowloaded files");
        System.out.println(file.getAbsolutePath());

        WebElement upload = driver.findElement(By.id("uploadFile"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", upload);
        upload.sendKeys(file.getAbsolutePath());

        Assert.assertEquals(driver.findElement(By.id("uploadedFilePath")).isDisplayed(), true);

    }
}
