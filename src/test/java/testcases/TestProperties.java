package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestProperties {
    public static WebDriver driver;
    public static Properties or = new Properties();
    public static Properties config = new Properties();
    public static FileInputStream fis;
    public static void main(String[] args) throws IOException {
        Properties or = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
        or.load(fis);
        System.out.println(or.getProperty("email_id"));
        Properties config = new Properties();
        FileInputStream fis2 = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
        config.load(fis2);
        System.out.println(config.getProperty("testsiteurl"));
        if (config.getProperty("browser").equals("chrome")){
            System.setProperty(config.getProperty("chromedriverkey"),System.getProperty("user.dir")+config.getProperty("chromedriverpath"));
            driver=new ChromeDriver();
        } else if (config.getProperty("browser").equals("firefox")){
            System.setProperty(config.getProperty("geckodriverkey"),System.getProperty("user.dir")+config.getProperty("geckodriverpath"));
            driver=new FirefoxDriver();
        } else if (config.getProperty("browser").equals("ie")){
            System.setProperty(config.getProperty("iedriverkey"),System.getProperty("user.dir")+config.getProperty("iedriverpath"));
            driver=new InternetExplorerDriver();
        }
        driver.get(config.getProperty("testsiteurl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
        driver.findElement(By.id(or.getProperty("email_id"))).sendKeys("zoran.v.zivanovic");
        driver.findElement(By.id(or.getProperty("nextButton_id"))).click();
        driver.findElement(By.name(or.getProperty("password_name"))).sendKeys("test");



    }
}
