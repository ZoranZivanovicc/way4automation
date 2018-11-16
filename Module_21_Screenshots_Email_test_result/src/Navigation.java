import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Navigation {
    public static WebDriver driver;
    public static String webBrowser;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        SendMailUsingAuthentication mail = new SendMailUsingAuthentication();
        driver.manage().window().maximize();
        driver.navigate().to("http://google.com");
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[3]/center/input[2]")).click();
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.navigate().back();
        driver.navigate().refresh();
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.navigate().forward();

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("C:/selenium/webdriver_gmail.jpg"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }



}
