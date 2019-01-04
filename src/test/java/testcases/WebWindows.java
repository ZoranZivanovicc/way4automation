package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import testcases.SendMailUsingAuthentication;

import java.util.Set;

public class WebWindows {
    public static WebDriver driver;
    public static String webBrowser;
    public static void main(String[] args) {
        driver = new ChromeDriver();
        SendMailUsingAuthentication mail = new SendMailUsingAuthentication();
        driver.manage().window().maximize();
        driver.navigate().to("http://icicbank.com");


    }
}
