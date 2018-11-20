package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class Keywords {
    WebDriver driver = DriverManager.getDriver();
    public static Properties or = new Properties();
    public static Properties config = new Properties();
    public static FileInputStream fis_or;


    public void sendText(String locator, String text) throws IOException {
            fis_or = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
            or.load(fis_or);
        System.out.println(or.getProperty(locator));
        if(locator.endsWith("_XPATH")){
            driver.findElement(By.xpath(or.getProperty(locator))).sendKeys(text);
        }
        else if(locator.endsWith("_ID")){
            driver.findElement(By.id(or.getProperty(locator))).sendKeys(text);
        }
        else if(locator.endsWith("_NAME")){
            driver.findElement(By.name(or.getProperty(locator))).sendKeys(text);
        }
        else if(locator.endsWith("_CSS")){
            driver.findElement(By.cssSelector(or.getProperty(locator))).sendKeys(text);
        }
        else if(locator.endsWith("_CLASS")){
            driver.findElement(By.className(or.getProperty(locator))).sendKeys(text);
        }
        else if(locator.endsWith("_LINKTEXT")){
            driver.findElement(By.linkText(or.getProperty(locator))).sendKeys(text);
        } else if(locator.endsWith("_PARTIALLINK")){
            driver.findElement(By.partialLinkText(or.getProperty(locator))).sendKeys(text);
        }else {
            System.out.println("Your locator name is not properly defined, please check your locator name");
        }
    }
    public void clickIt(String locator) throws IOException {
        fis_or = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
        or.load(fis_or);
        System.out.println(or.getProperty(locator));
        if(locator.endsWith("_XPATH")){
            driver.findElement(By.xpath(or.getProperty(locator))).click();
        }
        else if(locator.endsWith("_ID")){
            driver.findElement(By.id(or.getProperty(locator))).click();
        }
        else if(locator.endsWith("_NAME")){
            driver.findElement(By.name(or.getProperty(locator))).click();
        }
        else if(locator.endsWith("_CSS")){
            driver.findElement(By.cssSelector(or.getProperty(locator))).click();
        }
        else if(locator.endsWith("_CLASS")){
            driver.findElement(By.className(or.getProperty(locator))).click();
        }
        else if(locator.endsWith("_LINKTEXT")){
            driver.findElement(By.linkText(or.getProperty(locator))).click();
        } else if(locator.endsWith("_PARTIALLINK")){
            driver.findElement(By.partialLinkText(or.getProperty(locator))).click();
        }else {
            System.out.println("Your locator name is not properly defined, please check your locator name");
        }

    }
    public void switchTabs(String tabNumber){
        Set<String> winIds = driver.getWindowHandles();
        Iterator<String> iterate = winIds.iterator();
        String firstTab = iterate.next();
        String secondTab = iterate.next();

        if(tabNumber.equals("1")){
            driver.switchTo().window(firstTab);
        }
        else if(tabNumber.equals("2")){
            driver.switchTo().window(secondTab);
        }
        else{
            System.out.println("You didn't insert parameter value corectly, please insert number 1 or 2 ");
        }

    }

}
