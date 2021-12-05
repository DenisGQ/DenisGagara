package HW11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class FileTest
{
    @Test
    public void fileGenerate()
    {
        File file = new File("target", "fileTest.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
        file.delete(); //удаление файла сделано исключительно для локального теста, чтоб не очищать target после каждого теста

    }
}
