package HW12.tests;

import HW12.pages.HomePage;
import HW12.pages.PracticeForm;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class PracticeFormTest {
    WebDriver driver;
    HomePage homePage;
    PracticeForm practiceForm;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

    @DataProvider
    public Object[][] fillFormsDataProvider() {
        return new Object[][]
                {
                        {"Lorem", "Ipsum", "lorem@ipsum.com", "0001112233", "December", "1912",
                                "Hin", "C:\\Users\\UncleYorick\\Downloads\\WallpaperDog-17216155.jpg",
                                "22, Grove Street, Los Santos", "NCR", "Noida"}
                };
    }

    @Test(dataProvider = "fillFormsDataProvider")
    public void automationPracticeForm
            (String firstName, String lastName, String userEmail, String userNumber, String month, String year,
             String subjectInput, String pictureLink, String currentAdress, String stateInput, String cityInput)
    {
        homePage = new HomePage(driver);
        practiceForm = new PracticeForm(driver);

        homePage.openPage();
        Assert.assertTrue(homePage.isBannerDisplayed());

        homePage.clickFormsTab();
        practiceForm.clickTabPracticeForm();
        practiceForm.removeTrash();
        practiceForm.setFirstName(firstName);
        practiceForm.setLastName(lastName);
        practiceForm.setUserEmail(userEmail);
        practiceForm.clickGender();
        practiceForm.setUserNumber(userNumber);
        practiceForm.clickDateOfBirthInput();
        practiceForm.selectMonth(month);
        practiceForm.selectYear(year);
        practiceForm.clickDayElement();
        practiceForm.setSubject(subjectInput);
        practiceForm.checkHobbies1();
        practiceForm.checkHobbies2();
        practiceForm.checkHobbies3();
        practiceForm.uploadPicture(pictureLink);
        practiceForm.setCurrentAdress(currentAdress);
        practiceForm.setState(stateInput);
        practiceForm.setCity(cityInput);
        practiceForm.scroll();
        practiceForm.clickSubmit();

        Assert.assertEquals(driver.findElement(By.xpath("//*[@class = 'modal-content']")).isDisplayed(), true);
    }
}
