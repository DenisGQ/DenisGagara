package LuckyTest;

import HW7.Lucky;
import org.testng.Assert;
import org.testng.annotations.*;

public class LuckyTestNG
{
    Lucky lucky = new Lucky();

    @BeforeSuite
    public void beforeSuite()
    {
        System.out.println("For text 'Before all tests' we use annotation @BeforeSuite");
    }
    @AfterSuite
    public void afterSuite()
    {
        System.out.println("For text 'After all tests' we use annotation @AfterSuite");
    }
    @BeforeTest
    public void beforeTest()
    {
        System.out.println("Attention! Three runs are falling on purpose for testing custom exceptions. It's ok, as intended.");
    }
    @AfterTest
    public void afterTest()
    {
        System.out.println("This is text after each test");
    }

    @DataProvider
    public Object[][] integerLuckDataProvider()
    {
        int[] array0 = {15, 8, 24, 41, 9, 84};
        int[] array1 = {64, 65, 445, 58, 0, 49};
        int[] array2 = {619, 5};
        int[] array3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int[] array4 = {8, 786, 4753, 78, 45, 12};
        int[] array5 = {};

        return new Object[][]
                {
                        {array0, 3, false},
                        {array1, 1, false},
                        {array2, 0, false},
                        {array3, 5, true},
                        {array4, 2, false},
                        {array5, 4, true},
                };
    }

    @Test(dataProvider = "integerLuckDataProvider")
    public void test(int[] array, int index, boolean result) throws Exception
    {
        Assert.assertEquals(lucky.random (array, index), result);
    }
}
