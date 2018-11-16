package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestIsElementPresent {

    public static WebDriver driver;
    public  static boolean isElementPresent(String xpath){
        try {
            driver.findElement(By.xpath(xpath));
            return true;
        }catch (Throwable t){
            return false;
        }

    }

    public  static boolean isElementPresents(String xpath){
        int size = driver.findElements(By.xpath(xpath)).size();
        if(size==0){
            return false;
        }
            else{
            return true;
        }

        }

    public  static boolean isElementPresent(By by){
        try {
            driver.findElement(by);
            return true;
        }catch (Throwable t){
            return false;
        }

    }



    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://gmail.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println("Visibility of the element is: " + isElementPresent("//tralalal"));





    }
}
