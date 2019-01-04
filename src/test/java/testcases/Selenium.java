package testcases;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import testcases.SendMailUsingAuthentication;

import java.io.File;
import java.io.IOException;


public class Selenium {
public static  WebDriver driver;
public static String webBrowser;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        SendMailUsingAuthentication mail = new SendMailUsingAuthentication();
        driver.manage().window().maximize();
        driver.get("http://gmail.com");

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("C:/selenium/webdriver_gmail.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            driver.findElement(By.xpath("//*[@id=\"wrongxpath\"]"));
        }
        catch (Throwable t){
            try {
                FileUtils.copyFile(scrFile, new File("C:/selenium/error.jpg"));
                mail.postMail(SendMailUsingAuthentication.emailList,SendMailUsingAuthentication.emailSubjectTxt,SendMailUsingAuthentication.emailMsgTxt,SendMailUsingAuthentication.emailFromAddress);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (MessagingException e) {
                e.printStackTrace();
            } catch (javax.mail.MessagingException e) {
                e.printStackTrace();
            }
        }
        /*
        Screenshot only in the case of the error
         */
    }

}
