package HW9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.apache.commons.lang.StringUtils.trim;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.*;


public class Tests
{
    WebDriver driver;

    @BeforeMethod
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
    }

    @AfterMethod
    public void teardown2()
    {
        driver.quit();
    }

    @Test
    public void firstTest() throws InterruptedException
    {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com");
        System.out.println("First tab: " + driver.getTitle() + " " + driver.getWindowHandle());
        WebElement banner = driver.findElement(By.xpath("//*[@class = 'home-banner']"));
        banner.click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.toolsqa.com/selenium-training/");
        System.out.println("Second tab: " + driver.getTitle() + " " + driver.getWindowHandle());
        System.out.println("No. of tabs: " + tabs.size());
    }

    @Test
    public void secondTest()
    {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com");
        List<String> cards = new ArrayList<String>();
        List<WebElement> allCardsText = driver.findElements(
                By.xpath(".//*[@class = 'card-body']"));
        for(WebElement w : allCardsText)
        {
            cards.add(w.getText());
        }
        System.out.print(cards);
        assertThat(cards, contains("Elements", "Forms", "Alerts, Frame & Windows", "Widgets", "Interactions", "Book Store Application"));
    }

    @Test
    public void thirdTest() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com");

        WebElement elements = driver.findElement(By.xpath("//*[contains(text(),'Elements')]"));
        elements.click();

        WebElement tbox = driver.findElement(By.xpath("//*[contains(text(),'Text Box')]"));
        tbox.click();

        WebElement userName = driver.findElement(By.id("userName"));
        userName.sendKeys("Lorem Ipsum");

        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys("lorem@ipsum.com");

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("22, Grove Street, Los Santos");

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("Not your business");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        Map<String, String> udata = new LinkedHashMap<>();
        List<WebElement> elist = driver.findElements(By.xpath("//div[contains(@class, 'border col-md-12 col-sm-12')]/p"));
        for (WebElement element : elist) {
            String[] spl = element.getText().split(":");
            for (int i = 0, j = spl.length / 2; j < spl.length; i++, j++) {
                udata.put(trim(spl[i]), trim(spl[j]));
            }
        }

        Map<String, String> control = new LinkedHashMap<String, String>();
        control.put("Name", "Lorem Ipsum");
        control.put("Email", "lorem@ipsum.com");
        control.put("Current Address", "22, Grove Street, Los Santos");
        control.put("Permananet Address", "Not your business");

        System.out.println(udata);

        assertThat(control.entrySet(), equalTo(udata.entrySet()));

    }
}
