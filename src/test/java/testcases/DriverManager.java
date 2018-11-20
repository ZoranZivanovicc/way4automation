package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    public static WebDriver driver;
    public static Properties or = new Properties();
    public static Properties config = new Properties();
    public static FileInputStream fis;
    public static WebDriverWait explicitWait;



    public DriverManager(String browser, String url) throws IOException {
        fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
        config.load(fis);
        if (browser.equalsIgnoreCase("chrome")){
            System.setProperty(config.getProperty("chromedriverkey"),System.getProperty("user.dir")+config.getProperty("chromedriverpath"));
            driver=new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox")){
            System.setProperty(config.getProperty("geckodriverkey"),System.getProperty("user.dir")+config.getProperty("geckodriverpath"));
            driver=new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("ie")){
            System.setProperty(config.getProperty("iedriverkey"),System.getProperty("user.dir")+config.getProperty("iedriverpath"));
            driver=new InternetExplorerDriver();
        }
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
    }
    public static WebDriver getDriver() {
        return driver;
    }
}
