package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestingWebElements {
    public static void main(String[] args) {

        System.out.println(System.getProperty("user.dir"));

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.wikipedia.org/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement dropdown = driver.findElement(By.xpath("//select[@id='searchLanguage']"));
        //driver.findElement(By.xpath("//select[@name='dropdownmenu']")).sendKeys("Milk");
        Select select = new Select(dropdown);
        select.selectByValue("hi");
        List<WebElement> list = select.getOptions();

        for (int i =0; i<list.size(); i++){
            System.out.println(list.get(i).getText());
        }
        System.out.println("----------Jezik na indexu 7--------------");
        System.out.println(list.get(7).getText());
        System.out.println("--------Pronaci sve linkove------------------");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement element: links){
            System.out.println( "URL is: " + element.getAttribute("href"));
        }






    }
}
